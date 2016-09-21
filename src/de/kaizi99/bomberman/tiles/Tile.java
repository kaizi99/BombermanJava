package de.kaizi99.bomberman.tiles;

public class Tile {

	public enum TileType {
		BLOCKED,
		BRICK,
		FREE;
	}
	
	public TileType type;
	public int x, y;
	
	public Tile(TileType type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}
}
