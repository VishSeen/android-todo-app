package com.vish.apps.habits.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vish.apps.habits.R;
import com.vish.apps.habits.adapters.TodoAdapter;
import com.vish.apps.habits.model.TodoDatabase;
import com.vish.apps.habits.model.TodoEntity;
import com.vish.apps.habits.object.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class TodoFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;
    private int mColumnCount = 1;
    private List<TodoEntity> mListTodo;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TodoFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TodoFragment newInstance(int columnCount) {
        TodoFragment fragment = new TodoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        mListTodo = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_todo_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        todoAdapter = new TodoAdapter(getContext(), mListTodo);
        recyclerView.setAdapter(todoAdapter);

        loadTodoList();

        return view;
    }


    // Loads every items in the local database
    public void loadTodoList() {
        TodoDatabase todoDatabase = TodoDatabase.getDbInstance(getContext());
        List<TodoEntity> listTodos = todoDatabase.todoDao().getAllTodo();
        todoAdapter.setTodoList(listTodos);
    }
}