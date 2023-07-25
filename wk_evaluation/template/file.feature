Feature: Creating Internal Organization

Scenario Outline: Create an internal organization record

Given I login as admin and datacert
Then  I prepare item screen 'Base Org Header' for the entity 'Organization' in mode 'Add'


Then I prepare list screen 'Organization List' with given mode 'Normal' 
Then I remove all search filters
Then I add search filters perform search and store result in a variable '_ParentInstanceId'
Then I provide field 'Organization Type' with value '[#]OrgType'
ThenI provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'
Then I provide field 'Vendor ID' with value '[#]OrgNum'
Then I invoke operation 'Save'

Then I provide field 'Organization Type' with value '[#]OrgType'
Then I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'
Then I provide field 'Vendor ID' with value '[#]OrgNum'
Then I invoke operation 'Save'


Examples:
| Scenario |
|    1     |
