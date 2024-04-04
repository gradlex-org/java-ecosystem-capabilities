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

package org.gradlex.javaecosystem.conflict.detection.rules.logging;

import org.gradle.api.artifacts.CacheableRule;
import org.gradle.api.artifacts.ModuleVersionIdentifier;
import org.gradlex.javaecosystem.conflict.detection.rules.AlignmentDefinition;
import org.gradlex.javaecosystem.conflict.detection.rules.AlignmentDefinitionRule;
import org.gradlex.javaecosystem.conflict.detection.util.VersionNumber;

import javax.inject.Inject;

@CacheableRule
public abstract class Slf4J2Alignment extends AlignmentDefinitionRule {

    @Inject
    public Slf4J2Alignment(AlignmentDefinition definition) {
        super(definition);
    }

    @Override
    protected boolean shouldApply(ModuleVersionIdentifier id) {
        return VersionNumber.parse(id.getVersion()).compareTo(VersionNumber.parse("2.0.8")) >= 0;
    }
}
