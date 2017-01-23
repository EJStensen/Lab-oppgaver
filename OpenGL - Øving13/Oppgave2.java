package Oving13;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class Oppgave2 extends GLCanvas implements GLEventListener{
	

	private static final long serialVersionUID = 1L;
	private GLU glu = new GLU();
	private GLUT glut = new GLUT();

	public Oppgave2(){
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
		
		//Oppgave a
		gl.glBegin(GL2.GL_LINE_LOOP);
		gl.glVertex3d(-1.0f, -1.0f, -1.0f); // Bak venstre nede
		gl.glVertex3d(-1.0f, -1.0f, 1.0f);  // Går til høyre bak
		gl.glVertex3d(1.0f, -1.0f, 1.0f);   // Går til høyre fram
		gl.glVertex3d(1.0f, -1.0f, -1.0f);  // Går til venstre fram
		gl.glVertex3d(-1.0f, -1.0f, -1.0f); // Tilbake til start
		
		gl.glVertex3d(-1.0f, 1.0f, -1.0f); // Går oppover fra start til andre plan
		gl.glVertex3d(1.0f, 1.0f, -1.0f);  // Går til høyre bak (andre plan)
		gl.glVertex3d(1.0f, -1.0f, -1.0f); // Går nedover til første plan
		gl.glVertex3d(1.0f, 1.0f, -1.0f);  // Går oppover til andre plan
		gl.glVertex3d(1.0f, 1.0f, 1.0f);   // Går til høyre fram (andre plan)
		gl.glVertex3d(1.0f, -1.0f, 1.0f);  // Går nedover til første plan
		gl.glVertex3d(1.0f, 1.0f, 1.0f);   // Går oppover til andre plan
		gl.glVertex3d(-1.0f, 1.0f, 1.0f);  // Går til venstre fram (andre plan)
		gl.glVertex3d(-1.0f, -1.0f, 1.0f); // Går nedover til første plan
		gl.glVertex3d(-1.0f, 1.0f, 1.0f);  // Går oppover til andre plan
		gl.glVertex3d(-1.0f, 1.0f, -1.0f); // Tilbake til start (andre plan)
		gl.glEnd();
		
		//Oppgave b
		gl.glTranslatef(5.0f, 0.0f, 0.0f);
		glut.glutWireCube(2.0f);
		
	}
	
	public void display(GLAutoDrawable glDrawable){
		GL2 gl = (glDrawable).getGL().getGL2();
		drawGLScene(glDrawable);
		gl.glFlush();
	}
	
	public static void main(String[] args){
		Window2 Window2 = new Window2("Oppgave 2a");
		Window2.setVisible(true);
	}
}

class Window2 extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Window2(String title){
		
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Oppgave2 draw = new Oppgave2();
		draw.setSize(1280, 720);
		add(draw);
		pack();
	}	
}