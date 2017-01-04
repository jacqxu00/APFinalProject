public class Sim {
    double mass;
    double height;
    double gravity;
    double coeff;
    double velocity;
    double totalE;

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

    public void setVelocity(double v) {
	velocity = v;
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

    public double calcTotalEnergy() {
	return mass * gravity * height;
    }	
}
