package com.racing.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class AI {
    public int tileWidth, tileHeight;
    public List OpenNodes = new ArrayList();                    //List of available nodes
    public Vector2 startingNode;
    public Vector2 goalNode;
    public Vector2 testNode;
    public float prevStartScore;
    public float prevGoalScore;
    public float curStartScore;
    public float curGoalScore;
    public final int TILESIZE_WIDTH = 64;
    public final int TILESIZE_HEIGHT = 64;

    public AI(int trackValue, int mapWidth, int mapHeight)
    {
        tileWidth = mapWidth / TILESIZE_WIDTH + 2;
        tileHeight = mapHeight / TILESIZE_HEIGHT + 2;

//        switch (trackValue)                                   //Determines starting value based on map
//        {
//            case 1:
//                startingNode = ()
//        }

    }

    public void testMap()
        {
            OpenNodes.add(0, startingNode);
        }

}
