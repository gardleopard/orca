package com.netflix.spinnaker.orca.clouddriver.tasks.providers.aws.cloudformation;

import com.google.common.collect.ImmutableMap;
import com.netflix.spinnaker.kork.artifacts.model.Artifact;
import com.netflix.spinnaker.orca.ExecutionStatus;
import com.netflix.spinnaker.orca.Task;
import com.netflix.spinnaker.orca.TaskResult;
import com.netflix.spinnaker.orca.clouddriver.KatoService;
import com.netflix.spinnaker.orca.clouddriver.OortService;
import com.netflix.spinnaker.orca.clouddriver.model.TaskId;
import com.netflix.spinnaker.orca.clouddriver.tasks.AbstractCloudProviderAwareTask;
import com.netflix.spinnaker.orca.pipeline.model.Stage;
import com.netflix.spinnaker.orca.pipeline.util.ArtifactResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class DeployCloudFormationTask extends AbstractCloudProviderAwareTask implements Task {

  @Autowired
  KatoService katoService;

  public static final String TASK_NAME = "deployCloudFormation";

  @Nonnull
  @Override
  public TaskResult execute(@Nonnull Stage stage) {
    String credentials = getCredentials(stage);
    String cloudProvider = getCloudProvider(stage);

    Map task = new HashMap(stage.getContext());

    Map<String, Map> operation = new ImmutableMap.Builder<String, Map>()
        .put(TASK_NAME, task)
        .build();

    TaskId taskId = katoService.requestOperations(cloudProvider, Collections.singletonList(operation)).toBlocking().first();

    Map<String, Object> outputs = new ImmutableMap.Builder<String, Object>()
        .put("kato.result.expected", true)
        .put("kato.last.task.id", taskId)
        .put("deploy.account.name", credentials)
        .build();

    return new TaskResult(ExecutionStatus.SUCCEEDED, outputs);

  }

  @Override
  public void onTimeout(@Nonnull Stage stage) {

  }

  @Override
  public void onCancel(@Nonnull Stage stage) {

  }
}
