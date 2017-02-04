package com.mygdx.game;

/**
 * Created by JavaDev on 04.02.2017.
 */

public class Cell {

    int value;
    int kind;
    boolean isActive;

    public Cell(boolean isActive, int kind, int value) {
        this.isActive = isActive;
        this.kind = kind;
        this.value = value;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
