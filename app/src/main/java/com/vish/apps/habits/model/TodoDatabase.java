package com.vish.apps.habits.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {TodoEntity.class}, version = 1)
public abstract class TodoDatabase extends RoomDatabase {

    public abstract TodoDao todoDao();

    private static TodoDatabase INSTANCE;

    public static TodoDatabase getDbInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TodoDatabase.class, "TODO_DB").allowMainThreadQueries().build();
        }

        return INSTANCE;
    }
}
