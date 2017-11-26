
/**
 * Copyright 2017 by Spaceboy. All rights reserved. 
 */

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveTree {
	public static int count = 0;

	public static void tree(int order, double x0, double y0, double x1, double y1, int branch, double pw) {
		
		if (order <= 2) {
			double length = Math.sqrt((x0-x1)*(x0-x1) + (y0-y1)*(y0-y1));
			double angle;
			if (Math.abs(x1 - x0) < 0.0001) {
				angle = Math.PI / 2;
				if (y1 > y0) {
					angle = Math.PI / 2;
				} else {
					angle = Math.PI * 3 / 2;
				}
			} else {
				angle = Math.atan2((y1-y0), (x1-x0));
				if (angle < 0) {
					angle += Math.PI * 2;
				}
			}
			double step = (Math.PI / 2) / (branch-1);
			double left = angle + Math.PI / 4;
			double x2, y2;
			StdDraw.setPenRadius(pw * 0.7);
			StdDraw.setPenColor(StdDraw.GREEN);
			for (int i = 0; i < branch; i++) {
				x2 = x1 + length * 0.7 * Math.cos(left - step * i);
				y2 = y1 + length * 0.7 * Math.sin(left - step * i);
//				System.out.println(Double.toString(angle) + ", " + Double.toString(left) + ", " + Double.toString(step));
//				System.out.println(Double.toString(x2) + ", " + Double.toString(y2));
				StdDraw.line(x1, y1, x2, y2);
			}
//			StdDraw.setPenColor(StdDraw.GRAY);
//			StdDraw.setPenRadius(pw);
			return;
		}
		
		double length = Math.sqrt((x0-x1)*(x0-x1) + (y0-y1)*(y0-y1));
		double angle;
		if (Math.abs(x1 - x0) < 0.0001) {
			if (y1 > y0) {
				angle = Math.PI / 2;
			} else {
				angle = Math.PI * 3 / 2;
			}
		} else {
			angle = Math.atan2((y1-y0), (x1-x0));
			if (angle < 0) {
				angle += Math.PI * 2;
			}
		}
		double step = (Math.PI / 2) / (branch-1);
		double left = angle + Math.PI / 4;
//		left most is addition to 45 degree, which is pi / 4
//		do something, draw all trunks
		double x2, y2;
		double width = pw * 0.7;
		for (int i = 0; i < branch; i++) {
			x2 = x1 + length * 0.7 * Math.cos(left - step * i);
			y2 = y1 + length * 0.7 * Math.sin(left - step * i);
			StdDraw.setPenRadius(width);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.line(x1, y1, x2, y2);
			tree(order - 1, x1, y1, x2, y2, branch, width);
		}
		
		return ;
	}
	
	public static void main(String[] args) {
		int width = 800;
		int height = 800;
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, 800);
		StdDraw.setYscale(0, 800);
		StdDraw.setPenRadius(0.03);
		StdDraw.setPenColor(StdDraw.GRAY);
		count = 0;
		StdDraw.line(400, 200, 400, 400);
		
		tree(5, 400, 200, 400, 400, 7, 0.03);
		StdDraw.show();
	}
}
