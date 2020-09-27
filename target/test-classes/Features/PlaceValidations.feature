Feature: Validating place API
@AddPlace @Sanity
Scenario Outline: Verify if place is being added using AddPlaceAPI
	Given Add place payload "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" http request
	Then Then API call should give reponse status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And Verify created place_id maps to "<name>" using "GetPlaceAPI"
Examples:
	|name	|language	|address	|
	|HouseNameCC|Telugu|Sweet Home|
#	|Bangalore house|Kannada|Rent Home|

@DeletePlace @Sanity
Scenario: Verify Delete place funcationality
	Given Delete place payload
	When user calls "DeletePlaceAPI" with "POST" http request
	Then Then API call should give reponse status code 200
	And "status" in response body is "OK"
	
	
	
	