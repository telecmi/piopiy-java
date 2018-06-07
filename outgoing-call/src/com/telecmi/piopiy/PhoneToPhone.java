package com.telecmi.piopiy;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;


public class PhoneToPhone {

public static void main(String args[]) {
   


JSONObject json = new JSONObject();

json.put("appid",11111);
json.put("secret","bgct45fg");
json.put("from",9894);
json.put("to",9677);


String baseurl = "https://piopiy.telecmi.com/v1/getdigits";


DefaultHttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost(baseurl);
post.setHeader("Accept", "application/json");
post.setHeader("headerValue", "HeaderInformation");

StringEntity entity = new StringEntity(json.toString(), "UTF8");
entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
post.setEntity(entity);


HttpResponse response = client.execute(post);
System.out.println("Response: " + response.getStatusLine());
return response.getStatusLine().toString();

    }

}