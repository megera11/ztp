package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SimpleMoveStrategy implements IMoveStrategy {
    public Sprite move(Sprite sprite){
       sprite.translateY(-2f);
       return sprite;
    };

}
