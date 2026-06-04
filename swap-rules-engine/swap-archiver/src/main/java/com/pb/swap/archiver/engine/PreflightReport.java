package com.pb.swap.archiver.engine;

import java.util.ArrayList;
import java.util.List;

/** Collected results of the pre-flight checks. The run proceeds only when there is no FAIL. */
public final class PreflightReport {

    /** Outcome of a single check. */
    public enum Status {
        PASS,
        WARN,
        FAIL
    }

    /** One named check and its outcome. */
    public record Check(String name, Status status, String detail) {}

    private final List<Check> checks = new ArrayList<>();

    public void pass(String name, String detail) {
        checks.add(new Check(name, Status.PASS, detail));
    }

    public void warn(String name, String detail) {
        checks.add(new Check(name, Status.WARN, detail));
    }

    public void fail(String name, String detail) {
        checks.add(new Check(name, Status.FAIL, detail));
    }

    public List<Check> checks() {
        return checks;
    }

    /** @return true when no check failed (warnings are allowed). */
    public boolean ok() {
        return checks.stream().noneMatch(c -> c.status() == Status.FAIL);
    }

    public String render() {
        StringBuilder sb = new StringBuilder("Pre-flight report:\n");
        for (Check c : checks) {
            sb.append(String.format("  [%-4s] %-28s %s%n", c.status(), c.name(), c.detail()));
        }
        sb.append("  => ").append(ok() ? "PASS" : "FAIL");
        return sb.toString();
    }
}
