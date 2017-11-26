package Lab2;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Copyright 2017 by Spaceboy. All rights reserved. 
 */

public class Body {
	
	//creating variables
	
	public double x;
	public double y;
	private double vx;
	private double vy;
	private int pixelRadius;
	private double mess;
	private int R;
	private int G;
	private int B;
	
	// creating a constructor method
	public Body(double locationX, double locationY, double velocityX, double velocityY, int radius, double weight) {
		x = locationX;
		y = locationY;
		vx = velocityX;
		vy = velocityY;
		pixelRadius = radius;
		mess = weight;
	}
	
	// creating another constructor method that requires additional arguments of RGB, which represents the color of each solar system.
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
	
	// updating the position of x and y to rotate within time step
	public void updatePosition(double timeStep) {
		x = x + vx * timeStep;
		y = y + vy * timeStep;
	}
	
	// updating the velocity of rotating around the Sun
	public void updateVelocity(double ax, double ay, double timeStep) {
		vx = vx + ax * timeStep;
		vy = vy + ay * timeStep;
	}
	
	// creating a getter for mess
	public double getMess() {
		return mess;
	}
	
	// creating a method that picks the color of each planet and draws a filled circle using pixelsPerMeter
	public void draw(double cx, double cy, double pixelsPerMeter) {
		StdDraw.setPenColor(R, G, B);
		
		StdDraw.filledCircle(cx + x * pixelsPerMeter, cy + y * pixelsPerMeter, pixelRadius);
	}
	
}
