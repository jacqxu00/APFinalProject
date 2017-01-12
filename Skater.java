import java.lang.Math;
import java.util.*;

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
    private Vector<Double> position = new Vector<Double>();
    private Vector<Double> velocity = new Vector<Double>();

    public Skater(){
	mass = 50.0;
	gravity = 9.81;
	coeff = 0;
        setHeight();
	velocity.add(0.0);
	velocity.add(0.0);
	position.add(40.0);
	position.add(185.0);
	dist = 0;
	totalE = 0;
	kineticE = 0;
	potentialE = 0;
	thermalE = 0;
	angle = 0;
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
	double ans = 520 - position.get(1);
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
	dist += ans;
	return ans;
    }

    public double getAngle() {
	return this.angle;
    }

    public void setAngle(Vector<Double> old) {
	double ans;
        if ((old.get(0) - this.position.get(0)) <= 0 && (old.get(1) - this.position.get(1)) <= 0) {
	    ans = 3*Math.PI/2 + Math.atan((old.get(1)-this.position.get(1))/(old.get(0)-this.position.get(0)));
	    this.angle = ans;
	}
	if ((old.get(0) - this.position.get(0)) <= 0 && (old.get(1) - this.position.get(1)) > 0) {
	    ans = 1*Math.PI/2 - Math.atan((old.get(1)-this.position.get(1))/(old.get(0)-this.position.get(0)));
	    this.angle = ans;
	}
	if ((old.get(0) - this.position.get(0)) > 0 && (old.get(1) - this.position.get(1)) <= 0) {
	    ans = 3*Math.PI/2 - Math.atan((old.get(1)-this.position.get(1))/(old.get(0)-this.position.get(0)));
	    this.angle = ans;
	}
	if ((old.get(0) - this.position.get(0)) > 0 && (old.get(1) - this.position.get(1)) <= 0) {
	    ans = 1*Math.PI/2 + Math.atan((old.get(1)-this.position.get(1))/(old.get(0)-this.position.get(0)));
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

    public double getVelY(){
	return this.velocity.get(1);
    }

    public double getVelocity(){
	double velocity = Math.sqrt(Math.pow(this.velocity.get(0),2)+Math.pow(this.velocity.get(1),2));
	return velocity;
    }

    public void setVelocity() {
	double ans = totalE - potentialE - thermalE;
	double vel  = Math.sqrt((2 * ans)/mass);
	this.velocity.set(0,Math.cos(angle) * vel);
	this.velocity.set(1,Math.sin(angle) * vel);
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
	double ans = mass * gravity * height;
	this.totalE = ans;
    }
    
    public double getThermEnergy() {
	return this.thermalE;
    }
    
    public void setThermEnergy() {
	double ans = coeff * mass * gravity * Math.cos(angle) * dist;
	this.thermalE = ans;
    }

    public double getKinEnergy() {
	return this.kineticE;
    }

    public void setKinEnergy() {
	double velocity = Math.sqrt(Math.pow(this.velocity.get(0),2)+Math.pow(this.velocity.get(1),2));
	double ans = 0.5 * mass * velocity * velocity;
	this.kineticE = ans;
    }
    
    public static void main (String[] args){
	Skater skater = new Skater();
	System.out.println(skater.getMass());
	System.out.println(skater.getGravity());
	System.out.println(skater.getCoeff());
	System.out.println(skater.getTotEnergy());
	System.out.println(skater.getPotEnergy());
	System.out.println(skater.getKinEnergy());
	System.out.println(skater.getThermEnergy());
	System.out.println(skater.getVelocity());
    }

}
