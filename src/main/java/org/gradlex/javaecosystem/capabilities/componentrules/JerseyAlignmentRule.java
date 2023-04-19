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
import org.gradle.api.artifacts.ModuleVersionIdentifier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@CacheableRule
abstract public class JerseyAlignmentRule implements ComponentMetadataRule {

	public static final String BOM_GROUP_NAME = "org.glassfish.jersey";
	public static final String BOM_ARTIFACT_NAME = "jersey-bom";

	public static final Set<String> GROUPS = new HashSet<>(Arrays.asList(
			"org.glassfish.jersey.bundles",
			"org.glassfish.jersey.connectors",
			"org.glassfish.jersey.containers",
			"org.glassfish.jersey.containers.glassfish",
			"org.glassfish.jersey.core",
			"org.glassfish.jersey.ext",
			"org.glassfish.jersey.ext.cdi",
			"org.glassfish.jersey.ext.microprofile",
			"org.glassfish.jersey.ext.rx",
			"org.glassfish.jersey.inject",
			"org.glassfish.jersey.media",
			"org.glassfish.jersey.security",
			"org.glassfish.jersey.test-framework",
			"org.glassfish.jersey.test-framework.providers"
	));

	@Override
	public void execute(ComponentMetadataContext context) {
		ModuleVersionIdentifier id = context.getDetails().getId();
		if (GROUPS.contains(id.getGroup()) && !id.getName().equals(BOM_ARTIFACT_NAME)) {
			context.getDetails().belongsTo(BOM_GROUP_NAME + ":" + BOM_ARTIFACT_NAME + ":" + id.getVersion(), false);
		}
	}
}