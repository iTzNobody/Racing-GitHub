package com.racing.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class MainMenuStage implements Screen
{
    public static MainMenuStage menuStage;
    private MainMenuScreen stage;

    public MainMenuStage()

    {
        menuStage = this;
        stage = new MainMenuScreen();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.render(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
