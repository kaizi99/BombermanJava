package de.kaizi99.bomberman.engine.maths;

public class Vector3 {

	public float x;
	public float y;
	public float z;
	
	public Vector3() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}
	
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3(float x) {
		this.x = x;
		this.y = x;
		this.z = x;
	}
	
	public Vector3(Vector3 old) {
		x = old.x;
		y = old.y;
		z = old.z;
	}
	
}
