package de.kaizi99.bomberman.engine;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import de.kaizi99.bomberman.engine.maths.Vector3;

public class RenderableModel extends Renderable{

	ShaderProgram shader;
	
	int vaoID;
	int vertexCount;
	
	public RenderableModel(Vector3[] positions, int[] indices) {
		shader = new StaticShader();
		vertexCount = indices.length;
		createVAO();
		bindIndicesBuffer(indices);
		storeDataInAttributeList(0, positions);
		unbindVAO();
	}
	
	@Override
	public void Update() {
		
	}

	@Override
	public void Render(Vector3 pos, Vector3 rot, Vector3 scale) {
		GL30.glBindVertexArray(vaoID);
		GL20.glEnableVertexAttribArray(0);
		shader.start();
		GL11.glDrawElements(GL11.GL_TRIANGLES, vertexCount, GL11.GL_UNSIGNED_INT, 0);
		shader.stop();
		GL20.glDisableVertexAttribArray(0);
		unbindVAO();
	}
	
	private void createVAO() {
		vaoID = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vaoID);
		ManualCleanup.vaos.add(vaoID);
	}
	
	private void storeDataInAttributeList(int attributeNumber, Vector3[] data) {
		int vboID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		FloatBuffer buffer = storeDataInFloatBuffer(data);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		ManualCleanup.vbos.add(vboID);
	}
	
	private void unbindVAO() {
		GL30.glBindVertexArray(0);
	}
	
	private void bindIndicesBuffer(int[] indices) {
		int vboID = GL15.glGenBuffers();
		ManualCleanup.vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
		IntBuffer buffer = storeDataInIntBuffer(indices);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
	}
	
	private FloatBuffer storeDataInFloatBuffer(Vector3[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length * 3);
		for (Vector3 vec : data) {
			buffer.put(vec.x);
			buffer.put(vec.y);
			buffer.put(vec.z);
		}
		buffer.flip();
		return buffer;
	}
	
	private IntBuffer storeDataInIntBuffer(int[] data) {
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		
		return buffer;
	}
}
