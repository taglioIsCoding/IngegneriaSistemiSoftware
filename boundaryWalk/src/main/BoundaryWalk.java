package main;

import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import unibo.basicomm23.utils.CommUtils;

public class BoundaryWalk {
	
	
	public static void main(String[] args) {
		MoverWs mover = new MoverWs("localhost:8091/");
		//mover.moveAround();
		
		//JSONObject result = callHTTP("{\"robotmove\":\"moveForward\"  , \"time\": \"1000\"}");
	}


}
