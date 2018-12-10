package com.netflix.spinnaker.orca.clouddriver.tasks.providers.aws.cloudformation;

import com.netflix.spinnaker.orca.ExecutionStatus;
import com.netflix.spinnaker.orca.Task;
import com.netflix.spinnaker.orca.TaskResult;
import com.netflix.spinnaker.orca.pipeline.model.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.UUID;

@Slf4j
@Component
public class UploadCloudFormationTask implements Task {

  public static final String TASK_NAME = "uploadCloudFormation";

  @Nonnull
  @Override
  public TaskResult execute(@Nonnull Stage stage) {
    log.info("I AM EXECUTING");

    return new TaskResult(ExecutionStatus.SUCCEEDED, Collections.emptyMap(),
        Collections.singletonMap("cloudFormationTaskId", UUID.randomUUID()));
  }

  @Override
  public void onTimeout(@Nonnull Stage stage) {

  }

  @Override
  public void onCancel(@Nonnull Stage stage) {

  }
}
