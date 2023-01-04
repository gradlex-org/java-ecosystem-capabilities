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

@CacheableRule
abstract public class ApacheSshdAlignmentRule implements ComponentMetadataRule {

	public static final String APACHE_SSHD_GROUP = "org.apache.sshd";

	@Override
	public void execute(ComponentMetadataContext context) {
		if (context.getDetails().getId().getGroup().equals(APACHE_SSHD_GROUP)) {
			context.getDetails().belongsTo("org.apache.sshd:apache-sshd-platform:" + context.getDetails().getId().getVersion());
		}
	}
}