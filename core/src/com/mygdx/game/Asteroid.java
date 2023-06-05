package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Asteroid {
    private float x;
    private float y;
    private float radius;
    private Texture texture;

    public Asteroid(float x, float y, float radius, Texture texture) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.texture = texture;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x - radius, y - radius, 2 * radius, 2 * radius);
    }

    // Геттеры и сеттеры для полей
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}