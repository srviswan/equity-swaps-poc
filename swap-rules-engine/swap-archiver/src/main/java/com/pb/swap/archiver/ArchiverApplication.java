package com.pb.swap.archiver;

import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.engine.Orchestrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * CLI entrypoint. A single fat jar runs ARCHIVE, RESTORE, or DRY_RUN depending on {@code
 * archiver.mode}. The actual archival logic is driven entirely by the {@code archive.*} control
 * tables, so behaviour changes without redeploying this artifact.
 */
@SpringBootApplication
@EnableConfigurationProperties(ArchiverProperties.class)
public class ArchiverApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ArchiverApplication.class);

    private final ArchiverProperties props;
    private final Orchestrator orchestrator;

    public ArchiverApplication(ArchiverProperties props, Orchestrator orchestrator) {
        this.props = props;
        this.orchestrator = orchestrator;
    }

    public static void main(String[] args) {
        SpringApplication.run(ArchiverApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("swap-archiver starting: job={} mode={}", props.jobName(), props.mode());
        int exitCode = orchestrator.run();
        log.info("swap-archiver finished with exit code {}", exitCode);
    }
}
