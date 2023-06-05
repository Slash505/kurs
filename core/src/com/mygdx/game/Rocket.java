package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.List;

public class Rocket {
    private float x;
    private float y;
    private float radius;
    private float mass;
    private float fuel;
    private Vector2 velocity;
    private Vector2 acceleration;
    private Texture texture;

    public Rocket(float x, float y, float radius, float mass, float fuel, Texture texture) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.mass = mass;
        this.fuel = fuel;
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 0);
        this.texture = texture;
    }

    public Rocket(int x, int y, Texture rocketTexture) {
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public void update(float delta, List<Planet> planets) {
        // Обновление скорости и положения ракеты
        for (Planet planet : planets) {
            // Вычисление гравитационной силы, действующей на ракету
            float distance = planet.getPosition().dst(x, y);
            float force = planet.getMass() / (distance * distance);
            Vector2 direction = planet.getPosition().cpy().sub(x, y).nor();
            Vector2 gravity = direction.scl(force);
            acceleration.add(gravity);
        }
        float totalMass = mass + fuel;
        acceleration.scl(1 / totalMass);
        velocity.add(acceleration.cpy().scl(delta));
        x += velocity.x * delta;
        y += velocity.y * delta;
        acceleration.set(0, 0);

        // Обновление количества топлива
        fuel -= 10 * delta;
        fuel = Math.max(fuel, 0);
    }

    public boolean collidesWith(Asteroid asteroid) {
        float distance = new Vector2(x, y).dst(asteroid.getX(), asteroid.getY());
        return (distance < radius + asteroid.getRadius());
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

    public float getMass() {
        return mass;
    }

    public float getFuel() {
        return fuel;
    }

    public Vector2 getVelocity() {
        return velocity;
    }
}
