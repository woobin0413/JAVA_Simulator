package Lab2;

import edu.princeton.cs.introcs.StdDraw;

public class Body {
	public double x;
	public double y;
	private double vx;
	private double vy;
	private int pixelRadius;
	private double mess;
	private int R;
	private int G;
	private int B;
	
	public Body(double locationX, double locationY, double velocityX, double velocityY, int radius, double weight) {
		x = locationX;
		y = locationY;
		vx = velocityX;
		vy = velocityY;
		pixelRadius = radius;
		mess = weight;
	}
	
	public Body(double locationX, double locationY, double velocityX, double velocityY, int radius, double weight, int r, int g, int b) {
		x = locationX;
		y = locationY;
		vx = velocityX;
		vy = velocityY;
		pixelRadius = radius;
		mess = weight;
		R = r;
		G = g;
		B = b;
	}
	
	public void updatePosition(double timeStep) {
		x = x + vx * timeStep;
		y = y + vy * timeStep;
	}
	
	public void updateVelocity(double ax, double ay, double timeStep) {
		vx = vx + ax * timeStep;
		vy = vy + ay * timeStep;
	}
	
	public double getMess() {
		return mess;
	}
	
	public void draw(double cx, double cy, double pixelsPerMeter) {
		StdDraw.setPenColor(R, G, B);
		
		StdDraw.filledCircle(cx + x * pixelsPerMeter, cy + y * pixelsPerMeter, pixelRadius);
	}
	
}
