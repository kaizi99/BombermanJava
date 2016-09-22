package de.kaizi99.bomberman.engine;

import de.kaizi99.bomberman.engine.maths.Matrix4f;

public class StaticShader extends ShaderProgram{

	private static final String FRAGMENT_FILE = "src/shaders/shader.frag";
	private static final String VERTEX_FILE = "src/shaders/shader.vert";
	
	private int loc_m_transform;
	
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}
	
	@Override
	public void bindAttributes() {
		super.bindAttributes(0, "position");	
	}

	@Override
	protected void getAllUniformLocations() {
		loc_m_transform = super.getUniformLocation("m_transform");
	}
	
	public void loadModelMatrix(Matrix4f matrix) {
		super.loadMatrix(loc_m_transform, matrix);
	}
}
