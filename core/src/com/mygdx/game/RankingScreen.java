package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class RankingScreen extends ScreenAdapter {

    private MyGdxGame game;

    public RankingScreen(MyGdxGame game){
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
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        Texture texture = new Texture("Logo.png");
        game.batch.draw(new Texture("background.png"),0,0);
        game.batch.draw(texture, (1280-texture.getWidth())/2,550);
        game.font.draw(game.batch, "Press ESCAPE to back to menu", 1280/2, 300);
        game.batch.end();
    }


}