package com.vish.apps.habits.fragment;

import android.os.Bundle;

import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.vish.apps.habits.R;
import com.vish.apps.habits.model.TodoDatabase;
import com.vish.apps.habits.model.TodoEntity;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    private TodoDatabase todoDatabase;
    private EditText edtTitle;
    private Button btnAdd;
    private Button btnCancel;


    public BottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        todoDatabase = Room.databaseBuilder(getContext(), TodoDatabase.class, "database-name").build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_add_habit, container, false);
        edtTitle = (EditText) view.findViewById(R.id.bottom_sheet_add_edt_add_habit);
        btnCancel = (Button) view.findViewById(R.id.bottom_sheet_button_cancel);
        btnAdd = (Button) view.findViewById(R.id.bottom_sheet_button_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoTitle = edtTitle.getText().toString();
                saveTodo(todoTitle, 0, false);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });


        return view;
    }



    private void saveTodo(String title, int category, boolean isDone) {
        TodoDatabase todoDatabase = TodoDatabase.getDbInstance(getActivity().getApplicationContext());

        TodoEntity todo = new TodoEntity();
        todo.mTitle = title;
        todo.mCategory = category;
        todo.mIsDone = isDone;

        todoDatabase.todoDao().insertTodo(todo);
    }
}