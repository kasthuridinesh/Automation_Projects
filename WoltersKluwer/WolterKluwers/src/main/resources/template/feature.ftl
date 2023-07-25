Feature: ${feature}
Scenario: ${scenarioName}
<#list givenSteps as step>
  Given ${step}
</#list>
<#list thenSteps as step>
  Then ${step}
</#list>