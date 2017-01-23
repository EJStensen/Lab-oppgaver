package Oving13;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class eksde extends GLCanvas implements GLEventListener{
	

	private static final long serialVersionUID = 1L;
	private GLU glu = new GLU();
	private GLUT glut = new GLUT();

	public eksde(){
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

		//Første kube
		glut.glutWireCube(2.0f);
		
		//Andre
		gl.glTranslatef(5.0f, 0.0f, 0.0f);
		gl.glRotatef(40.0f, 0.0f, 0.5f, 5.0f);
		glut.glutWireCube(2f);
		
		//Tredje
		gl.glRotatef(40.0f, 0.0f, 0.5f, 5.0f);
		gl.glTranslatef(-5.0f, 0.0f, 0.0f);
		glut.glutWireCube(2f);
		
		//Fjerde
		gl.glLoadIdentity();
		gl.glTranslated(-5.0f, -4.6f, -5.0f);
		gl.glScalef(3.0f, 2.0f, 1.0f);
		glut.glutWireCube(2f);
	}
	
	public void display(GLAutoDrawable glDrawable){
		GL2 gl = (glDrawable).getGL().getGL2();
		drawGLScene(glDrawable);
		gl.glFlush();
	}
	
	public static void main(String[] args){
		Window5 xd = new Window5("Oppgave 3");
		xd.setVisible(true);
	}
}

class Window5 extends JFrame{

	private static final long serialVersionUID = 1L;

	public Window5(String title){
			setTitle(title); 
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			eksde draw = new eksde(); 
			draw.setSize(1280, 720);
			add(draw); 
			pack();
	}
}