package Actors;

import mayflower.World;

public class Player extends ModActor
{

    public Player(World world)
    {
        super("☺",world);
        setSpeed((int)(Math.random()*10)+10);
        setHealth((int)(Math.random()*10)+10);
        setName("Player");
    }

    @Override
    public void Tick()
    {

    }

}
