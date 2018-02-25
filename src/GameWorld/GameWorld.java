package GameWorld;

import Actors.ModActor;
import Actors.Player;
import General.ModWorld;
import mayflower.Actor;
import mayflower.World;

import java.util.ArrayList;
import java.util.List;

public class GameWorld extends ModWorld
{
    private List<ModActor> Actors;
    private List<Class> classes;
    private ModActor[][] world;
    private long Timer;
    private Player player;

    public GameWorld(Player player)
    {
        Timer = 1000+System.currentTimeMillis();
        this.player = player;
        Actors = new ArrayList<>();
        world = new ModActor[100][100];
        world[99][99] = player;
        player.setxyIndex(99,99);
        render();
        setBackground("img/black-background.jpg");
        Actors.add(player);
    }

    @Override
    public void Tick()
    {
        for(ModActor Actor: Actors)
        {
            Actor.Tick();
        }
    }

    @Override
    public void Process(String s)
    {

    }

    public void render()
    {
        int x = player.getxIndex()-32;
        int y = player.getyIndex()-24;
        int x2 = player.getxIndex()+31;
        int y2 = player.getyIndex()+23;
        if(x<0) {
            x2-= x;
            x = 0;
        }
        else if(x2>(world[0].length)) {
            x -= x2-world[0].length+1;
            x2 = world[0].length;
        }
        if(y<24) {
            y2-= y;
            y = 0;

        }
        else if(y2>(world[0].length)) {
            y -= y2-world.length-1;
            y2 = world.length;
        }
        for(int y1 = y; y1<y2;y1++)
        {
            for(int x1 =x;x1<x2;x1++)
            {
                ModActor actor = world[y1][x1];
                if(actor != null)
                {
                    showText(actor.getLetter(),16,(x1-x)*16,(y1-y)*16+16,actor.getColor());

                    if(actor.getClass().equals(Player.class))
                    {
                        player.setxyIndex(x1,y1);
                    }
                }


            }

        }
    }

    @Override
    public void act()
    {
        if(System.currentTimeMillis()>=Timer) {
            Timer = System.currentTimeMillis()+1000;
            for(ModActor actor:Actors)
            {
                actor.animate();
                render();
            }
        }
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
