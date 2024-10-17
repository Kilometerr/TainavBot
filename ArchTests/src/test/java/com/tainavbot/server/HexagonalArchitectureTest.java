package com.tainavbot.server;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

class HexagonalArchitectureTest {

    private final String DOMAIN_PACKAGE = ".domain";
    private final String DOMAIN_MODEL_PACKAGE = DOMAIN_PACKAGE + ".model..";
    private final String DOMAIN_VO_PACKAGE = DOMAIN_PACKAGE + ".vo";
    private final String DOMAIN_VOS_PACKAGE = DOMAIN_VO_PACKAGE + ".vo";
    private final String ROOT_PACKAGE = "com.tainavbot.server";
    private final String DOMAIN_SERVICE_PACKAGE = DOMAIN_PACKAGE + ".service..";
    private final String APPLICATION_SERVICE_PACKAGE = DOMAIN_PACKAGE + "port.primary..";
    private final String INFRASTRUCTURE_PACKAGE = ".infrastructure";
    private final String INFRASTRUCTURE_PRIMARY_ADAPTERS_PACKAGE = INFRASTRUCTURE_PACKAGE + ".adapter.primary";
    private final String INFRASTRUCTURE_PERSISTENCE_PRIMARY_ADAPTERS_PACKAGE = INFRASTRUCTURE_PACKAGE + ".adapter.secondary";
    private final String DOMAIN_ENUM_PACKAGE = DOMAIN_PACKAGE + ".enumeration";
    private final String DOMAIN_ENUMS_PACKAGE = DOMAIN_ENUM_PACKAGE + "..";
    private final String DOMAIN_POLICY_PACKAGE = DOMAIN_PACKAGE + ".policy..";
    private final String DOMAIN_EXCEPTION_PACKAGE = DOMAIN_PACKAGE + ".exception..";
    private final String DOMAIN_PERSISTENCE_PORT_PACKAGE = DOMAIN_PACKAGE + ".port.secondary";
    private final String DOMAIN_PERSISTENCE_PORTS_PACKAGE = DOMAIN_PERSISTENCE_PORT_PACKAGE + "..";

    private final JavaClasses classes = new ClassFileImporter().importPackages(pack(DOMAIN_PACKAGE), pack(INFRASTRUCTURE_PACKAGE));

    @Test
    void testHexagonalArchitecture() {
        ArchRule rule = onionArchitecture()
                .domainModels(
                        pack(DOMAIN_MODEL_PACKAGE),
                        pack(DOMAIN_VOS_PACKAGE),
                        pack(DOMAIN_ENUMS_PACKAGE),
                        pack(DOMAIN_POLICY_PACKAGE))
                .domainServices(
                        pack(DOMAIN_SERVICE_PACKAGE),
                        pack(DOMAIN_EXCEPTION_PACKAGE),
                        pack(DOMAIN_PERSISTENCE_PORTS_PACKAGE))
                .applicationServices(pack(APPLICATION_SERVICE_PACKAGE))
                .adapter("primaryAdapters", pack(INFRASTRUCTURE_PRIMARY_ADAPTERS_PACKAGE))
                .adapter("persistenceAdapters", pack(INFRASTRUCTURE_PERSISTENCE_PRIMARY_ADAPTERS_PACKAGE))
                .withOptionalLayers(true);

        rule.check(classes);
    }

    private String pack(String packageName) {
        return ROOT_PACKAGE + packageName;
    }
}