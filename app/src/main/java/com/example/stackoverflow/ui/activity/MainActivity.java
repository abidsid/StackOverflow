package com.example.stackoverflow.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.stackoverflow.R;
import com.example.stackoverflow.databinding.ActivityMainBinding;
import com.example.stackoverflow.ui.adapters.QuestionAdapter;
import com.example.stackoverflow.ui.viewModels.StackExchangeViewModel;

public class MainActivity extends AppCompatActivity implements QuestionAdapter.QuestionsInterface {

    private ActivityMainBinding binding;
    private StackExchangeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);
        setContentView(binding.getRoot());
        setupTheme();
    }

    public void setupTheme() {
        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        viewModel = new ViewModelProvider(this, factory).get(StackExchangeViewModel.class);

        QuestionAdapter questionAdapter = new QuestionAdapter(this);
        binding.recyclerView.setAdapter(questionAdapter);

        viewModel.getQuestionsList().observe(this, questionLists -> {
            if (questionLists != null) {
                Log.d("MainActivity", "setupTheme: Questions " + questionLists.size());
                questionAdapter.updateList(questionLists);
            }
        });
    }


    @Override
    public void onShowButtonClick(String link) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}