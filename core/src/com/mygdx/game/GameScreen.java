package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class GameScreen extends ScreenAdapter {

    AliensGame game;
    SpaceShip spaceShip;
    Texture laserTexture;
    Array<IComponent> enemyShips = new Array<>();
    Array<IComponent> lasers = new Array<>();
    Array<IComponent> enemyProjectiles = new Array<>();
    Array<IBonus> bonuses = new Array<>();
    SpriteBatch batch;

    Score score;

    CollisionManager collisionManager;
    LvlManager lvlManager;

    float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();

    public GameScreen(AliensGame game, String nickname){

        this.game = game;
        score = new Score(nickname);

        spaceShip = new SpaceShip(new Texture("spaceship.png"),w/2 -128,0);
        collisionManager = new CollisionManager(spaceShip,enemyShips,lasers,enemyProjectiles,bonuses,score);
        lvlManager = new LvlManager(lasers,enemyShips,bonuses,game,nickname,spaceShip,score);
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter(){
            public boolean keyDown(int keyCode){
                if(keyCode == Input.Keys.ESCAPE) {
                    game.setScreen(new EndGameScreen(game,score.getScore(),false));
                }
                return true;
            }

        });


        laserTexture = new Texture("Laser.png");

        batch = game.batch;

    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && spaceShip.getxPosition()>0){
            spaceShip.move(-10f,true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && spaceShip.getxPosition()<(Gdx.graphics.getWidth()-spaceShip.getSize())){
            spaceShip.move(10f,false);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            spaceShip.shoot(lasers,delta);
        }
        lvlManager.render(delta);
        collisionManager.checkCollision();

        if(spaceShip.getHP()<=0){
            score.savetofile();
            game.setScreen(new EndGameScreen(game, score.getScore(), false));
        }

        for(Iterator<IComponent> itr = enemyShips.iterator(); itr.hasNext(); ) {
            IComponent b = itr.next();

            b.update();

            EnemyShip x = (EnemyShip) b;
            x.shoot(enemyProjectiles);

            if (b.getyPosition() < -1*b.getSize() ) {
                itr.remove();
            }
        }


        for(Iterator<IComponent> itr = lasers.iterator(); itr.hasNext(); ) {
            IComponent b = itr.next();

            b.update();

            if (b.getyPosition() > Gdx.graphics.getHeight()-b.getSize()) {
                itr.remove();
            }
        }

        for(Iterator<IComponent> itr = enemyProjectiles.iterator(); itr.hasNext(); ) {
            IComponent b = itr.next();

            b.update();

            if (b.getyPosition() < -1*b.getSize() ) {
                itr.remove();
            }
        }

        for(Iterator<IBonus> itr = bonuses.iterator(); itr.hasNext(); ) {
            IComponent b = itr.next();

            b.update();

            if (b.getyPosition() < -1*b.getSize() ) {
                itr.remove();
            }
        }


        batch.begin();
        game.font.draw(batch, "Score: " + score.getScore(), Gdx.graphics.getWidth()-200, 20);
        for(IComponent x:lasers){
            x.draw(batch);
        }
        for(IComponent x:enemyShips){
            x.draw(batch);
        }
        for(IComponent x:enemyProjectiles){
            x.draw(batch);
        }
        for(IComponent x:bonuses){
            x.draw(batch);
        }

        spaceShip.draw(batch);
        batch.end();

    }

    @Override
    public void dispose () {
        batch.dispose();
        spaceShip.dispose();
        for(IComponent x:lasers){
            x.dispose();
        }
        for(IComponent x:enemyShips){
            x.dispose();
        }
        for(IComponent x:enemyProjectiles){
            x.dispose();
        }
        for(IComponent x:bonuses){
            x.dispose();
        }
    }
}