package ta.v09;

public class Triangle {

	double ax;
	double ay;
	double bx;
	double by;
	double cx;
	double cy;
	
	Triangle(double x1, double y1,
			 double x2, double y2,
			 double x3, double y3) {
		ax = x1;
		this.ay = y1;
		this.bx = x2;
		this.by = y2;
		this.cx = x3;
		this.cy = y3;
	}
	
	String category() {

		if ((side_ab() == side_bc()) && (side_bc() == side_ca())) {
			return "equilateral";
		} else if ((side_ab() == side_bc()) || (side_ab() == side_ca()) || (side_bc() == side_ca())) {
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
		return point_distance(ax, ay, bx, by);
	}
	
	double side_bc() {
		return point_distance(bx, by, cx, cy);
	}
	
	double side_ca() {
		return point_distance(cx, cy, ax, ay);
	}

	static double point_distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
	}

}
/*
 * The mehtod can call other instance methods of itself, still do not need
 * to use this.example
 * so this.side_ab() = side.ab() (whithin the same class
 * 
 */
