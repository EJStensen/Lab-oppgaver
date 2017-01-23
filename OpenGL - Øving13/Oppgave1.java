package Oving13;

import javax.swing.*;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;

public class Oppgave1 extends GLCanvas implements GLEventListener {

   private static final long serialVersionUID = 1L;
   private GLU glu = new GLU();

   public Oppgave1() {
      this.addGLEventListener(this);
   }
   
   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
   }
   
   public void dispose(GLAutoDrawable d){
   }
   
   public void init(GLAutoDrawable glDrawable) {
	   
	   GL2 gl = glDrawable.getGL().getGL2();
	   gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	   gl.glMatrixMode(GL2.GL_PROJECTION);
	   gl.glLoadIdentity();
	   glu.gluPerspective(50.0, 1.25, 2.0, 20.0);
	   gl.glMatrixMode(GL2.GL_MODELVIEW);
   }

   public void drawGLScene(GLAutoDrawable glDrawable) {
	   
      GL2 gl = glDrawable.getGL().getGL2();
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
      gl.glLoadIdentity();
      gl.glColor3f(1.0f, 1.0f, 1.0f);
      
      double[][] tabell ={{0.0f, 2.0f, 0.0f},{1.5f, 1.5f, 0.0f},{2.0f, 0.0f, 0.0f},{1.5f, -1.5f, 0.0f}, 
				  {0.0f, -2.0f, 0.0f},{-1.5f, -1.5f, 0.0f},{-2.0f, 0.0f, 0.0f},{-1.5f, 1.5f, 0.0f}};

      //GL_POINTS
      gl.glTranslatef(-7.0f, 5.0f, -20.0f);
      gl.glBegin(GL2.GL_POINTS);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
      
      //GL_LINES
      gl.glTranslatef(5.0f, 0.0f, 0.0f);
      gl.glBegin(GL2.GL_LINES);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
      
      //GL_LINE_STRIP
      gl.glTranslatef(5.0f, 0.0f, 0.0f);
      gl.glBegin(GL2.GL_LINE_STRIP);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
      
      //GL_LINE_LOOP
      gl.glTranslatef(5.0f, 0.0f, 0.0f);
      gl.glBegin(GL2.GL_LINE_LOOP);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
      
      //GL_TRIANGLES
      gl.glTranslatef(-15.0f, -5.0f, 0.0f);
      gl.glBegin(GL2.GL_TRIANGLES);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
      
      //GL_TRIANGLE_STRIP
      gl.glTranslatef(5.0f, 0.0f, 0.0f);
      gl.glBegin(GL2.GL_TRIANGLE_STRIP);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
      
      //GL_TRIANGLE_FAN
      gl.glTranslatef(5.0f, 0.0f, 0.0f);
      gl.glBegin(GL2.GL_TRIANGLE_FAN);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
      
      //GL_QUADS
      gl.glTranslatef(5.0f, 0.0f, 0.0f);
      gl.glBegin(GL2.GL_QUADS);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
      
      //GL_QUAD_STRIP
      gl.glTranslatef(-10.0f, -5.0f, 0.0f);
      gl.glBegin(GL2.GL_TRIANGLE_STRIP);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
      
      
      //GL_POLYGON
      gl.glTranslatef(5.0f, 0.0f, 0.0f);
      gl.glBegin(GL2.GL_POLYGON);
      for (int i = 0; i < tabell.length; i++){
    	  gl.glVertex3dv(tabell[i],0);
      }
      gl.glEnd();
   }

   public void display(GLAutoDrawable glDrawable) {
	   GL2 gl = glDrawable.getGL().getGL2();
	   drawGLScene(glDrawable);
	   gl.glFlush();
   }
   
   public static void main(String[] args){
	   Window window = new Window("OpenGL primitivene");
	   window.setVisible(true);
   }
}

class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Window(String title){
		
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Oppgave1 draw = new Oppgave1();
		draw.setSize(1000, 1000);
		add(draw);
		pack();
	}	
}