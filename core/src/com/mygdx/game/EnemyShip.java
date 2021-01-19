package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class EnemyShip extends Ship {
    float timer = 2f;
    float shootingInterval = 2f;
    IEnemyMoveStrategy moveStrategy;
    Texture laserTexture;
    Texture missileTexture;

    public EnemyShip(Texture texture, float xPosition, float yPosition, IEnemyMoveStrategy moveStrategy) {
        super(texture, xPosition, yPosition);
        this.moveStrategy = moveStrategy;
        this.laserTexture = new Texture("LaserEnemy.png");
        this.missileTexture = new Texture("bonus.png");
    }

    public void update() {
        moveStrategy.move(spriteSpaceShip);
        yPosition = spriteSpaceShip.getY();
        xPosition = spriteSpaceShip.getX();
    }

    public void shoot(Array<IComponent> enemyProjectiles, SpaceShip spaceShip) {

        timer += Gdx.graphics.getDeltaTime();

        if (timer >= shootingInterval && yPosition < Gdx.graphics.getHeight() && yPosition > 0) {

            timer = 0f;
            Laser laser = new Laser(laserTexture, xPosition + spriteSpaceShip.getHeight() / 4, yPosition, true);
            enemyProjectiles.add(laser);
            Gdx.app.log("LightEnemy", "Shoot");

        }
    }
}
