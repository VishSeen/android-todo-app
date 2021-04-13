package com.vish.apps.habits.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vish.apps.habits.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmptyStateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmptyStateFragment extends Fragment {


    public EmptyStateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmptyStateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmptyStateFragment newInstance(String param1, String param2) {
        EmptyStateFragment fragment = new EmptyStateFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_empty_habit_state, container, false);

        // Inflate the layout for this fragment
        return rootView;
    }
}