package com.vish.apps.habits.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TodoEntity {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "todo_title")
    public String mTitle;

    @ColumnInfo(name = "todo_category")
    public int mCategory;

    @ColumnInfo(name = "todo_is_done")
    public boolean mIsDone;
}
