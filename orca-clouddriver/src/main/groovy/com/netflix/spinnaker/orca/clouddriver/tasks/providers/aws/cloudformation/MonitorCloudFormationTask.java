package com.netflix.spinnaker.orca.clouddriver.tasks.providers.aws.cloudformation;

import com.netflix.spinnaker.orca.Task;
import com.netflix.spinnaker.orca.TaskResult;
import com.netflix.spinnaker.orca.pipeline.model.Stage;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Random;

@Component
public class MonitorCloudFormationTask implements Task {

  public static final String TASK_NAME = "monitorCloudFormation";

  @Nonnull
  @Override
  public TaskResult execute(@Nonnull Stage stage) {
    if (new Random().nextInt(10) > 8) {
      return TaskResult.RUNNING;
    }
    return TaskResult.SUCCEEDED;
  }
}
