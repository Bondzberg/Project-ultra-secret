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
            if(Mayflower.isKeyDown(key))
            {
                client.onEvent(keys.get(key));
            }
        }
    }
}
