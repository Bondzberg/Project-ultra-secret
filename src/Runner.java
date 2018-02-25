
import GameClient.GameClient;
import mayflower.*;

public class Runner extends Mayflower
{
    public Runner(){
        super("Snek", 1024, 768);
    }

    public void init()
    {
        //Mayflower.setFullScreen(true);
        new GameClient();

    }

    public static void main(String[] args){
        new Runner();
    }
}