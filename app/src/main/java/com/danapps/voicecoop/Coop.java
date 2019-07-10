package com.danapps.voicecoop;

public class Coop {

    private int id;

    private boolean isCompleted;

    public Coop(int id, boolean isCompleted) {
        this.id = id;
        isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
