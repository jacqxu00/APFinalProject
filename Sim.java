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
    SpringLayout layout = new SpringLayout();
    private String event;
    private Timer timer;
	
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
		    /*if (event.equals("Opt1")){
			double newxcor = circle.getPosX()+circle.getVelX()/100;
			double newycor = -1 * (320.0/62500)*Math.pow(newxcor - 290,2)+500;
			circle.moveTo(newxcor,newycor);
			circle.setPosition(newxcor,newycor); 
		    }
		    if (event.equals("Opt2")){ //ASIM we'll have to change this
			double newxcor = circle.getPosX()+circle.getVelX()/100;
			double newycor = -1 * (320.0/62500)*Math.pow(newxcor - 290,2)+500;
			circle.moveTo(newxcor,newycor);
			circle.setPosition(newxcor,newycor); 
		    }
		    if (event.equals("Opt3")){ //ASIM we'll have to change this
			double newxcor = circle.getPosX()+circle.getVelX()/100;
			double newycor = -1 * (320.0/62500)*Math.pow(newxcor - 290,2)+500;
			circle.moveTo(newxcor,newycor);
			circle.setPosition(newxcor,newycor); 
			}*/
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
	// add JLabel coordinates skater
	setSize(1000,600);
	setVisible(true);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane(); 
	pane.setLayout(layout);
	/*JRadioButton option1 = new JRadioButton("Option 1");
	option1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    repaint(); //ASIM not sure if this is correct also these are radio buttons, is there a way that java knows these three are connected or it already knows idk also how do you make default option 1
		}
	    });
	option1.setActionCommand("Opt2");
	JRadioButton option2 = new JRadioButton("Option 2");
	option2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    repaint(); //ASIM not sure if this is correct
		}
	    });
	option2.setActionCommand("Opt3");
	JRadioButton option3 = new JRadioButton("Option 3");
	option3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    repaint(); //ASIM not sure if this is correct
		}
		});    
		option3.setActionCommand("Opt1");      */   
	JButton move  = new JButton("Go");
	move.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    updateGame(); //ASIM this makes the thing go faster if its already moving
		}
	    });
	move.setActionCommand("Go");
	JButton stop = new JButton("Stop");
	stop.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
		    stop();
		}
	    });
	stop.setActionCommand("Stop");
	JButton reset = new JButton("Reset");
	reset.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
		    reset();
		}
	    });
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
	tabbedPane = new JTabbedPane();
	barsPage=new JPanel();
	valsPage=new JPanel(new GridLayout(0,1));
	tabbedPane.addTab("Energy Graph",barsPage);
	tabbedPane.addTab("Skater Values", valsPage);
	/*JSlider mslider = new JSlider(JSlider.HORIZONTAL, 1, 200, 50);
	  mslider.setMinorTickSpacing(2);
	  mslider.setMajorTickSpacing(10);
	  mslider.setPaintTicks(true);
	  mslider.setPaintLabels(true);
	  mslider.setLabelTable(mslider.createStandardLabels(10));
	  JSlider gslider = new JSlider(JSlider.HORIZONTAL, 1, 100, 10);
	  gslider.setMinorTickSpacing(2);
	  gslider.setMajorTickSpacing(10);
	  gslider.setPaintTicks(true);
	  gslider.setPaintLabels(true);
	  gslider.setLabelTable(gslider.createStandardLabels(10));
	  JSlider cslider = new JSlider(JSlider.HORIZONTAL, 0, 1, 0);
	  cslider.setMinorTickSpacing(2);
	  cslider.setMajorTickSpacing(10);
	  cslider.setPaintTicks(true);
	  cslider.setPaintLabels(true);
	  cslider.setLabelTable(cslider.createStandardLabels(10));
	  pane.add(mslider);
	  pane.add(gslider);
	  pane.add(cslider);*/
	pane.add(move);
	pane.add(stop);
	pane.add(reset); 
	mlab = new JLabel("Mass of Skater (kg)");
	glab = new JLabel("Gravitational Acceleration (m/s^2)");
	clab = new JLabel("Coefficient of Friction");
	tabbedPane = new JTabbedPane();
	barsPage=new JPanel();
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
	layout.putConstraint(SpringLayout.WEST, move, 800, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, move, 15, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, stop, 900, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, stop, 15, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, reset, 950, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, reset, 15, SpringLayout.NORTH, pane);
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
	/* layout.putConstraint(SpringLayout.WEST, option1, 10, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, option1, 10, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, option2, 2, SpringLayout.EAST, option1);
	layout.putConstraint(SpringLayout.NORTH, option2, 10, SpringLayout.NORTH, pane);
	layout.putConstraint(SpringLayout.WEST, option3, 2, SpringLayout.WEST, option2);
	layout.putConstraint(SpringLayout.NORTH, option3, 10, SpringLayout.NORTH, pane);*/
    }

    public void reset(){
	stop();
	setup();
    }
	
    public void stop(){
	timer.stop();
	// ASIM this is called by reset button and by stop button and when the values are incorrect in the text boxes (reset button steps shown above) please write this
    }
	
	
    
    public void paint(Graphics g) {
	// ASIM i added this if statement but not show if it will work, so it might cause problems when you later test it, youll have to see. i cant test it rn bc the stop/play are not working
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
	    /*if (event.equals("Opt1")){
		QuadCurve2D.Double curve = new QuadCurve2D.Double(40,190,300,850,560,190);
		((Graphics2D)g).draw(curve);
	    }
	    if (event.equals("Opt2")){ //ASIM we'll have to change this 
		//ALSO ERROR message because event is defined as 'String event = evt.getActionCommand();' see below
		// BUT the problem is that the getActionCommand can only be written in a actionPerformed method, i think
		// i was thinking of moving the actionperformed and actionlistener part from down there up to here, but im not sure if the timer needs it so i didnt want to touch it
		//im gonna leave that error for you
		QuadCurve2D.Double curve = new QuadCurve2D.Double(40,190,300,850,560,190);
		((Graphics2D)g).draw(curve);
	    }
	    if (event.equals("Opt3")){ //ASIM we'll have to change this
		QuadCurve2D.Double curve = new QuadCurve2D.Double(40,190,300,850,560,190);
		((Graphics2D)g).draw(curve);
		} */
	}

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
	
	timer.start();
    }

    public static void main(String[] args){
	Sim z = new Sim();
	z.setVisible(true);
    }
	
}
