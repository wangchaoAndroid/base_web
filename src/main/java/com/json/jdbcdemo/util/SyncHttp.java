package com.json.jdbcdemo.util;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class SyncHttp {
	public static final String CODE = "statusCode";

	public static String httpGet(String url_str, String params) {
		String response = "";
		if (null != params && !params.equals("")) {
			url_str += "?" + params;
		}
		try {
			int timeoutConnection = 20000;
			int timeoutSocket = 20000;
			HttpParams httpParameters = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParameters,
					timeoutConnection);
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

			HttpClient httpClient = new DefaultHttpClient(httpParameters);
			URL url = new URL(url_str);
			URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
			HttpGet httpGet = new HttpGet(uri);	
			HttpResponse httpResponse = httpClient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				response = EntityUtils.toString(httpResponse.getEntity(),
						"utf-8");
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return response;
	}

	public static String httpPost(String url, List<NameValuePair> params) {
		String response = CODE + ":null";
		int timeoutConnection = 20000;
		int timeoutSocket = 20000;
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters,
				timeoutConnection);
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

		HttpClient httpClient = new DefaultHttpClient(httpParameters);
		HttpPost httpPost = new HttpPost(url);

		try {
			if (params.size() >= 0) {
				httpPost
						.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			}
			HttpResponse httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				response = EntityUtils.toString(httpResponse.getEntity(),
						"utf-8");
			} else {
				response = CODE + ":" + statusCode;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			if (e instanceof UnknownHostException) {
				response = CODE
						+ ":IP address of a host could not be determined";
			}
			if (e instanceof ConnectTimeoutException) {
				response = CODE + ":timed out";
			}
			e.printStackTrace();
		}
		return response;
	}

}
