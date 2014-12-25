package ta.v10;

public class Point {
	double x;
	double y;
	
	Point (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	double distanceTo(Point other_point) {
		return Math.sqrt((this.x - other_point.x)*(this.x - other_point.x) +
						 (this.y - other_point.y)*(this.y - other_point.y));
						
	}
}
/*
 * 1. make variables
 * 2. create the point field
 * You can make sure the parameter names not match so you won't have to use the this
 * You can use the this in the instance method
 * In more modern code you do
 * x = x_;
 * y = y_;
 * To make sure that there are no conflicts
 * 3. Then make a useful method, as in the distanceTo method
 * Where did the other_point come from - you made a point in the constructor
 * 
 */
