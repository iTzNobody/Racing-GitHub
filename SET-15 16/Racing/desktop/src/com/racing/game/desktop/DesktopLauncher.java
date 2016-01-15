package com.racing.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.racing.game.MainMenu;
import com.racing.game.MyGdxGame;


public class DesktopLauncher
{
	public static void main (String[] arg)
    {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 1080;
        config.width = 1920;
        config.fullscreen = true;
        config.vSyncEnabled = true;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
