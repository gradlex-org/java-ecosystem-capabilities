package de.jjohannes.gradle.javaecosystem.capabilities.rules;

import org.gradle.api.artifacts.CacheableRule;
import org.gradle.api.artifacts.ComponentMetadataContext;
import org.gradle.api.artifacts.ComponentMetadataRule;

@CacheableRule
public abstract class JtsCoreRule implements ComponentMetadataRule {

    public static final String CAPABILITY_GROUP = "com.vividsolutions";
    public static final String CAPABILITY_NAME = "jts-core";

    public static final String[] MODULES = {
            "org.locationtech.jts:jts-core"
    };

    @Override
    public void execute(ComponentMetadataContext context) {
        String version = context.getDetails().getId().getVersion();
        context.getDetails().allVariants(variant -> variant.withCapabilities(capabilities -> capabilities.addCapability(
                CAPABILITY_GROUP, CAPABILITY_NAME, version
        )));
    }
}
