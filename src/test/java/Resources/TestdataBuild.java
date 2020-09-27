package Resources;

import java.util.ArrayList;
import java.util.List;

import POJOS.AddlocationPOJO;

public class TestdataBuild {

	
	public AddlocationPOJO addLocationPayload(String name, String language, String address)
	{
	POJOS.AddlocationPOJO p= new POJOS.AddlocationPOJO();
	p.setAccuracy(50);
	p.setAddress(address);
	p.setLanguage(language);
	p.setPhone_number("9487555745");
	p.setName(name);
	
	List<String> mylist= new ArrayList<String>();
	mylist.add("shoe park");
	mylist.add("shop");

	p.setTypes(mylist);
	p.setWebsite("http://google.com");
	
	POJOS.LocationPOJO lp= new POJOS.LocationPOJO();
	lp.setLat(-38.383494);
	lp.setLng(33.427362);
	p.setLocation(lp);
	
	return p;
}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n" + 
				"    \"place_id\": \""+placeId+"\"\r\n" + 
				"}";
	}

}