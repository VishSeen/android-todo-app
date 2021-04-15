package com.vish.apps.habits.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todoentity WHERE todo_is_done == 0")
    List<TodoEntity> getTodo();

    @Query("SELECT * FROM todoentity WHERE todo_is_done == 1")
    List<TodoEntity> getCompleted();

    @Query("SELECT * FROM todoentity WHERE todo_category LIKE :category")
    TodoEntity findByCategory(int category);

    @Insert
    void insertTodo(TodoEntity... todoEntities);

    @Delete
    void delete(TodoEntity todoEntity);

    @Query("DELETE FROM todoentity")
    void deleteAll();

//    @Query("UPDATE todoentity SET todo_is_done = :isDone WHERE todo_id =:id")
//    void updateCheckState(boolean isDone, int id);
}
