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
    private Vector<Double> position;
    private Vector<Double> velocity;

    public Skater(){
	mass = 50.0;
	gravity = 9.81;
	coeff = 0;
        setHeight();
	velocity = (0,0);
	position = (40,185);
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

    public double setHeight() {
	double ans = 520 - position.y;
	height = ans;
	return ans;
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
    
    public double setDist(Vector old) {
	double ans = position.dist(old);
	dist += ans;
	return ans;
    }

    public double getAngle() {
	return this.angle;
    }

    public void setAngle(Vector old) {
	double ans;
        if (old.get(0) - new.get(0) <= 0 && old.get(1) - new.get(1) <= 0) {
	    ans = 3*PI/2 + atan((old.y-position.y)/(old.x-position.x));
	}
	if (old.get(0) - new.get(0) <= 0 && old.get(1) - new.get(1) > 0) {
	    ans = 1*PI/2 - atan((old.y-position.y)/(old.x-position.x));
	}
	if (old.get(0) - new.get(0) > 0 && old.get(1) - new.get(1) <= 0) {
	    ans = 3*PI/2 - atan((old.y-position.y)/(old.x-position.x));
	}
	if (old.get(0) - new.get(0) > 0 && old.get(1) - new.get(1) <= 0) {
	    ans = 1*PI/2 + atan((old.y-position.y)/(old.x-position.x));
	}
	
	angle = ans;
    }
   
    public double getPosition(){
	return this.position;
    }

    public void setPosition(double x, double y){
	this.position.set(0,x);
	this.position.set(1,y);
    }

    public double getVelocity(){
	return this.velocity;
    }

    public void setVelocity() {
	double ans = totalE - potentialE - thermalE;
	double vel  = Math.sqrt((2 * ans)/mass);
	this.velocity.set(0,cos(angle) * vel);
	this.velocity.set(1,sin(angle) * vel);
    }

    public void getPotEnergy() {
	return this.potentialE;
    }
    
    public void setPotEnergy() {
	double ans = mass * gravity * height;
	this.potentialE = ans;
    }

    public void getTotEnergy() {
	return this.totalE;
    }

    public void setTotEnergy() {
	double ans = mass * gravity * height;
	this.totalE = ans;
    }
    
    public void getThermEnergy() {
	return this.thermalE;
    }
    
    public void setThermEnergy() {
	double ans = coeff * mass * gravity * Math.cos(angle) * dist;
	this.thermalE = ans;
    }

    public void getKinEnergy() {
	return this.KineticE;
    }

    public void setKinEnergy() {
	double ans = 0.5 * mass * velocity * velocity;
	this.kineticE = ans;
    }
    
    public static void main (String[] args){
	Skater skater = new Skater();
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
