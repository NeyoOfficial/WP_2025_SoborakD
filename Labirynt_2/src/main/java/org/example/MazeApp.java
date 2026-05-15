package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MazeApp extends JFrame implements ActionListener, KeyListener {

    private MyPanel myPanel = new MyPanel();

    private Image buffer;
    private Graphics g;

    // GRACZ
    private Player player = new Player(70, 90);
    private final int SPEED = 10;

    // LABIRYNT
    private Maze maze;

    public MazeApp() {

        JButton buttonDraw = new JButton("Draw maze");
        buttonDraw.addActionListener(this);

        setLayout(new BorderLayout());
        add(buttonDraw, BorderLayout.NORTH);
        add(myPanel, BorderLayout.CENTER);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addKeyListener(this);

        setVisible(true);

        myPanel.setFocusable(true);
        myPanel.requestFocusInWindow();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(MazeApp::new);
    }

    // =========================
    // DRAW BUTTON
    // =========================
    @Override
    public void actionPerformed(ActionEvent e) {
        render();
    }

    private void render() {

        buffer = myPanel.getImage();
        g = buffer.getGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, myPanel.getWidth(), myPanel.getHeight());

        drawMaze(50, 75);
        drawPlayer();

        myPanel.repaint();
        myPanel.requestFocusInWindow();
    }

    public void drawMaze(int startX, int startY) {

        maze = new Maze();

        int rows = 6;
        int cols = 6;
        int size = MapSite.L;

        Room[][] rooms = new Room[rows][cols];

        Random random = new Random();

        int nr = 1;

        // TWORZENIE POKOI
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                int x = startX + c * size;
                int y = startY + r * size;

                Room room = new Room(x, y, nr++);

                rooms[r][c] = room;

                maze.add(room);
            }
        }

        // LOSOWE ŁĄCZENIE POKOI
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                Room room = rooms[r][c];

                // NORTH
                if (r == 0) {

                    room.setSite(Direction.NORTH,
                            new Wall(room.getX(),
                                    room.getY(),
                                    Direction.NORTH));

                } else {

                    if (random.nextBoolean()) {

                        room.setSite(Direction.NORTH,
                                new Door(room, rooms[r - 1][c]));

                    } else {

                        room.setSite(Direction.NORTH,
                                new Wall(room.getX(),
                                        room.getY(),
                                        Direction.NORTH));
                    }
                }

                // SOUTH
                if (r == rows - 1) {

                    room.setSite(Direction.SOUTH,
                            new Wall(room.getX(),
                                    room.getY() + size,
                                    Direction.SOUTH));

                } else {

                    if (random.nextBoolean()) {

                        room.setSite(Direction.SOUTH,
                                new Door(room, rooms[r + 1][c]));

                    } else {

                        room.setSite(Direction.SOUTH,
                                new Wall(room.getX(),
                                        room.getY() + size,
                                        Direction.SOUTH));
                    }
                }

                // WEST
                if (c == 0) {

                    room.setSite(Direction.WEST,
                            new Wall(room.getX(),
                                    room.getY(),
                                    Direction.WEST));

                } else {

                    if (random.nextBoolean()) {

                        room.setSite(Direction.WEST,
                                new Door(room, rooms[r][c - 1]));

                    } else {

                        room.setSite(Direction.WEST,
                                new Wall(room.getX(),
                                        room.getY(),
                                        Direction.WEST));
                    }
                }

                // EAST
                if (c == cols - 1) {

                    room.setSite(Direction.EAST,
                            new Wall(room.getX() + size,
                                    room.getY(),
                                    Direction.EAST));

                } else {

                    if (random.nextBoolean()) {

                        room.setSite(Direction.EAST,
                                new Door(room, rooms[r][c + 1]));

                    } else {

                        room.setSite(Direction.EAST,
                                new Wall(room.getX() + size,
                                        room.getY(),
                                        Direction.EAST));
                    }
                }
            }
        }

        maze.drawMaze(buffer);
    }

    public void drawPlayer() {

        player.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_W -> player.setY(player.getY() - SPEED);

            case KeyEvent.VK_S -> player.setY(player.getY() + SPEED);

            case KeyEvent.VK_A -> player.setX(player.getX() - SPEED);

            case KeyEvent.VK_D -> player.setX(player.getX() + SPEED);
        }

        render();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}