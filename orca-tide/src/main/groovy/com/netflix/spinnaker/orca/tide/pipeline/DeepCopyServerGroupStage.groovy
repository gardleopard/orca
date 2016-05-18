/*
 * Copyright 2015 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.tide.pipeline

import com.netflix.spinnaker.orca.pipeline.StageDefinitionBuilder
import com.netflix.spinnaker.orca.tide.tasks.DeepCopyServerGroupTask
import com.netflix.spinnaker.orca.tide.tasks.WaitForTideTask
import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

import static com.netflix.spinnaker.orca.pipeline.StageDefinitionBuilder.StageDefinitionBuilderSupport.getType

@Component
@CompileStatic
class DeepCopyServerGroupStage implements StageDefinitionBuilder {
  public static final String PIPELINE_CONFIG_TYPE = getType(DeepCopyServerGroupStage)

  @Override
  List<StageDefinitionBuilder.TaskDefinition> taskGraph() {
    return [
      new StageDefinitionBuilder.TaskDefinition("deepCopyServerGroup", DeepCopyServerGroupTask),
      new StageDefinitionBuilder.TaskDefinition("waitForDeepCopyCompletion", WaitForTideTask),
    ]
  }
}
