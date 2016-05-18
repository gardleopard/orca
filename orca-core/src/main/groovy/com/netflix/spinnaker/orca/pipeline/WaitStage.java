/*
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.pipeline;

import java.util.List;
import com.netflix.spinnaker.orca.pipeline.tasks.WaitTask;
import org.springframework.stereotype.Component;
import static java.util.Collections.singletonList;

@Component
public class WaitStage implements StageDefinitionBuilder {
  @Override public List<TaskDefinition> taskGraph() {
    return singletonList(new TaskDefinition("wait", WaitTask.class));
  }
}
