package com.vish.apps.habits.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vish.apps.habits.R;
import com.vish.apps.habits.model.TodoEntity;
import com.vish.apps.habits.object.Todo;
import com.vish.apps.habits.recycleview.RecyclerViewHolder;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Context mContext;
    private List<TodoEntity> mListTodo;

    public TodoAdapter(Context context, List<TodoEntity> listTodo) {
        mContext = context;
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
        holder.getRadioButton().setText(mListTodo.get(position).mTitle);
    }

    @Override
    public int getItemCount() {
        return mListTodo.size();
    }

    public void setTodoList(List<TodoEntity> listTodos) {
        mListTodo = listTodos;
        notifyDataSetChanged();
    }

}

