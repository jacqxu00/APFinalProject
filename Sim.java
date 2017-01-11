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
	setTitle("Conservation of Energy: AsimulaXuon");
        setSize(1000,800);
	setVisible(true);
	//setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	Container pane = getContentPane();
	SpringLayout layout = new SpringLayout();
	pane.setLayout(layout);
	JTextField m = new JTextField(10);
	m.setText("50.0");
	JTextField g = new JTextField(10);
	g.setText("9.81");
	JTextField c = new JTextField(10);
	c.setText("0.0");
	JLabel mlab = new JLabel("Mass of Skater");
	JLabel glab = new JLabel("Gravitational Acceleration");
	JLabel clab = new JLabel("Coefficient of Friction");
	JTabbedPane tabbedPane = new JTabbedPane();
	JPanel barsPage=new JPanel();
	JPanel valsPage=new JPanel();
	tabbedPane.addTab("Bar Graph",barsPage);
 	tabbedPane.addTab("Values", valsPage);
	pane.add(mlab);
	pane.add(m);
	pane.add(glab);
	pane.add(g);
	pane.add(clab);
	pane.add(c);
	pane.add(tabbedPane);
	layout.putConstraint(SpringLayout.WEST, mlab, 10, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, mlab, 10, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, m, 10, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, m, 10, SpringLayout.SOUTH, mlab);
	layout.putConstraint(SpringLayout.WEST, glab, 10, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, glab, 10, SpringLayout.SOUTH, m);
	layout.putConstraint(SpringLayout.WEST, g, 10, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, g, 10, SpringLayout.SOUTH, glab);
	layout.putConstraint(SpringLayout.WEST, clab, 10, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, clab, 10, SpringLayout.SOUTH, g);
	layout.putConstraint(SpringLayout.WEST, c, 10, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, c, 10, SpringLayout.SOUTH, clab);
	layout.putConstraint(SpringLayout.WEST, mlab, 610, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, mlab, 10, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, m, 610, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, m, 5, SpringLayout.SOUTH, mlab);
	layout.putConstraint(SpringLayout.WEST, glab, 610, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, glab, 15, SpringLayout.SOUTH, m);
	layout.putConstraint(SpringLayout.WEST, g, 610, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, g, 5, SpringLayout.SOUTH, glab);
	layout.putConstraint(SpringLayout.WEST, clab, 610, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, clab, 15, SpringLayout.SOUTH, g);
	layout.putConstraint(SpringLayout.WEST, c, 610, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, c, 5, SpringLayout.SOUTH, clab);
	layout.putConstraint(SpringLayout.WEST, tabbedPane, 610, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, tabbedPane, 15, SpringLayout.SOUTH, c);
	layout.putConstraint(SpringLayout.EAST, tabbedPane, 20, SpringLayout.EAST, pane);
	layout.putConstraint(SpringLayout.SOUTH, tabbedPane, 20, SpringLayout.SOUTH, pane);
	JSplitPane splitPane = new JSplitPane();
	splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	pane.add(splitPane);


	

	//Provide minimum sizes for the two components in the split pane
	//	Dimension minimumSize = new Dimension(100, 50);
	//	listScrollPane.setMinimumSize(minimumSize);
	//	pictureScrollPane.setMinimumSize(minimumSize);
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
