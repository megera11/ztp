package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class EasyLevelBuilder implements ILevelBuilder {

    public Array<IComponent> enemyShips = new Array<>();
    public Array<IBonus> bonuses = new Array<>();
    Texture enemyLightTexture = new Texture("bomber.png");
    Texture bonusTexture = new Texture("bonus.png");
    Random random = new Random();
    float pom = 200;

    public void BuildLvl(SpaceShip spaceShip) {


        for (int j = 0; j < 3; j++) {
            random = new Random();
            float offset1 = 800 + j * 350;
            float offset2 = 1300 + j * 350;
            Float hrand = offset1 + random.nextFloat() * (offset2 - offset1);
            Float hrand1 = offset1 + random.nextFloat() * (offset2 - offset1);
            Float hrand2 = offset1 + random.nextFloat() * (offset2 - offset1);
            Float hrand3 = offset1 + random.nextFloat() * (offset2 - offset1);


            Float wrand = 70 + random.nextFloat() * pom;
            enemyShips.add(new EnemyShip(enemyLightTexture, wrand, hrand, new SimpleMoveStrategy()));
            Float wrand1 = 350 + random.nextFloat() * pom;
            enemyShips.add(new EnemyShip(enemyLightTexture, wrand1, hrand1, new SimpleMoveStrategy()));
            Float wrand2 = 650 + random.nextFloat() * pom;
            enemyShips.add(new EnemyShip(enemyLightTexture, wrand2, hrand2, new SimpleMoveStrategy()));
            Float wrand3 = 950 + random.nextFloat() * pom;
            enemyShips.add(new EnemyShip(enemyLightTexture, wrand3, hrand3, new SimpleMoveStrategy()));
        }

        IBonus bonus = new Bonus(bonusTexture, pom, 1500, spaceShip, new SimpleMoveStrategy());
        bonuses.add(new ShootIntervalDecorator(bonus));
        bonus = new Bonus(bonusTexture, 400, 3000, spaceShip, new SimpleMoveStrategy());
        bonuses.add(new HpDecorator(bonus));
        bonus = new Bonus(bonusTexture, 600, 4500, spaceShip, new SimpleMoveStrategy());
        bonuses.add(new HpDecorator(bonus));

    }

    public Array<IComponent> getEnemies() {
        return enemyShips;
    }

    public Array<IBonus> getBonuses() {
        return bonuses;
    }


}
