package org.example;

import java.awt.*;

public class Door extends MapSite {

    private Room room1;
    private Room room2;

    public Door(Room room1, Room room2)
    {
        super(0, 0);
        this.room1 = room1;
        this.room2 = room2;
    }

    public Room getRoom1()
    {
        return room1;
    }

    public Room getRoom2()
    {
        return room2;
    }

    @Override
    public void draw(Image image)
    {

        Graphics g = image.getGraphics();

        g.setColor(Color.GREEN);

        g.fillRect(getX() - 5, getY() - 5, 10, 10);
    }
}