package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        Random rand = new Random();

        for(int y = 0; y < ySize; ++y){
            cells.add(new ArrayList<Cell>());
            for(int x = 0; x < xSize; ++x){
                int a = rand.nextInt(8)+1;
                getCell(x,y).setValue(a);
            }
        }

        for(int y = 0+1; y < 2+1; ++y){
            for(int x = 0+1; x < 2+1; ++x){
                getCell(x,y).setKind(1);
                getCell(x,y).setValue(rand.nextInt(8)+1);
            }
        }

        for(int y = 3+1; y < 5+1; ++y){
            for(int x = 0+1; x < 2+1; ++x){
                getCell(x,y).setKind(2);
                getCell(x,y).setValue(rand.nextInt(8)+1);
            }
        }

        for(int y = 0+1; y < 2+1; ++y){
            for(int x = 2+1; x < 4+1; ++x){
                getCell(x,y).setKind(3);
                getCell(x,y).setValue(rand.nextInt(8)+1);
            }
        }


        for(int y = 3+1; y < 5+1; ++y){
            for(int x = 2+1; x < 4+1; ++x){
                getCell(x,y).setKind(4);
                getCell(x,y).setValue(rand.nextInt(8)+1);
            }
        }


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
