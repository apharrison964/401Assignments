package ta.v11;

public class Triangle {

	Point a;
	Point b;
	Point c;
	
	final static double SIDE_EPSILON = 0.001;
		
	Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	String category() {

		if (sides_are_same(side_ab(),side_bc()) && //Where did sides are same come from
			sides_are_same(side_bc(),side_ca())) {
			return "equilateral";
		} else if ((sides_are_same(side_ab(), side_bc())) || 
				   (sides_are_same(side_ab(), side_ca())) || 
				   (sides_are_same(side_bc(), side_ca()))) {
			return "isosceles";
		} else {
			return "scalene";
		}
	}

	double area() {
		double s = (side_ab()+side_bc()+side_ca())/2.0;

		return Math.sqrt(s*(s-side_ab())*(s-side_bc())*(s-side_ca()));		
	}

	double side_ab() {
		return a.distanceTo(b);
	}
	
	double side_bc() {
		return b.distanceTo(c);
	}
	
	double side_ca() {
		return c.distanceTo(a);
	}
	
	static boolean sides_are_same(double s1, double s2) {
		return (Math.abs(s1-s2) < SIDE_EPSILON); //Class method, helper method
	}
}
/*
 * Use static as epsilon 0 (final static double = whatever)
 * If you have a field of any sort, that is never going to change after it is initialized,
 * you can use the final keyword, which turns it into a constant. You are suppose
 * to use all caps for the variable name
 */
