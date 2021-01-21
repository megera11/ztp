package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

public class Ship implements IComponent {
     Sprite spriteShip;
     Texture texture;
     float xPosition;
     float yPosition;

    public Ship(Texture texture, float xPosition, float yPosition){
        this.texture = texture;
        this.spriteShip =new Sprite(texture);
        this.spriteShip.setPosition(xPosition,yPosition);

        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }


    public void shoot(Array<IComponent> lasers, float deltaTime){

    }

    public void shoot(Array<IComponent> enemyProjectiles){

    }

    public void draw(Batch batch){
        spriteShip.draw(batch);
    }

    public void update(){};

    public float getxPosition(){
        return this.xPosition;
    }

    public float getyPosition(){
        return this.yPosition;
    }

    public Sprite getSprite(){
        return spriteShip;
    }

    public void setPosition(float xPosition,float yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public float getSize(){
        return spriteShip.getHeight();
    }

    public void dispose(){
        texture.dispose();
    }

}
