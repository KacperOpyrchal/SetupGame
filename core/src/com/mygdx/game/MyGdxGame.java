package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import sun.rmi.runtime.Log;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{
	ShapeRenderer shapeRenderer;

	int x;
	int y;

	@Override
	public void create() {
		x = 0;
		y = 0;
		shapeRenderer = new ShapeRenderer();
		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void resize(int width, int height) {}
	@Override
	public void render() {
		Gdx.gl.glClearColor( 1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Czyści ekran

		RenderBoard.renderGrid(shapeRenderer);
		RenderBoard.renderSquare(shapeRenderer, x, y);

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