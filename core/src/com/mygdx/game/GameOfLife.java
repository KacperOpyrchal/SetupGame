package com.mygdx.game;

/**
 * Created by velvet071 on 2015-07-28.
 */

public class GameOfLife {

    int X,Y;
    int ConMin, ConMax, ConDead;
    boolean[][] game;
    public GameOfLife(int x, int y){
        this.X = x;
        this.Y = y;
        game = new boolean[x][x];
        for(int i = 0; i < x; ++i){
            for(int j = 0; j < y; ++j){
                game[i][j] = false;
            }
        }///Bechamie kurw
        ConMin = 2;
        ConMax = 2;
        ConDead = 3;
    }
    public void changeState(int x, int y){
        if(game[x][y] == false) game[x][y] = true;
        else game[x][y] = false;
    }

    public boolean getState(int x, int y){
        return game[x][y];
    }

    public void nextCycle(){
        boolean[][] clone = new boolean[X][Y];
        for(int i = 0; i < X; ++i){
            for(int j = 0; j < Y; ++j){
                clone[i][j] = getState(i,j);
            }
        }

        int n;

        for(int i = 0; i < X; ++i){
            for(int j = 0; j < Y; ++j){
                n = countAliveNeighbours(i,j);
                if(game[i][j] == true){
                    if(n < 2 || n > 3) clone[i][j] = false;
                }else{
                    if(n == 3) clone[i][j] = true;
                }
            }
        }

        game = clone;
    }

    public int countAliveNeighbours(int x, int y){
        int results = 0;
        int startX = Math.max(0,x-1);
        int startY = Math.max(0,y-1);
        int endX = Math.min(X - 1, x + 1);
        int endY = Math.min(Y-1,y+1);

        for(int i = startX; i <= endX; ++i){
            for(int j = startY; j <= endY; ++j){
                if(game[i][j] == true) results++;
            }
        }
        if(game[x][y] == true) --results;

        return results;
    }

    public void changeSize(int x, int y){
        this.X = x;
        this.Y = y;

        game = new boolean[X][Y];
        for(int i = 0; i < x; ++i){
            for(int j = 0; j < y; ++j){
                game[i][j] = false;
            }
        }
    }

    public int getSize(){
        return X;
    }
}
