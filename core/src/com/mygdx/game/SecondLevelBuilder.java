package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class SecondLevelBuilder implements ILevelBuilder{

    SpaceShip spaceShip;
    public Array<IComponent> enemyShips = new Array<>();
    public Array<IBonus> bonuses = new Array<>();
    Texture texture = new Texture("bomber.png");

    public SecondLevelBuilder(SpaceShip spaceShip){
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        this.spaceShip = spaceShip;

        enemyShips.add(new EnemyBomber(texture, 1200, 500, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, 1200, 400, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, 1200, 600, new MovingLeftStrategy(),spaceShip));
    }

    public Array<IComponent> getEnemies(){
        return enemyShips;
    }
    public Array<IBonus> getBonuses(){
        return bonuses;
    }

}