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
    private Skater y = new Skater(41.0,186.0,11.0);
    private String imgSkaterJPG = "images/skater.jpg"; 
    private Image img;  // this is a BufferedImage object
    private Skater circle = new Skater(40.0,185.0,10.0);
    

    public Sim() { //change!!
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
        barsPage=new JPanel();
        valsPage=new JPanel();
	tabbedPane.addTab("Bar Graph",barsPage);
 	tabbedPane.addTab("Values", valsPage);
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

	circle = new Skater(10, 15, 5);
	circle.setMotion(3.0, 6.0);
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
	/*Graphics2D circle = (Graphics2D) g;
	circle.drawOval((int)(y.getPosX()+y.getVelX()/100),(int)(y.getPosY()+y.getVelY()/100),10,10);
	y.setPosition(y.getPosX()+y.getVelX()/100,y.getPosY()+y.getVelY()/100); */
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
		    y.setMass(mass);
		    double grav = Double.parseDouble(g.getText());
		    y.setGravity(grav);
		    double coeff = Double.parseDouble(c.getText());
		    y.setCoeff(coeff);
		    Vector<Double> temp = new Vector<Double>(2);
		    temp.add(0.0); //values?
		    temp.add(0.0); //values?
		    repaint();
		    y.setHeight();
		    y.setPotEnergy();
		    circle.moveTo(y.getPosX()+y.getVelX()/100,y.getPosY()+y.getVelY()/100);
		    y.setPosition(y.getPosX()+y.getVelX()/100,y.getPosY()+y.getVelY()/100); 
		    y.setDist(temp);
		    y.setAngle(temp);
		    y.setThermEnergy();
		    y.setKinEnergy();
		    y.setVelocity();
		    System.out.println("Angle: " + y.getAngle());
		    System.out.println("Position: " + y.getPosX() + ", " + y.getPosY());
		    System.out.println("Velocity: " + y.getVelX() + ", " + y.getVelY());
		    System.out.println("Height: " + y.geHeight());
		    System.out.println("Potential Energy: " + y.getPotEnergy());
		    System.out.println("Kinetic Energy: " + y.getKinEnergy());
		    System.out.println("Thermal Energy: " + y.getThermEnergy());
		    System.out.println("Total Energy: " + y.getTotEnergy());
		    System.out.println("");
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
