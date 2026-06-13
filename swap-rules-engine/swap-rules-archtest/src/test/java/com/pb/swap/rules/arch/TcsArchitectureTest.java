package com.pb.swap.rules.arch;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.pb.tcs")
public class TcsArchitectureTest {

    @ArchTest
    static final ArchRule tcsMustNotDependOnRulesAdminOrStore =
            noClasses()
                    .that()
                    .resideInAPackage("com.pb.tcs..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAnyPackage(
                            "com.pb.swap.rules.admin..", "com.pb.swap.rules.store..");

    @ArchTest
    static final ArchRule domainMustNotDependOnBootShell =
            noClasses()
                    .that()
                    .resideInAnyPackage(
                            "com.pb.tcs.rules..",
                            "com.pb.tcs.ingress..",
                            "com.pb.tcs.dispatch..",
                            "com.pb.tcs.routing..",
                            "com.pb.tcs.recon..",
                            "com.pb.tcs.parity..",
                            "com.pb.tcs.approval..",
                            "com.pb.tcs.crossref..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("com.pb.tcs.boot..");
}
