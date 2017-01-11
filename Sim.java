import java.lang.Math;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sim extends JFrame {
    private static double mass;
    private static double height;
    private static double gravity;
    private static double coeff;
    private static double velocity;
    private static double dist;
    private static double totalE;
    private static double kineticE;
    private static double potentialE;
    private static double thermalE;
    private static double angle;
    private static Container pane;
    private static JTextField m;
    private static JTextField g;
    private static JTextField c;

    public Sim() { //change!!
	mass = 50.0;
	gravity = 9.81;
	coeff = 0;
	height = 0;
	velocity = 0;
	dist = 0;
	totalE = 0;
	kineticE = 0;
	potentialE = 0;
	thermalE = 0;
	angle = 0;
	this.setTitle("Conservation of Energy AsimulaXuon");
	this.setTitle("Conservation of Energy: AsimulaXuon");
	this.setSize(400,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	JTextField m = new JTextField(10);
	m.setText("50.0");
	JTextField g = new JTextField(10);
	g.setText("9.81");
	JTextField c = new JTextField(10);
	c.setText("0.0");
	JLabel mlab = new JLabel("Mass of Skater");
	JLabel glab = new JLabel("Gravitational Acceleration");
	JLabel clab = new JLabel("Coefficient of Friction");
	pane.add(mlab);
	pane.add(m);
	pane.add(glab);
	pane.add(g);
	pane.add(clab);
	pane.add(c);
    }

    // MATH

    public static void setHeight(double h) {
	height = h;
    }

    public static void setMass(double m) {
	mass = m;
    }

    public static void setGravity(double g) {
	gravity = g;
    }
   
    public static void setCoeff(double c) {
	coeff = c;
    }

    public static double setPotEnergy() {
	double ans = mass * gravity * height;
	potentialE = ans;
	return ans;
    }

    public static double setTotEnergy() {
	double ans = mass * gravity * height;
	totalE = ans;
	return ans;
    }

    // need to set distance and angle
    public static double setThermEnergy() {
	double ans = coeff * mass * gravity * Math.cos(angle) * dist;
	thermalE = ans;
	return ans;
    }

    public static double setVelocity() {
	double ans = totalE - potentialE - thermalE;
	ans = Math.sqrt((2 * ans)/mass);
	velocity = ans;
	return ans;
    }

    public static double setKinEnergy() {
	double ans = 0.5 * mass * velocity * velocity;
	kineticE = ans;
	return ans;
    }

    // GUI TEXTBOXES

    public void paint(Graphics g) {
	QuadCurve2D.Double curve = new QuadCurve2D.Double(20,70,200,550,380,70);
	((Graphics2D)g).draw(curve);
    }
    
    // UPDATE and RUN

    public static void main(String[] args){
	Sim z = new Sim();
        z.setVisible(true);
	while(true){
	    updateGame();
	}
    }

    public static void updateGame(){
	setMass(Double.parseDouble(m.getText()));
	setGravity(Double.parseDouble(g.getText()));
	setCoeff(Double.parseDouble(c.getText()));
	// setHeight = # of pixels;
	// setAngle = something GUI;
	// setDist = based on time? GUI
	setTotEnergy();
	setPotEnergy();
	// setThermEnergy();
	setVelocity();
	setKinEnergy();
    }
    
}
