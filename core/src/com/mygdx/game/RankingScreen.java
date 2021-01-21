package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class RankingScreen extends ScreenAdapter {

    private AliensGame game;
    Score ranking;

    public RankingScreen(AliensGame game){
        this.game = game;
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                if(keyCode == Input.Keys.ESCAPE){
                    game.setScreen(new MenuScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta){
        game.batch.begin();
        Texture texture = new Texture("Logo.png");
        game.batch.draw(new Texture("background.png"),0,0);
        game.batch.draw(texture, (1280-texture.getWidth())/2,550);
        ranking.printRanking(game);
        game.batch.end();
    }


}