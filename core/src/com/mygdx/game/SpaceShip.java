package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpaceShip extends Ship{

    private int hp;

    public SpaceShip(Texture texture, float xPosition, float yPosition) {
        super(texture, xPosition, yPosition);

    }

    public void move(float speed,boolean direction){
        if(direction){
            spriteSpaceShip.translateX(-10.0f);
            xPosition = spriteSpaceShip.getX();
        }else {
            spriteSpaceShip.translateX(10.0f);
            xPosition = spriteSpaceShip.getX();
        }
    }

    public int  getHp(){
        return this.hp;
    }

    public void setHp(int dmg){
        hp=hp-dmg;
    }


}
