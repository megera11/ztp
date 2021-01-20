package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SlidingMoveStrategy implements IMoveStrategy {
    boolean used=false;
    public Sprite move(Sprite sprite){
        sprite.translateX(-2f);

        return sprite;
    };
}
