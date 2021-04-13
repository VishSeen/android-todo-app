package com.vish.apps.habits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vish.apps.habits.fragment.BottomSheetFragment;
import com.vish.apps.habits.fragment.EmptyStateFragment;
import com.vish.apps.habits.fragment.TodoFragment;
import com.vish.apps.habits.model.TodoDatabase;
import com.vish.apps.habits.model.TodoEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mBtnTodo;
    private Button mBtnCompleted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// TODO: an if statement to hide the empty state when the todo list has tasks
        TodoDatabase db = TodoDatabase.getDbInstance(getApplicationContext());
        List<TodoEntity> listInDb = db.todoDao().getAllTodo();

        if(listInDb.size() != 0) {
            loadFragment(new TodoFragment());
        } else {
            loadFragment(new EmptyStateFragment());
        }

        mBtnTodo = (Button) findViewById(R.id.act_main_bottom_nav_btn_todo);
        mBtnCompleted = (Button) findViewById(R.id.act_main_bottom_nav_btn_completed);

    }


    /** Click events */
    public void btnFabAddClicked(View v) {
        View view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet_add_habit, null);
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }

    public void btnBottomNavTodo(View view) {
        mBtnTodo.setBackgroundResource(R.drawable.back_bottom_nav_active);
        mBtnTodo.setTextColor(getResources().getColor(R.color.white_primary_text));

        mBtnCompleted.setBackgroundResource(R.drawable.back_bottom_nav_inactive);
        mBtnCompleted.setTextColor(getResources().getColor(R.color.black_primary_text));

        loadFragment(new TodoFragment());
    }
    public void btnBottomNavCompleted(View view) {
        mBtnCompleted.setBackgroundResource(R.drawable.back_bottom_nav_active);
        mBtnCompleted.setTextColor(getResources().getColor(R.color.white_primary_text));

        mBtnTodo.setBackgroundResource(R.drawable.back_bottom_nav_inactive);
        mBtnTodo.setTextColor(getResources().getColor(R.color.black_primary_text));

        loadFragment(new EmptyStateFragment());
    }



    /**
     * Used to load Fragments depending of the
     * state of the app.
     *
     * @param fragment Fragment to switch to.
     */
    public void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // fragmentTransaction to do transaction of replacing fragments
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit);

        // replace frame layout with current Fragment
        fragmentTransaction.replace(R.id.act_main_frame_layout, fragment);

        // validate the transaction
        fragmentTransaction.commit();
    }
}