package org.example;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 30, 30);
    }

    @Override
    public void update() {
    }
}