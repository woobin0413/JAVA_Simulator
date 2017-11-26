package Lab2;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class EarthMoon {
	public static double AU = 1.49598e11;
	public static double EM = 5.9736e24;
	public static double SunMess = 1.98892e30;
	
	
	public static void main(String[] args) {
		Body earth = new Body(0, 0, 0, 0, 20, EM, 0, 0, 255);
		Body moon = new Body(3.844e8, 0, 0, -1022, 5, 7.3477e22, 255, 255, 255);
		
		ArrayList<Body> bodies = new ArrayList<Body>();
		bodies.add(earth);
		bodies.add(moon);
		System earthMoon = new System(bodies);
		double timeStep = 100000 / 50;
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0, 400);
		StdDraw.setYscale(0, 400);
		while (true) {
			earthMoon.update(timeStep);
			earthMoon.draw(200, 200, 3/1e7);
		}
	}
	
}
