package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Memento {
    private float xPosition;

    public Memento(float xPosition){
        this.xPosition=xPosition;
    }

    public float getxPosition(){
        return xPosition;
    }
}
