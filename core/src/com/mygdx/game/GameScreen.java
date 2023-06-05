package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private Texture rocketTexture;
    private Texture planetTexture;
    private Texture asteroidTexture;
    private Rocket rocket;
    private ArrayList<Planet> planets;
    private ArrayList<Asteroid> asteroids;

    public GameScreen(SpriteBatch batch) {
        this.batch = batch;
        rocketTexture = new Texture("rocket.png");
        planetTexture = new Texture("planet.png");
        asteroidTexture = new Texture("asteroid.png");
        rocket = new Rocket(100, 100, rocketTexture);
        planets = new ArrayList<Planet>();
        planets.add(new Planet(500, 500, 100, 1000, planetTexture));
        asteroids = new ArrayList<Asteroid>();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    private void update(float delta) {
        rocket.update(delta, planets);
        for (Asteroid asteroid : asteroids) {
            if (rocket.collidesWith(asteroid)) {
                // обработка столкновения с астероидом
            }
        }
    }

    private void draw() {
        batch.begin();
        rocket.draw(batch);
        for (Planet planet : planets) {
            planet.draw(batch);
        }
        for (Asteroid asteroid : asteroids) {
            asteroid.draw(batch);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        rocketTexture.dispose();
        planetTexture.dispose();
        asteroidTexture.dispose();
    }

}