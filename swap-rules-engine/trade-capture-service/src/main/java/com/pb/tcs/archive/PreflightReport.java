package com.pb.tcs.archive;

import java.util.ArrayList;
import java.util.List;

/** Minimal preflight report (mirrors swap-archiver pattern without Spring dependency). */
public final class PreflightReport {

    public enum Status {
        PASS,
        WARN,
        FAIL
    }

    public record Check(String name, Status status, String detail) {}

    private final List<Check> checks = new ArrayList<>();

    public void pass(String name, String detail) {
        checks.add(new Check(name, Status.PASS, detail));
    }

    public void fail(String name, String detail) {
        checks.add(new Check(name, Status.FAIL, detail));
    }

    public List<Check> checks() {
        return checks;
    }

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
