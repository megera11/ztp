package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class SecondLvlBuilder implements ILevelBuilder{

    SpaceShip spaceShip;
    public Array<IComponent> enemyShips = new Array<>();
    Texture texture = new Texture("bomber.png");

    public SecondLvlBuilder(SpaceShip spaceShip){
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        this.spaceShip = spaceShip;

        enemyShips.add(new EnemyBomber(texture, w/2, 500, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, w/2, 400, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, w/2, 600, new MovingLeftStrategy(),spaceShip));
    }

    public Array<IComponent>  getComponents(){
        return enemyShips;
    }

}