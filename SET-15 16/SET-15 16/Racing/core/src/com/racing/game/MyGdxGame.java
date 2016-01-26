package com.racing.game;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.sun.prism.image.ViewPort;
import com.racing.game.Powerups;


import static com.badlogic.gdx.Input.Keys;

public class MyGdxGame extends  Game implements Screen
{
    public SpriteBatch spriteBatch;
    public static OrthographicCamera camera;
    public static TiledMap tileMap, collisionMap;
    private OrthogonalTiledMapRenderer tiledMapRenderer, tileMapRenderer;
    public static TiledMapTileLayer collisionLayer;
    Player player;
    float w;
    float h;
    Texture carImg;
    public static Sprite sprite;
    Powerups powerups;
    public static Rectangle lastKnownPosition;

    public MyGdxGame()
    {
        create();
        render();
    }


    public void show()
    {

    }

    @Override
    public void render(float delta)
    {

    }

    public void hide()
    {

    }

    @Override
    public void create()
    {

        lastKnownPosition = new Rectangle();
        spriteBatch = new SpriteBatch();
        carImg = new Texture(Gdx.files.internal("android/assets/car.png"));
        sprite = new Sprite(carImg);
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setPosition(0, 0);
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        //collisionMap = new TmxMapLoader().load("android/assets/Collision.tmx");
        collisionMap = new TmxMapLoader().load("android/assets/Track2/NewTrack1Collision.tmx");
        collisionLayer = (TiledMapTileLayer) collisionMap.getLayers().get("Tile Layer 1");
        //tileMap = new TmxMapLoader().load("android/assets/SecondTrackMap.tmx");
        tileMap = new TmxMapLoader().load("android/assets/Track2/NewTrack1.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tileMap);
        tileMapRenderer = new OrthogonalTiledMapRenderer(collisionMap);
        player = new Player(spriteBatch, sprite, collisionLayer);
        powerups = new Powerups(spriteBatch, sprite);
    }



    @Override
    public void dispose()
    {
        carImg.dispose();
        collisionMap.dispose();
        tileMap.dispose();
        tileMapRenderer.dispose();
        tiledMapRenderer.dispose();
        spriteBatch.dispose();
    }


	@Override
	public void render ()
    {
        camera.position.set(player.sprite.getX(),player.sprite.getY(),0);
        if(Gdx.input.isKeyPressed(Keys.ESCAPE))
            Gdx.app.exit();
        if(Gdx.input.isKeyPressed(Keys.TAB)) {
            dispose();
            setScreen(new Splash());
        }
        if(Gdx.input.isKeyPressed(Keys.T))
        {
            setScreen(new MainMenuScreen());
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        tiledMapRenderer.setView(camera);
        tileMapRenderer.setView(camera);
        tiledMapRenderer.render();
        //will lag if this next line isn't commented out
        //there so the colliding areas can be seen
        //tileMapRenderer.render();
        player.update();
        powerups.update();
        spriteBatch.setProjectionMatrix(camera.combined);
        camera.update();
    }
}
