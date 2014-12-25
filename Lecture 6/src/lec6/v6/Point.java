package lec6.v6;

interface Point {
	int getX();
	int getY();
	double distanceTo(Point p);
	boolean equals(Point p);
}
// Anything can be a point as long as it has public methods called getY(),etc
// All have to be public