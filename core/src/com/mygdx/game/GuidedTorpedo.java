package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GuidedTorpedo implements IObserver,IComponent {
    private Sprite sprite;
    private Texture texture;
    private Ship ship;
    private float shipX;
    private float shipY;
    private float xPostion;
    private float yPosition;
    private float rotation;


    public GuidedTorpedo(Ship ship, Texture texture){
        this.ship = ship;
        this.shipX = ship.getxPosition();
        this.shipY = ship.getyPosition();
        this.texture = texture;
        this.sprite = new Sprite(texture);
    }



    public void updateObserver(){
        shipX = ship.getxPosition();
    }


    public void draw(Batch batch){
        sprite.draw(batch);
    }

    public void update(){

    }

    public float getyPosition(){
        return yPosition;
    }

    public void dispose(){
        texture.dispose();
    }

    public Sprite getSprite(){
        return this.sprite;
    }
}
