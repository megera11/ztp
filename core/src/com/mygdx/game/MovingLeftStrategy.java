package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class MovingLeftStrategy implements IEnemyMoveStrategy{



    public Sprite move(Sprite sprite){


        sprite.translateX(-2f);

        return sprite;

    }
}