package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class SimpleMoveStrategy implements  IEnemyMoveStrategy{
    public Sprite move(Sprite sprite){
       sprite.translateY(-2f);
       return sprite;
    };

}
