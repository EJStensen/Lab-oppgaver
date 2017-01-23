import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JApplet;

class Vindu extends JFrame{
	public Vindu(String tittel){
		setTitle(tittel);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tegning tegningen = new Tegning();
		add(tegningen);
	}
}

class Tegning extends JPanel{
	public void paintComponent(Graphics smiley){
        smiley.setColor(Color.YELLOW);
        smiley.fillOval(100, 100, 250, 250);
        smiley.setColor(Color.WHITE);
        smiley.fillOval(120, 150, 50, 50); //øye venstre
        smiley.fillOval(280, 150, 50, 50); //øye høyre
        smiley.setColor(Color.BLACK);
        smiley.fillOval(120, 180, 20, 20); //pupil venstre
        smiley.fillOval(310, 150, 20, 20); //pupil høyre
        smiley.fillArc(120, 250, 200, 50, 0, 180); //munn
	}
}

class Smiley10_1{
	public static void main(String[] args){
		Vindu etVindu = new Vindu("Smiley");
		etVindu.setVisible(true);
	}
}