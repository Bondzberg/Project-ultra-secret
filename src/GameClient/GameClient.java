package GameClient;

import Actors.ModActor;
import Actors.Player;
import General.ModWorld;
import Title.MainTitle;
import Title.SelectSave;
import mayflower.*;
import mayflower.event.EventListener;
import GameWorld.GameWorld;





import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class GameClient implements EventListener
{
    private ModWorld world;
    private List<World> tempWorlds;
    private InputManagers inputManager;
    private Player player;
    private Queue inputs;
    private static Map<Integer, Font> fonts = new HashMap();


    public GameClient()
    {
        world = new MainTitle(this);

        player = new Player(world);
        Mayflower.setWorld(world);
        inputs = new LinkedList();
        String text = "☺";

        /*
           Because font metrics is based on a graphics context, we need to create
           a small, temporary image so we can ascertain the width and height
           of the final image
         */
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Time new Roman", Font.PLAIN, 16);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.WHITE);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();

        try {
            ImageIO.write(img, "png", new File("Text.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        MayflowerImage image = new MayflowerImage("Text.png");

        inputManager = new InputManagers(this);
        inputManager.setImage(image);

        world.addObject(inputManager,0,0);

    }

    public void Process(String s)
    {
        inputs.add(s);
        world.Process(s);
    }
    public void changeWorld(ModWorld world)
    {
        this.world = world;
        world.addObject(inputManager,-1,-1);
        Mayflower.setWorld(this.world);
    }
    @Override
    public void onEvent(String s)
    {
        switch (s) {
            case "play":
                world = new SelectSave(this);
                inputManager.clearKeys();
                inputManager.addKeys(Keyboard.KEY_UP, "up");
                inputManager.addKeys(Keyboard.KEY_DOWN, "down");
                onEvent("game");
                break;
            case "game":
                world = new GameWorld(player);
                player.setWorld(world);
                inputManager.clearKeys();
                inputManager.addKeys(Keyboard.KEY_NUMPAD8,"N");
                inputManager.addKeys(Keyboard.KEY_NUMPAD9,"NE");
                inputManager.addKeys(Keyboard.KEY_NUMPAD6,"E");
                inputManager.addKeys(Keyboard.KEY_NUMPAD3,"SE");
                inputManager.addKeys(Keyboard.KEY_NUMPAD2,"S");
                inputManager.addKeys(Keyboard.KEY_NUMPAD1,"SW");
                inputManager.addKeys(Keyboard.KEY_NUMPAD4,"W");
                inputManager.addKeys(Keyboard.KEY_NUMPAD7,"NW");
                changeWorld(world);
                break;
        }
    }

}
