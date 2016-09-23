#version 400 core

in vec3 position;

out vec3 color;

uniform mat4 m_transform;
uniform mat4 m_view;
uniform mat4 m_projection;

void main(void) {
	gl_Position = m_transform * vec4(position, 1.0);
	color = vec3(0.0, 1.0, 1.0);
}