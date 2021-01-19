package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class EasyLevelBuilder implements  ILevelBuilder{
    public Array<EnemyShip> enemyShips= new Array<>();
    Texture texture1 = new Texture("EnemyLight.png");
    private int ship_width = 128;
    public EasyLevelBuilder(){
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        enemyShips.add(new EnemyShip(texture1,w/2 -ship_width,h-ship_width,new SlidingMoveStrategy()));
        enemyShips.add(new EnemyShip(texture1,w/2 -2*ship_width,h,new SimpleMoveStrategy()));
        enemyShips.add(new EnemyShip(texture1,w/2 +ship_width,h,new SimpleMoveStrategy()));
        enemyShips.add(new EnemyShip(texture1,w/2 +2*ship_width,h,new SimpleMoveStrategy()));


        enemyShips.add(new EnemyShip(texture1,w/2 +2*ship_width,h + 256,new SimpleMoveStrategy()));
        enemyShips.add(new EnemyShip(texture1,w/2 ,h +256,new SimpleMoveStrategy()));
        enemyShips.add(new EnemyShip(texture1,w/2 -2*ship_width,h +256,new SimpleMoveStrategy()));
    }







}
