/*
 * Copyright 2022 the GradleX team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradlex.javaecosystem.capabilities.componentrules;

import org.gradle.api.artifacts.CacheableRule;
import org.gradle.api.artifacts.ComponentMetadataContext;
import org.gradle.api.artifacts.ComponentMetadataRule;

import java.util.Arrays;
import java.util.List;

/**
 * Sets status of component versions that are not final releases to 'integration' instead of 'release'.
 * Otherwise, they are considered when asking for the 'latest.release' version.
 * POM metadata does not support the 'status' concept and thus Gradle assumes everything is a 'release' by default.
 */
@CacheableRule
public abstract class ComponentStatusRule implements ComponentMetadataRule {

    public static List<String> INTEGRATION_VERSION_MARKER = Arrays.asList(
            "-b",
            "alpha",
            "beta",
            "cr",
            "m",
            "rc"
    );

    @Override
    public void execute(ComponentMetadataContext context) {
        String version = context.getDetails().getId().getVersion().toLowerCase();
        if (INTEGRATION_VERSION_MARKER.stream().anyMatch(version::contains)) {
            context.getDetails().setStatus("integration");
        }
    }
}
