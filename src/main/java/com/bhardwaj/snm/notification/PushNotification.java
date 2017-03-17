package com.bhardwaj.snm.notification;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.mail.iap.Response;

public class PushNotification {
	
	public void notificationResult() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("https://fcm.googleapis.com/fcm/send");
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", "key=AIzaSyDtIO0WQzcnhzLHCUZi-ASKIg867E8bM4Q");
		JSONObject message = new JSONObject();
		
		JSONObject notification = new JSONObject();
		try {
			message.put("to", "");
			message.put("priority", "high");
			notification.put("title", "Java");
			notification.put("body", "Notification to java");
			message.put("notification", notification);
			post.setEntity(new StringEntity(message.toString(), "UTF-8"));
			HttpResponse httpResponse = httpClient.execute(post);
			System.out.println("httpResponse" + httpResponse);
			System.out.println("message" + message);
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
