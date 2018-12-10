package com.netflix.spinnaker.orca.clouddriver.pipeline.providers.aws;

import com.netflix.spinnaker.orca.clouddriver.tasks.providers.aws.cloudformation.MonitorCloudFormationTask;
import com.netflix.spinnaker.orca.clouddriver.tasks.providers.aws.cloudformation.DeployCloudFormationTask;
import com.netflix.spinnaker.orca.pipeline.StageDefinitionBuilder;
import com.netflix.spinnaker.orca.pipeline.TaskNode;
import com.netflix.spinnaker.orca.pipeline.model.Stage;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Component
public class DeployCloudFormationStage implements StageDefinitionBuilder {
  public static final String PIPELINE_CONFIG_TYPE = "deployCloudFormation";

  @Override
  public void taskGraph(@Nonnull Stage stage, @Nonnull TaskNode.Builder builder) {
    builder.withTask(DeployCloudFormationTask.TASK_NAME, DeployCloudFormationTask.class)
    .withTask(MonitorCloudFormationTask.TASK_NAME, MonitorCloudFormationTask.class);
  }
}
