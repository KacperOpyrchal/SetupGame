package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by JavaDev on 05.11.2016.
 */
public class RenderBoard {

    static BitmapFont font;

    public static void renderGrid(ShapeRenderer shapeRenderer, Board board){
        int x = Gdx.graphics.getWidth();
        int y = Gdx.graphics.getHeight();

        y = (int)(y*0.6);

        int nx = board.getX();
        int ny = board.getY();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, 0);

        for(int i = 0; i <= ny; ++i){
            shapeRenderer.rectLine(0, i*(y/ny), x, i*(y/ny), 5);
        }
        for(int i = 0; i <= nx; ++i){
            shapeRenderer.rectLine(i*(x/nx), 0, i*(x/nx), y, 5);
        }

        shapeRenderer.end();

    }

    public static void renderCells(ShapeRenderer shapeRenderer, Board board){
        int x = Gdx.graphics.getWidth();
        int y = Gdx.graphics.getHeight();
        int nx = board.getX();
        int ny = board.getY();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, 0);

        y = (int)(y*0.6);

        x /= nx;
        y /= ny;

        for(int i = 0; i < ny; ++i){
            for(int j = 0; j < nx; ++j){

                switch (board.getCell(j, i).getKind()){
                    case 0:
                        shapeRenderer.setColor(1, 1, 1, 0);
                        break;
                    case 1:
                        shapeRenderer.setColor(.899f, 0, 0, 0);
                        break;
                    case 2:
                        shapeRenderer.setColor(0, 0, .899f, 0);
                        break;
                    case 3:
                        shapeRenderer.setColor(0, .899f, 0, 0);
                        break;
                    case 4:
                        shapeRenderer.setColor(.899f, 0, .899f, 0);
                        break;
                }

                shapeRenderer.rect(j*x, i*y, x, y);
            }
        }

        shapeRenderer.end();

        /*font = new BitmapFont();

        batch.begin();

        //batch.setColor(1, 0, 1, 0);
        font.getData().setScale(3);
        font.setColor(Color.WHITE);

        for(int i = 0; i < ny; ++i){
            for(int j = 0; j < nx; ++j){
                font.draw(batch, board.getCell(j, i).getValue()+"", (j*x)+ (x/2), ((i+1)*y) - (y/4) );
            }
        }

        batch.end();*/



    }

    public static void renderNumbers(Batch batch, Board board){
        int x = Gdx.graphics.getWidth();
        int y = Gdx.graphics.getHeight();
        int nx = board.getX();
        int ny = board.getY();
        y = (int)(y*0.6);

        x /= nx;
        y /= ny;

        font = new BitmapFont();

        batch.begin();

        //batch.setColor(1, 0, 1, 0);
        font.getData().setScale(3);
        font.setColor(Color.WHITE);

        for(int i = 0; i < ny; ++i){
            for(int j = 0; j < nx; ++j){
                font.draw(batch, board.getCell(j, i).getValue()+"", (j*x)+ (x/2), ((i+1)*y) - (y/4) );
            }
        }

        batch.end();



    }

    public static void renderSquare(ShapeRenderer shapeRenderer, int x, int y, Board board){
        Gdx.gl.glLineWidth(100);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        int rx = Gdx.graphics.getWidth();
        int ry = Gdx.graphics.getHeight();
        int nx = board.getX();
        int ny = board.getY();

        ry = (int)(ry*0.6);

        nx = rx / nx;
        ny = ry / ny;

        x /= nx;

        int Y = Gdx.graphics.getHeight();
        y = Y-y;
        y /= ny;

        shapeRenderer.setColor(.255f, .655f, .950f, 0);

        if(y < board.getY()){
            if(board.getCell(x,y).getKind() != 0)
            for (int i = y - 1; i <= y + 1; ++i) {
                for (int j = x - 1; j <= x + 1; ++j) {

                    if (j >= 0 && j < board.getX() && i >= 0 && i < board.getY()) {
                        if (board.getCell(x,y).getKind() != board.getCell(j,i).getKind()){
                            shapeRenderer.rect(j*nx, i*ny, nx, ny);
                        }
                    }

                }
            }


            shapeRenderer.setColor(.955f, .655f, .250f, 0);
            shapeRenderer.rect(x*nx, y*ny, nx, ny);

        }
        shapeRenderer.end();


    }


}
