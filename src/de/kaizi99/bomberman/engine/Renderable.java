package de.kaizi99.bomberman.engine;

import de.kaizi99.bomberman.engine.maths.Vector3;

public abstract class Renderable {

	abstract public void Update();
	abstract public void Render(Vector3 pos, Vector3 rot, Vector3 scale);
}
