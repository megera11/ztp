package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.mygdx.game.AliensGame;

import java.io.File;

public class DesktopLauncher {


	//Klasa ropoczynająca nasz program
	//
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 720;
		config.width = 1280;
		config.forceExit = false;
		config.resizable = false;

		new LwjglApplication(new AliensGame(), config);
	}
}
