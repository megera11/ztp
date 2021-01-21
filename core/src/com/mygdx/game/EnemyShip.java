package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class EnemyShip extends Ship {
    float timer ;
    float shootingInterval;
    IMoveStrategy moveStrategy;
    Texture laserTexture;
    Texture missileTexture;

    public EnemyShip(Texture texture, float xPosition, float yPosition, IMoveStrategy moveStrategy) {
        super(texture, xPosition, yPosition);
        this.moveStrategy = moveStrategy;
        this.laserTexture = new Texture("LaserEnemy.png");
        this.missileTexture = new Texture("kulamocy.png");
        this.timer = 2f;
        this.shootingInterval = 2f;
    }

    public void update() {
        moveStrategy.move(spriteShip);
        yPosition = spriteShip.getY();
        xPosition = spriteShip.getX();
    }

    public void shoot(Array<IComponent> enemyProjectiles) {

        timer += Gdx.graphics.getDeltaTime();

        if (timer >= shootingInterval && yPosition < Gdx.graphics.getHeight() && yPosition > 0) {

            timer = 0f;
            Laser laser = new Laser(laserTexture, xPosition + spriteShip.getHeight() / 4, yPosition, true);
            enemyProjectiles.add(laser);
            Gdx.app.log("LightEnemy", "Shoot");

        }
    }
}
