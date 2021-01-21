package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class CollisionManager {
    SpaceShip spaceShip;
    Score score;
    Array<IComponent> enemyShips;
    Array<IComponent> lasers;
    Array<IComponent> enemyProjectiles;
    Array<IBonus> bonuses;

    Iterator<IComponent> iterComp;
    Iterator<IBonus> iterBon;

    public CollisionManager(SpaceShip spaceShip, Array<IComponent> enemyShips,Array<IComponent> lasers,Array<IComponent> enemyProjectiles,Array<IBonus> bonuses,Score score){
        this.spaceShip = spaceShip;
        this.enemyShips = enemyShips;
        this.lasers = lasers;
        this.enemyProjectiles = enemyProjectiles;
        this.bonuses = bonuses;
        this.score = score;
    }


    public void checkCollision() {

        checkPlayerProjectilesCollision();
        checkPlayerShipCollision();
        checkEnemyProjectilesCollisions();
        checkPlayerProjectileCollisions();
        checkBonusCollision();
    }


    private void checkPlayerProjectilesCollision() {
        iterComp = enemyShips.iterator();

        while (iterComp.hasNext()) {
            IComponent enemyShip = iterComp.next();

            Iterator<IComponent> iterLas = lasers.iterator();

            while (iterLas.hasNext()) {
                IComponent laser = iterLas.next();

                if (laser.getSprite().getBoundingRectangle().overlaps(enemyShip.getSprite().getBoundingRectangle())) {
                    Gdx.app.log("Enemy", " Hit by laser");
                    iterLas.remove();
                    if(enemyShip instanceof BossEnemy && ((BossEnemy) enemyShip).getHP() > 0){
                        ((BossEnemy) enemyShip).damage(1);
                        return;
                    }
                    iterComp.remove();
                    score.increasescore();
                }
            }


        }
    }

    private void checkPlayerShipCollision(){
        iterComp = enemyShips.iterator();

        while (iterComp.hasNext()) {
            IComponent enemyShip = iterComp.next();

            if (enemyShip.getSprite().getBoundingRectangle().overlaps(spaceShip.getSprite().getBoundingRectangle())) {
                Gdx.app.log("Player", " Hit by ship");
                iterComp.remove();
                spaceShip.damage(1);
            }
        }
    }

    private void checkBonusCollision(){
        iterBon = bonuses.iterator();

        while (iterBon.hasNext()) {
            IBonus bonus = iterBon.next();


            if (bonus.getSprite().getBoundingRectangle().overlaps(spaceShip.getSprite().getBoundingRectangle())) {
                Gdx.app.log("Player", " Hit by bonus");
                bonus.modify(spaceShip);
                iterBon.remove();

            }
        }
    }

    private void checkEnemyProjectilesCollisions() {
        iterComp = enemyProjectiles.iterator();

        while (iterComp.hasNext()) {
            IComponent enemyProjectile = iterComp.next();

            if(enemyProjectile instanceof GuidedTorpedo){
                Iterator<IComponent> iterLas = lasers.iterator();

                while (iterLas.hasNext()) {
                    IComponent laser = iterLas.next();

                    if (laser.getSprite().getBoundingRectangle().overlaps(enemyProjectile.getSprite().getBoundingRectangle())) {
                        Gdx.app.log("Bomb", " Hit by laser");
                        iterLas.remove();
                        spaceShip.unregister((GuidedTorpedo)enemyProjectile);
                        iterComp.remove();

                    }
                }
            }

        }
    }

    private void checkPlayerProjectileCollisions(){
        iterComp = enemyProjectiles.iterator();

        while (iterComp.hasNext()) {
            IComponent enemyProjectile = iterComp.next();

            if (enemyProjectile.getSprite().getBoundingRectangle().overlaps(spaceShip.getSprite().getBoundingRectangle())) {
                Gdx.app.log("Player", " Hit by projectile");
                iterComp.remove();
                spaceShip.damage(1);

            }
        }
    }

}
