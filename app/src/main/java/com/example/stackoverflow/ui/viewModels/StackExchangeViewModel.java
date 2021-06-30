package com.example.stackoverflow.ui.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.stackoverflow.data.remote.repository.StackExchangeRepository;
import com.example.stackoverflow.data.remote.response.Question;

import java.util.List;

public class StackExchangeViewModel extends ViewModel {


    private final StackExchangeRepository stackExchangeRepository = new StackExchangeRepository();

    public LiveData<List<Question>> getQuestionsList() {
        return stackExchangeRepository.getQuestionsList();
    }


}
