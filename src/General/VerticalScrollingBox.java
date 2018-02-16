package General;

import mayflower.Actor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VerticalScrollingBox extends Actor
{
    private Queue inputs;
    private LinkedList saves;
    private Boolean done;
    private Saves[] displayed;
    private int index;

    public VerticalScrollingBox(List<Saves> saves)
    {
        inputs = new LinkedList();
        for(Saves save: saves)
        {
            this.saves.add(save);
        }
        done = true;
        displayed = new Saves[3];
        displayed[0] = saves.get(0);
        displayed[1] = saves.get(1);
        displayed[2] = saves.get(2);

    }

    public void inputs(String s)
    {
        this.inputs.add(s);
    }
    @Override
    public void act()
    {
        if(inputs.peek()!=null&&done)
        {
            if(inputs.peek().equals("up"))
            {

            }
        }
    }
    public void goUp()
    {

    }
}
