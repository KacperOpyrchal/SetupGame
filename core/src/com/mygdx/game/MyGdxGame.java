package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import sun.rmi.runtime.Log;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{
	ShapeRenderer shapeRenderer;
	Batch batch;

	int x;
	int y;
	Board board;

	@Override
	public void create() {
		x = 0;
		y = 0;
		batch = new SpriteBatch();
		board = new Board(6, 7);
		shapeRenderer = new ShapeRenderer();
		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void resize(int width, int height) {}
	@Override
	public void render() {
		Gdx.gl.glClearColor( 1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Czyści ekran

		RenderBoard.renderCells(shapeRenderer, board);
		RenderBoard.renderNumbers(batch, board);
		RenderBoard.renderGrid(shapeRenderer, board);
		RenderBoard.renderSquare(shapeRenderer, x, y, board);

	}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void dispose() {
		shapeRenderer.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		x = screenX;
		y = screenY;
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
