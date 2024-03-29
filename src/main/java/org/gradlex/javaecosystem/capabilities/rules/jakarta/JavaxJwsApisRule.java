/*
 * Copyright the GradleX team.
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

package org.gradlex.javaecosystem.capabilities.rules.jakarta;

import org.gradle.api.artifacts.CacheableRule;
import org.gradle.api.artifacts.ModuleVersionIdentifier;
import org.gradlex.javaecosystem.capabilities.rules.CapabilityDefinitions;
import org.gradlex.javaecosystem.capabilities.rules.CapabilityDefinitionsRule;
import org.gradlex.javaecosystem.capabilities.util.VersionNumber;

import javax.inject.Inject;

@CacheableRule
public abstract class JavaxJwsApisRule extends CapabilityDefinitionsRule {

    static final String FIRST_JAKARTA_VERSION = "3.0.0";

    @Inject
    public JavaxJwsApisRule(CapabilityDefinitions rule) {
        super(rule);
    }

    @Override
    protected boolean shouldApply(ModuleVersionIdentifier id) {
        return VersionNumber.parse(getVersion(id)).compareTo(VersionNumber.parse(FIRST_JAKARTA_VERSION)) < 0;
    }
}

