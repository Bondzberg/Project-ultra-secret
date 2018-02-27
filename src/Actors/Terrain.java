package Actors;

import mayflower.Color;

public class Terrain
{
    private Color color;
    private String letter;

    public Terrain(Color color,String letter)
    {
        this.color = color;
        this.letter = letter.substring(0,1);
    }

    public String getLetter() {
        return letter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
