/*Pipiline f�r OpenGL um die Daten aus CubePosition zu lesen*/

attribute vec4 a_Position;


/*Haupteingangspunkt f�r die Shader*/
void main()
{
	gl_Position = a_Position;
}