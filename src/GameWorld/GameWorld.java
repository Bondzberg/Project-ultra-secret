package GameWorld;

import Actors.ModActor;
import Actors.Player;
import Actors.Terrain;
import Actors.Wall;
import Actors.terrain_types.roads;
import General.ModWorld;
import mayflower.Font;
import storage.Nodes;
import mayflower.Color;

import java.io.File;
import java.util.*;

public class GameWorld extends ModWorld
{
    private List<ModActor> Actors;
    private List<Class> classes;
    private storage.Nodes[][] world;
    private long Timer;
    private Player player;
    private Queue inputs;
    private boolean done;
    private Font font;

    public GameWorld(Player player)
    {
        Timer = 1000+System.currentTimeMillis();
        this.player = player;
        Actors = new ArrayList<>();
        world = new Nodes[100][100];
        player.setxyIndex(99,99);
        render();
        setBackground("img/black-background.jpg");
        Actors.add(player);
        inputs = new LinkedList();
        done =true;
        setWorld();
        font = new Font("Time new Roman",16);
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
        inputs.add(s);

    }

    public void render()
    {
        Set<String> strings = new HashSet<>();
        for(String s: this.getTexts().keySet())
        {
            strings.add(s);
        }
        for(String s:strings)
        {
            this.getTexts().remove(s);
        }
        this.getTexts();
        int x = player.getxIndex()-31;
        int y = player.getyIndex()-24;
        int x2 = player.getxIndex()+33;
        int y2 = player.getyIndex()+23;
        if(x<0) {
            x2-= x;
            x = 0;
        }
        else if(x2>(world[0].length)-1) {
            x -= x2-world[0].length;
            x2 = world[0].length;
        }
        if(y<0) {
            y2-= y;
            y = 0;

        }
        else if(y2>(world.length)) {
            y -= y2-world.length-1;
            y2 = world.length;
        }
        for(int y1 = y; y1<y2;y1++)
        {
            for(int x1 =x;x1<x2;x1++)
            {
                if(world[y1][x1]!=null) {
                    ModActor actor = world[y1][x1].Actor();
                    Terrain terrain = world[y1][x1].Terrain();
                    if (actor != null) {
                        showText(actor.getLetter(), 16, (x1 - x) * 16, (y1 - y) * 16 + 16, actor.getColor());

                        if (actor.getClass().equals(Player.class)) {
                            player.setxyIndex(x1, y1);
                        }
                    } else if (terrain != null) {
                        showText(terrain.getLetter(), 16, (x1 - x) * 16, (y1 - y) * 16 + 16, terrain.getColor());
                    }
                }

            }

        }

    }

    @Override
    public void act()
    {
        if(inputs.size()>0&&done)
        {
            done = false;
            String s = (String)inputs.remove();
            int x =0;
            int y =0;
            if(s.substring(0,1).equals("N"))
            {
                y-=1;
                if(s.length()==2)
                {
                    if(s.substring(1,2).equals("E"))
                        x+=1;
                    else
                        x-=1;
                }
            }
            else if(s.substring(0,1).equals("S"))
            {
                y+=1;
                if(s.length()==2)
                {
                    if(s.substring(1,2).equals("E"))
                        x+=1;
                    else
                        x-=1;
                }
            }
            else{
                if(s.substring(0,1).equals("E"))
                    x+=1;
                else
                    x-=1;
            }
            if(legalAction(x,y))
            {
                world[player.getyIndex()][player.getxIndex()].setActor(null);
                world[player.getyIndex()+y][player.getxIndex()+x].setActor(player);
                player.setxyIndex(player.getxIndex()+x,player.getyIndex()+y);
                render();
            }
            done =true;

        }
        if(System.currentTimeMillis()>=Timer) {
            Timer = System.currentTimeMillis()+1000;
            for(ModActor actor:Actors)
            {
                actor.animate();

            }
            render();
        }
    }

    public boolean legalAction(int x, int y)
    {
        if(x+player.getxIndex()>=world[0].length||x+player.getxIndex()<0)
            return false;
        if(y+player.getyIndex()>=world.length||y+player.getyIndex()<0)
            return false;
        if(world[y+player.getyIndex()][x+player.getxIndex()].Actor() !=null)
            return false;
        return true;
    }

    public void setWorld()
    {
        try {
            Scanner s = new Scanner(new File("supa secret fold(do not touch)/World.txt"));
            int lnum = 0;
            while (s.hasNext()) {
                String line = s.nextLine();
                String[] strings = line.split(",");
                for (int i = 0; i < 100; i++) {
                    world[lnum][i] = new Nodes(null, new roads(Double.valueOf(strings[i])));
                    if(Double.valueOf(strings[i])==3.0)
                        world[lnum][i].setActor(new Wall());
                }
                lnum++;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.print("Chances are you didn't listen to me");
        }
        world[99][99].setActor(player);
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
