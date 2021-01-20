package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class HpDecorator extends BonusDecorator {


    public HpDecorator(IBonus decoratedBonus){
        super(decoratedBonus);
    }

    @Override
    public void modify(SpaceShip spaceShip){
        ibonus.modify(spaceShip);
        setHp(spaceShip);
    }

    private void setHp(SpaceShip spaceShip){
        spaceShip.changeHP(1);
    }

    public void draw(Batch batch){
        ibonus.draw(batch);
    };

    public void update(){
        ibonus.update();
    };

    public float getyPosition(){
        return ibonus.getyPosition();
    };

    public void dispose(){
        ibonus.dispose();
    };

    public Sprite getSprite(){
        return ibonus.getSprite();
    }

    public float getSize(){
        return ibonus.getSize();
    }

}
