public class Ellipse extends Shape {
	double radius1,radius2;
	Ellipse(double x,double y,double r1,double r2){
		super();
		setX(x);
		setY(y);
		radius1=r1;
		radius2=r2;
	}
	
	@Override
	double getArea(){
		return Math.PI*radius1*radius2;
	}
	
	@Override
	double getPerimeter() {
		return 2*3.14*Math.sqrt((Math.pow(radius1,2)+Math.pow(radius2,2))/2);
	}
	
	void drawShape(){
		System.out.println("x = "+x+"\ny = "+y+"\nradius1 = "+radius1+"\nraduis2 = "+radius2+"\nColor = "+c+"\nFill = "+fill+"\n");
	}
}