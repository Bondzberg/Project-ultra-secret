package GameClient;

import Actors.ModActor;
import Actors.Player;
import General.ModWorld;
import Title.MainTitle;
import Title.SelectSave;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.World;
import mayflower.event.EventListener;
import GameWorld.GameWorld;
import java.util.List;

public class GameClient implements EventListener
{
    private ModWorld world;
    private List<World> tempWorlds;
    private InputManagers inputManager;
    private Player player;


    public GameClient()
    {
        world = new MainTitle(this);
        inputManager = new InputManagers(this);
        world.addObject(inputManager,-1,-1);
       // player = new Player();
        //world = new GameWorld(player);
        //Mayflower.setWorld(world);
    }
    @Override
    public void onEvent(String s)
    {
        if(s.equals("Play"))
        {
            world = new SelectSave();
            inputManager.clearKeys();
            inputManager.addKeys(Keyboard.KEY_UP,"up");
            inputManager.addKeys(Keyboard.KEY_DOWN,"down");
        }
        else
        {

        }
    }

}
