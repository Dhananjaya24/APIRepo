package Resources;

public enum APIEndpointResources {
	
	AddPlaceAPI("maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	String apiResource;
	APIEndpointResources(String apiResource)
	{
		this.apiResource=apiResource;
	}
	
	public String getAPIResource()
	{
		return apiResource;
	}

}
