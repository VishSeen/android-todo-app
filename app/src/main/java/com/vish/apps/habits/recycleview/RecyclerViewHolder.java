package com.vish.apps.habits.recycleview;


import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vish.apps.habits.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private RadioButton radioButton;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        radioButton = itemView.findViewById(R.id.list_items_todo_radio_btn);
    }

    public RadioButton getRadioButton(){
        return radioButton;
    }
}