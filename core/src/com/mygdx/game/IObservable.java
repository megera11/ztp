package com.mygdx.game;

public interface IObservable {
    void register(IObserver observer);
    void unregister(IObserver observer);
    void notifyObservers();

}
