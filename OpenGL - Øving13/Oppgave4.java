package Oving13;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class Oppgave4 extends GLCanvas implements GLEventListener{
	

	private static final long serialVersionUID = 1L;
	private GLU glu = new GLU();
	private GLUT glut = new GLUT();

	public Oppgave4(){
		this.addGLEventListener(this);
	}
	
	public void init(GLAutoDrawable glDrawable){
		GL2 gl = glDrawable.getGL().getGL2();
			gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
			gl.glMatrixMode(GL2.GL_PROJECTION);
			gl.glLoadIdentity();
			glu.gluPerspective(120.0, 1.25, 2.0, 25);
			gl.glMatrixMode(GL2.GL_MODELVIEW);
	}
	
	public void reshape(GLAutoDrawable glDrawable, int x, int y, int width, int height){
	}
	
	public void dispose(GLAutoDrawable d){
	}
	
	public void drawGLScene(GLAutoDrawable glDrawable){
		GL2 gl = glDrawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

		gl.glLoadIdentity();
		gl.glTranslatef(-1.5f, 0.0f, -5.0f);
		gl.glColor3f(1.0f, 1.0f, 1.0f);
		
		//Første kuben
		glut.glutWireCube(2.0f);
		glu.gluLookAt(1.0, 1.0, 1.0, 0.0, -1.0, 0.0f, -3.0f, 1.0, 0.0);
		gl.glEnd();
		
		// Andre Kuben
		gl.glLoadIdentity();
		gl.glTranslatef(5.5f, 0.0f, -5.0f);
 		glut.glutWireCube(2.0f);
 		glu.gluLookAt(1.0, 0.0, 1.0, 0.0, -1.0, 0.0f, -3.0f, 1.0, 0.0);
 		gl.glEnd();
 		
 		//Tredje Kuben
 		gl.glLoadIdentity();
 		gl.glTranslatef(-6.0f, 0.0f, -5.0f);
 		glut.glutWireCube(2.0f);
 		glu.gluLookAt(0.0, 1.0, 1.0, 0.0, 1.0, 0.0f, -3.0f, 1.0, 0.0);
 		gl.glEnd();
	}
	
	public void display(GLAutoDrawable glDrawable){
		GL2 gl = (glDrawable).getGL().getGL2();
		drawGLScene(glDrawable);
		gl.glFlush();
	}
	
	public static void main(String[] args){
		Window4 Window4 = new Window4("Oppgave 4");
		Window4.setVisible(true);
	}
}

class Window4 extends JFrame{

	private static final long serialVersionUID = 1L;

	public Window4(String title){
			setTitle(title); 
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			Oppgave4 draw = new Oppgave4(); 
			draw.setSize(1280, 720);
			add(draw); 
			pack();
	}
}