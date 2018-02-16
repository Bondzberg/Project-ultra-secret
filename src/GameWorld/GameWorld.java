package GameWorld;

import Actors.ModActor;
import General.ModWorld;
import mayflower.Actor;
import mayflower.World;

import java.util.List;

public class GameWorld extends ModWorld
{
    private List<ModActor> Actors;
    private List<Class> classes;
    @Override
    public void Tick()
    {
        for(ModActor Actor: Actors)
        {
            Actor.Tick();
        }
    }
    @Override
    public void act()
    {

    }

    @Override
    public String toString()
    {
        String ret="";
        for(Class classe: classes)
        {
            for(Object actor:this.getObjects(classe))
            {
                ret = actor.toString();
            }

        }
        return ret;
    }

}
