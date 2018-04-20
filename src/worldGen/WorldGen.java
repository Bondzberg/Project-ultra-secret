package worldGen;

import mayflower.Color;
import mayflower.World;

import java.math.MathContext;

public class WorldGen
{
    private World world;
    private double[][] map;
    private int dy;
    private int dx;
    private OpenSimplexNoise[] octave;
    //private double persistance;
    //private double lacunarity;

    public WorldGen(World world)
    {
        this.world = world;
        this.world.setFont("Time new Roman",8);
        dy = (int)((Math.random()+1)*10);
        dx = (int)((Math.random()+1)*10);
        octave=new OpenSimplexNoise[3];
        octave[0] = new OpenSimplexNoise((long)(Math.random()*Integer.MAX_VALUE));
        octave[1] = new OpenSimplexNoise((long)(Math.random()*Integer.MAX_VALUE));
        octave[2] = new OpenSimplexNoise((long)(Math.random()*Integer.MAX_VALUE));
        //persistance = .5;
        //lacunarity = 2.0;
        setMap(100,100,2,.5,27.3);
        Initilize();
    }

    public void Initilize()
    {


        for(int y=0;y<map.length;y++)
        {
            for(int x=0;x<map[0].length;x++)
            {
                Color color = Color.ORANGE;
                //double val = noise.eval(x/1,y/1);
                //double absVal = Math.abs(abs.eval(x/5,y/5));
                double dfc = Math.sqrt((50-x)*(50-x)+(50-y)*(50-y));

                double fin = map[y][x];

                if(fin>.8)
                    color = Color.GRAY;
                else if(fin>.5)
                    color = Color.GREEN;
                else if(fin>.4)
                    color = Color.YELLOW;
                else
                    color = Color.BLUE;
                world.showText("█",8,8*x,y*8,color);
            }
        }

    }

    /*private double getV(int x,int y)
    {
        double ret=0;
        for(int i=0;i<octave.length;i++)
        {
            double lac= Math.pow(lacunarity,i);
            double per = Math.pow(persistance,i);
            ret+=per*octave[i].eval(x*lac,y*lac);

        }
        return ret;
    }*/
    private void setMap(int mapHeight,int mapWidth,double persistance,double lacunarity,double scale)
    {

         map = new double[mapHeight][mapWidth];
        double maxHeight = Double.MIN_VALUE;
        double minHeight = Double.MAX_VALUE;

        for(int y = 0;y<map.length;y++)
        {
            for(int x =0;x<map[0].length;x++)
            {
                double amplitude = 1;
                double frequency = 1;
                double noiseHeight = 0;
                for(int i =0;i<octave.length;i++)
                {
                    double sampleX = x / scale *frequency;
                    double sampleY = y / scale *frequency;

                    double value = octave[i].eval(sampleX,sampleY) *2 -1;
                    noiseHeight += value*amplitude;

                    amplitude*=persistance;
                    frequency*=lacunarity;
                }

                if(noiseHeight>maxHeight)
                    maxHeight = noiseHeight;
                else if(noiseHeight<minHeight)
                    minHeight = noiseHeight;
                map[y][x] = noiseHeight;
            }
        }
        for(int y = 0;y<map.length;y++) {
            for (int x = 0; x < map[0].length; x++) {
                map[y][x] = normalize(minHeight,maxHeight,map[y][x]);
            }
        }
    }

    private double normalize(double min,double max,double val)
    {
        return (val-min)/(max-min);
    }

    public World getWorld() {
        return world;
    }
}
