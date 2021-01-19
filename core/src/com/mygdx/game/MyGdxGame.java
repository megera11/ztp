package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	SpaceShip spaceShip;
	Texture laserTexture;
	Array<IComponent> enemyShips = new Array<>();
	Array<IComponent> lasers = new Array<>();
	Array<IComponent> enemyLasers = new Array<>();
	Array<IComponent> torpedoes = new Array<>();
	CollisionManager collisionManager;
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		spaceShip = new SpaceShip(new Texture("spaceship.png"),w/2 -128,0);
		laserTexture = new Texture("Laser.png");
		batch = new SpriteBatch();

		EasyLevelBuilder easyLevelBuilder = new EasyLevelBuilder();
		enemyShips = easyLevelBuilder.enemyShips;

		collisionManager = new CollisionManager(spaceShip,enemyShips,lasers,enemyLasers,torpedoes);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && spaceShip.getxPosition()>0){
				spaceShip.move(-10f,true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && spaceShip.getxPosition()<(Gdx.graphics.getWidth()-spaceShip.getSpaceShipWidth())){
				spaceShip.move(10f,false);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			Laser laser = new Laser(laserTexture, spaceShip.getxPosition() +spaceShip.getSpaceShipWidth()/4, spaceShip.getyPosition(),false);
			lasers.add(laser);
		}

		collisionManager.checkCollision();

		for(IComponent x:enemyShips){
			x.update();
			EnemyShip b = (EnemyShip) x;
			b.shoot(enemyLasers,torpedoes,spaceShip);
		}

		for(Iterator<IComponent> itr = lasers.iterator(); itr.hasNext(); ) {
			IComponent b = itr.next();

			b.update();

			if (b.getyPosition() > Gdx.graphics.getHeight()) {
				itr.remove();
			}
		}

		for(Iterator<IComponent> itr = enemyLasers.iterator(); itr.hasNext(); ) {
			IComponent b = itr.next();

			b.update();

			if (b.getyPosition() > Gdx.graphics.getHeight()) {
				itr.remove();
			}
		}

		for(Iterator<IComponent> itr = torpedoes.iterator(); itr.hasNext(); ) {
			IComponent b = itr.next();

			b.update();

			if (b.getyPosition() > Gdx.graphics.getHeight()) {
				itr.remove();
			}
		}





		batch.begin();
		for(IComponent x:lasers){
			x.draw(batch);
		}
		for(IComponent x:enemyLasers){
			x.draw(batch);
		}
		for(IComponent x:enemyShips){
			x.draw(batch);
		}
		for(IComponent x:torpedoes){
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
		for(IComponent x:torpedoes){
			x.dispose();
		}
		for(IComponent x:enemyLasers){
			x.dispose();
		}

	}



}
