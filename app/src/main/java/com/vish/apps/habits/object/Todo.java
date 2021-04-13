package com.vish.apps.habits.object;

public class Todo {
    private static int mId;
    private String mTitle;
    private int mCategory; // 0 - personal, 1 - shopping, 2 - important, 3 - other
    private boolean mDone;


    public Todo() {
        mId += 1;
    }

    public Todo(String title, int category, boolean done){
        mTitle = title;
        mCategory = category;
        mDone = done;
    }


    public void setId(int id) {
        mId = id;
    }
    public void setTitle(String title) {
        mTitle = title;
    }
    public void setCategory(int category) {
        mCategory = category;
    }


    public static int getId() {
        return mId;
    }
    public String getTitle() {
        return mTitle;
    }
    public int getCategory() {
        return mCategory;
    }
}
