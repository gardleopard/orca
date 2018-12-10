package com.netflix.spinnaker.orca.clouddriver.pipeline.providers.aws

import com.netflix.spinnaker.orca.pipeline.TaskNode
import com.netflix.spinnaker.orca.pipeline.model.Execution
import com.netflix.spinnaker.orca.pipeline.model.Stage
import spock.lang.Specification
import spock.lang.Subject

class CloudFormationStageTest extends Specification {

  def builder = new TaskNode.Builder()

  @Subject
  def cloudFormationStage = new CloudFormationStage()

  def "should return CloudFormation execution ID"() {
    given:
    def stage = new Stage(new Execution(Execution.ExecutionType.PIPELINE, "testApp"), "cf_1", [:])

    when:
    cloudFormationStage.taskGraph(stage, builder)

    then:
    stage.context == [:]
  }

}
