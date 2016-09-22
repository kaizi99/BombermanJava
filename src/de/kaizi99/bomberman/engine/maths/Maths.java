package de.kaizi99.bomberman.engine.maths;

public class Maths {

	public static Matrix4f createTransformationMatrix(Vector3f translation, float rx, float ry, float rz, float scale) {
		Matrix4f translationMatrix = Matrix4f.translate(translation.x, translation.y, translation.z);
		Matrix4f rotationMatrixX = Matrix4f.rotate((float)Math.toRadians(rx), 1.0f, 0.0f, 0.0f);
		Matrix4f rotationMatrixY = Matrix4f.rotate((float)Math.toRadians(ry), 0.0f, 1.0f, 0.0f);
		Matrix4f rotationMatrixZ = Matrix4f.rotate((float)Math.toRadians(rz), 0.0f, 0.0f, 1.0f);
		Matrix4f scaleMatrix = Matrix4f.scale(scale, scale, scale);
		
		Matrix4f returnMatrix = translationMatrix.multiply(rotationMatrixX);
		returnMatrix = returnMatrix.multiply(rotationMatrixY);
		returnMatrix = returnMatrix.multiply(rotationMatrixZ);
		returnMatrix = returnMatrix.multiply(scaleMatrix);
		
		return returnMatrix;
	}
}
