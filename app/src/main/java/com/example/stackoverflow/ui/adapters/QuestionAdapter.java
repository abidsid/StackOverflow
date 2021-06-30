package com.example.stackoverflow.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stackoverflow.data.remote.response.Question;
import com.example.stackoverflow.databinding.ItemQuestionBinding;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {

    private final ArrayList<Question> items = new ArrayList<>();
    private final QuestionsInterface listener;

    public QuestionAdapter(QuestionsInterface listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemQuestionBinding binding = ItemQuestionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Question question = items.get(position);
        holder.binding.setQuestion(question);
        holder.binding.setListener(listener);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateList(List<Question> questionsList) {
        items.clear();
        items.addAll(questionsList);
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemQuestionBinding binding;

        public MyViewHolder(@NonNull ItemQuestionBinding viewBinding) {
            super(viewBinding.getRoot());
            binding = viewBinding;
        }
    }

    public interface QuestionsInterface {
        void onShowButtonClick(String link);
    }

}
