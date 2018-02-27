package Actors.terrain_types;

import Actors.Terrain;
import mayflower.Color;

public class roads extends Terrain
{
    public roads(double value)
    {
        super(Color.BLACK,"☺");
        if((int)value == 1)
        {
            if(value == 1.1) {
                super.setColor(Color.DARK_GRAY);
                super.setLetter("≈");
            }
            else if(value==1.2)
            {
                super.setLetter("≈");
                super.setColor(Color.YELLOW);
            }
            else if(value ==1.3)
            {
                super.setLetter("");
                super.setColor(Color.GRAY);
            }
        }
        if((int)value == 2)
        {
            if(value == 2.1)
            {
                super.setColor(Color.ORANGE);
                super.setLetter("");
            }
        }
    }
}
