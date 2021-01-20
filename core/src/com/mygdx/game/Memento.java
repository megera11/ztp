package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Memento {
    private Sprite sprite;

    public Memento(Sprite sprite){
        this.sprite = sprite;
    }

    public Sprite getSprite(){
        return sprite;
    }
}
