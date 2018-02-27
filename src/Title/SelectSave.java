package Title;

import GameClient.GameClient;
import General.ModWorld;
import General.Saves;
import General.VerticalScrollingBox;

import java.util.LinkedList;

public class SelectSave extends ModWorld
{
    private LinkedList<Saves> saves;
    private VerticalScrollingBox vox;

    public SelectSave(GameClient client)
    {
        saves = new LinkedList<>();
        //vox = new VerticalScrollingBox(saves);

    }
    @Override
    public void act()
    {

    }

    @Override
    public void Tick() {

    }

    @Override
    public void Process(String s)
    {
        vox.inputs(s);
    }
}
