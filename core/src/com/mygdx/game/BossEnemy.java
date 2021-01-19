package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class BossEnemy extends EnemyShip{


    public BossEnemy(Texture texture, float xPosition, float yPosition, IEnemyMoveStrategy moveStrategy){
        super(texture,xPosition,yPosition, moveStrategy);
    }

    public void update(){
        moveStrategy.move(spriteSpaceShip);
        xPosition = spriteSpaceShip.getX();
        yPosition = spriteSpaceShip.getY();
    }

    public void shoot(Array<IComponent> laserArray){

        timer += Gdx.graphics.getDeltaTime();
        if(timer >= 3f) {

            timer = 0f;
            laserArray.add(new Laser(laserTexture, xPosition +spriteSpaceShip.getHeight()/4, yPosition,true));
            Gdx.app.log("shoot", " Hit");
        }
    }
}
