package com.example.hp.cliser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ankush on 07-Feb-17.
 */

public interface ApiCall {

    String BASE_URL = "http://b0e39123.ngrok.io";

    @GET("/")
    Call<List<String>> getResponse(@Query("string1") String str1, @Query("string2") String str2);

    public class Factory {
        public static ApiCall service;

        public static ApiCall getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
                service = retrofit.create(ApiCall.class);
                return service;
            } else {
                return service;
            }
        }
    }
}
