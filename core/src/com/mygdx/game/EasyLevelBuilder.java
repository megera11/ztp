package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import javax.xml.soap.Text;
import java.util.Random;

public class EasyLevelBuilder implements ILevelBuilder {
    SpaceShip spaceShip;
    public Array<IComponent> enemyShips = new Array<>();
    public Array<IComponent> bonuses = new Array<>();
    Texture enemyLightTexture = new Texture("EnemyLight.png");
    Texture bonusTexture = new Texture("bonus.png");
    Random random = new Random();
    float pom = 200;

    public EasyLevelBuilder(SpaceShip spaceShip) {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        this.spaceShip = spaceShip;
        for (int j = 0; j < 10; j++) {
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

            bonuses.add(new Bonus(bonusTexture,pom,800,spaceShip,new SimpleMoveStrategy()));
    }
    public Array<IComponent> getEnemies(){
        return enemyShips;
    }
    public Array<IComponent> getBonuses(){
        return bonuses;
    }


}
