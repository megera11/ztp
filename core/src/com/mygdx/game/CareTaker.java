package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

public class CareTaker {

    private Memento memento = new Memento(new Sprite());

    public void addMemento(Memento m) {
        memento = m;
    }

    public Memento getMemento() {
        return memento;
    }
}
