import java.lang.Math;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Sim extends JFrame implements ActionListener{
    private Container pane;
    private JTextField m;
    private JTextField g;
    private JTextField c;
    private JLabel mlab;
    private JLabel glab;
    private JLabel clab;
    private Skater circle = new Skater();
    SpringLayout layout = new SpringLayout();
    private String event;
    private Timer timer;
    private double newxcor;
    private double newycor;
    private ButtonGroup group = new ButtonGroup();
    private String groupcmd = "Track 1";
    private Bar bar = new Bar(0,0,0,0);
    private JRadioButton option1 = new JRadioButton("Track 1");
    private JRadioButton option2 = new JRadioButton("Track 2");
    private double mass;
    private double grav;
    private double coeff;
	
    public Sim() {
	setup();
    }
	
    public void setup(){
	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    if (m.getText().length()>0) {
			double mass = Double.parseDouble(m.getText());
			circle.setMass(mass);
		    }
		    else {
			circle.setMass(50.0);
		    }
		    if (g.getText().length()>0) {
			double grav = Double.parseDouble(g.getText());
			circle.setGravity(grav);
		    }
		    else {
			circle.setGravity(9.81);
		    }
		    if (c.getText().length()>0) {
			double coeff = Double.parseDouble(c.getText());
			circle.setCoeff(coeff);
		    }
		    else {
			circle.setCoeff(0);
		    }
		    Vector<Double> temp = new Vector<Double>(2);
		    double mass = Double.parseDouble(m.getText());
		    circle.setMass(mass);
		    double grav = Double.parseDouble(g.getText());
		    circle.setGravity(grav);
		    double coeff = Double.parseDouble(c.getText());
		    circle.setCoeff(coeff);
		    circle.setTotEnergy();
		    temp.clear();
		    temp.add(circle.getPosX());
		    temp.add(circle.getPosY());
		    groupcmd = group.getSelection().getActionCommand();
		    repaint();
		    bar = new Bar(circle.getTotEnergy(), circle.getPotEnergy(), circle.getKinEnergy(), circle.getThermEnergy());
		    bar.repaint();
		    if (groupcmd.equals("Track 1")){
			newxcor = circle.getPosX()+circle.getVelX()/100;
			if (circle.getPosX() > 580) {
			    stop();
			}
			else if (circle.getPosX() > 300) {
			    newycor = 500;
			}
			else {
			    newycor = Math.sqrt(108900.0-(1089.0/625)*Math.pow(newxcor-290,2))+170;
			}
		    }
		    if (groupcmd.equals("Track 2")){
			if (circle.getPosX() > 300 && circle.getVelX() < 1.5 && circle.getAngle() < Math.PI/2 && circle.getAngle() > 0) {
			    circle.setVelX(circle.getVelX()*-1);
			}
			if (circle.getPosX() < 300 && circle.getVelX() > -1.5 && circle.getAngle() < Math.PI && circle.getAngle() > Math.PI/2) {
			    circle.setVelX(circle.getVelX()*-1);
			}
			newxcor = circle.getPosX()+circle.getVelX()/100;
			newycor = -1 * (320.0/62500)*Math.pow(newxcor - 290,2)+500;
		    }
		    circle.moveTo(newxcor,newycor);
		    circle.setPosition(newxcor,newycor); 
		    circle.setHeight();
		    circle.setPotEnergy();
		    circle.setDist(temp);
		    circle.setAngle(temp);
		    circle.setThermEnergy();
		    circle.setKinEnergy();
		    circle.setVelocity();
		    System.out.println("Angle: " + circle.getAngle()*180/Math.PI);
		    System.out.println("Position: " + circle.getPosX() + ", " + circle.getPosY());
		    System.out.println("Velocity: " + circle.getVelX() + ", " + circle.getVelY());
		    System.out.println("Height: " + circle.geHeight());
		    System.out.println("Distance: "+ circle.getDist());
		    System.out.println("Potential Energy: " + circle.getPotEnergy());
		    System.out.println("Kinetic Energy: " + circle.getKinEnergy());
		    System.out.println("Thermal Energy: " + circle.getThermEnergy());
		    System.out.println("Total Energy: " + circle.getTotEnergy());
		}
	    };
	timer = new Timer(5, taskPerformer);
	
	setTitle("Conservation of Energy: AsimulaXuon");
	setSize(920,600);
	setVisible(true);
	setLocation(0,0);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane(); 
	pane.setLayout(layout);
	option1.addActionListener(this);
	option1.setActionCommand("Track 1");
	option1.setSelected(true);
	option2.addActionListener(this);
	option2.setActionCommand("Track 2");
	group.add(option1);
	group.add(option2);
	groupcmd = group.getSelection().getActionCommand();
	JButton move  = new JButton("Go");
	move.addActionListener(this);
	move.setActionCommand("Go");
	JButton stop = new JButton("Stop");
	stop.addActionListener(this);
	stop.setActionCommand("Stop");
	JButton reset = new JButton("Reset");
	reset.addActionListener(this);
	reset.setActionCommand("Reset");
	m = new JTextField(10);
	m.setText("50.0");
	g = new JTextField(10);
	g.setText("9.81");
	c = new JTextField(10);
	c.setText("0.0");
	mlab = new JLabel("Mass of Skater (kg)");
	glab = new JLabel("Gravitational Acceleration (m/s^2)");
	clab = new JLabel("Coefficient of Friction");
	pane.add(move);
	pane.add(stop);
	pane.add(reset); 
	JLabel title = new JLabel("Energy Levels");
	JLabel tot = new JLabel("Total");
	JLabel pot = new JLabel("Potential");
	JLabel kin = new JLabel("Kinetic");
	JLabel therm = new JLabel("Thermal");
	pane.add(move);
	pane.add(stop);
	pane.add(reset);
	pane.add(mlab);
	pane.add(m);
	pane.add(glab);
	pane.add(g);
	pane.add(clab);
	pane.add(c);
	pane.add(option1);
	pane.add(option2);
	pane.add(title);
	pane.add(tot);
	pane.add(pot);
	pane.add(kin);
	pane.add(therm);
	
	layout.putConstraint(SpringLayout.WEST, move, 845, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, move, 400, SpringLayout.NORTH, pane);
	
	layout.putConstraint(SpringLayout.WEST, stop, 845, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, stop, 10, SpringLayout.SOUTH, move);
	
	layout.putConstraint(SpringLayout.WEST, reset, 845, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, reset, 10, SpringLayout.SOUTH, stop);
	
	layout.putConstraint(SpringLayout.WEST, mlab, 620, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, mlab, 380, SpringLayout.NORTH, pane);
	
	layout.putConstraint(SpringLayout.WEST, m, 620, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, m, 10, SpringLayout.SOUTH, mlab);
	
	layout.putConstraint(SpringLayout.WEST, glab, 620, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, glab, 10, SpringLayout.SOUTH, m);
	
	layout.putConstraint(SpringLayout.WEST, g, 620, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, g, 10, SpringLayout.SOUTH, glab);
	
	layout.putConstraint(SpringLayout.WEST, clab, 620, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, clab, 10, SpringLayout.SOUTH, g);
	
	layout.putConstraint(SpringLayout.WEST, c, 620, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, c, 10, SpringLayout.SOUTH, clab);
		

	//track options
	layout.putConstraint(SpringLayout.WEST, option1, 10, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, option1, 10, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, option2, 0, SpringLayout.EAST, option1);
	layout.putConstraint(SpringLayout.NORTH, option2, 10, SpringLayout.NORTH, pane);

	//bar graph
	layout.putConstraint(SpringLayout.WEST, title, 720, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, title, 350, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, therm, 625, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, therm, 320, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, kin, 700, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, kin, 320, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, pot, 765, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, pot, 320, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, tot, 848, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, tot, 320, SpringLayout.NORTH, pane);
    }
		
		
    public void reset(){
	stop();
	circle.reset();
	if (m.getText().length()>0) {
	    double mass = Double.parseDouble(m.getText());
	    circle.setMass(mass);
	}
	if (g.getText().length()>0) {
	    double grav = Double.parseDouble(g.getText());
	    circle.setGravity(grav);
	}
	if (c.getText().length()>0) {
	    double coeff = Double.parseDouble(c.getText());
	    circle.setCoeff(coeff);
	}
	System.out.println("circ Angle: " + circle.getAngle()*180/Math.PI);
	System.out.println("circ Position: " + circle.getPosX() + ", " + circle.getPosY());
	System.out.println("circ Velocity: " + circle.getVelX() + ", " + circle.getVelY());
	System.out.println("circ Height: " + circle.geHeight());
	System.out.println("circ Distance: "+ circle.getDist());
	System.out.println("circ Potential Energy: " + circle.getPotEnergy());
	System.out.println("circ Kinetic Energy: " + circle.getKinEnergy());
	System.out.println("circ Thermal Energy: " + circle.getThermEnergy());
	System.out.println("circ Total Energy: " + circle.getTotEnergy());
	setup();
	repaint();
    }
	
    public void stop(){
	timer.stop();
    }
	
    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if (circle.getMass() <= 0 || circle.getGravity() <= 0 || circle.getCoeff() < 0) {
	    reset();
	    JLabel error1 = new JLabel("Incorrect Values Error:");
	    JLabel error2 = new JLabel("Please make sure that mass > 0, gravity > 0, and 0 <= coefficient < 1.");
	    JLabel error3 = new JLabel("To continue, please press reset and input correct values, then press start.");
	    pane.add(error1);
	    pane.add(error2);
	    pane.add(error3);
	    layout.putConstraint(SpringLayout.WEST, error1, 50, SpringLayout.WEST, pane);
	    layout.putConstraint(SpringLayout.NORTH, error1, 100, SpringLayout.NORTH, pane);
	    layout.putConstraint(SpringLayout.WEST, error2, 50, SpringLayout.WEST, pane);
	    layout.putConstraint(SpringLayout.NORTH, error2, 0, SpringLayout.SOUTH, error1);
	    layout.putConstraint(SpringLayout.WEST, error3, 50, SpringLayout.WEST, pane);
	    layout.putConstraint(SpringLayout.NORTH, error3, 0, SpringLayout.SOUTH, error2);
	}
	else if (event.equals("Stop")) {
	    stop();
	}
	else if (event.equals("Go")) {
	    updateGame();
	}
	else if (event.equals("Reset")) {
	    reset();
	}
    } 
    
    public void paint(Graphics g) {
	System.out.println("paint");
	Graphics2D gsky = (Graphics2D) g;
	gsky.setColor(new Color(200,200,225));
	gsky.drawRect(0,0,600,600);
	gsky.fillRect(0,0,600,600);
	Graphics2D gground = (Graphics2D) g;
	gground.setColor(new Color(000,075,025));
	gground.drawRect(0,520,600,80);
	gground.fillRect(0,520,600,80);
	if (groupcmd.equals("Track 1")){
	    Graphics2D arc = (Graphics2D) g;
	    arc.drawArc(40, -160, 520, 680, 180,90);
	}
	if (groupcmd.equals("Track 2")){
	    gground.setColor(new Color(000,000,000));
	    QuadCurve2D.Double curve = new QuadCurve2D.Double(40,190,300,850,560,190);
	    ((Graphics2D)g).draw(curve);
	}
	circle.paint(g);
	bar.paint(g);
    }

    public void updateGame(){
	timer.start();
    }

    public static void main(String[] args){
	Sim z = new Sim();
	z.setVisible(true);
    }
	
}
