package General;

import GameWorld.GameWorld;
import mayflower.World;

import java.io.File;

public class Saves
{
    private String important;
    private File file;
    //creates a new save file
    public Saves(GameWorld gameWorld)
    {
        important = gameWorld.toString();
    }
    //recreates a save file
    public Saves(File filel)
    {
        //To-do create a system that recreates a save/world via a txt file
    }
    public World world()
    {
        //uses the important string to make a world
        return null;
    }
}
