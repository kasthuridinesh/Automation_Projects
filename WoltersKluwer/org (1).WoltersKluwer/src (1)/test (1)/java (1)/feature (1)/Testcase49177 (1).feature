Feature: 
MMC_Organization_Edit_Person
Scenario Outline: 
TC:49177
Given  I login as Admin with datacert

Then  I prepare list screenInternalwith given mode 'Normal'

Then  I prepare item screen 'Base Org Header' for the entity 'Organization' in mode 'Add'

Then  I provide field 'Name' with value '[#]OrgName'

Then I provide field 'Organization Type' with value '[#]OrgType'

Then I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'

Then I provide field 'Vendor ID' with value '[#]OrgNum'

Then I invoke operation 'Save'

Then I prepare list screen 'Organization List' with given mode 'Normal'

Then  I remove all search filters

Then  I add search filters perform search and store result in a variable '_ParentInstanceId'

Then  I verify list row count '[#]count'

Examples: 
 | Scenario | 
 |    1   |