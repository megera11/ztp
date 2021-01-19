package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class EnemyShip extends Ship {
    float timer1 = 2f;
    float timer2 = 4f;
    IEnemyMoveStrategy moveStrategy;

    Texture lasertexture;
    Texture missiletexture;

    public EnemyShip(Texture texture, float xPosition, float yPosition, IEnemyMoveStrategy moveStrategy) {
        super(texture, xPosition, yPosition);
        this.moveStrategy = moveStrategy;
        this.lasertexture = new Texture("LaserEnemy.png");
        this.missiletexture = new Texture("bonus.png");
    }

    public void update() {
        moveStrategy.move(spriteSpaceShip);
        yPosition = spriteSpaceShip.getY();
        xPosition = spriteSpaceShip.getX();
    }

    public void shoot(Array<IComponent> laserArray, Array<IComponent> torpedoes, SpaceShip spaceShip) {

        timer1 += Gdx.graphics.getDeltaTime();
        timer2 += Gdx.graphics.getDeltaTime();
        if (timer1 >= 2f && yPosition < Gdx.graphics.getHeight() && yPosition > 0) {

            timer1 = 0f;
            laserArray.add(new Laser(lasertexture, xPosition + spaceShipWidth / 4, yPosition, true));
        }
        if (timer2 >= 4f && yPosition < Gdx.graphics.getHeight() && yPosition > 0) {

            timer2 = 0f;
            GuidedTorpedo torpedo = new GuidedTorpedo(spaceShip, missiletexture,xPosition,yPosition);
            torpedoes.add(torpedo);
            spaceShip.register(torpedo);
        }
    }
}
