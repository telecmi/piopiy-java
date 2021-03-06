package com.telecmi.piopiy;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

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


public class PhoneToPhone {

public static void main(String args[]) throws Exception {
   


JSONObject json = new JSONObject();
json.put("appid",11111);
json.put("secret","bgct45fg");
BigInteger from = new BigInteger("1234567890");
json.put("from",from);
BigInteger to = new BigInteger("1234567891");
json.put("to",to);


String baseurl = "https://piopiy.telecmi.com/v1/phone2phone";


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