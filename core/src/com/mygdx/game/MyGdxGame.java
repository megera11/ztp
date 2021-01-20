package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	SpaceShip spaceShip;
	Texture laserTexture;

	Array<IComponent> enemyShips = new Array<>();
	Array<IComponent> lasers = new Array<>();
	Array<IComponent> enemyProjectiles = new Array<>();
	Array<IBonus> bonuses = new Array<>();

	CollisionManager collisionManager;


	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		spaceShip = new SpaceShip(new Texture("spaceship.png"),w/2 -128,0);
		laserTexture = new Texture("Laser.png");

		batch = new SpriteBatch();

		ILevelBuilder builder = new EasyLevelBuilder(spaceShip);
		enemyShips = builder.getEnemies();
		bonuses = builder.getBonuses();

		collisionManager = new CollisionManager(spaceShip,enemyShips,lasers,enemyProjectiles,bonuses);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && spaceShip.getxPosition()>0){
				spaceShip.move(-10f,true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && spaceShip.getxPosition()<(Gdx.graphics.getWidth()-spaceShip.getSize())){
				spaceShip.move(10f,false);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			Laser laser = new Laser(laserTexture, spaceShip.getxPosition() +spaceShip.getSize()/4, spaceShip.getyPosition(),false);
			lasers.add(laser);
		}

		collisionManager.checkCollision();

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

			if (b.getyPosition() > Gdx.graphics.getHeight()) {
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
	}



}
