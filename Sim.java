import java.lang.Math;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Sim extends JFrame{

    public static final int framewidth = 1000;
    public static final int frameheight = 600;
    private Container pane;
    private JTextField m;
    private JTextField g;
    private JTextField c;
    private JLabel mlab;
    private JLabel glab;
    private JLabel clab;
    private JTabbedPane tabbedPane;
    private JPanel barsPage;
    private JPanel valsPage;
    //private Skater y = new Skater(40.0,185.0,10.0);
    private String imgSkaterJPG = "images/skater.jpg"; 
    private Image img;  // this is a BufferedImage object
    private Skater circle = new Skater(10, 15, 10);
    

    public Sim() {
	setTitle("Conservation of Energy: AsimulaXuon");
	// add JLabel coordinates skater
        setSize(1000,600);
	setVisible(true);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	Container pane = getContentPane();
	SpringLayout layout = new SpringLayout();
	pane.setLayout(layout);
	JButton move  = new JButton("Go");
	//	move.addActionListener(this);
	move.setActionCommand("Go");
	move.setBackground(new Color(000,075,025));
    m = new JTextField(10);
	m.setText("50.0");
	g = new JTextField(10);
	g.setText("9.81");
	c = new JTextField(10);
	c.setText("0.0");
    mlab = new JLabel("Mass of Skater (kg)");
	glab = new JLabel("Gravitational Acceleration (m/s^2)");
    clab = new JLabel("Coefficient of Friction");
	tabbedPane = new JTabbedPane();
    barsPage=new JPanel(new SpringLayout);
    valsPage=new JPanel(new GridLayout(0,1));
	tabbedPane.addTab("Energy Graph",barsPage);
 	tabbedPane.addTab("Skater Values", valsPage);
	pane.add(move);
	pane.add(mlab);
	pane.add(m);
	pane.add(glab);
	pane.add(g);
	pane.add(clab);
	pane.add(c);
	pane.add(tabbedPane);
	layout.putConstraint(SpringLayout.WEST, move, 140, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, move, 300, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.WEST, move, 255, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, move, 520, SpringLayout.WEST, pane);
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
    }

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
	circle.paint(g);
	if((circle.x() < 0) || (circle.x() > framewidth))
	  circle.setMotion(-circle.xMotion(), circle.yMotion());
	if((circle.yMotion() < 0) || (circle.yMotion() > frameheight))
	  circle.setMotion(circle.xMotion(),-circle.yMotion());

    //redraw  the frame

    }

    /* public void paint2 (Graphics g){
	URL imgUrl = getClass().getClassLoader().getResource(imgSkaterJPG);
	if (imgUrl == null) {
	    System.err.println("Couldn't find file: " + imgSkaterJPG);
	} else {
	    try {
		img = ImageIO.read(imgUrl);
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}
	g.drawImage(img, 40, 190, null);
	y.position.set(0,y.position.get(0)+y.velocity.get(0)/100);
	y.position.set(0,y.position.get(1)+y.velocity.get(1)/100);
	}*/

    

    public void updateGame(){
	int delay = 50; 
	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    double mass = Double.parseDouble(m.getText());
		    circle.setMass(mass);
		    double grav = Double.parseDouble(g.getText());
		    circle.setGravity(grav);
		    double coeff = Double.parseDouble(c.getText());
		    circle.setCoeff(coeff);
		    Vector<Double> temp = new Vector<Double>(2);
			temp.clear();
		    temp.add(circle.getPosX()); //values?
		    temp.add(circle.getPosY()); //values?
		    repaint();
			double newxcor = circle.getPosX()+circle.getVelX()/100;
			double newycor = -1 * (320.0/62500)*Math.pow(newxcor - 290,2)+500;
		    circle.moveTo(newxcor,newycor);
		    circle.setPosition(newxcor,newycor); 
		    circle.setHeight();
		    circle.setPotEnergy();
		    circle.setDist(temp);
		    circle.setAngle(temp);
		    circle.setThermEnergy();
		    circle.setKinEnergy();
		    circle.setVelocity();/*
		    double mass = Double.parseDouble(m.getText());
		    circle.setMass(mass);
		    double grav = Double.parseDouble(g.getText());
		    circle.setGravity(grav);
		    double coeff = Double.parseDouble(c.getText());
		    circle.setCoeff(coeff);
		    Vector<Double> temp = new Vector<Double>(2);
			System.out.println("Angle: " + circle.getAngle());
		    System.out.println("Position: " + circle.getPosX() + ", " + circle.getPosY());
		    System.out.println("Velocity: " + circle.getVelX() + ", " + circle.getVelY());
		    System.out.println("Height: " + circle.geHeight());
		    System.out.println("Potential Energy: " + circle.getPotEnergy());
		    System.out.println("Kinetic Energy: " + circle.getKinEnergy());
		    System.out.println("Thermal Energy: " + circle.getThermEnergy());
		    System.out.println("Total Energy: " + circle.getTotEnergy());
		    
			temp.clear();
		    temp.add(circle.getPosX()); //values?
		    temp.add(circle.getPosY()); //values?
		    repaint();
		    circle.setHeight();
		    circle.setPotEnergy();
		    circle.moveTo(circle.getPosX()+circle.getVelX()/100,circle.getPosY()+circle.getVelY()/100);
		    circle.setPosition(circle.getPosX()+circle.getVelX()/100,circle.getPosY()+circle.getVelY()/100); 
		    circle.setDist(temp);
		    circle.setAngle(temp);
		    circle.setThermEnergy();
		    circle.setKinEnergy();
		    circle.setVelocity();
		    System.out.println(temp);*/
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
		}
	    };
	new Timer(delay, taskPerformer).start();
    }

    public static void main(String[] args){
	Sim z = new Sim();
        z.setVisible(true);
	    z.updateGame();
	
    }
}
