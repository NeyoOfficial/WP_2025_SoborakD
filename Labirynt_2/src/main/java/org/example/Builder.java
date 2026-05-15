package org.example;

public class Builder implements IMazeBuilder {

	private Maze maze;

	@Override
	public void buildMaze() {
		maze = new Maze();
	}

	@Override
	public void buildRoom(int x, int y, int nr) {

		Room room = new Room(x, y, nr);

		room.setSite(Direction.NORTH, new Wall(x, y, Direction.NORTH));
		room.setSite(Direction.EAST, new Wall(x, y, Direction.EAST));
		room.setSite(Direction.SOUTH, new Wall(x, y, Direction.SOUTH));
		room.setSite(Direction.WEST, new Wall(x, y, Direction.WEST));

		maze.add(room);
	}

	@Override
	public void buildDoor(int room_1, int room_2) {

		Room r1 = maze.getRoom(room_1);
		Room r2 = maze.getRoom(room_2);

		if (r1 == null || r2 == null) return;

		Door door = new Door(r1, r2);

		r1.setSite(Direction.EAST, door);
		r2.setSite(Direction.WEST, door);
	}

	@Override
	public Maze getMaze() {
		return maze;
	}
}