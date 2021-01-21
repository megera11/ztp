package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SideMovingStrategy implements IMoveStrategy {



    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();
    int i=0;

    public Sprite move(Sprite sprite){

        originator.setxPosition(sprite.getX());
        if(sprite.getX() == sprite.getX()+i) {
            caretaker.addMemento(originator.save());
            i++;
        }

        if(sprite.getX() > 0)
            sprite.translateX(-2f);
        else
            sprite.setX(originator.restore(caretaker.getMemento()));

        return sprite;

    }
}