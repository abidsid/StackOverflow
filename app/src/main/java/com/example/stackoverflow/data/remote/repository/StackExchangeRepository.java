package com.example.stackoverflow.data.remote.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.stackoverflow.data.remote.api.ApiClient;
import com.example.stackoverflow.data.remote.api.ApiInterface;
import com.example.stackoverflow.data.remote.response.Question;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StackExchangeRepository {

    private final String TAG = "Repo";
    private final ArrayList<Question> _questionsList = new ArrayList<>();
    private final MutableLiveData<ArrayList<Question>> questionsList = new MutableLiveData<>();


    public MutableLiveData<ArrayList<Question>> getQuestionsList() {
        if (_questionsList.isEmpty()) {
            loadQuestionsList();
        }
        questionsList.setValue(_questionsList);
        return questionsList;
    }

    private void loadQuestionsList() {
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<Question>> call = apiInterface.getQuestionsList();
        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                if (response.isSuccessful()) {
                    _questionsList.clear();
                    if (response.body() != null) {
                        _questionsList.addAll(response.body());
                    }
                    questionsList.postValue(_questionsList);
                }
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

}
