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

    public String getName(){
        switch (kind){
            case 0:
                return "WHITE";
            case 1:
                return "RED";
            case 2:
                return "BLUE";
            case 3:
                return "GREEN";
            case 4:
                return "PINK";

        }

        return "NULL";
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
