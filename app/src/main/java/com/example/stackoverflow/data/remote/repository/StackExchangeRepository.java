package com.example.stackoverflow.data.remote.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.stackoverflow.data.remote.api.ApiClient;
import com.example.stackoverflow.data.remote.api.ApiInterface;
import com.example.stackoverflow.data.remote.response.Question;
import com.example.stackoverflow.data.remote.response.QuestionList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StackExchangeRepository {

    private final String TAG = "Repo";
    private final ArrayList<Question> _questionsList = new ArrayList<>();
    private final MutableLiveData<List<Question>> questionsList = new MutableLiveData<>();


    public MutableLiveData<List<Question>> getQuestionsList() {
        if (_questionsList.isEmpty()) {
            loadQuestionsList();
        }
        questionsList.setValue(_questionsList);
        return questionsList;
    }

    private void loadQuestionsList() {
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -2);

        Call<QuestionList> call = apiInterface.getQuestionsList(
                calendar.getTimeInMillis() / 1000,
                "desc",
                "activity",
                "True",
                2,
                "stackoverflow"
        );

        Log.d(TAG, "Response : " + call.request());
        Log.d(TAG, "Response : " + call.request().url());
        Log.d(TAG, "Response : " + call.request().toString());
        call.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                Log.d(TAG, "Response : " + response.raw());
                if (response.isSuccessful()) {
                    _questionsList.clear();
                    if (response.body() != null) {
                        Log.d(TAG, "Response: " + response.body().getItems().size());
                        _questionsList.addAll(response.body().getItems());
                    }
                    Log.d(TAG, "Live Data " + _questionsList.size());
                    questionsList.postValue(_questionsList);
                }
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

}
