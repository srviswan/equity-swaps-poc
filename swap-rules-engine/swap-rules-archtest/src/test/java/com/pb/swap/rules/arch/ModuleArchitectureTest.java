package com.pb.swap.rules.arch;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.pb.swap.rules")
public class ModuleArchitectureTest {

    @ArchTest
    static final ArchRule coreMustNotDependOnSpring =
            noClasses()
                    .that()
                    .resideInAPackage("com.pb.swap.rules.core..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAnyPackage("org.springframework..");

    @ArchTest
    static final ArchRule runtimeMustNotDependOnStoreOrAdmin =
            noClasses()
                    .that()
                    .resideInAPackage("com.pb.swap.rules.runtime..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAnyPackage(
                            "com.pb.swap.rules.store..", "com.pb.swap.rules.admin..");

    @Test
    void corePackageExists() {
        JavaClasses core =
                new ClassFileImporter()
                        .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                        .importPackages("com.pb.swap.rules.core");
        org.assertj.core.api.Assertions.assertThat(core).isNotEmpty();
    }
}
