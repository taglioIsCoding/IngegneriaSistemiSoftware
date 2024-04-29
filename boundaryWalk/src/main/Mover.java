package main;

import java.net.URI;
import java.util.Observable;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import unibo.basicomm23.interfaces.IObservable;
import unibo.basicomm23.interfaces.IObserver;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;
import unibo.basicomm23.utils.ConnectionFactory;

public class Mover {

	private  JSONParser simpleparser = new JSONParser();
	private  final String localHostName    = "localhost"; //"localhost"; 192.168.1.7
    private  final int port                = 8090;
    private  final String URL              = "http://"+localHostName+":"+port+"/api/move";
    private CloseableHttpClient httpclient = HttpClients.createDefault();

    public Mover() {
    	
    }
    
	protected JSONObject callHTTP( String crilCmd )  {
		JSONObject jsonEndmove = null;
		 try {
		   StringEntity entity = new StringEntity(crilCmd);
		   HttpUriRequest httppost = RequestBuilder.post()
		      .setUri(new URI(URL))
		      .setHeader("Content-Type", "application/json")
		      .setHeader("Accept", "application/json")
		      .setEntity(entity)
		      .build();
		   CloseableHttpResponse response = httpclient.execute(httppost);
		   String jsonStr = EntityUtils.toString( response.getEntity() );
		   jsonEndmove    = (JSONObject) simpleparser.parse(jsonStr);
		 } catch(Exception e){}
		 return jsonEndmove;
	}
	
	public void moveAround() {
		JSONObject result;
		do {
			result = this.callHTTP("{\"robotmove\":\"moveForward\"  , \"time\": \"1000\"}");
		} while (result.get("endmove").equals("true") && result.get("move").equals("moveForward"));
		this.callHTTP("{\"robotmove\":\"turnLeft\"  , \"time\": \"300\"}");
		
		do {
			result = this.callHTTP("{\"robotmove\":\"moveForward\"  , \"time\": \"1000\"}");
		} while (result.get("endmove").equals("true") && result.get("move").equals("moveForward"));
		this.callHTTP("{\"robotmove\":\"turnLeft\"  , \"time\": \"300\"}");
		
		do {
			result = this.callHTTP("{\"robotmove\":\"moveForward\"  , \"time\": \"1000\"}");
		} while (result.get("endmove").equals("true") && result.get("move").equals("moveForward"));
		this.callHTTP("{\"robotmove\":\"turnLeft\"  , \"time\": \"300\"}");
		
		do {
			result = this.callHTTP("{\"robotmove\":\"moveForward\"  , \"time\": \"1000\"}");
		} while (result.get("endmove").equals("true") && result.get("move").equals("moveForward"));
		this.callHTTP("{\"robotmove\":\"turnLeft\"  , \"time\": \"300\"}");
		
		
		CommUtils.outblue("moveForward result=" + result);
	}
	
}
