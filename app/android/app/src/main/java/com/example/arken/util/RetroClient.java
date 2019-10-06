package com.example.arken.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    private static final String BASE_URL = "http://api.dev.arkenstone.ml/auth/";
    private Retrofit retrofit = null;
    private static RetroClient mInstance;

    public RetroClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }
    public static synchronized RetroClient getInstance(){
         if(mInstance == null){
             mInstance = new RetroClient();
         }
         return mInstance;
    }
    public APIService getAPIService(){
        return retrofit.create(APIService.class);
    }
}