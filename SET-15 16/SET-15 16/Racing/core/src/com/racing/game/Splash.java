package com.racing.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Splash extends Game implements Screen
{
    private Texture splashScreen;
    private SpriteBatch spriteBatch;



    public void create()
    {

    }

    @Override
    public void show()
    {
        splashScreen = new Texture(Gdx.files.internal("android/assets/splash.png"));
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render(float delta)
    {
        handleInput();

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(splashScreen,0,0);
        spriteBatch.end();
    }

    private void handleInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.TAB))
        {
            dispose();
           //setScreen(new MyGdxGame());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            Gdx.app.exit();
        }
    }
    @Override
         public void resize(int width, int height)
         {
         }
         @Override
         public void hide()
         {
         }
         @Override
         public void pause()
         {
         }
         @Override
         public void resume()
         {
         }
         @Override
         public void dispose()
         {
             splashScreen.dispose();
             spriteBatch.dispose();
         }
}
