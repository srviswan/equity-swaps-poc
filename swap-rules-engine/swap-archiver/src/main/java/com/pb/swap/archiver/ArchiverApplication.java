package com.pb.swap.archiver;

import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.engine.Orchestrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * CLI entrypoint. A single fat jar runs ARCHIVE, RESTORE, or DRY_RUN depending on {@code
 * archiver.mode}. The actual archival logic is driven entirely by the {@code archive.*} control
 * tables, so behaviour changes without redeploying this artifact.
 *
 * <p>The orchestrator's exit code is propagated to the JVM process exit code (via
 * {@link ExitCodeGenerator}) so a scheduler (cron / Airflow / Autosys) can detect a failed,
 * paused, or break-glass-halted run — a plain {@code run()} that logged the code but returned 0
 * would look like success to the scheduler.
 */
@SpringBootApplication
@EnableConfigurationProperties(ArchiverProperties.class)
public class ArchiverApplication implements CommandLineRunner, ExitCodeGenerator {

    private static final Logger log = LoggerFactory.getLogger(ArchiverApplication.class);

    private final ArchiverProperties props;
    private final Orchestrator orchestrator;
    private int exitCode = 0;

    public ArchiverApplication(ArchiverProperties props, Orchestrator orchestrator) {
        this.props = props;
        this.orchestrator = orchestrator;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ArchiverApplication.class, args);
        System.exit(SpringApplication.exit(ctx));
    }

    @Override
    public void run(String... args) {
        log.info("swap-archiver starting: job={} mode={}", props.jobName(), props.mode());
        exitCode = orchestrator.run();
        log.info("swap-archiver finished with exit code {}", exitCode);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
