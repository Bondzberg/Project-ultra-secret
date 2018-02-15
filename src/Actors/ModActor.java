package Actors;

import mayflower.Actor;
import mayflower.Color;
import mayflower.Label;
import mayflower.MayflowerImage;

public abstract class ModActor extends Actor
{
    private Label image;
    private int speed;
    private int time;
    private int Health;
    private String letter;
    private String name;

    public ModActor()
    {
        image = new Label("");
    }
    public ModActor(String image)
    {
        this.image = new Label(image.substring(0,1),10, Color.CYAN);
        letter = image.substring(0,1);
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
        Health = health;
    }

    public abstract void Tick();

    public void modTime(int x)
    {
        time -= x;
    }
    
    public void modHealth(int x)
    {
        this.Health -= x;
    }

    public int getHealth() {
        return Health;
    }

    public int getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String ret =name+": "+letter+","+Integer.toString(speed)+","+Integer.toString(time)+","+Integer.toString(Health);

        return super.toString();
    }
}
