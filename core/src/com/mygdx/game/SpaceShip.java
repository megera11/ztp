package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Ship implements  IObservable{

    private int HP;
    private List<IObserver> observers = new ArrayList<IObserver>();

    public SpaceShip(Texture texture, float xPosition, float yPosition) {
        super(texture, xPosition, yPosition);
        this.HP = 5;
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

    public int getHP(){
        return HP;
    }

    public void changeHP(int value) {HP = HP + value;}

    public void damage(int dmg){
        HP = HP -dmg;
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
