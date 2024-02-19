Feature: ServiceNow Incident Management - Incidents

@CreateIncident
Scenario: TC001 Create Incident with Request body as file
Given Set the endpoint for ServiceNow Incident Management
And Set the authentication for ServiceNow
And Set the QueryParam for Create Incident Request
And Set the Content Type for Create Incident Request
And Set the Accept for Create Incident Request
And Set the request body as 'CreateRequest.json' Create Incident Request
When Send the POST request to ServiceNow Incident Management
Then Validate the Status code as 201
And Validate the response that has number starts with INC

@CreateIncident
Scenario: TC002 Create Incident with Request body as file
Given Set the endpoint for ServiceNow Incident Management
And Set the authentication for ServiceNow
And Set the QueryParam for Create Incident Request
And Set the Content Type for Create Incident Request
And Set the Accept for Create Incident Request
And Set the request body as 'CreateRequestWithSoftware.json' Create Incident Request
When Send the POST request to ServiceNow Incident Management
Then Validate the Status code as 201
And Validate the response that has number starts with INC

@RunTest
Scenario Outline: TC003 Create Incident with Request body as file
Given Set the endpoint for ServiceNow Incident Management
And Set the authentication for ServiceNow
And Set the QueryParam for Create Incident Request
And Set the Content Type for Create Incident Request
And Set the Accept for Create Incident Request
And Set the request body as <File_Name> Create Incident Request
When Send the POST request to ServiceNow Incident Management
Then Validate the Status code as 201
And Validate the response that has number starts with INC

Examples:
|File_Name|
|CreateRequest.json|
|CreateRequestWithSoftware.json|

@RunTest @GetIncident
Scenario: TC004 Get all Incident with Category as filter
Given Set the endpoint for ServiceNow Incident Management
And Set the authentication for ServiceNow
And Set the QueryParam in the Request
|sysparm_fields|sys_id, number, category, description, short_description|
|category|software|
And Set the Accept for Create Incident Request
And Set the request body as 'CreateRequestWithSoftware.json' Create Incident Request
When Send the GET request to ServiceNow Incident Management
Then Validate the Status code as 200