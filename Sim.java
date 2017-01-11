import java.lang.Math;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sim extends JFrame implements ActionListener{
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
        setSize(1000,600);
	setVisible(true);
	//setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	Container pane = getContentPane();
	SpringLayout layout = new SpringLayout();
	pane.setLayout(layout);
	JButton move  = new JButton("Go");
	move.addActionListener(this);
	move.setActionCommand("Go");
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
<<<<<<< HEAD
	pane.add(move);
=======
>>>>>>> 741d28ee6c5baa9c0f4ee30fb8113573ce606b53
	pane.add(mlab);
	pane.add(m);
	pane.add(glab);
	pane.add(g);
	pane.add(clab);
	pane.add(c);
	pane.add(tabbedPane);
<<<<<<< HEAD
	layout.putConstraint(SpringLayout.WEST, move, 140, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, move, 300, SpringLayout.WEST, pane);
=======
>>>>>>> 741d28ee6c5baa9c0f4ee30fb8113573ce606b53
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
<<<<<<< HEAD
	layout.putConstraint(SpringLayout.WEST, tabbedPane, 610, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, tabbedPane, 15, SpringLayout.SOUTH, c);
	layout.putConstraint(SpringLayout.EAST, tabbedPane, 20, SpringLayout.EAST, pane);
	layout.putConstraint(SpringLayout.SOUTH, tabbedPane, 20, SpringLayout.SOUTH, pane);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("Byte")){
	    
	}
	if(event.equals("NotByte")){
	    
	}
=======
	layout.putConstraint(SpringLayout.WEST, tabbedPane, 605, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, tabbedPane, 15, SpringLayout.SOUTH, c);
	layout.putConstraint(SpringLayout.EAST, tabbedPane, 20, SpringLayout.EAST, pane);
	layout.putConstraint(SpringLayout.SOUTH, tabbedPane, 20, SpringLayout.SOUTH, pane);
>>>>>>> 741d28ee6c5baa9c0f4ee30fb8113573ce606b53
    }

    // MATH

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

    /** ----------------NEED TO WRITE THIS---------------
    public static double setHeight() {
	double ans = 520 - position.y;
	height = ans;
	return ans;
    }

    public static double setAngle(Pvector old) {
	double ans = atan((old.y-position.y)/(old.x-position.x));
	angle = ans;
	return ans;
    }

    public static double setDist(Pvector old) {
	double ans = position.dist(old);
	dist += ans;
	return ans;
    }
    **/

    // GUI

    public void paint(Graphics g) {
	Graphics2D gsky = (Graphics2D) g;
	gsky.setColor(new Color(200,200,225));
	gsky.drawRect(0,0,600,600);
	gsky.fillRect(0,0,600,600);
	Graphics2D gground = (Graphics2D) g;
	gground.setColor(new Color(000,075,025));
	gground.drawRect(0,520,600,80);
	gground.fillRect(0,520,600,80);
	QuadCurve2D.Double curve = new QuadCurve2D.Double(40,190,300,850,560,190);
    	((Graphics2D)g).draw(curve);
	
    }
    
    // UPDATE and RUN

    public static void main(String[] args){
	Sim z = new Sim();
        z.setVisible(true);
	while(true){
	    //Pvector temp = (position.x,position.y);
	    //run();
	    //setAngle(temp);
	    //setDist(temp);
	    updateGame();
	}
    }

    /** ----------------NEED TO WRITE THIS---------------
    public static void run(){
    }
    **/

    public static void updateGame(){
	setMass(Double.parseDouble(m.getText()));
	setGravity(Double.parseDouble(g.getText()));
	setCoeff(Double.parseDouble(c.getText()));
	// setHeight();
	// setAngle();
	// setDist();
	setTotEnergy();
	setPotEnergy();
	// setThermEnergy();
	setVelocity();
	setKinEnergy();
    }
    
}
