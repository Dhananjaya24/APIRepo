package StepDefination;

import java.io.IOException;

import cucumber.api.java.Before;

public class Hooks {
	
	AddPlace ap = new AddPlace();
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		if(AddPlace.placeId==null)
		{
		ap.add_place_payload("Placename", "language", "address");
		ap.user_calls_with_post_http_request("AddPlaceAPI", "POST");
		ap.verify_created_place_id_maps_to_using("Placename", "GetPlaceAPI");
		}
	}

}
