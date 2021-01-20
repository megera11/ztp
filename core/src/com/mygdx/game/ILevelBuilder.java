package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public interface ILevelBuilder {

     Array<IComponent> getEnemies();
     Array<IBonus> getBonuses();


}
