package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Ship implements  IObservable{

    private int hp;
    private List<IObserver> observers = new ArrayList<IObserver>();

    public SpaceShip(Texture texture, float xPosition, float yPosition) {
        super(texture, xPosition, yPosition);

    }

    public void move(float speed,boolean direction){
        if(direction){
            spriteSpaceShip.translateX(-10.0f);
            xPosition = spriteSpaceShip.getX();
            notifyObservers();
        }else {
            spriteSpaceShip.translateX(10.0f);
            xPosition = spriteSpaceShip.getX();
            notifyObservers();
        }
    }

    public int  getHp(){
        return this.hp;
    }

    public void setHp(int dmg){
        hp=hp-dmg;
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
