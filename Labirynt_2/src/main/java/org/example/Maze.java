package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Maze {

	private ArrayList<Room> rooms = new ArrayList<>();

	public Room getRoom(int nr) {

		for (Room r : rooms) {
			if (r.getNr() == nr) return r;
		}

		return null;
	}

	public void add(Room room) {
		rooms.add(room);
	}

	public void drawMaze(Image image) {

		for (Room r : rooms) {
			r.draw(image);
		}
	}
}