package GameClient;

import Actors.ModActor;
import General.ModWorld;
import Title.MainTitle;
import Title.SelectSave;
import mayflower.World;
import mayflower.event.EventListener;

import java.util.List;

public class GameClient implements EventListener
{
    private ModWorld world;
    private List<World> tempWorlds;
    private InputManagers inputManager;
    private ModActor player;


    public GameClient()
    {
        world = new MainTitle(this);
        inputManager = new InputManagers(this);
        world.addObject(inputManager,-1,-1);
    }
    @Override
    public void onEvent(String s)
    {
        if(s.equals("Play"))
        {
            world = new SelectSave();
        }
    }

}
