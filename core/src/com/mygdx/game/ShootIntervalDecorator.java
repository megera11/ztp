package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ShootIntervalDecorator extends  BonusDecorator{

    Thread thread;

    public ShootIntervalDecorator(IBonus decoratedBonus){
        super(decoratedBonus);
    }

    @Override
    public void modify(SpaceShip spaceShip){
        ibonus.modify(spaceShip);
        setShootingInterval(spaceShip);
    }

    private void setShootingInterval(final SpaceShip spaceShip){
        spaceShip.setFireDelay(0.025f);
        thread = new Thread(){
            public void run(){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spaceShip.setFireDelay(0.05f);
            }
        };
        thread.start();

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
