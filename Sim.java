import java.lang.Math;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Sim extends JFrame implements ActionListener {

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
    private Skater y = new Skater();

    public Sim() { //change!!
	setTitle("Conservation of Energy: AsimulaXuon");
        setSize(1000,600);
	setVisible(true);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	Container pane = getContentPane();
	SpringLayout layout = new SpringLayout();
	pane.setLayout(layout);
	/*JButton move  = new JButton("Go");
	move.addActionListener(this);
	move.setActionCommand("Go");*/
        m = new JTextField(10);
	m.setText("50.0");
	g = new JTextField(10);
	g.setText("9.81");
	c = new JTextField(10);
	c.setText("0.0");
        mlab = new JLabel("Mass of Skater");
	glab = new JLabel("Gravitational Acceleration");
        clab = new JLabel("Coefficient of Friction");
	tabbedPane = new JTabbedPane();
        barsPage=new JPanel();
        valsPage=new JPanel();
	tabbedPane.addTab("Bar Graph",barsPage);
 	tabbedPane.addTab("Values", valsPage);
	//pane.add(move);
	pane.add(mlab);
	pane.add(m);
	pane.add(glab);
	pane.add(g);
	pane.add(clab);
	pane.add(c);
	pane.add(tabbedPane);
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
	/*layout.putConstraint(SpringLayout.WEST, move, 140, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, move, 300, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.WEST, move, 255, SpringLayout.WEST, pane);
	layout.putConstraint(SpringLayout.NORTH, move, 520, SpringLayout.WEST, pane);*/
<<<<<<< HEAD
	/*layout.putConstraint(SpringLayout.WEST, move, 255, SpringLayout.WEST, pane);
	  layout.putConstraint(SpringLayout.NORTH, move, 520, SpringLayout.WEST, pane);*/
=======
=======
	/*layout.putConstraint(SpringLayout.WEST, move, 255, SpringLayout.WEST, pane);
	  layout.putConstraint(SpringLayout.NORTH, move, 520, SpringLayout.WEST, pane);*/
>>>>>>> asim
>>>>>>> master
=======
	/*layout.putConstraint(SpringLayout.WEST, move, 255, SpringLayout.WEST, pane);
	  layout.putConstraint(SpringLayout.NORTH, move, 520, SpringLayout.WEST, pane);*/
>>>>>>> master
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

    public void updateGame(){
	int delay = 1000; //in milliseconds
	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> master
		    double mass = Double.parseDouble(m.getText());
		    y.setMass(mass);
		    double grav = Double.parseDouble(g.getText());
		    y.setGravity(grav);
		    double coeff = Double.parseDouble(c.getText());
		    y.setCoeff(coeff);
		    Vector<Double> temp = new Vector<Double>();
		    //movement
		    y.setHeight();
		    y.setPotEnergy();
		    y.setDist(temp);
		    y.setAngle(temp);
		    y.setThermEnergy();
		    y.setKinEnergy();
		    y.setVelocity();
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======

>>>>>>> asim
>>>>>>> master
=======
>>>>>>> master
		}
	    };
	new Timer(delay, taskPerformer).start();
    }

    public void main(String[] args){
	Sim z = new Sim();
        z.setVisible(true);
	while(true){
	   updateGame();
	}
    }
}
