package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public interface IEnemyMoveStrategy {
    Sprite move(Sprite sprite);
}
