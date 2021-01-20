package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class EnemyBomber extends EnemyShip{
    SpaceShip spaceShip;
    CareTaker careTaker;

    public EnemyBomber(Texture texture,float xPosition, float yPosition, IEnemyMoveStrategy moveStrategy,SpaceShip spaceShip){
        super(texture,xPosition,yPosition, moveStrategy);
        this.shootingInterval = 3;
        this.spaceShip = spaceShip;
        careTaker = new CareTaker();
        save();
    }

    @Override
    public void shoot(Array<IComponent> enemyProjectiles){

        timer += Gdx.graphics.getDeltaTime();
        if(timer >= shootingInterval) {

            timer = 0f;
            GuidedTorpedo torpedo = new GuidedTorpedo(spaceShip, missileTexture,xPosition,yPosition);
            enemyProjectiles.add(torpedo);
            spaceShip.register(torpedo);
            Gdx.app.log("Bomber", "Shoot");
        }
    }

    @Override
    public void update() {

        if(xPosition<0){
            restore(careTaker.getMemento());
            yPosition = spriteSpaceShip.getY();
            xPosition = spriteSpaceShip.getX();

        }else {

            moveStrategy.move(spriteSpaceShip);
            yPosition = spriteSpaceShip.getY();
            xPosition = spriteSpaceShip.getX();
        }
    }

    public Memento save(){
        return new Memento(spriteSpaceShip);
    }

    public void restore(Memento m){
      spriteSpaceShip = m.getSprite();
    }

}
