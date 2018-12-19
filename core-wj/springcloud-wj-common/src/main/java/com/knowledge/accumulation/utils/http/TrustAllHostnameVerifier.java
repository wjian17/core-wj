package com.knowledge.accumulation.utils.http;


import javax.net.ssl.*;
import java.security.SecureRandom;

public class TrustAllHostnameVerifier implements HostnameVerifier {

    public boolean verify(String s, SSLSession sslSession) {
        return true;
    }
    public static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null,  new TrustManager[] { new TrustAllCerts() }, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }
        return ssfFactory;
    }
}
