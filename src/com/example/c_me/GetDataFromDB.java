package com.example.c_me;

// CHAT.java  CLASS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
 
public class GetDataFromDB {
 
    public String getDataFromDB() {
        try {
 
            HttpPost httppost;
            HttpClient httpclient;
            httpclient = new DefaultHttpClient();
            httppost = new HttpPost(
                    "http://resound.esy.es/androidselect.php"); // <span id="IL_AD4" class="IL_AD">change</span> this to your URL.....
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httppost,
                    responseHandler);
             
            return response.trim();
 
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
            return "error";
        }
    }
}