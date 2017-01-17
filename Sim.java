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
    private JTabbedPane tabbedPane;
    private JPanel valsPage;
    private Skater circle = new Skater();
    SpringLayout layout = new SpringLayout();
    private String event;
    private Timer timer;
    private double newxcor;
    private double newycor;
    private ButtonGroup group = new ButtonGroup();
    private String groupcmd = "Track 1";
	
    public Sim() {
	setup();
    }
	
    public void setup(){
	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    event = evt.getActionCommand();
		    double mass = Double.parseDouble(m.getText());
		    circle.setMass(mass);
		    double grav = Double.parseDouble(g.getText());
		    circle.setGravity(grav);
		    double coeff = Double.parseDouble(c.getText());
		    circle.setCoeff(coeff);
		    Vector<Double> temp = new Vector<Double>(2);
		    temp.clear();
		    temp.add(circle.getPosX());
		    temp.add(circle.getPosY());
		    repaint();
		    if (groupcmd.equals("Track 1")){
			newxcor = circle.getPosX()+circle.getVelX()/100;
			newycor = -1 * (320.0/62500)*Math.pow(newxcor - 290,2)+500;
		    }
		    if (groupcmd.equals("Track 2")){
			newxcor = circle.getPosX()+circle.getVelX()/100;
			newycor = -1 * (320.0/62500)*Math.pow(newxcor - 290,2)+500;
		    }
		    if (groupcmd.equals("Track 3")){
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
		    System.out.println("Potential Energy: " + circle.getPotEnergy());
		    System.out.println("Kinetic Energy: " + circle.getKinEnergy());
		    System.out.println("Thermal Energy: " + circle.getThermEnergy());
		    System.out.println("Total Energy: " + circle.getTotEnergy());
		    System.out.println("");
		    JLabel poslab = new JLabel("Position: (" + circle.getPosX() + ", " + circle.getPosY()+ ")");
		    JLabel vellab = new JLabel("Velocity: " + circle.getVelX() + ", " + circle.getVelY()); //change into just magnitude velocity;
		    JLabel dislab = new JLabel("Distance: "+ circle.getDist());
		    JLabel anglab = new JLabel("Angle: "+ circle.getAngle());
		    JLabel heilab = new JLabel("Height: " + circle.geHeight());
		    JLabel potlab = new JLabel("Potential Energy: " + circle.getPotEnergy());
		    JLabel kinlab = new JLabel("Kinetic Energy: " + circle.getKinEnergy());
		    JLabel thelab = new JLabel("Thermal Energy: " + circle.getThermEnergy());
		    JLabel totlab = new JLabel("Total Energy: " + circle.getTotEnergy());
		    valsPage.removeAll();
		    valsPage.add(poslab);
		    valsPage.add(vellab);
		    valsPage.add(dislab);
		    valsPage.add(anglab);
		    valsPage.add(heilab);
		    valsPage.add(potlab);
		    valsPage.add(kinlab);
		    valsPage.add(thelab);
		    valsPage.add(totlab);
		    valsPage.removeAll();
		    valsPage.add(poslab);
		    valsPage.add(vellab);
		    valsPage.add(dislab);
		    valsPage.add(anglab);
		    valsPage.add(heilab);
		    valsPage.add(potlab);
		    valsPage.add(kinlab);
		    valsPage.add(thelab);
		    valsPage.add(totlab);
		}
	    };
	timer = new Timer(50, taskPerformer);

	
	setTitle("Conservation of Energy: AsimulaXuon");
	setSize(1500,600);
	setVisible(true);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane(); 
	pane.setLayout(layout);
	JRadioButton option1 = new JRadioButton("Track 1");
	option1.addActionListener(this);
	option1.setActionCommand("Track 1");
	option1.setSelected(true);
	JRadioButton option2 = new JRadioButton("Track 2");
	option2.addActionListener(this);
	option2.setActionCommand("Track 2");
	JRadioButton option3 = new JRadioButton("Track 3");
	option3.addActionListener(this);
	option3.setActionCommand("Track 3");
	group.add(option1);
	group.add(option2);
	group.add(option3);
	/*System.out.println(group.getSelection().getActionCommand());
	  option1.addActionListener(new ActionListener() {  
	  public void actionPerformed(ActionEvent e) {
	  groupcmd = group.getSelection().getActionCommand();
	  }    
	  });  
	  option2.addActionListener(new ActionListener() {  
	  public void actionPerformed(ActionEvent e) {
	  groupcmd = group.getSelection().getActionCommand();
	  }  
	  });  
	  option3.addActionListener(new ActionListener() {  
	  public void actionPerformed(ActionEvent e) {
	  groupcmd = group.getSelection().getActionCommand();
	  }  
	  });  */
	groupcmd = group.getSelection().getActionCommand();
	option3.setActionCommand("Opt1");
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
	valsPage=new JPanel(new BorderLayout());
	pane.add(mlab);
	pane.add(m);
	pane.add(glab);
	pane.add(g);
	pane.add(clab);
	pane.add(c);
	pane.add(option1);
	pane.add(option2);
	pane.add(option3);
	pane.add(move);
	pane.add(stop);
	pane.add(reset);
	pane.add(valsPage);
	layout.putConstraint(SpringLayout.WEST, move, 810, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, move, 15, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, stop, 810, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, stop, 5, SpringLayout.SOUTH, move);
	layout.putConstraint(SpringLayout.WEST, reset, 810, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, reset, 5, SpringLayout.SOUTH, stop);
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
	layout.putConstraint(SpringLayout.WEST, option1, 10, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, option1, 10, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, option2, 2, SpringLayout.EAST, option1);
	layout.putConstraint(SpringLayout.NORTH, option2, 10, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, option3, 2, SpringLayout.EAST, option2);
	layout.putConstraint(SpringLayout.NORTH, option3, 10, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, valsPage, 950, SpringLayout.EAST, pane);
	layout.putConstraint(SpringLayout.NORTH, valsPage, 40, SpringLayout.NORTH, pane);
    }

    public void reset(){
	timer.stop();
	getContentPane().removeAll();
	//getContentPane().revalidate();
	//getContentPane().repaint();
       	//setup1();
	//setup2();
    }
	
    public void stop(){
	timer.stop();
    }
	
    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if (event.equals("Stop")) {
	    stop();
	}
	if (event.equals("Go")) {
	    updateGame();
	}
	if (event.equals("Reset")) {
	    reset();
	}
    }
	
    public void itemStateChanged(ItemEvent e) {
	reset();
    }
    
    public void paint(Graphics g) {
	if (circle.getMass() <= 0 || circle.getGravity() <= 0 || circle.getCoeff() < 0) {
	    reset();
	    JLabel error1 = new JLabel("Incorrect Values Error:");
	    JLabel error2 = new JLabel("Please make sure that mass > 0, gravity > 0, and coefficient >= 0.");
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
	else {
	    Graphics2D gsky = (Graphics2D) g;
	    gsky.setColor(new Color(200,200,225));
	    gsky.drawRect(0,0,600,600);
	    gsky.fillRect(0,0,600,600);
	    Graphics2D gground = (Graphics2D) g;
	    gground.setColor(new Color(000,075,025));
	    gground.drawRect(0,520,600,80);
	    gground.fillRect(0,520,600,80);
	    if (groupcmd.equals("Track 1")){
		QuadCurve2D.Double curve = new QuadCurve2D.Double(40,190,300,850,560,190);
		((Graphics2D)g).draw(curve);
	    }
	    if (groupcmd.equals("Track 2")){
		QuadCurve2D.Double curve = new QuadCurve2D.Double(40,190,300,850,560,190);
		((Graphics2D)g).draw(curve);
	    }
	    if (groupcmd.equals("Track 3")){
		QuadCurve2D.Double curve = new QuadCurve2D.Double(40,190,300,850,560,190);
		((Graphics2D)g).draw(curve);
	    }
	}
	circle.paint(g);
	Bar bar = new Bar(circle.getTotEnergy(), circle.getPotEnergy(), circle.getKinEnergy(), circle.getThermEnergy());
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
