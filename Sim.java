import java.lang.Math;

public class Sim {
    double mass;
    double height;
    double gravity;
    double coeff;
    double velocity;
    double dist;
    double totalE;
    double kineticE;
    double potentialE;
    double thermalE;
    double angle;

    public Sim() {
	mass = 50.0;
	gravity = 9.81;
	coeff = 0;
	height = 0;
	velocity = 0;
    }

    public void setHeight(double h) {
	height = h;
    }

    public void setMass(double m) {
	mass = m;
    }

    public void setGravity(double g) {
	gravity = g;
    }
   
    public void setCoeff(double c) {
	coeff = c;
    }

    public double setPotEnergy() {
	double ans = mass * gravity * height;
	totalE = ans;
	return ans;
    }

    // need to set distance and angle
    public double setThermEnergy() {
	double ans = coeff * mass * gravity * Math.cos(angle) * dist;
	thermalE = ans;
	return ans;
    }

    public double calcVelocity() {
	double ans = totalE - potentialE - thermalE;
	ans = Math.sqrt((2 * ans)/mass);
	velocity = ans;
	return ans;
    }

    public double setKinEnergy() {
	double ans = 0.5 * mass * velocity * velocity;
	kineticE = ans;
	return ans;
    }
}
