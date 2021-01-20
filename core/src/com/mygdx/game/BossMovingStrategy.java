package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class BossMovingStrategy implements IMoveStrategy {

    private boolean direction = false;
    private float approachSpeed = 1f;
    private float speed = 4f;
    public Sprite move(Sprite sprite){

        if(sprite.getY()>=450) {
            sprite.translateY(-1*approachSpeed);
            return sprite;
        }

        if(direction == false) {
            sprite.translateX(-1*speed);
            if (sprite.getX() < 0)
                direction = true;
        }
        else {
            sprite.translateX(speed);
            if(sprite.getX()>1000)
                direction = false;
        }
        return sprite;

    }

}
