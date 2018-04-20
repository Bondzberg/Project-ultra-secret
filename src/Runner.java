
import GameClient.GameClient;
import mayflower.*;
import worldGen.WorldGen;

public class Runner extends Mayflower
{
    public Runner(){
        super("Project ultra secret", 800, 800);
    }

    public void init()
    {
        //Mayflower.setFullScreen(true);
        //new GameClient();
        WorldGen worldGen =new WorldGen(new World() {
            @Override
            public void act() {

            }
        });
        worldGen.getWorld().setBackground("img/black-background.jpg");
        Mayflower.setWorld(worldGen.getWorld());

    }

    public static void main(String[] args){
        new Runner();
    }
}