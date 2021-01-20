package com.mygdx.game;

public abstract class BonusDecorator implements IBonus {
    IBonus ibonus;

    public BonusDecorator(IBonus ibonus){
        this.ibonus = ibonus;
    }

    public void modify(SpaceShip spaceShip){
        ibonus.modify(spaceShip);
    }
}
