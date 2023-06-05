package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Planet {
    private float x;
    private float y;
    private float radius;
    private float mass;
    private Texture texture;

    public Planet(float x, float y, float radius, float mass, Texture texture) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.mass = mass;
        this.texture = texture;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public Vector2 getPosition() {
        return new Vector2(x, y);
    }

    public float getMass() {
        return mass;
    }

    // Геттеры и сеттеры для полей
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }
}