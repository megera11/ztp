package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class CollisionManager {
    SpaceShip spaceShip;
    Array<IComponent> enemyShips;
    Array<IComponent> lasers;
    Array<IComponent> enemyProjectiles;

    Iterator<IComponent> iter;

    public CollisionManager(SpaceShip spaceShip, Array<IComponent> enemyShips,Array<IComponent> lasers,Array<IComponent> enemyProjectiles){
        this.spaceShip = spaceShip;
        this.enemyShips = enemyShips;
        this.lasers = lasers;
        this.enemyProjectiles = enemyProjectiles;
    }


    public void checkCollision() {

        checkPlayerLaserShipCollision();
        checkEnemyProjectilesCollision();
    }


    private void checkPlayerLaserShipCollision() {
        iter = enemyShips.iterator();

        while (iter.hasNext()) {
            IComponent enemyShip = iter.next();

            Iterator<IComponent> iterLas = lasers.iterator();

            while (iterLas.hasNext()) {
                IComponent laser = iterLas.next();

                if (laser.getSprite().getBoundingRectangle().overlaps(enemyShip.getSprite().getBoundingRectangle())) {
                    Gdx.app.log("Enemy", " Hit by laser");
                    iterLas.remove();
                    iter.remove();
                }
            }

            if (enemyShip.getSprite().getBoundingRectangle().overlaps(spaceShip.getSprite().getBoundingRectangle())) {
                Gdx.app.log("Player", " Hit by ship");
                iter.remove();
            }
        }
    }



    private void checkEnemyProjectilesCollision() {
        iter = enemyProjectiles.iterator();

        while (iter.hasNext()) {
            IComponent enemyProjectile = iter.next();

            if (enemyProjectile.getSprite().getBoundingRectangle().overlaps(spaceShip.getSprite().getBoundingRectangle())) {
                Gdx.app.log("Player", " Hit by projectile");
                iter.remove();

            }
        }
    }
}
