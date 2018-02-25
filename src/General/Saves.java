package General;

import GameWorld.GameWorld;
import mayflower.World;

import java.io.*;

public class Saves
{
    private String important;
    private File file;
    //creates a new save file
    public Saves(GameWorld gameWorld)
    {
        important = gameWorld.toString();
        int num = 1;
        try {
            do {
                file = new File(String.format("saves/%d.sav", num));
                num++;
            } while (!file.createNewFile());
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(String.format("saves%d.sav", num-1)) ));
            writer.write(important);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //recreates a save file
    public Saves(File file)
    {
        //To-do create a system that recreates a save/world via a sav file
    }
    public World world()
    {
        //uses the important string to make a world
        return null;
    }
}
