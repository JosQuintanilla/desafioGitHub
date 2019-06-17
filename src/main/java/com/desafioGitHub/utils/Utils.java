package com.desafioGitHub.utils;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public abstract class Utils {

	public static RestTemplate getRestTemplate()
            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

    	TrustManager[] trustAllCerts = new TrustManager[]{
    			
    			new X509TrustManager() {
    				
    				@Override
    				public X509Certificate[] getAcceptedIssuers() {
    					return null;
    				}

    				@Override
    				public void checkClientTrusted(X509Certificate[] certs, String authType) {
    				}

    				@Override
    				public void checkServerTrusted(X509Certificate[] certs, String authType) {
    				}
    			}
    	};

        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(
        		sc,new String[]{"TLSv1.2"}, null, new NoopHostnameVerifier());

        CloseableHttpClient httpClient = org.apache.http.impl.client.HttpClients.custom().setSSLSocketFactory(csf).build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
            
        return restTemplate;
    }
}