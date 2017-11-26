package Lab2;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Copyright 2017 by Spaceboy. All rights reserved. 
 */

public class System {
	
	// creating a Body class arraylist called, "bodies"
	// creating a private type variable for Gravitational constant
	ArrayList<Body> bodies;
	private double G = 6.67384e-11;
	
	// creating a constructor that body type arraylist
	public System(ArrayList<Body> bodyList) {
		bodies = bodyList;
	}
	
	private double[] computeAcceleration(Body b) {
		double ax = 0;
		double ay = 0;
		double dx = 0;
		double dy = 0;
		double a;
		double r = 0;
		for (int i = 0; i < bodies.size(); i++) {
			if (b.equals(bodies.get(i))) {
				continue;
			}
			dx = bodies.get(i).x - b.x;
			dy = bodies.get(i).y - b.y;
			r = Math.sqrt(dx*dx + dy*dy);
			a = G * bodies.get(i).getMess() / (r*r);
			ax += a * dx / r;
			ay += a * dy / r;
		}
		double[] acce = new double[2];
		acce[0] = ax;
		acce[1] = ay;
		
		return acce;
	}
	
	public void update(double timeStep) {
		double[] as;
		for (int i = 0; i < bodies.size(); i++) {
			as = computeAcceleration(bodies.get(i));
			bodies.get(i).updateVelocity(as[0], as[1], timeStep);
			bodies.get(i).updatePosition(timeStep);
		}
	}
	
	public void draw(double cx, double cy, double pixelsPerMeter) {
		StdDraw.clear(StdDraw.BLACK);
		for (int i = 0; i < bodies.size(); i++) {
			bodies.get(i).draw(cx, cy, pixelsPerMeter);
		}
		StdDraw.show(20);
	}
}
