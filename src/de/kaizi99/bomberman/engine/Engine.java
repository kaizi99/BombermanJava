package de.kaizi99.bomberman.engine;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import de.kaizi99.bomberman.Level;
import de.kaizi99.bomberman.engine.maths.Vector3f;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Engine {

	private int width;
	private int height;
	
	private long window;
	Level currentLevel;
	
	Entity testObject;
	Vector3f[] vertecies = {
			new Vector3f(-0.5f, 0.5f, 0.0f),
			new Vector3f(-0.5f, -0.5f, 0.0f),
			new Vector3f(0.5f, -0.5f, 0.0f),
			new Vector3f(0.5f, 0.5f, 0.0f),
	};
	
	int[] indices = {
			0, 1, 3,
			3, 1, 2
	};
	
	Camera camera;
	
	public Engine(int width, int height) {
		this.width = width;
		this.height = height;
		initOpenGL();
		initScene();
		loop();
		cleanup();
	}
	
	private void initOpenGL() {
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if ( !glfwInit() )
			throw new IllegalStateException("Unable to initialize GLFW");

		// Configure our window
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); // the window wont be resizable

		// Create the window
		window = glfwCreateWindow(width, height, "Bomberman Clone", NULL, NULL);
		if ( window == NULL )
			throw new RuntimeException("Failed to create the GLFW window");

		// Setup a key callback. It will be called every time a key is pressed, repeated or released.
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true); // We will detect this in our rendering loop
		});

		// Get the resolution of the primary monitor
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		// Center our window
		glfwSetWindowPos(
			window,
			(vidmode.width() - width) / 2,
			(vidmode.height() - height) / 2
		);

		// Make the OpenGL context current
		glfwMakeContextCurrent(window);
		// Enable v-sync
		glfwSwapInterval(1);
		
		// Make the window visible
		glfwShowWindow(window);
		
		GL.createCapabilities();
	}
	
	private void initScene() {
		camera = new Camera(width / height, 90);
		testObject = new Entity(new RenderableModel(vertecies, indices), new Vector3f(), 0.0f, 0.0f, 0.0f, 1.0f, camera);
		currentLevel = new Level(11, 11);
	}
	
	private void loop() {
		glClearColor(0.0f, 0.0f, 1.0f, 1.0f);
		while (!glfwWindowShouldClose(window)) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			camera.Update();
			
			testObject.Update();
			testObject.Render();
			
			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}
	
	private void cleanup() {
		ManualCleanup.Cleanup();
	}
}
