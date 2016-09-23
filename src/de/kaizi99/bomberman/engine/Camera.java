package de.kaizi99.bomberman.engine;

import de.kaizi99.bomberman.engine.maths.Matrix4f;
import de.kaizi99.bomberman.engine.maths.Vector3f;

public class Camera {

	public Matrix4f view;
	public Matrix4f projection;
	
	public Vector3f position;
	public Vector3f lookAt;
	
	float aspect;
	int fov;
	
	public Camera(float aspectRatio, int fov) {
		position = new Vector3f(0, 0, 5);
		lookAt = new Vector3f(0, 0, 0);
		aspect = aspectRatio;
		this.fov = fov;
	}
	
	public void Update()
	{
		view = Matrix4f.view(position, lookAt, new Vector3f(0.0f, 1.0f, 0.0f));
		projection = Matrix4f.perspective((float)Math.toRadians(fov), aspect, 0.1f, 100f);
	}
}
