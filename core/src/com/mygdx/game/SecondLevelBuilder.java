package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class SecondLevelBuilder implements ILevelBuilder{


    public Array<IComponent> enemyShips = new Array<>();
    public Array<IBonus> bonuses = new Array<>();
    Texture texture = new Texture("EnemyLight.png");
    Texture bonusTexture = new Texture("bonus.png");
    private int offset1 = 1200;

    public void BuildLvl(SpaceShip spaceShip){
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();


        enemyShips.add(new EnemyBomber(texture, 1200, 500, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, 1600, 400, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, 1400, 600, new MovingLeftStrategy(),spaceShip));

        enemyShips.add(new EnemyBomber(texture, 1600, 500, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, 2000, 400, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, 1800, 600, new MovingLeftStrategy(),spaceShip));

        enemyShips.add(new EnemyBomber(texture, 2000, 500, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, 2400, 400, new MovingLeftStrategy(),spaceShip));
        enemyShips.add(new EnemyBomber(texture, 2200, 600, new MovingLeftStrategy(),spaceShip));

        IBonus bonus = new Bonus(bonusTexture,200,1500,spaceShip,new SimpleMoveStrategy());
        bonuses.add(new HpDecorator(bonus));
    }

    public Array<IComponent> getEnemies(){
        return enemyShips;
    }
    public Array<IBonus> getBonuses(){
        return bonuses;
    }

}