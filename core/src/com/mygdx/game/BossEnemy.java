package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

public class BossEnemy extends EnemyShip {
    private SpaceShip spaceShip;
    private float timer1 = 0;
    private float timer2 = 0;
    private int HP;
    private float stageStartPosition=450;
    private Texture hpTexture;
    private Array<Sprite> hpSprites = new Array<>();
    public BossEnemy(Texture texture, float xPosition, float yPosition, IMoveStrategy moveStrategy, SpaceShip spaceShip) {
        super(texture, xPosition, yPosition, moveStrategy);
        HP = 20;
        this.spaceShip = spaceShip;
        this.hpTexture = new Texture("bosshp.png");
        for(int i=0;i<2*HP;i++) {
            Sprite sprite = new Sprite(hpTexture);
            sprite.setPosition(sprite.getWidth()*i,Gdx.graphics.getHeight()-sprite.getHeight());
            hpSprites.add(sprite);

        }

    }

    public void update() {
        moveStrategy.move(spriteShip);
        xPosition = spriteShip.getX();
        yPosition = spriteShip.getY();
    }

    public void shoot(Array<IComponent> enemyProjectiles) {

        if (yPosition <= stageStartPosition) {
            timer1 += Gdx.graphics.getDeltaTime();
            timer2 += Gdx.graphics.getDeltaTime();
        }
        if (timer1 >= 1f) {

            timer1 = 0f;
            enemyProjectiles.add(new Laser(laserTexture, xPosition + spriteShip.getHeight() / 4, yPosition, true));
            Gdx.app.log("Boss", " shoot");

        }
        if (timer2 >= 2.5f) {

            timer2 = 0f;
            GuidedTorpedo torpedo = new GuidedTorpedo(spaceShip, missileTexture, xPosition, yPosition);
            enemyProjectiles.add(torpedo);
            spaceShip.register(torpedo);

        }

    }

    public void draw(Batch batch){
        spriteShip.draw(batch);
        for(Sprite x:hpSprites){
            x.draw(batch);
        }
    }

    public void damage(int dmg) {
        if (yPosition <= stageStartPosition) {
            HP = HP - dmg;
            if (hpSprites.isEmpty()) {
                return;
            }
            hpSprites.removeIndex(2 * HP + 1);
            hpSprites.removeIndex(2 * HP);
        }
    }

    public int getHP() {
        return HP;
    }
}
