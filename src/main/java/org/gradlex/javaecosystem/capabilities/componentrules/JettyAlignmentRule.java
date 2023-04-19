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
abstract public class JettyAlignmentRule implements ComponentMetadataRule {

	public static final String BOM_GROUP_NAME = "org.eclipse.jetty";
	public static final String BOM_ARTIFACT_NAME = "jetty-bom";

	public static final Set<String> GROUPS = new HashSet<>(Arrays.asList(
			"org.eclipse.jetty",
			"org.eclipse.jetty.fcgi",
			"org.eclipse.jetty.gcloud",
			"org.eclipse.jetty.http2",
			"org.eclipse.jetty.http3",
			"org.eclipse.jetty.memcached",
			"org.eclipse.jetty.osgi",
			"org.eclipse.jetty.quic",
			"org.eclipse.jetty.websocket"
	));

	@Override
	public void execute(ComponentMetadataContext context) {
		ModuleVersionIdentifier id = context.getDetails().getId();
		if (GROUPS.contains(id.getGroup()) && !id.getName().equals(BOM_ARTIFACT_NAME)) {
			context.getDetails().belongsTo(BOM_GROUP_NAME + ":" + BOM_ARTIFACT_NAME + ":" + id.getVersion(), false);
		}
	}
}