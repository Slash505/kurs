package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private SpriteBatch batch;
	private GameScreen gameScreen;

	@Override
	public void create() {
		batch = new SpriteBatch();
		gameScreen = new GameScreen(batch);
		Gdx.graphics.setWindowedMode(WIDTH, HEIGHT);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameScreen.render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
