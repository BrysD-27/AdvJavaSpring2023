
public class TestShape {
	public static void main(String[] args) {

		Shape s = new Rectangle(2, 3, 2, 2);
		s.drawShape();
		
		s = new Square(2, 3, 4);
		s.drawShape();
	
		s = new Ellipse(2, 3, 2, 2);
		s.drawShape();
		
		s = new Circle(2, 3, 2);
		s.drawShape();
		
		s = new Triangle(2, 3, 4, 2, 3);
		s.drawShape();
	}
}
