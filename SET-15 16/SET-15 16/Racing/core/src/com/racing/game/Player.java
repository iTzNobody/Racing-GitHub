package com.racing.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.io.Console;


public class Player
{
    public TiledMapTileLayer collisionLayer;
    private SpriteBatch spriteBatch;
    float rotateValue = 0f;
    static float carSpeed = 0f;
    static float collisionSpeed = 0f;
    public static final int MAXSPEED = 800;
    public final int MINSPEED = -300;
    public static Sprite sprite;
    public static Sprite collisionSprite;
    int lap = 0;
    BitmapFont font = new BitmapFont();
    CharSequence str = "Lap: " + lap + " / 3";






    public Player(SpriteBatch spriteBatch1, Sprite sprite1, TiledMapTileLayer collisionLayer1) {
        spriteBatch = spriteBatch1;
        sprite = sprite1;
        collisionSprite = new Sprite(sprite1);
        collisionLayer = collisionLayer1;
        collisionSprite.setSize(MyGdxGame.sprite.getWidth(), MyGdxGame.sprite.getHeight());
        collisionSprite.setPosition(0,0);
      //  collisionSprite.setColor(Color.RED);
    }

    public void movement()
    {
        if (checkCollisionMap())
        {
            //handles what will happen if sprite(car)collides with collisionMap
            carSpeed = carSpeed / 2;
            sprite.setPosition(collisionSprite.getX(), collisionSprite.getY());
        }
        else
            collisionSprite.setPosition(sprite.getX(), sprite.getY());

        if (carSpeed == 0)
            rotateValue = 0f;
        else if ((carSpeed < 0 && carSpeed >= -100) || (carSpeed > 0 && carSpeed <= 100))
            rotateValue = .4f;
        else if((carSpeed < -100 && carSpeed >= -200) || (carSpeed > 100 && carSpeed <= 200 && carSpeed != 0))
            rotateValue = .8f;
        else if ((carSpeed < -200) || (carSpeed > 200 && carSpeed <= 300 && carSpeed != 0))
            rotateValue = 1.2f;
        else if (carSpeed > 300 && carSpeed <= 400 && carSpeed != 0)
            rotateValue = 1.6f;
        else if (carSpeed > 400 && carSpeed <= 500 && carSpeed != 0)
            rotateValue = 2f;
        else if (carSpeed > 500 && carSpeed <= 600 && carSpeed != 0)
            rotateValue = 2.4f;
        else if (carSpeed > 600 && carSpeed <= 700 && carSpeed != 0)
            rotateValue = 2.8f;
        else if  (carSpeed > 700 && carSpeed != 0)
            rotateValue = 3.2f;



        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
            sprite.rotate(rotateValue);


        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
            sprite.rotate(rotateValue * -1);



        sprite.setX(sprite.getX() + Gdx.graphics.getDeltaTime() * carSpeed * (float) Math.cos(Math.toRadians(sprite.getRotation())));
        sprite.setY(sprite.getY() + Gdx.graphics.getDeltaTime() * carSpeed * (float) Math.sin(Math.toRadians(sprite.getRotation())));


        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {

            if (carSpeed < MAXSPEED)
                if (carSpeed < 0)
                    carSpeed += 10;
                else if (carSpeed >= 0)
                    carSpeed += 5;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            if (carSpeed > MINSPEED)
                carSpeed -= 10;
        }
        else if (carSpeed != 0) {
            if (carSpeed > 0)
                carSpeed -= 5;
            if (carSpeed < 0)
                carSpeed += 5;
        }
        if(carSpeed == 0)
        {
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
                sprite.rotate(0f);
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
                sprite.rotate(0f);
        }
    }
    public void collMovement()
        {
        if (checkCollisionMap())
        {
            //handles what will happen if sprite(car)collides with collisionMap
            collisionSpeed = 0;
        }
        else if ((collisionSpeed < 0 && collisionSpeed >= -100) || (collisionSpeed > 0 && collisionSpeed <= 100))
            rotateValue = .4f;
        else if((collisionSpeed < -100 && collisionSpeed >= -200) || (collisionSpeed > 100 && collisionSpeed <= 200 && collisionSpeed != 0))
            rotateValue = .8f;
        else if ((collisionSpeed < -200) || (collisionSpeed > 200 && collisionSpeed <= 300 && collisionSpeed != 0))
            rotateValue = 1.2f;
        else if (collisionSpeed > 300 && collisionSpeed <= 400 && collisionSpeed != 0)
            rotateValue = 1.6f;
        else if (collisionSpeed > 400 && collisionSpeed <= 500 && collisionSpeed != 0)
            rotateValue = 2f;
        else if (collisionSpeed > 500 && collisionSpeed <= 600 && collisionSpeed != 0)
            rotateValue = 2.4f;
        else if (collisionSpeed > 600 && collisionSpeed <= 700 && collisionSpeed != 0)
            rotateValue = 2.8f;
        else if (collisionSpeed > 700 && collisionSpeed != 0)
            rotateValue = 3.2f;
        else
            rotateValue = 0f;


        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
        collisionSprite.rotate(rotateValue);

        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
        collisionSprite.rotate(rotateValue * -1);

            collisionSprite.setX(collisionSprite.getX() + Gdx.graphics.getDeltaTime() * collisionSpeed * (float) Math.cos(Math.toRadians(collisionSprite.getRotation())));
            collisionSprite.setY(collisionSprite.getY() + Gdx.graphics.getDeltaTime() * collisionSpeed * (float) Math.sin(Math.toRadians(collisionSprite.getRotation())));

        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {

          if (collisionSpeed < MAXSPEED)
               if (collisionSpeed < 0)
                    collisionSpeed += 10;
                else if (collisionSpeed >= 0)
                    collisionSpeed += 5;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            if (collisionSpeed > MINSPEED)
                collisionSpeed -= 10;
        }
        else if (collisionSpeed != 0) {
            if (collisionSpeed > 0)
                collisionSpeed -= 5;
            if (collisionSpeed < 0)
                collisionSpeed += 5;
        }
        if(carSpeed == 0)
        {
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
                collisionSprite.rotate(0f);
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
                collisionSprite.rotate(0f);
        }
    }
    public boolean checkCollisionMap()
    {
        float xWorld = sprite.getX();
        float yWorld = sprite.getY();
        float xWorldOther = sprite.getX() - sprite.getWidth();
        float yWorldOther = sprite.getY() - sprite.getHeight();
        boolean collisionWithMap;
        collisionWithMap = isCellBlocked(xWorld, yWorld, xWorldOther, yWorldOther);
        if(collisionWithMap)
        {
            return true;
        }
        return false;
    }
   /* public boolean checkLapCollision()
    {
        float xWorld = sprite.getX();
        float yWorld = sprite.getY();
        float xWorldOther = sprite.getX() - sprite.getWidth();
        float yWorldOther = sprite.getY() - sprite.getHeight();
        boolean lapCollision;
        lapCollision = lapCell(xWorld, yWorld, xWorldOther, yWorldOther);
        if(lapCollision)
        {
            return true;
        }
        return false;
    }*/



