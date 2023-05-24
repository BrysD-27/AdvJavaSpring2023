public class Rectangle extends Shape {
	double height, width;
	
	public Rectangle(double x, double y, double width, double height) {
		super();
		setX(x);
		setY(y);
		this.height = height;
		this.width = width;
	}
	
	double getArea(){
		return height * width;
	}
	double getPerimeter(){
		return 2 * (height + width);
	}
	
	void drawShape(){
		System.out.println("x = " + x + "\ny = " + y + "\nHeight = " + height + "\nWidth = " + width + "\nColor = " + c + "\nFill = " + fill + "\n");
	}

}