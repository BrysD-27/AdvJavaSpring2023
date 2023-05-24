import java.awt.Color;

abstract class Shape {
	double x, y;
	Color c;
	boolean fill;
	boolean SHAPE_DEFAULT_FILL = false;
	Color SHAPE_DEFAULT_COLOR = Color.gray;
	boolean SHAPE_SET_FILL = true;
	boolean SHAPE_SET_OUTLINE = false;
	
	Shape() {
		c = SHAPE_DEFAULT_COLOR;
		fill = SHAPE_DEFAULT_FILL;
	}
	
	Color getColor() {
		return c;
	}
	
	void setColor(Color c) {
		this.c = c;
	}
	
	boolean getFill() {
		return fill;
	}
	
	void setFill(boolean f) {
		this.fill = f;
	}
	
	double getX() {
		return x;
	}
	
	double getY() {
		return y;
	}
	
	void setX(double x) {
		this.x = x;
	}
	
	void setY(double y) {
		this.y = y;
	}
	
	double getArea() {
		return x * y;
	}
	
	double getPerimeter() {
		return x + y;
	}
	
	void drawShape() {
		System.out.println("x = " + x + "\ny = " + y + "\nColor = " + c + "\nFill = " + fill + "\n");
	}
}

