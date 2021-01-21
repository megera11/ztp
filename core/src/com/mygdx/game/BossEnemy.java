package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class BossEnemy extends EnemyShip{
    private SpaceShip spaceShip;
    private float timer1=0;
    private float timer2=0;
    private int HP;
    public BossEnemy(Texture texture, float xPosition, float yPosition, IMoveStrategy moveStrategy,SpaceShip spaceShip){
        super(texture,xPosition,yPosition, moveStrategy);
        HP=20;
        this.spaceShip=spaceShip;
    }

    public void update(){
        moveStrategy.move(spriteShip);
        xPosition = spriteShip.getX();
        yPosition = spriteShip.getY();
    }

    public void shoot(Array<IComponent> enemyProjectiles){

        timer1 += Gdx.graphics.getDeltaTime();
        timer2 += Gdx.graphics.getDeltaTime();
        if(timer1 >= 1f) {

            timer1 = 0f;
            enemyProjectiles.add(new Laser(laserTexture, xPosition + spriteShip.getHeight()/4, yPosition,true));
            Gdx.app.log("Boss", " shoot");

        }
        if(timer2 >= 2.5f) {

            timer2 = 0f;
            GuidedTorpedo torpedo = new GuidedTorpedo(spaceShip, missileTexture,xPosition,yPosition);
            enemyProjectiles.add(torpedo);
            spaceShip.register(torpedo);

        }



    }

    public void damage(int dmg){
        HP = HP -dmg;
    }

    public int getHP(){
        return HP;
    }
}
