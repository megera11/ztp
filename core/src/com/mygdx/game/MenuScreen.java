package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MenuScreen extends ScreenAdapter {
    AliensGame game;
    TextButton newgamebutton;
    TextButton rankingbutton;
    TextButton exitbutton;
    TextButtonStyle style;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    Stage stage;

    public MenuScreen(AliensGame game){
        this.game = game;
    }

    @Override
    public void show(){
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        style = new TextButtonStyle();
        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("commodore64/skin/uiskin.atlas"));
        skin.addRegions(buttonAtlas);
        style.font = font;
        style.up = skin.getDrawable("button");
        style.down = skin.getDrawable("button-down");

        newgamebutton = new TextButton("New Game", style);
        rankingbutton = new TextButton("Leader", style);
        exitbutton = new TextButton("Exit", style);
        newgamebutton.setPosition((Gdx.graphics.getWidth() - newgamebutton.getWidth())/2, 400);
        rankingbutton.setPosition((Gdx.graphics.getWidth() - rankingbutton.getWidth())/2, 350);
        exitbutton.setPosition((Gdx.graphics.getWidth() - exitbutton.getWidth())/2, 300);

        newgamebutton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.setScreen(new NickNameScreen(game));
            }
        });
        rankingbutton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.setScreen(new RankingScreen(game));
            }
        });
        exitbutton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        stage.addActor(newgamebutton);
        stage.addActor(rankingbutton);
        stage.addActor(exitbutton);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(new Texture("background.png"),0,0);
        Texture texture = new Texture("Logo.png");
        game.batch.draw(texture, (Gdx.graphics.getWidth()-texture.getWidth())/2,550);
        newgamebutton.draw(game.batch, 1);
        rankingbutton.draw(game.batch, 1);
        exitbutton.draw(game.batch, 1);
        stage.draw();
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
