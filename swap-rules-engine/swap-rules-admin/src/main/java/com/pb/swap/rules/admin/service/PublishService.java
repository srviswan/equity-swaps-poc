package com.pb.swap.rules.admin.service;

import com.pb.swap.rules.core.compile.CompiledRule;
import com.pb.swap.rules.core.compile.RuleCompiler;
import com.pb.swap.rules.core.model.ActionTemplate;
import com.pb.swap.rules.core.model.CriteriaFragment;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.snapshot.RuleSnapshot;
import com.pb.swap.rules.store.entity.SnapshotPublicationEntity;
import com.pb.swap.rules.store.mapper.RuleJsonMapper;
import com.pb.swap.rules.store.repo.ActionTemplateRepository;
import com.pb.swap.rules.store.repo.CriteriaFragmentRepository;
import com.pb.swap.rules.store.repo.RuleDefinitionRepository;
import com.pb.swap.rules.store.repo.SnapshotPublicationRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PublishService {
    private final RuleDefinitionRepository ruleRepo;
    private final ActionTemplateRepository templateRepo;
    private final CriteriaFragmentRepository fragmentRepo;
    private final SnapshotPublicationRepository publicationRepo;
    private final RuleCompiler compiler;
    private final SnapshotHolder snapshotHolder;
    private final RuleJsonMapper jsonMapper;
    private final StringRedisTemplate redis;
    private final String redisChannel;

    public PublishService(
            RuleDefinitionRepository ruleRepo,
            ActionTemplateRepository templateRepo,
            CriteriaFragmentRepository fragmentRepo,
            SnapshotPublicationRepository publicationRepo,
            RuleCompiler compiler,
            SnapshotHolder snapshotHolder,
            @org.springframework.beans.factory.annotation.Autowired(required = false)
                    StringRedisTemplate redis,
            @Value("${swap-rules.snapshot.redis-channel}") String redisChannel) {
        this.ruleRepo = ruleRepo;
        this.templateRepo = templateRepo;
        this.fragmentRepo = fragmentRepo;
        this.publicationRepo = publicationRepo;
        this.compiler = compiler;
        this.snapshotHolder = snapshotHolder;
        this.jsonMapper = new RuleJsonMapper();
        this.redis = redis;
        this.redisChannel = redisChannel;
    }

    @Transactional(readOnly = true)
    public RuleSnapshot publish(LocalDate asOf) throws Exception {
        List<RuleDefinition> rules = new ArrayList<>();
        for (var entity : ruleRepo.findPublished()) {
            rules.add(jsonMapper.toRule(entity));
        }
        List<ActionTemplate> templates = new ArrayList<>();
        for (var entity : templateRepo.findPublished()) {
            templates.add(jsonMapper.toTemplate(entity));
        }
        List<CriteriaFragment> fragments = new ArrayList<>();
        for (var entity : fragmentRepo.findPublished()) {
            fragments.add(jsonMapper.toFragment(entity));
        }
        detectConflicts(rules, templates, fragments, asOf);
        RuleSnapshot snapshot = compiler.compile(rules, templates, fragments, asOf);
        snapshotHolder.set(snapshot);
        SnapshotPublicationEntity pub = new SnapshotPublicationEntity();
        pub.setSnapshotId(snapshot.snapshotId());
        pub.setRuleCount(rules.size());
        pub.setTemplateCount(templates.size());
        pub.setFragmentCount(fragments.size());
        pub.setChecksum(snapshot.checksum());
        publicationRepo.save(pub);
        if (redis != null) {
            redis.convertAndSend(redisChannel, snapshot.snapshotId());
        }
        return snapshot;
    }

    private void detectConflicts(
            List<RuleDefinition> rules,
            List<ActionTemplate> templates,
            List<CriteriaFragment> fragments,
            LocalDate asOf) {
        RuleSnapshot snap = compiler.compile(rules, templates, fragments, asOf);
        Set<String> seen = new HashSet<>();
        for (var bucket : snap.allBuckets().values()) {
            for (CompiledRule r : bucket.rules()) {
                String key =
                        r.category()
                                + "|"
                                + r.target()
                                + "|"
                                + r.specificity()
                                + "|"
                                + r.fragmentIds();
                if (!seen.add(key)) {
                    throw new IllegalStateException(
                            "Conflict: duplicate specificity and fragments for rule " + r.ruleId());
                }
            }
        }
    }
}
