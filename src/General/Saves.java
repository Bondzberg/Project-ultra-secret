package General;

import GameWorld.GameWorld;

public class Saves
{
    private String important;

    //creates a new save file
    public Saves(GameWorld gameWorld)
    {
        important = gameWorld.toString();

    }
}
