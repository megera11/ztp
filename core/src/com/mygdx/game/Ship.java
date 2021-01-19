package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ship implements IComponent {
     Sprite spriteSpaceShip;
     Texture texture;
     float spaceShipWidth;
     float xPosition;
     float yPosition;

    public Ship(Texture texture, float xPosition, float yPosition){
        this.texture = texture;
        this.spriteSpaceShip =new Sprite(texture);
        this.spriteSpaceShip.setPosition(xPosition,yPosition);
        this.spaceShipWidth = spriteSpaceShip.getWidth();
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }


    public void shot(){

    }

    public void draw(Batch batch){
        spriteSpaceShip.draw(batch);
    }

    public void update(){};


    public float getxPosition(){
        return this.xPosition;
    }

    public float getyPosition(){
        return this.yPosition;
    }

    public float getSpaceShipWidth(){
        return this.spaceShipWidth;
    }

    public Sprite getSprite(){
        return spriteSpaceShip;
    }

    public void setxPosition(float xPosition,float yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void dispose(){
        texture.dispose();
    }

}