    public boolean isCellBlocked(float x, float y, float x2, float y2)
    {
        TiledMapTileLayer.Cell cell = collisionLayer.getCell(
                (int) (x / collisionLayer.getTileWidth()),
                (int) (y / collisionLayer.getTileHeight()));
        TiledMapTileLayer.Cell cell2 = collisionLayer.getCell(
                (int) (x2 / collisionLayer.getTileWidth()),
                (int) (y2 / collisionLayer.getTileHeight()));
        return (cell != null && cell.getTile() != null
                && cell.getTile().getProperties().containsKey("east")) ||
                (cell2 != null && cell2.getTile() != null && cell2.getTile().getProperties().containsKey("east"));
    }
   /* public boolean lapCell(float x, float y, float x2, float y2)
    {
        TiledMapTileLayer.Cell cell = collisionLayer.getCell(
                (int) (x / collisionLayer.getTileWidth()),
                (int) (y / collisionLayer.getTileHeight()));
        TiledMapTileLayer.Cell cell2 = collisionLayer.getCell(
                (int) (x2 / collisionLayer.getTileWidth()),
                (int) (y2 / collisionLayer.getTileHeight()));
        return (cell != null && cell.getTile() != null
                && cell.getTile().getProperties().containsKey("lap")) ||
                (cell2 != null && cell2.getTile() != null && cell2.getTile().getProperties().containsKey("lap"));
    } */



    public void render()
    {
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        font.draw(spriteBatch, str, 0, 0);
        spriteBatch.end();
    }

    public void update()
    {

        checkCollisionMap();
        //checkLapCollision();
        movement();
        collMovement();
       // if(checkLapCollision())
      //  {
           // lap++;
           // if(lap > 3)
           // {
           //     lap = 3;
           // }
           // System.out.print(lap);
       // }
        render();

    }


}