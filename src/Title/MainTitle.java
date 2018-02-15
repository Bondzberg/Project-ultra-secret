package Title;

import GameClient.GameClient;
import General.ModWorld;
import com.sun.deploy.util.SessionState;
import mayflower.Label;
import mayflower.Mayflower;
import mayflower.World;
import mayflower.event.EventListener;
import mayflower.ui.Button;

public class MainTitle extends ModWorld implements EventListener
{
    private Button play;
    private Button options;
    private Label Title;
    private GameClient client;

    public MainTitle(GameClient client)
    {
        play = new Button("img/play","play");
        play.addEventListener(this);
        addObject(play,400,300);
        Title = new Label("Title Screen");
        addObject(Title,400,100);
        options = new Button("img/play","option");
        options.addEventListener(this);
        addObject(options,400,500);
        Mayflower.setWorld(this);
    }

    @Override
    public void act()
    {

    }

    @Override
    public void Tick() {
        //do nothing
    }


    @Override
    public void onEvent(String s)
    {
        client.onEvent(s);
    }
}
