package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Ship implements  IObservable{

    private int HP;
    private float fireTimer;
    private float fireDelay;
    Texture laserTexture;
    private List<IObserver> observers = new ArrayList<>();
    Array<Sprite> hearts = new Array<>();
    public SpaceShip(Texture texture, float xPosition, float yPosition) {
        super(texture, xPosition, yPosition);
        this.laserTexture = new Texture("Laser.png");
        this.HP = 5;
        this.fireDelay =0.05f;
        for(int i=0;i<HP;i++) {
            Sprite sprite = new Sprite(new Texture("heart.png"));
            sprite.setPosition(sprite.getWidth()*i,0);
            hearts.add(sprite);

        }
    }

    public void move(float speed,boolean direction){
        if(direction){
            spriteShip.translateX(-10.0f);
            xPosition = spriteShip.getX();
            notifyObservers();
        }else {
            spriteShip.translateX(10.0f);
            xPosition = spriteShip.getX();
            notifyObservers();
        }
    }
    public void draw(Batch batch){
        spriteShip.draw(batch);
        for(Sprite x:hearts){
            x.draw(batch);
        }
    }

    public void shoot(Array<IComponent> lasers,float deltaTime){
        fireTimer-=deltaTime;
        if(fireTimer<=0) {
            lasers.add(new Laser(laserTexture, xPosition + this.getSize() / 4, yPosition, false));
           fireTimer+=fireDelay;
        }
    }

    public int getHP(){
        return HP;
    }

    public void changeHP(int value) {
        HP = HP + value;
        Sprite sprite = new Sprite(new Texture("heart.png"));
        sprite.setPosition(sprite.getWidth()*(HP-1),0);
        hearts.add(sprite);
    }

    public void damage(int dmg){
        HP = HP -dmg;
        if(hearts.isEmpty()){
            return;
        }
        hearts.removeIndex(HP);
    }


    public void register(IObserver observer){
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void unregister(IObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(IObserver observer:observers){
            observer.updateObserver();
        }
    }



}
