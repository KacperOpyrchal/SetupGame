package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by JavaDev on 05.11.2016.
 */
public class RenderBoard {

    public static void renderGrid(ShapeRenderer shapeRenderer, Board board){
        int x = Gdx.graphics.getWidth();
        int y = Gdx.graphics.getHeight();
        int nx = board.getX();
        int ny = board.getY();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, 0);

        for(int i = 0; i < ny; ++i){
            shapeRenderer.rectLine(0, i*(y/ny), x, i*(y/ny), 5);
        }
        for(int i = 0; i < nx; ++i){
            shapeRenderer.rectLine(i*(x/nx), 0, i*(x/nx), y, 5);
        }

        shapeRenderer.end();

    }

    public static void renderCells(ShapeRenderer shapeRenderer, Board board){
        int x = Gdx.graphics.getWidth();
        int y = Gdx.graphics.getHeight();
        int nx = 9;
        int ny = 16;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, 0);

        for(int i = 0; i < ny; ++i){
            shapeRenderer.rectLine(0, i*(y/ny), x, i*(y/ny), 10);
        }
        for(int i = 0; i < nx; ++i){
            shapeRenderer.rectLine(i*(x/nx), 0, i*(x/nx), y, 10);
        }

        shapeRenderer.end();
    }

    public static void renderSquare(ShapeRenderer shapeRenderer, int x, int y){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(255, 255, 0, 0);

        int Y = Gdx.graphics.getHeight();

        shapeRenderer.rect(x, Y-y, 100, 100);
        shapeRenderer.end();
    }



}
