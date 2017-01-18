import java.lang.Math;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Rectangle;

public class Skater{
    private double mass;
    private double height;
    private double gravity;
    private double coeff;
    private double dist;
    private double totalE;
    private double kineticE;
    private double potentialE;
    private double thermalE;
    private double angle;
    private double px,py;
    private Vector<Double> position = new Vector<Double>(2);
    private Vector<Double> velocity = new Vector<Double>(2);
    private Rectangle location;
    private Color color = new Color(200,0,0);

    public Skater(){
	mass = 50.0;
	gravity = 9.81;
	coeff = 0;
	reset();
    }
	
    public void reset() {
	position.add(45.0);
	position.add(-1 * (320.0/62500)*Math.pow(45.0 - 290,2)+500);
	px = 100;
	py = 510;
	setHeight();
	dist = 0;
	setTotEnergy();
	position.clear();
	position.add(45.1);
	position.add(-1 * (320.0/62500)*Math.pow(45.1 - 290,2)+500);
	velocity.add(0.0);
	velocity.add(0.0);
	Vector<Double> temp = new Vector<Double>(2);
	temp.clear();
	temp.add(45.0);
	temp.add(-1 * (320.0/62500)*Math.pow(45.0 - 290,2)+500);
	setDist(temp);
	setAngle(temp);
	setHeight();
	setPotEnergy();
	thermalE = 0;
	setKinEnergy();
	setVelocity();
	setVelocity();
	double vel = Math.sqrt((2 * this.kineticE)/this.mass);
	velocity.add(Math.cos(angle) * vel);
	velocity.add(Math.sin(angle) * vel);
	location = new Rectangle((int)(90), (int)(500), (int)(20),(int)( 20));
    }
	
    public void setMotion(double newX, double newY){
	position.set(0,newX);
	position.set(1,newY);
    }

    public double getMass(){
	return this.mass;
    }
    
    public void setMass(double m) {
	this.mass = m;		
    }

    public double geHeight() {
	return this.height;
    }
    
    public void setHeight() {
	double ans = 500 - position.get(1);
	this.height = ans;
    }

    public double getGravity(){
	return this.gravity;
    }

    public void setGravity(double g) {
	this.gravity = g;
    }

    public double getCoeff(){
	return this.coeff;
    }

    public void setCoeff(double c) {
	this.coeff = c;
    }

    public double getDist() {
	return this.dist;
    }
    
    public double setDist(Vector<Double> old) {
	double ans = Math.sqrt(Math.pow(old.get(0)-this.position.get(0),2)+Math.pow(old.get(1)-this.position.get(1),2));
	dist += ans/80;
	return ans;
    }

    public double getAngle() {
	return this.angle;
    }

    public void setAngle(Vector<Double> old) {
	double ans;
	if ((old.get(0) - this.position.get(0)) <= 0 && (old.get(1) - this.position.get(1)) <= 0) {
	    ans = 2*Math.PI - Math.atan((old.get(1)-this.position.get(1))/(old.get(0)-this.position.get(0)));
	    this.angle = ans;
	}
	if ((old.get(0) - this.position.get(0)) <= 0 && (old.get(1) - this.position.get(1)) > 0) {
	    ans = Math.atan((-1 * (old.get(1)-this.position.get(1))/(old.get(0)-this.position.get(0))));
	    this.angle = ans;
	}
	if ((old.get(0) - this.position.get(0)) > 0 && (old.get(1) - this.position.get(1)) <= 0) {
	    ans = Math.PI - Math.atan((old.get(1)-this.position.get(1))/(old.get(0)-this.position.get(0)));
	    this.angle = ans;
	}
	if ((old.get(0) - this.position.get(0)) > 0 && (old.get(1) - this.position.get(1)) > 0) {
	    ans = Math.PI + Math.atan((-1 * (old.get(1)-this.position.get(1))/(old.get(0)-this.position.get(0))));
	    this.angle = ans;
	}
    }
   
    public double getPosX(){
	return this.position.get(0);
    }

    public double getPosY(){
	return this.position.get(1);
    }

    public void setPosition(double x, double y){
	this.position.set(0,x);
	this.position.set(1,y);
    }

    public double getVelX(){
	return this.velocity.get(0);
    }
	
    public void setVelX(double v){
	this.velocity.set(0,v);
    }
	
    public double getVelY(){
	return this.velocity.get(1);
    }

    public int radius(){    
	return location.width/2;
    }

    public int x(){
	return location.x + radius();
    }
    
    public int y(){
	return location.y + radius();
    }

    public double xMotion(){
	return px;
    }
    
    public double yMotion(){    
	return py;
    }

    public Rectangle region(){
	return location;
    }
    
    public double getVelocity(){
	double velocity = Math.sqrt(Math.pow(this.velocity.get(0),2)+Math.pow(this.velocity.get(1),2));
	return velocity;
    }

    public void setVelocity() {
	double vel = Math.sqrt((this.kineticE)/this.mass);
	this.velocity.set(0,Math.cos(angle) * vel);
	this.velocity.set(1,-1 * Math.sin(angle) * vel); 
    }

    public double getPotEnergy() {
	return this.potentialE;
    }
    
    public void setPotEnergy() {
	double ans = mass * gravity * height;
	this.potentialE = ans;
    }

    public double getTotEnergy() {
	return this.totalE;
    }

    public void setTotEnergy() {
	double ans = mass * gravity * 335;
	this.totalE = ans;
    }
    
    public double getThermEnergy() {
	return this.thermalE;
    }
    
    public void setThermEnergy() {
	double ans = coeff * mass * gravity * Math.abs(Math.cos(angle)) * dist/100;
	this.thermalE += ans;
    }

    public double getKinEnergy() {
	return this.kineticE;
    }

    public void setKinEnergy() {
        double ans = this.totalE - this.potentialE - this.thermalE;
	this.kineticE = ans;
    }

    public void moveTo(double x, double y){
	location.setLocation((int)x, (int) y);
    }

    public void move(){
	location.translate((int) px,(int) py);
    }

    public void paint(Graphics g){
	g.fillOval(location.x, location.y, location.width,location.height);
    }

}
