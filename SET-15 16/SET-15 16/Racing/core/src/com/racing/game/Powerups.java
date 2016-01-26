package com.racing.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;
import com.racing.game.Player;
import com.racing.game.MyGdxGame;
import org.omg.CORBA.TypeCodePackage.BadKind;

import java.util.Random;

public class Powerups
{
    public Texture speedBoost;
    public Texture iceAttack;
    public Texture laserAttack;
    public Sprite speed;
    public Sprite ice;
    public Sprite laser;
    public Rectangle iceRect;
    private Rectangle speedRect;
    private Rectangle laserRect;
    private Rectangle playerRect;
    public boolean timerIsOn = false;
    public SpriteBatch spriteBatch;
    public Sprite sprite;
    //private Rectangle testRect;
    class ArrayDemo {
        public void main(String[] args) {
            Powerups[] powerUps;
            powerUps = new Powerups[6];

        }
    }

    
    public Powerups(SpriteBatch spriteBatch1, Sprite sprite1)
    {
        spriteBatch = spriteBatch1;
        sprite = sprite1;
        speedBoost = new Texture(Gdx.files.internal("android/assets/speedBoost.png"));
        iceAttack = new Texture(Gdx.files.internal("android/assets/ice.png"));
        speed = new Sprite(speedBoost);
        ice = new Sprite(iceAttack);
        ice.setPosition(2800,3700);

        laserAttack = new Texture(Gdx.files.internal("android/assets/laser.png"));
        laser = new Sprite(laserAttack);
        laser.setPosition(0,0);
        laserRect = new Rectangle(laser.getX(), laser.getY(),
        laser.getHeight(), laser.getWidth());
        speedRect = new Rectangle(speed.getX(), speed.getY(),
                speed.getWidth(), speed.getHeight());
        playerRect = new Rectangle(sprite.getX(), sprite.getY(),
                sprite.getWidth(), sprite.getHeight());
        iceRect = new Rectangle(ice.getX(), ice.getY(),
                ice.getWidth(), ice.getHeight());
    }

    public void onContact()
    {
        if(speedRect != null && playerRect.overlaps(speedRect))
        {
            timerIsOn = true;
            Timer.schedule(new Timer.Task() {
                @Override
                public void run()
                {
                    speedRect = null;
                    speed = null;
                    Player.carSpeed = Player.MAXSPEED + 150;
                }
        }, 0.5f);
        }
        if(laserRect != null && playerRect.overlaps(laserRect))
        {

        }
        if(iceRect != null & playerRect.overlaps(iceRect))
        {
            timerIsOn = true;
            Timer.schedule(new Timer.Task() {
                @Override
                public void run()
                {
                    Player.carSpeed = Player.carSpeed * 0.75f;  //test code; when working, it should slow down all other cars
                }
            }, 0.5f);
        }
    }
    public void spawnAtTile()
    {
        
    }
    public void render()
    {
            spriteBatch.begin();
//            speed.draw(spriteBatch);
            ice.draw(spriteBatch);
            laser.draw(spriteBatch);
            spriteBatch.end();
    }
    public void update()
    {
        playerRect.setPosition(sprite.getX(), sprite.getY());
        if (speed != null)
            speedRect.setPosition(speed.getX(), speed.getY());
        render();
        onContact();
    }
}