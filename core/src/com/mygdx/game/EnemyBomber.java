package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class EnemyBomber extends EnemyShip{
    SpaceShip spaceShip;

    public EnemyBomber(Texture texture,float xPosition, float yPosition, IEnemyMoveStrategy moveStrategy,SpaceShip spaceShip){
        super(texture,xPosition,yPosition, moveStrategy);
        this.shootingInterval = 3;
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
}
