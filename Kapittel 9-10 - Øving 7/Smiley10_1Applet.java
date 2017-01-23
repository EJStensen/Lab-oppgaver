import java.awt.*;
import javax.swing.*;

public class Smiley10_1Applet extends JApplet{
    private static final long serialVersionUID = 1L;
    
    public void init(){
        add(new Smiley());
    }
}

class Smiley extends JPanel{
	private static final long serialVersionUID = 2L;
    
    public void paintComponent(Graphics smiley){
        
        Graphics2D smiley1 = (Graphics2D) smiley;
        
        super.paintComponent(smiley);
        smiley.setColor(Color.YELLOW);
        smiley.fillOval(100, 100, 250, 250);
        smiley.setColor(Color.WHITE);
        smiley.fillOval(120, 150, 50, 50);
        smiley.fillOval(280, 150, 50, 50);
        smiley.setColor(Color.BLACK);
        smiley.fillOval(120, 180, 20, 20);
        smiley.fillOval(310, 150, 20, 20);
        smiley.fillArc(200, 250, 100, 50, 0, 180);
    }
}