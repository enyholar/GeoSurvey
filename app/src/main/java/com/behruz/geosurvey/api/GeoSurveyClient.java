package com.behruz.geosurvey.api;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amush on 12-Dec-17.
 */

public class GeoSurveyClient {
    private static Retrofit retrofit=null;
    public static OkHttpClient client;
    public static final String BASE_URL = "https://ids-survey.cfapps.io/api/v1/";

//    public static Retrofit getClient(String baseUrl)
//    {
//        if(retrofit==null)
//        {
//                        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//             client = new OkHttpClient.Builder()
//                     .connectTimeout(60, TimeUnit.SECONDS)
//                     .readTimeout(60, TimeUnit.SECONDS)
//                     .writeTimeout(60, TimeUnit.SECONDS)
//                     .addInterceptor(interceptor).build();
//
//            retrofit=new Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .client(client)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//
//
//
//
//
//

    public static Retrofit getRetrofit (){
         OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request originalRequest = chain.request();
//            Credentials.basic("aUsername", "aPassword")
                Request.Builder builder = originalRequest.newBuilder().header("Content-Type","application/json");

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        return new Retrofit.Builder()

                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
