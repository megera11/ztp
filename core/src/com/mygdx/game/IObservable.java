package com.mygdx.game;

import com.mygdx.game.IObserver;

public interface IObservable {
    void register(IObserver observer);
    void unregister(IObserver observer);
    void notifyObservers();

}
