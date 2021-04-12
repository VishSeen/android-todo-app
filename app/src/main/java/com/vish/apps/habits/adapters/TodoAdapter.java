package com.vish.apps.habits.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vish.apps.habits.R;
import com.vish.apps.habits.model.Todo;
import com.vish.apps.habits.recycleview.RecyclerViewHolder;

import java.util.List;
import java.util.Random;

public class TodoAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<Todo> mListTodo;

    public TodoAdapter(List<Todo> listTodo) {
        mListTodo = listTodo;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.list_items_todo;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getRadioButton().setText(mListTodo.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mListTodo.size();
    }
}

