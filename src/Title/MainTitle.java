package Title;

import GameClient.GameClient;
import General.ModWorld;
import com.sun.deploy.util.SessionState;
import mayflower.*;
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
        play = new Button("img/play.png","play");
        play.addEventListener(this);
        addObject(play,400,300);
        Title = new Label("Title Screen");
        addObject(Title,400,100);
        options = new Button("img/play.png","option");
        options.addEventListener(this);
        addObject(options,400,500);
        Label temp =new Label("@",50, Color.BLACK);
        addObject(temp,50,50);
        Mayflower.setWorld(this);
    }

    @Override
    public void act()
    {
        Label temp =new Label("@");
        addObject(temp,50,50);
        temp.setText("A");
        temp.setColor(Color.BLACK);
        new MayflowerImage("a",10,Color.BLACK);
    }

    @Override
    public void Tick() {
        //do nothing
    }

    @Override
    public void Process(String s)
    {

    }


    @Override
    public void onEvent(String s)
    {
        client.onEvent(s);
    }
}
