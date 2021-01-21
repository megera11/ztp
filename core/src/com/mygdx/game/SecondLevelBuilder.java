package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class SecondLevelBuilder implements ILevelBuilder{


    public Array<IComponent> enemyShips = new Array<>();
    public Array<IBonus> bonuses = new Array<>();
    Texture texture = new Texture("EnemyLight.png");
    Texture bonusTexture = new Texture("bonus.png");
    private int y1 = 500;
    private int y2 = 400;
    private int y3 = 600;
    Random random = new Random();

    public void BuildLvl(SpaceShip spaceShip){
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();


        for(int i = 0; i < 3; i++) {
            random = new Random();
            Float hrand = (1200+i*350) + random.nextFloat() * ((1800+i*350) - (1200+i*350));
            Float hrand1 = (1600+i*350) + random.nextFloat() * ((2200+i*350) - (1600+i*350));
            Float hrand2 = (1400+i*350) + random.nextFloat() * ((2000+i*350) - (1400+i*350));
            enemyShips.add(new EnemyBomber(texture, hrand, y1, new SideMovingStrategy(), spaceShip));
            enemyShips.add(new EnemyBomber(texture, hrand1, y2, new SideMovingStrategy(), spaceShip));
            enemyShips.add(new EnemyBomber(texture, hrand2, y3, new SideMovingStrategy(), spaceShip));
        }

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