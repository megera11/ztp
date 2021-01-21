package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class LevelBuilderDirector {

    public void LvlConstruct(ILevelBuilder builder,SpaceShip spaceShip)
    {
        builder.BuildLvl(spaceShip);
    }

}
