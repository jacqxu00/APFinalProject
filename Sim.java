import java.lang.Math;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Sim extends JFrame{

    private static Container pane;
    private static JTextField m;
    private static JTextField g;
    private static JTextField c;

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
	//pane.add(move);
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
	/*layout.putConstraint(SpringLayout.WEST, move, 255, SpringLayout.WEST, pane);
	  layout.putConstraint(SpringLayout.NORTH, move, 520, SpringLayout.WEST, pane);*/
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

	public void actionPerformed(ActionEvent e){
	    String event = e.getActionCommand();
	    if(event.equals("Byte")){
		
	    }
	    if(event.equals("NotByte")){
	    
	    }
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
    }

    //  public void paint2(Graphics g, ){
    // }

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
	//new skater
    }

    public static void updateGame(){
	int delay = 1000; //in milliseconds
	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    //paint2, with changing position/velocity for skater
		}
	    };
	new Timer(delay, taskPerformer).start();
    }
}
