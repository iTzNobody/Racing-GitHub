package com.racing.game;


import com.badlogic.gdx.Game;

public class MainMenu extends Game
{

    @Override
    public void create()
    {
       setScreen(new MainMenuScreen());
    }
}
