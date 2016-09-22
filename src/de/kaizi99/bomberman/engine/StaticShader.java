package de.kaizi99.bomberman.engine;

public class StaticShader extends ShaderProgram{

	private static final String FRAGMENT_FILE = "src/shaders/shader.frag";
	private static final String VERTEX_FILE = "src/shaders/shader.vert";
	
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}
	
	@Override
	public void bindAttributes() {
		super.bindAttributes(0, "position");	
	}
}
