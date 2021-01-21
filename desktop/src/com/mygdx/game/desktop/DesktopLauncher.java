package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.mygdx.game.AliensGame;

import java.io.File;

public class DesktopLauncher {



	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 720;
		config.width = 1280;
		config.forceExit = false;
		config.resizable = false;
		File file = new File("scores.txt");
		if(!file.exists()){
			FileHandle fileHandle = Gdx.files.local("scores.txt");
			fileHandle.writeString("", false);
		}
		new LwjglApplication(new AliensGame(), config);
	}
}
