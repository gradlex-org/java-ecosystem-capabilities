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
public abstract class JakartaActivationImplementationRule extends CapabilityDefinitionsRule {


    // Starting with this version the implementation moved to the 'org.eclipse' package and is no longer a conflict
    public static final String FIRST_ECLIPSE_VERSION = "2.0.0";

    @Inject
    public JakartaActivationImplementationRule(CapabilityDefinitions rule) {
        super(rule);
    }

    @Override
    protected boolean shouldApply(ModuleVersionIdentifier id) {
        return "com.sun.activation".equals(id.getGroup()) || VersionNumber.parse(id.getVersion()).compareTo(VersionNumber.parse(FIRST_ECLIPSE_VERSION)) < 0;
    }
}
