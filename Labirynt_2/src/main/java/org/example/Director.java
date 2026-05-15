package org.example;

public class Director {

	private Maze maze;

	public void constructMaze(int x, int y, IMazeBuilder mazeBuilder) {

		int nr = 1;

		int L = MapSite.L;

		mazeBuilder.buildMaze();

		mazeBuilder.buildRoom(x, y, nr++);

		mazeBuilder.buildRoom(x + L, y, nr++);

		mazeBuilder.buildDoor(1, 2);

		mazeBuilder.buildRoom(x + 2 * L, y, nr++);

		mazeBuilder.buildRoom(x + L, y + L, nr++);

		mazeBuilder.buildDoor(3, 2);
		mazeBuilder.buildDoor(4, 2);

		if (mazeBuilder instanceof Builder) {
			maze = ((Builder) mazeBuilder).getMaze();
		}
	}

	public Maze getMaze() {
		return maze;
	}
}