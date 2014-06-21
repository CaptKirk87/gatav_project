/*Pipiline für OpenGL um die Daten aus CubePosition zu lesen*/

attribute vec4 a_Position;


/*Haupteingangspunkt für die Shader*/
void main()
{
	gl_Position = a_Position;
}