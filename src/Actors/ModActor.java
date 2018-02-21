package Actors;

import mayflower.Actor;
import mayflower.Color;
import mayflower.Label;

public abstract class ModActor extends Actor
{
    private Label image;
    private int speed;
    private int time;
    private int health;
    private String letter;
    private String name;

    public ModActor()
    {
        image = new Label("");
    }
    public ModActor(String image)
    {
        this.image = new Label(image.substring(0,1),10, Color.RED);
        letter = image.substring(0,1);
    }

    public ModActor(String letter,int speed,int time,int health)
    {
        this.letter = letter;
        this.speed = speed;
        this.time = time;
        this.health = health;
    }

    //potential computer troubles
    @Override
    public void act()
    {
        this.image.setLocation(this.getX(),this.getY());
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

    @Override
    public String toString() {
        String ret =name+": "+letter+","+Integer.toString(speed)+","+Integer.toString(time)+","+Integer.toString(health);

        return super.toString();
    }
}
