package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class BossLevelBuilder implements ILevelBuilder{

    public BossEnemy bossEnemy;
    Texture texture = new Texture("Boss.png");

    public BossLevelBuilder() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        bossEnemy = new BossEnemy(texture, w / 2, 700, new BossMovingStrategy());
    }

    public Array<IComponent> getComponents(){
        return null;
    }

}
