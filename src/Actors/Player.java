package Actors;

public class Player extends ModActor
{

    public Player()
    {
        super("@");
        setSpeed((int)(Math.random()*10)+10);
        setHealth((int)(Math.random()*10)+10);
        setName("Player");

    }

    @Override
    public void Tick()
    {

    }

}
