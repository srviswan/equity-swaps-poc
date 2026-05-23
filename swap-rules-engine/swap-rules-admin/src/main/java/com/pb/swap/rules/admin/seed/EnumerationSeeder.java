package com.pb.swap.rules.admin.seed;

import com.pb.swap.rules.admin.enumeration.EnumerationRegistry;
import com.pb.swap.rules.store.entity.EnumerationEntity;
import com.pb.swap.rules.store.entity.EnumerationValueEntity;
import com.pb.swap.rules.store.repo.EnumerationRepository;
import com.pb.swap.rules.store.repo.EnumerationValueRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Seeds a starter pack of enumerations on first boot so the rule studio dropdowns are useful out of
 * the box. Runs before {@link SampleDataSeeder} so the @SchemaField {@code enumRef} bindings already
 * resolve when rules are seeded.
 */
@Component
@Order(0)
@ConditionalOnProperty(
        name = "swap-rules.seed.enabled",
        havingValue = "true",
        matchIfMissing = true)
public class EnumerationSeeder {

    private static final Logger log = LoggerFactory.getLogger(EnumerationSeeder.class);

    private final EnumerationRepository repo;
    private final EnumerationValueRepository valueRepo;
    private final EnumerationRegistry registry;

    public EnumerationSeeder(
            EnumerationRepository repo,
            EnumerationValueRepository valueRepo,
            EnumerationRegistry registry) {
        this.repo = repo;
        this.valueRepo = valueRepo;
        this.registry = registry;
    }

    @PostConstruct
    public void seed() {
        if (repo.count() > 0) {
            log.info("Enumerations already present (count={}); skipping seed", repo.count());
            return;
        }
        log.info("Seeding starter enumerations");

        define("CURRENCY", "Currency", "ISO 4217 currency codes");
        addValues(
                "CURRENCY",
                "USD", "US Dollar",
                "EUR", "Euro",
                "GBP", "Pound Sterling",
                "JPY", "Japanese Yen",
                "HKD", "Hong Kong Dollar",
                "SGD", "Singapore Dollar",
                "CHF", "Swiss Franc",
                "AUD", "Australian Dollar");

        define("BOOK", "Trading book", "Books the trade can be captured under");
        addValues(
                "BOOK",
                "EQ_SWAP", "Equity Swap book",
                "EQ_OTC", "Equity OTC book",
                "FIN_DESK", "Financing desk",
                "UNKNOWN_BOOK", "Unknown");

        define("PRODUCT_TYPE", "Product type", "Product family");
        addValues(
                "PRODUCT_TYPE",
                "EQUITY_SWAP", "Equity swap",
                "EQUITY_OPTION", "Equity option",
                "EQUITY_FORWARD", "Equity forward");

        define("CLIENT_TIER", "Client tier", "Internal client classification");
        addValues(
                "CLIENT_TIER",
                "TIER_1", "Tier 1",
                "TIER_2", "Tier 2",
                "TIER_3", "Tier 3");

        define("TRADE_SOURCE", "Trade source", "Capture origin");
        addValues(
                "TRADE_SOURCE",
                "MANUAL", "Manual capture",
                "AUTO", "Automated capture",
                "STP", "Straight-through processing");

        define("DAY_COUNT", "Day count convention", "Interest leg day count");
        addValues(
                "DAY_COUNT",
                "ACT/360", "Actual / 360",
                "ACT/365", "Actual / 365",
                "30/360", "30 / 360",
                "ACT/ACT", "Actual / Actual");

        define("RATE_TYPE", "Rate type", "Fixed or floating");
        addValues(
                "RATE_TYPE",
                "FIXED", "Fixed",
                "FLOAT", "Floating");

        define("RATE_INDEX", "Rate index", "Reference rate");
        addValues(
                "RATE_INDEX",
                "SOFR", "SOFR",
                "ESTR", "ESTR",
                "SONIA", "SONIA",
                "TONA", "TONA");

        define("RETURN_TYPE", "Return type", "Equity leg return type");
        addValues(
                "RETURN_TYPE",
                "TOTAL_RETURN", "Total return",
                "PRICE_RETURN", "Price return");

        define("FEE_TYPE", "Fee type", "Financing fee model");
        addValues(
                "FEE_TYPE",
                "FLAT", "Flat",
                "GC_PLUS", "GC + spread");

        define("PAYMENT_FREQUENCY", "Payment frequency", "Coupon payment frequency");
        addValues(
                "PAYMENT_FREQUENCY",
                "MONTHLY", "Monthly",
                "QUARTERLY", "Quarterly",
                "SEMI_ANNUAL", "Semi-annual",
                "ANNUAL", "Annual");

        define("ROLL_CONVENTION", "Roll convention", "Schedule roll");
        addValues(
                "ROLL_CONVENTION",
                "FOLLOWING", "Following business day",
                "MODIFIED_FOLLOWING", "Modified following",
                "PRECEDING", "Preceding business day");

        define("DIV_TIMING", "Dividend timing", "Passthrough timing");
        addValues(
                "DIV_TIMING",
                "PAYMENT_DATE", "Payment date",
                "EX_DATE", "Ex-dividend date",
                "RECORD_DATE", "Record date");

        define("LEGAL_ENTITY", "Legal entity", "Booking legal entity");
        addValues(
                "LEGAL_ENTITY",
                "PB_US", "PB US",
                "PB_UK", "PB UK",
                "PB_HK", "PB Hong Kong");

        define("WORKFLOW_STATUS", "Workflow status", "Trade workflow state");
        addValues(
                "WORKFLOW_STATUS",
                "PENDING_APPROVAL", "Pending approval",
                "APPROVED", "Approved",
                "REJECTED", "Rejected");

        define("ROUTING_DESTINATION", "Routing destination", "Downstream system");
        addValues(
                "ROUTING_DESTINATION",
                "PB_DOWNSTREAM", "PB downstream",
                "RISK_ENGINE", "Risk engine",
                "BACK_OFFICE", "Back office");

        registry.refresh();
        log.info("Enumeration seed complete ({} enumerations)", repo.count());
    }

    private void define(String code, String displayName, String description) {
        if (repo.findById(code).isPresent()) return;
        EnumerationEntity e = new EnumerationEntity();
        e.setCode(code);
        e.setDisplayName(displayName);
        e.setDescription(description);
        e.setProviderType("DATABASE");
        e.setRefreshPolicy("MANUAL");
        e.setVersion(1);
        repo.save(e);
    }

    /** {@code codeA, labelA, codeB, labelB, ...} convenience. */
    private void addValues(String enumCode, String... pairs) {
        if (pairs.length % 2 != 0) throw new IllegalArgumentException("expect even arg count");
        for (int i = 0; i < pairs.length; i += 2) {
            EnumerationValueEntity v = new EnumerationValueEntity();
            v.setEnumCode(enumCode);
            v.setValueCode(pairs[i]);
            v.setDisplayLabel(pairs[i + 1]);
            v.setSortOrder(i / 2);
            v.setActive(true);
            valueRepo.save(v);
        }
    }

}
