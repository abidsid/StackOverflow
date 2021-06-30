package com.example.stackoverflow.data.remote.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://api.stackexchange.com/2.3/";
    private static Retrofit retrofit;

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC);


    private static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(logging)
            .build();

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }


}
