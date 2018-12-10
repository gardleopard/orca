package com.netflix.spinnaker.orca.clouddriver.pipeline.providers.aws;

import com.netflix.spinnaker.orca.clouddriver.tasks.providers.aws.cloudformation.MonitorCloudFormationTask;
import com.netflix.spinnaker.orca.clouddriver.tasks.providers.aws.cloudformation.UploadCloudFormationTask;
import com.netflix.spinnaker.orca.pipeline.StageDefinitionBuilder;
import com.netflix.spinnaker.orca.pipeline.TaskNode;
import com.netflix.spinnaker.orca.pipeline.model.Stage;

import javax.annotation.Nonnull;

public class CloudFormationStage implements StageDefinitionBuilder {
  @Override
  public void taskGraph(@Nonnull Stage stage, @Nonnull TaskNode.Builder builder) {
    builder.withTask(UploadCloudFormationTask.TASK_NAME, UploadCloudFormationTask.class)
    .withTask(MonitorCloudFormationTask.TASK_NAME, MonitorCloudFormationTask.class);
  }
}
