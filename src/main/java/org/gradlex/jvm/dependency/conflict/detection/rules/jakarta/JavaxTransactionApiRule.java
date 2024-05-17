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

package org.gradlex.jvm.dependency.conflict.detection.rules.jakarta;

import org.gradle.api.artifacts.CacheableRule;
import org.gradle.api.artifacts.ModuleVersionIdentifier;
import org.gradlex.jvm.dependency.conflict.detection.rules.CapabilityDefinition;
import org.gradlex.jvm.dependency.conflict.detection.rules.CapabilityDefinitionRule;
import org.gradlex.jvm.dependency.conflict.detection.util.VersionNumber;

import javax.inject.Inject;

@CacheableRule
public abstract class JavaxTransactionApiRule extends CapabilityDefinitionRule {

    static final String FIRST_JAKARTA_VERSION = "2.0.0";

    @Inject
    public JavaxTransactionApiRule(CapabilityDefinition rule) {
        super(rule);
    }

    @Override
    protected boolean shouldApply(ModuleVersionIdentifier id) {
        return VersionNumber.parse(getVersion(id)).compareTo(VersionNumber.parse(FIRST_JAKARTA_VERSION)) < 0;
    }

    @Override
    protected String getVersion(ModuleVersionIdentifier id) {
        String name = id.getName();
        String moduleVersion = id.getVersion();

        if (name.contains("jboss-transaction-api_")) {
            return transactionApiVersionForJbossName(name);
        }

        return moduleVersion;
    }

    private static String transactionApiVersionForJbossName(String name) {
        int index = "jboss-transaction-api_".length();
        return name.substring(index, index + 3) + ".0";
    }
}
