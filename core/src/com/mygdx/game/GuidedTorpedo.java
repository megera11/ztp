package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GuidedTorpedo implements IObserver, IComponent {
    private Sprite sprite;
    private Texture texture;
    private Ship ship;
    private float shipX;
    private float shipY;
    private float xPosition;
    private float yPosition;
    private float speed;


    public GuidedTorpedo(Ship ship, Texture texture, float x, float y) {
        this.ship = ship;
        this.shipX = ship.getxPosition();
        this.shipY = ship.getyPosition();
        this.texture = texture;
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
        this.speed = 4f;
    }


    public void updateObserver() {
        shipX = ship.getxPosition();
        shipY = ship.getyPosition();
    }


    public void draw(Batch batch) {
        sprite.draw(batch);
    }

    public void update() {
        float distance = Math.abs(xPosition - shipX) + Math.abs(yPosition - shipY);


        float vx = (shipX - xPosition) * speed / distance;
        float vy = (shipY - yPosition) * speed / distance;
        sprite.translateX(vx);
        sprite.translateY(vy);
        xPosition = sprite.getX();
        yPosition = sprite.getY();

    }

    public float getyPosition() {
        return yPosition;
    }

    public void dispose() {
        texture.dispose();
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public float getSize(){
        return sprite.getHeight();
    }
}
