package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JavaDev on 04.02.2017.
 */

public class Board {

    int xSize;
    int ySize;
    List<List<Cell>> cells;

    public Board(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;

        cells = new ArrayList<List<Cell>>();

        for(int y = 0; y < ySize; ++y){
            cells.add(new ArrayList<Cell>());
            for(int x = 0; x < xSize; ++x){
                cells.get(y).add(new Cell(true, 0, 0));
            }
        }

        generateBoard();
    }

    public void generateBoard(){
        getCell(0,0).setValue(2);
        getCell(0,0).setKind(1);

        getCell(0,1).setValue(1);
        getCell(0,1).setKind(1);

        getCell(1,1).setValue(5);
        getCell(1,1).setKind(1);

        getCell(0,2).setValue(4);
        getCell(0,2).setKind(1);


        getCell(3,0).setValue(5);
        getCell(3,0).setKind(2);

        getCell(3,1).setValue(2);
        getCell(3,1).setKind(2);

        getCell(3,1).setValue(1);
        getCell(3,1).setKind(2);

        getCell(3,2).setValue(3);
        getCell(3,2).setKind(2);

    }

    public Cell getCell(int x, int y){
        if(x < xSize && y < ySize){
            return cells.get(y).get(x);
        }else{
            return new Cell(true, 0, 0);
        }
    }

    public int getX(){
        return xSize;
    }

    public int getY(){
        return ySize;
    }
}
