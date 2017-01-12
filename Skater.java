import java.awt.Graphics;

public class Skater{
    private double mass;
    private double height;
    private double gravity;
    private double coeff;
    private double velocity;
    private double dist;
    private double totalE;
    private double kineticE;
    private double potentialE;
    private double thermalE;
    private double angle;
    private double xCor;
    private double yCor;

    public Skater(){
	xCor = 1.0;
	yCor = 1.0;
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
    }

    public double getMass(){
	return this.mass;
    }

    public double getGravity(){
	return this.gravity;
    }

    public double getCoeff(){
	return this.coeff;
    }

    public void setMass(double m) {
	this.mass = m;		
    }

    public void setGravity(double g) {
	this.gravity = g;
    }
   
    public void setCoeff(double c) {
	this.coeff = c;
    }

    public double setPotEnergy() {
	double ans = mass * gravity * height;
	this.potentialE = ans;
	return ans;
    }

    public double setTotEnergy() {
	double ans = mass * gravity * height;
	this.totalE = ans;
	return ans;
    }

    // need to set distance and angle
    public double setThermEnergy() {
	double ans = coeff * mass * gravity * Math.cos(angle) * dist;
	this.thermalE = ans;
	return ans;
    }

    public double setVelocity() {
	double ans = totalE - potentialE - thermalE;
	ans = Math.sqrt((2 * ans)/mass);
	this.velocity = ans;
	return ans;
    }

    public double setKinEnergy() {
	double ans = 0.5 * mass * velocity * velocity;
	this.kineticE = ans;
	return ans;
    }

    /** ----------------NEED TO WRITE THIS---------------
    public double setHeight() {
	double ans = 520 - position.y;
	height = ans;
	return ans;
    }

    public double setAngle(Pvector old) {
	double ans = atan((old.y-position.y)/(old.x-position.x));
	angle = ans;
	return ans;
    }

    public double setDist(Pvector old) {
	double ans = position.dist(old);
	dist += ans;
	return ans;
    }
    **/
    
    public static void main (String[] args){
	Skater skater = new Skater();
	System.out.println(skater.getMass());
	System.out.println(skater.getGravity());
	System.out.println(skater.getCoeff());
	skater.setMass(70);
	skater.setGravity(15);
	skater.setCoeff(2);
	System.out.println(skater.getMass());
	System.out.println(skater.getGravity());
	System.out.println(skater.getCoeff());
	System.out.println(skater.setTotEnergy());
	System.out.println(skater.setPotEnergy());
	System.out.println(skater.setKinEnergy());
	System.out.println(skater.setThermEnergy());
	System.out.println(skater.setVelocity());
    }

}
