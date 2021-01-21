package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class EndGameScreen extends ScreenAdapter {

    AliensGame game;
    private int score;
    private boolean win;


    public EndGameScreen(AliensGame game,int score,boolean win){
        this.game = game;
        this.score = score;
        this.win = win;
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean keyDown(int keyCode) {

                if (keyCode == Input.Keys.ENTER) {
                    game.setScreen(new MenuScreen(game));
                }

                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        if(win == true){

            game.batch.begin();
            Texture texture = new Texture("Logo.png");
            game.batch.draw(new Texture("background.png"),0,0);
            game.batch.draw(texture, (1280-texture.getWidth())/2,550);
            game.font.draw(game.batch, "You win! ", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
            game.font.draw(game.batch, "Your score = " + Integer.toString(score), Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .50f);
            game.font.draw(game.batch, "Press enter to restart.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
            game.batch.end();
        }
        else {
            game.batch.begin();
            Texture texture = new Texture("Logo.png");
            game.batch.draw(new Texture("background.png"), 0, 0);
            game.batch.draw(texture, (1280 - texture.getWidth()) / 2, 550);
            game.font.draw(game.batch, "You lose! ", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
            game.font.draw(game.batch, "Your score = " + Integer.toString(score), Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .50f);
            game.font.draw(game.batch, "Press enter to restart.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
            game.batch.end();
        }

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }


}
