package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class MovingLeftStrategy implements IMoveStrategy {



    public Sprite move(Sprite sprite){


        sprite.translateX(-2f);

        return sprite;

    }
}