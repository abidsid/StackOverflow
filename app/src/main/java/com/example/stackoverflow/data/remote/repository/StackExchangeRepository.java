package com.example.stackoverflow.data.remote.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.stackoverflow.data.remote.api.ApiClient;
import com.example.stackoverflow.data.remote.api.ApiInterface;
import com.example.stackoverflow.data.remote.response.Question;
import com.example.stackoverflow.data.remote.response.QuestionList;

import java.util.ArrayList;
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
        Call<QuestionList> call = apiInterface.getQuestionsList();
        call.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                if (response.isSuccessful()) {
                    _questionsList.clear();
                    if (response.body() != null) {
                        for (Question question : response.body().getQuestions()) {
                            if (question.getAnswer_count() > 1) {
                                _questionsList.add(question);
                            }
                        }
                    }
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
