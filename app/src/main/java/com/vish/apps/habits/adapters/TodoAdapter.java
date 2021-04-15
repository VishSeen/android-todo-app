package com.vish.apps.habits.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.vish.apps.habits.R;
import com.vish.apps.habits.model.TodoDatabase;
import com.vish.apps.habits.model.TodoEntity;
import com.vish.apps.habits.object.Todo;
import com.vish.apps.habits.recycleview.RecyclerViewHolder;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Context mContext;
    private List<TodoEntity> mListTodo;
    private TodoDatabase todoDatabase;

    public TodoAdapter(Context context, List<TodoEntity> listTodo) {
        mContext = context;
        mListTodo = listTodo;
        todoDatabase = Room.databaseBuilder(context, TodoDatabase.class, "TODO_DB").build();
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
        RadioButton radioButton = holder.getRadioButton();

        radioButton.setText(mListTodo.get(position).mTitle);

        if (mListTodo.get(position).mIsDone) {
            radioButton.setChecked(true);
        }

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, radioButton.getText(), Toast.LENGTH_SHORT).show();
//                todoDatabase.todoDao().updateCheckState(true, radioButton.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListTodo.size();
    }

    public void setTodoList(List<TodoEntity> listTodo) {
        mListTodo = listTodo;
        notifyDataSetChanged();
    }

}

