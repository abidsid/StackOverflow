package com.example.stackoverflow.ui.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stackoverflow.data.remote.response.Question;
import com.example.stackoverflow.databinding.ItemQuestionBinding;

import java.util.Collections;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {

    private DiffUtil.ItemCallback<Question> diffUtilCallback = new DiffUtil.ItemCallback<Question>() {
        @Override
        public boolean areItemsTheSame(@NonNull Question oldItem, @NonNull Question newItem) {
            return oldItem.getQuestion_id() == newItem.getQuestion_id();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Question oldItem, @NonNull Question newItem) {
            return oldItem.equals(newItem);
        }
    };
    private AsyncListDiffer<Question> differ = new AsyncListDiffer<>(this, diffUtilCallback);
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
        Question question = differ.getCurrentList().get(position);
        holder.binding.setQuestion(question);
        holder.binding.setListener(listener);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }

    public void updateList(List<Question> questionsList) {
        if (questionsList.isEmpty()) {
//            differ.submitList(Collections.emptyList());
            return;
        }
        differ.submitList(questionsList);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemQuestionBinding binding;

        public MyViewHolder(@NonNull ItemQuestionBinding viewBinding) {
            super(viewBinding.getRoot());
            binding = viewBinding;
        }
    }

    public interface QuestionsInterface {
        void onShowButtonClick(String link);
    }

}
