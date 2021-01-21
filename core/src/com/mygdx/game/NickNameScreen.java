package com.mygdx.game;

import com.badlogic.gdx.*;

import com.badlogic.gdx.graphics.Texture;


public class NickNameScreen extends ScreenAdapter implements Input.TextInputListener {

    private AliensGame game;
    private String nickname;


    public NickNameScreen(AliensGame game){
        this.game = game;
    }

    @Override
    public void show(){
        Gdx.input.getTextInput(this, "Enter your nickname", "", "");
    }
    @Override
    public void render(float delta){
        if(nickname != null)
            game.setScreen(new GameScreen(game, nickname));
        if(nickname == "Canceled")
            game.setScreen(new MenuScreen(game));
        game.batch.begin();
        Texture texture = new Texture("Logo.png");
        game.batch.draw(new Texture("background.png"),0,0);
        game.batch.draw(texture, (1280-texture.getWidth())/2,550);
        game.batch.end();
    }
    @Override
    public void input(String nickname){
        this.nickname = nickname;
    }
    @Override
    public void canceled(){
        this.nickname = "Canceled";
    }
}