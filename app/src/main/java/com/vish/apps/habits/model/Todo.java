package com.vish.apps.habits.model;

public class Todo {
    private static int mId;
    private String mTitle;
    private boolean mTodoDone;

    public Todo() {
        mId =+ 1;
    }

    public Todo(String title, boolean todoDone) {
        mTitle = title;
        mTodoDone = todoDone;
    }

    // GETTERS
    public String getTitle() {
        return mTitle;
    }
    public boolean getDone() {
        return mTodoDone;
    }

    // SETTERS
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
    public void setTodoDone(boolean mTodoDone) {
        this.mTodoDone = mTodoDone;
    }
}
