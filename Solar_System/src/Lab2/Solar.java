package Lab2;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class Solar {
	public static double AU = 1.49598e11;
	public static double EM = 5.9736e24;
	public static double SunMess = 1.98892e30;
	
	
	public static void main(String[] args) {
		Body sun = new Body(0, 0, 0, 0, 10, SunMess, 255, 0, 0);
		Body earth = new Body(AU, 0, 0, 29790, 5, EM, 0, 0, 255);
		Body moon = new Body(3.844e8, 0, 0, -1022, 5, 7.3477e22, 255, 255, 255);
		Body mercury = new Body(0.3871 * AU, 0, 0, 48000, 3, 0.055 * EM, 123, 234, 012);		
		Body venus = new Body(0.7233 * AU, 0, 0, 35000, 5, 0.81 * EM, 35, 199, 200);
		Body mars = new Body(1.524 * AU, 0, 0, 24140, 4, 0.108 * EM, 42, 234, 012);
		Body jupiter = new Body(5.203 * AU, 0, 0, 13060, 8, 317.83 * EM, 55, 23, 123);
		Body satum = new Body(9.539 * AU, 0, 0, 9640, 8, 95 * EM, 244, 100, 012);
		Body uranus = new Body(19.19 * AU, 0, 0, 6810, 9, 14.5 * EM, 12, 255, 98);
		Body neptune = new Body(30.06 * AU, 0, 0, 5430, 3, 17.14 * EM, 66, 88, 99);
		
		
		ArrayList<Body> bodies = new ArrayList<Body>();
		bodies.add(sun);
		bodies.add(earth);
		bodies.add(mercury);
		bodies.add(venus);
		bodies.add(mars);
		bodies.add(jupiter);
		bodies.add(satum);
		bodies.add(uranus);
		bodies.add(neptune);
		
		System solar = new System(bodies);
		double timeStep = 5000000 / 50;
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 400);
		StdDraw.setYscale(0, 400);
		while (true) {
			solar.update(timeStep);
			solar.draw(200, 200, 5/1e10);
		}
	}
	
}
