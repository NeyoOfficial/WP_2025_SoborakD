package org.example;

import java.awt.*;

public class Room extends MapSite {

	private MapSite[] sites = new MapSite[4];
	private int nr;

	public Room(int x, int y, int nr) {
		super(x, y);
		this.nr = nr;
	}

	public int getNr() {
		return nr;
	}

	public void setSite(Direction d, MapSite site) {

		switch (d) {

			case NORTH:
			case WEST:
				site.setX(getX());
				site.setY(getY());
				break;

			case SOUTH:
				site.setX(getX());
				site.setY(getY() + L);
				break;

			case EAST:
				site.setX(getX() + L);
				site.setY(getY());
				break;
		}

		sites[d.ordinal()] = site;
	}

	public MapSite getSite(Direction d) {
		return sites[d.ordinal()];
	}

	@Override
	public void draw(Image image) {

		for (MapSite site : sites) {
			if (site != null) {
				site.draw(image);
			}
		}

		Graphics g = image.getGraphics();
		g.setColor(Color.BLACK);

		g.drawString(
				String.valueOf(nr),
				getX() + L / 2,
				getY() + L / 2
		);
	}
}