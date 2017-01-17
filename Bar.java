import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Bar extends JFrame{
    private double totheight;
    private double potheight;
    private double kinheight;
    private double thermheight;
	
    public Bar (double tot, double pot, double kin, double therm){
	totheight = 300;
	potheight = (pot/tot)*300;
	kinheight = (kin/tot)*300;
	thermheight = (therm/tot)*300;
    }

    public void paint(Graphics g){
	Graphics2D gbackground = (Graphics2D) g;
	gbackground.setColor(Color.white);
	gbackground.drawRect(610,210,300,400);
	gbackground.fillRect(610,210,300,400); 

	Graphics2D totbar = (Graphics2D) g;
	totbar.setColor(new Color(000,075,025));
	totbar.drawRect(850,(int)(520-totheight),40,(int)totheight);
	totbar.fillRect(850,(int)(520-totheight),40,(int)totheight);
	
	Graphics2D potbar = (Graphics2D) g;
	potbar.setColor(new Color(000,075,025));
	potbar.drawRect(800,(int)(520-potheight),40,(int)potheight);
	potbar.fillRect(800,(int)(520-potheight),40,(int)potheight);
	
	Graphics2D kinbar = (Graphics2D) g;
	kinbar.setColor(new Color(000,075,025));
	kinbar.drawRect(750,(int)(520-kinheight),40,(int)kinheight);
	kinbar.fillRect(750,(int)(520-kinheight),40,(int)kinheight);
	
	Graphics2D thermbar = (Graphics2D) g;
	thermbar.setColor(new Color(000,075,025));
	thermbar.drawRect(700,(int)(520-thermheight),40,(int)thermheight);
	thermbar.fillRect(700,(int)(520-thermheight),40,(int)thermheight);
	
	Graphics2D bottomline = (Graphics2D) g;
	bottomline.setColor(new Color(000,000,000));
	bottomline.drawLine(610,520,910,520);
    }
}
