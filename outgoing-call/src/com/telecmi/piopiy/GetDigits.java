package com.telecmi.piopiy;


import java.io.StringWriter;
import java.math.BigInteger;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;


public class GetDigits {

public static void main(String args[]) throws Exception {
  
JSONObject getdigits = new JSONObject();
getdigits.put("start","https://example.com/voice/question.wav");
getdigits.put("invalid","https://example.com/voice/question.wav");
getdigits.put("min",1);
getdigits.put("max",1);
getdigits.put("post","https://example.com/whatnext");

JSONObject json = new JSONObject();

json.put("appid",11111);
json.put("secret","bgct45fg");
BigInteger to = new BigInteger("1234567891");
json.put("to",to);
json.put("get",getdigits);

String baseurl = "https://piopiy.telecmi.com/v1/getdigits";


DefaultHttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost(baseurl);
post.setHeader("Accept", "application/json");
post.setHeader("headerValue", "HeaderInformation");

StringEntity entity = new StringEntity(json.toString(), "UTF8");
entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
post.setEntity(entity);


HttpResponse response = client.execute(post);
HttpEntity objEntity = response.getEntity();

StringWriter writer=new StringWriter();
IOUtils.copy(objEntity.getContent(),writer);
System.out.println("==="+writer.toString());


    }



}