package com.example.stackoverflow.data.remote.api;

import com.example.stackoverflow.data.remote.response.QuestionList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Accept: application/json")
    @GET("search/advanced")
    Call<QuestionList> getQuestionsList(
            @Query("fromdate") long fromDate,
            @Query("order") String order,
            @Query("sort") String sort,
            @Query("accepted") String accepted,
            @Query("answers") int answers,
            @Query("site") String stackoverflow
    );

}
