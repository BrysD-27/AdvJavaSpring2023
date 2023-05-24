
public class Triangle extends Shape {
	double  side1, side2, side3;
	public Triangle(double x, double y, double side1, double side2, double side3) {
		super();
		setX(x);
		setY(y);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	double getArea() {
		return side1 * side2 / 2;
	}
	
	double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	void drawShape(){
		System.out.println("x = " + x + "\ny = " + y + "\nSide 1 = " + side1 + "\nSide 2 = " + side2 + "\nSide 3 = " + side3 + "\nColor = " + c + "\nFill = " + fill + "\n");
	}
}
