package week2.week2day3;

public class APIClient {
	public void sendRequest(String endpoint)
	{
		System.out.println("sendRequest endpoint is" + endpoint);
		
	}
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) 
	{
		System.out.println("sendRequest endpoint is " + endpoint);
		System.out.println("sendRequest sends " + requestBody);
		System.out.println(requestStatus);
		
		
	}

	public static void main(String[] args) 
	{
		APIClient api = new APIClient();
		api.sendRequest("www.google.com");
		api.sendRequest("www.amazon.in", "request body", false);

	}

}
