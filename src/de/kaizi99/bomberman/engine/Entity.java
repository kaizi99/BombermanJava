package de.kaizi99.bomberman.engine;

import de.kaizi99.bomberman.engine.maths.Maths;
import de.kaizi99.bomberman.engine.maths.Vector3f;

public class Entity{

	public RenderableModel model;
	
	public Vector3f position;
	public float rx, ry, rz;
	public float scale;
	
	float time;
	Camera c;
	
	public Entity(RenderableModel model, Vector3f position, float rx, float ry, float rz, float scale, Camera c) {
		super();
		this.model = model;
		this.position = position;
		this.rx = rx;
		this.ry = ry;
		this.rz = rz;
		this.scale = scale;
		this.c = c;
	}
	
	public void move(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}
	
	public void increaseRotation(float dx, float dy, float dz) {
		this.rx += dx;
		this.ry += dy;
		this.rz += dz;
	}

	public void Update() {
		time += 0.1;
		position.x = (float) Math.sin(time);
		
		//position.z = 4;
	}

	public void Render() {
		model.prepareRendering(Maths.createTransformationMatrix(position, rx, ry, rz, scale), c);
		model.Render();
		model.endRendering();
	}
}
