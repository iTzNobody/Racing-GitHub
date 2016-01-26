package com.racing.game;


import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenuScreen extends Game implements Screen
{
    public Skin skin;

    public SpriteBatch batch = new SpriteBatch();
    public BitmapFont font;
    public Stage stage = new Stage();
    public float delta;
    public Texture background = new Texture(Gdx.files.internal("android/assets/background.png"));
    public Texture logo = new Texture(Gdx.files.internal("android/assets/logo.png"));
    public Texture title = new Texture(Gdx.files.internal("android/assets/title.png"));
    public Sprite backgroundSprite = new Sprite(background);
    public Sprite logoSprite = new Sprite(logo);
    public Sprite titleSprite = new Sprite(title);
    public InputListener inputListener = new InputListener();
    public TextButton newGameButton;
    public TextButton exitGameButton;

    public MainMenuScreen()
    {
        createMenu();
        render(delta);
    }

    public void createMenu()
    {
        Gdx.input.setInputProcessor(stage);
        //create a font and skin
        font = new BitmapFont();
        skin = new Skin();
        skin.add("default",font);


        //create a font and skin
        font = new BitmapFont();
        skin = new Skin();
        skin.add("default",font);

        //create a texture
        Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();
        skin.add("android/assets/background.png", new Texture(pixmap));

        //Create a button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("android/assets/background.png", Color.WHITE);
        textButtonStyle.down = skin.newDrawable("android/assets/background.png", Color.BLUE);
        textButtonStyle.checked = skin.newDrawable("android/assets/background.png", Color.WHITE);
        textButtonStyle.over = skin.newDrawable("android/assets/background.png", Color.WHITE);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
        newGameButton = new TextButton("New Game", skin);
        exitGameButton = new TextButton("Exit Game", skin);
        exitGameButton.setPosition(600, 50);
        newGameButton.setPosition(200, 50);
        stage.addActor(newGameButton);
        stage.addActor(exitGameButton);
        exitGameButton.addListener(inputListener);
        newGameButton.addListener(inputListener);
    }

    @Override
    public  void create()
    {

    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        //Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgroundSprite.setSize(1920, 1080);
        logoSprite.setPosition(750, 430);
        titleSprite.setPosition(700, 350);
        batch.begin();
        backgroundSprite.draw(batch);
        logoSprite.draw(batch);
        titleSprite.draw(batch);
        batch.end();
        stage.act();
        stage.draw();


        //if(newGameButton.isPressed())
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            //setScreen(new MyGdxGame());
            newGameButton.setChecked(true);
        }
        if(newGameButton.isChecked())
        {
            setScreen(new MyGdxGame());
            dispose();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.TAB))
        {
            Gdx.app.exit();
        }
        if(exitGameButton.isPressed())
        {
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height)
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
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        //stage.clear();
        skin.dispose();
        stage.dispose();
    }
}