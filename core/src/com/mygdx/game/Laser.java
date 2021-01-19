package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Pool;

public class Laser implements IComponent{


    private Sprite spriteLaser;
    private Texture texture;
    private boolean isEnemy;
    private float xPosition;
    private float yPosition;
    private float velocity;

    private boolean alive;

    public Laser (Texture texture,float xPosition,float yPosition,boolean isEnemy){
        this.texture = texture;
        this.spriteLaser = new Sprite(texture);
        this.spriteLaser.setPosition(xPosition,yPosition);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isEnemy = isEnemy;
        this.velocity = 5f;
    }

    public void update()
    {
        if(isEnemy){
            yPosition -= velocity;
            spriteLaser.translateY(-velocity);
        }else{
            yPosition += velocity;
            spriteLaser.translateY(velocity);
        }

        if(yPosition > Gdx.graphics.getHeight()){
            alive = false;
        }
    }

    public void draw(Batch batch){
        spriteLaser.draw(batch);
    }

    public void dispose(){
        texture.dispose();
    }



    public float getxPosition(){
        return this.xPosition;
    }

    public float getyPosition(){
        return this.yPosition;
    }
    public Sprite getSprite(){
        return this.spriteLaser;
    }

}
