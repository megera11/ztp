package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public interface IComponent {

    void draw(Batch batch);

    void update();

    float getyPosition();

    void dispose();

    Sprite getSprite();

}
