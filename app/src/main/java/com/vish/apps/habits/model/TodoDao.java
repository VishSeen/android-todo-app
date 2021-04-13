package com.vish.apps.habits.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todoentity")
    List<TodoEntity> getAllTodo();

    @Insert
    void insertTodo(TodoEntity... todoEntities);

    @Delete
    void delete(TodoEntity todoEntity);
}
