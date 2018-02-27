package storage;

import Actors.ModActor;
import Actors.Terrain;

import java.util.List;

public class Nodes
{
    private ModActor actor;
    private List item;
    private Terrain terrain;
    public Nodes(ModActor actor,Terrain terrain)
    {
        this.terrain = terrain;
        this.actor = actor;
    }

    public ModActor Actor() {
        return actor;
    }

    public Terrain Terrain() {
        return terrain;
    }

    public List Items() {
        return item;
    }

    public void setActor(ModActor actor) {
        this.actor = actor;
    }
}
