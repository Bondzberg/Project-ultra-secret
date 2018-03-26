package GameClient;

import mayflower.Actor;
import mayflower.Mayflower;


import java.util.HashMap;

public class InputManagers extends Actor
{
    private HashMap<Integer,String> keys;
    private GameClient client;

    public InputManagers(GameClient client)
    {
        keys = new HashMap<>();
        this.client = client;
        setImage("img/play.png");
        getImage().setTransparency(100);
    }
    public void addKeys(Integer key,String Action)
    {
        keys.put(key,Action);
    }
    public  void clearKeys()
    {
        keys = new HashMap<>();
    }
    @Override
    public void act()
    {
        for(int key: keys.keySet())
        {
            if(Mayflower.isKeyPressed(key))
            {
                client.Process(keys.get(key));
                break;
            }
        }
    }
}
