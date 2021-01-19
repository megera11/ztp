package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;

public class EasyLevelBuilder implements ILevelBuilder {
    public Array<IComponent> enemyShips = new Array<>();
    Texture texture = new Texture("EnemyLight.png");
    Random random = new Random();
    float pom = 200;

    public EasyLevelBuilder() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        for (int j = 0; j < 10; j++) {
            random = new Random();
            float offset1 = 800 + j * 350;
            float offset2 = 1300 + j * 350;
            Float hrand = offset1 + random.nextFloat() * (offset2 - offset1);
            Float hrand1 = offset1 + random.nextFloat() * (offset2 - offset1);
            Float hrand2 = offset1 + random.nextFloat() * (offset2 - offset1);
            Float hrand3 = offset1 + random.nextFloat() * (offset2 - offset1);


            Float wrand = 70 + random.nextFloat() * pom;
            enemyShips.add(new EnemyShip(texture, wrand, hrand, new SimpleMoveStrategy()));
            Float wrand1 = 350 + random.nextFloat() * pom;
            enemyShips.add(new EnemyShip(texture, wrand1, hrand1, new SimpleMoveStrategy()));
            Float wrand2 = 650 + random.nextFloat() * pom;
            enemyShips.add(new EnemyShip(texture, wrand2, hrand2, new SimpleMoveStrategy()));
            Float wrand3 = 950 + random.nextFloat() * pom;
            enemyShips.add(new EnemyShip(texture, wrand3, hrand3, new SimpleMoveStrategy()));

        }
    }
}
