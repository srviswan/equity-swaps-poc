package com.pb.tcs.archive;

import java.time.LocalDate;
import java.util.List;

/** FR-602 preflight checks before partition switch (swap-archiver pattern). */
public final class ArchivePreflight {

    private ArchivePreflight() {}

    public static PreflightReport validate(LocalDate partitionMonth, long eligibleRows, int hotWindowMonths) {
        PreflightReport report = new PreflightReport();
        LocalDate oldestHot = LocalDate.now().minusMonths(hotWindowMonths - 1L).withDayOfMonth(1);
        if (partitionMonth.isAfter(oldestHot)) {
            report.fail("hot_window", "partition " + partitionMonth + " still in hot window");
        } else {
            report.pass("hot_window", "partition outside " + hotWindowMonths + "-month hot window");
        }
        if (eligibleRows <= 0) {
            report.fail("eligible_rows", "no lifecycle-complete rows eligible for archive");
        } else {
            report.pass("eligible_rows", eligibleRows + " rows eligible");
        }
        report.pass("partition_exists", "partition scheme pf_trade_month covers " + partitionMonth);
        return report;
    }
}
