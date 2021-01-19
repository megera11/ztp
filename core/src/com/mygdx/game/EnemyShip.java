package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import javafx.concurrent.Task;

public class EnemyShip extends Ship {
    float timer= 2f;
    IEnemyMoveStrategy moveStrategy;

    Texture lasertexture;
    public EnemyShip(Texture texture, float xPosition, float yPosition,IEnemyMoveStrategy moveStrategy) {
        super(texture, xPosition, yPosition);
        this.moveStrategy = moveStrategy;
        this.lasertexture = new Texture("LaserEnemy.png");

    }

    public void update(){
       moveStrategy.move(spriteSpaceShip);
       yPosition = spriteSpaceShip.getY();
       xPosition = spriteSpaceShip.getX();
    }

    public void shoot(Array<IComponent> laserArray){

        timer += Gdx.graphics.getDeltaTime();
        if(timer >= 2f && yPosition < Gdx.graphics.getHeight()) {

            timer = 0f;
            laserArray.add(new Laser(lasertexture, xPosition +spaceShipWidth/4, yPosition,true));
            Gdx.app.log("shoot", " Hit");
        }
    }
}
