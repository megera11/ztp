package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class CollisionManager {
    SpaceShip spaceShip;
    Array<IComponent> enemyShips;
    Array<IComponent> lasers;
    Array<IComponent> enemyLasers;
    Array<IComponent> torpedoes;
    Iterator<IComponent> iter;

    public CollisionManager(SpaceShip spaceShip, Array<IComponent> enemyShips,Array<IComponent> lasers,Array<IComponent> enemyLasers,Array<IComponent> torpedoes){
        this.spaceShip = spaceShip;
        this.enemyShips = enemyShips;
        this.lasers = lasers;
        this.enemyLasers = enemyLasers;
        this.torpedoes = torpedoes;
    }


    public void checkCollision() {
        checkBulletShipCollision();
        checkEnemyLaserCollision();
        checkTorpedoCollision();
    }


    private void checkBulletShipCollision() {
        iter = enemyShips.iterator();

        while (iter.hasNext()) {
            IComponent enemyShip = iter.next();

            //initialise the bullet iterator each time here
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


    private void checkTorpedoCollision() {
        iter = torpedoes.iterator();

        while (iter.hasNext()) {
            IComponent torpedo = iter.next();

            if (torpedo.getSprite().getBoundingRectangle().overlaps(spaceShip.getSprite().getBoundingRectangle())) {
                Gdx.app.log("Player", "Hit by torpedo");
                iter.remove();
            }
        }
    }

    private void checkEnemyLaserCollision() {
        iter = enemyLasers.iterator();

        while (iter.hasNext()) {
            IComponent enemyLaser = iter.next();

            if (enemyLaser.getSprite().getBoundingRectangle().overlaps(spaceShip.getSprite().getBoundingRectangle())) {
                Gdx.app.log("Player", " Hit by laser");
                iter.remove();

            }
        }
    }
}
