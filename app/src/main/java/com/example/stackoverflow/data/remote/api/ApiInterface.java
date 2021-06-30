package com.example.stackoverflow.data.remote.api;

import com.example.stackoverflow.data.remote.response.QuestionList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("advanced-search#order=desc&sort=activity&accepted=True&filter=default&site=stackoverflow")
    Call<QuestionList> getQuestionsList();

}
