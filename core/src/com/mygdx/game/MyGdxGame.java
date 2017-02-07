package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ParticleControllerFinalizerInfluencer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

import sun.rmi.runtime.Log;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{
	ShapeRenderer shapeRenderer;
	Batch batch;

	int x;
	int y;

	int prevX;
	int prevY;

	int nowX;
	int nowY;

	Board board;

	String attacker;
	String defender;
	String result;

	@Override
	public void create() {
		x = 0;
		y = 0;

		prevX = -1;
		prevY = -1;

		nowX = -1;
		nowY = -1;

		attacker = "ATT";
		defender = "DEF";
		result = "RESULT";

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
		RenderBoard.renderFight(batch, attacker, defender, result);

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
		x = Gdx.graphics.getWidth();
		y = Gdx.graphics.getHeight();

		y = (int)(y*0.6);

		x /= board.getX();
		y /= board.getY();

		prevX = nowX;
		prevY = nowY;

		nowX = screenX / x;
		nowY = (Gdx.graphics.getHeight() - screenY) / y;

		result = "X = " + nowX + " Y = " + nowY;

		if(prevX >= 0 && prevY >= 0 && prevX < board.getX() && prevY < board.getY()){
			if(nowX >= 0 && nowY >= 0 && nowX < board.getX() && nowY < board.getY()){
				Cell att = board.getCell(prevX, prevY);
				Cell def = board.getCell(nowX, nowY);

				if(att.getKind() != 0 && att.getKind() != def.getKind()){

					Random rand = new Random();

					int sumAtt = 0;

					attacker = att.getName()+" : ";
					defender = def.getName()+" : ";

					for(int i = 0; i < att.getValue(); ++i){
						int a = rand.nextInt(6)+1;
						attacker += ""+a+" + ";
						sumAtt += a;
					}

					attacker += " = "+sumAtt;

					int sumDef = 0;

					for(int i = 0; i < def.getValue(); ++i){
						int a = rand.nextInt(6)+1;
						defender += ""+a+" + ";
						sumDef += a;
					}

					defender += " = "+sumDef;

					if(sumAtt > sumDef){
						result = att.getName()+" ATTACK SUCCESSFULLY!!!";

						def.setKind(att.getKind());
						def.setValue(att.getValue()-1);
						att.setValue(1);

					}else{
						result = def.getName()+" DEFEND SUCCESSFULLY!!!";
						att.setValue(1);
					}

				}
			}

		}

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
