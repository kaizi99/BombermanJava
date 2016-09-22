package de.kaizi99.bomberman.engine;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

public class ManualCleanup {

	public static List<Integer> vaos = new ArrayList<Integer>();
	public static List<Integer> vbos = new ArrayList<Integer>();
	
	public static void Cleanup() {
		for (int vao : vaos)
			GL30.glDeleteVertexArrays(vao);
		for (int vbo : vbos) 
			GL15.glDeleteBuffers(vbo);
	}
}
