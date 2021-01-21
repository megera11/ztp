package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class BossLevelBuilder implements ILevelBuilder{
    public Array<IComponent> enemyShips = new Array<>();
    public Array<IBonus> bonuses = new Array<>();
    public BossEnemy bossEnemy;
    Texture texture = new Texture("Boss.png");

    public void BuildLvl(SpaceShip spaceShip) {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        bossEnemy = new BossEnemy(texture, w / 2, 700, new BossMovingStrategy(),spaceShip);
        enemyShips.add(bossEnemy);
    }

    public Array<IComponent> getEnemies(){
        return enemyShips;
    }
    public Array<IBonus> getBonuses(){
        return bonuses;
    }


}
