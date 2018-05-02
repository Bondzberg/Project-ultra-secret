package Actors;

import mayflower.*;

public abstract class ModActor
{

    private int speed;
    private int time;
    private int health;
    private String letter;
    private String name;
    private Color color;
    private boolean darker;
    private Color oldcolor;
    private World world;
    private int xIndex;
    private int yIndex;

    public ModActor()
    {
        letter = "";
        color = Color.WHITE;

    }
    public ModActor(String image,World world)
    {

        letter = image.substring(0,1);
        color = Color.ORANGE;
        oldcolor = color;

        darker = false;
        this.world = world;

        getWorld().showText(letter,getxIndex(),getyIndex());
    }

    public ModActor(String letter,int speed,int time,int health)
    {
        this.letter = letter.substring(0,1);
        this.speed = speed;
        this.time = time;
        this.health = health;
    }

    public void animate()
    {
        if(darker) {
            color = color.brighter().brighter().brighter().brighter().brighter();
            darker = false;
        }
        else {
            //color = new Color(color.getRed()-20,color.getGreen()-20,color.getBlue());
            color = oldcolor;
            darker = true;
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void Tick();

    public void modTime(int x)
    {
        time -= x;
    }

    public void modHealth(int x)
    {
        this.health -= x;
    }

    public int getHealth() {
        return health;
    }

    public int getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLetter() {
        return letter;
    }

    public Color getColor() {
        return color;
    }

    public World getWorld() {
        return world;
    }
    public void setWorld(World world) {
        this.world = world;
    }
    public void setxyIndex(int x,int y)
    {
        this.xIndex =x;
        this.yIndex =y;
    }

    public int getxIndex() {
        return xIndex;
    }

    public int getyIndex() {
        return yIndex;
    }

    @Override
    public String toString() {
        String ret =name+": "+letter+","+Integer.toString(speed)+","+Integer.toString(time)+","+Integer.toString(health)+"/"+getxIndex()+","+getyIndex();

        return super.toString();
    }
}
