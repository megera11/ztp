package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public interface ILevelBuilder {

     void BuildLvl(SpaceShip spaceShip);
     Array<IComponent> getEnemies();
     Array<IBonus> getBonuses();




}
