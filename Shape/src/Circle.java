public class Circle extends Ellipse {
	
	Circle(double x, double y, double r) {
		super(x, y, r, r);
	}
	
	double getPerimeter(){
		return 2*Math.PI*radius1;
	}

}