package com.example.c_me;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// CLASS CREATED TO HANDLE ALL LINKS
public class HelloWebViewClient extends WebViewClient {
	
	  @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) 
	    {
	        view.loadUrl(url);
	        return true;

}
}