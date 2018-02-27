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

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameClient implements EventListener
{
    private ModWorld world;
    private List<World> tempWorlds;
    private InputManagers inputManager;
    private Player player;
    private Queue inputs;

    public GameClient()
    {
        world = new MainTitle(this);
        inputManager = new InputManagers(this);
        world.addObject(inputManager,-1,-1);
        player = new Player(world);
        Mayflower.setWorld(world);
        inputs = new LinkedList();

    }

    public void Process(String s)
    {
        inputs.add(s);
        world.Process(s);
    }
    public void changeWorld(ModWorld world)
    {
        this.world = world;
        world.addObject(inputManager,-1,-1);
        Mayflower.setWorld(this.world);
    }
    @Override
    public void onEvent(String s)
    {
        switch (s) {
            case "play":
                world = new SelectSave(this);
                inputManager.clearKeys();
                inputManager.addKeys(Keyboard.KEY_UP, "up");
                inputManager.addKeys(Keyboard.KEY_DOWN, "down");
                onEvent("game");
                break;
            case "game":
                world = new GameWorld(player);
                player.setWorld(world);
                inputManager.clearKeys();
                inputManager.addKeys(Keyboard.KEY_NUMPAD8,"N");
                inputManager.addKeys(Keyboard.KEY_NUMPAD9,"NE");
                inputManager.addKeys(Keyboard.KEY_NUMPAD6,"E");
                inputManager.addKeys(Keyboard.KEY_NUMPAD3,"SE");
                inputManager.addKeys(Keyboard.KEY_NUMPAD2,"S");
                inputManager.addKeys(Keyboard.KEY_NUMPAD1,"SW");
                inputManager.addKeys(Keyboard.KEY_NUMPAD4,"W");
                inputManager.addKeys(Keyboard.KEY_NUMPAD7,"NW");
                changeWorld(world);
                break;
        }
    }

}
