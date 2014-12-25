package ta.v07;

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
		this.ax = x1;
		this.ay = y1;
		this.bx = x2;
		this.by = y2;
		this.cx = x3;
		this.cy = y3;
	}
}


/* Constructor will result in new triangle object
You can provife values, you need to have user give the values, in this case you will accepts
6 double values
You use this.example to refer to the object upon which the method it operating on
You have to initialized the fields of hte new object with the this keyword
This references the object
dot operator refers to the variable you are calling, says look into that object
To use you use new Example
*/