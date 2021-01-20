package com.mygdx.game;

public class Originator {
    private float xPosition;

    public void setxPosition(float xPosition){
        this.xPosition = xPosition;
    }

    public Memento save(){
        return new Memento(xPosition);
    }
    public float restore(Memento memento){
        xPosition = memento.getxPosition();
        return xPosition;
    }

}
