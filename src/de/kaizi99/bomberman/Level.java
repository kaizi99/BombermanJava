package de.kaizi99.bomberman;

import java.util.List;

import de.kaizi99.bomberman.engine.Renderable;
import de.kaizi99.bomberman.engine.RenderableModel;
import de.kaizi99.bomberman.engine.maths.Vector3;
import de.kaizi99.bomberman.tiles.Tile;
import de.kaizi99.bomberman.tiles.Tile.TileType;

public class Level extends Renderable{
	
	Tile[][] level;
	int width, height;
	
	List<RenderableModel> renderableModels;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		level = new Tile[width][height];
		generateLevel();
	}
	
	private void generateLevel() {
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				level[x][y] = new Tile(TileType.BLOCKED, x, y);
		
		for (int x = 1; x < width - 1; x += 2)
			for (int y = 1; y < height - 1; y++)
				level[x][y] = new Tile(TileType.FREE, x, y);
		
		for (int y = 1; y < height-1; y += 2)
			for (int x = 1; x < width - 1; x++)
				level[x][y] = new Tile(TileType.FREE, x, y);
		
		debugPrint();
	}
	
	private void debugPrint() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++)
				switch (level[x][y].type)
				{
				case BLOCKED:
					System.out.print("X");
					break;
				case BRICK:
					System.out.print("B");
					break;
				case FREE:
					System.out.print("O");
					break;
				}
			System.out.println();
		}
	}
	
	public void Update() {
		
	}
	
	public void Render(Vector3 pos, Vector3 rot, Vector3 scale) {
		
	}

}
