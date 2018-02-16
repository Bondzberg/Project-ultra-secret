package Title;

import General.ModWorld;
import General.Saves;
import General.VerticalScrollingBox;

import java.util.LinkedList;

public class SelectSave extends ModWorld
{
    private LinkedList<Saves> saves;
    private VerticalScrollingBox vox;

    public SelectSave()
    {
        saves = new LinkedList<>();
        vox = new VerticalScrollingBox(saves);
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
