
import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;

public class Pong {

	public static void ponggame(){
		CanvasSize();
		game(30, 482, 440, 75, 20, 80, 252 , 252, 10);

	}
	public static void CanvasSize(){
		StdDraw.setXscale(0,512);
		StdDraw.setYscale(0,512);

	}

	public static void game (int leftX, int rightX, int leftY, int rightY, int HalfW, int HalfH,int xBall, int yBall, int radius){
		double v_x = -2;
		double v_y = 2;
		boolean Game = true;
		int Red = 20;
		int Blue = 200;
		int Green = 10;




		while (Game){

			StdDraw.clear();
			StdDraw.clear(StdDraw.BLACK);
			StdDraw.setPenColor(Red, Green, Blue);
			StdDraw.filledCircle( xBall, yBall, radius);

			StdDraw.setPenColor(Color.WHITE);
			StdDraw.filledRectangle(leftX, leftY, HalfW, HalfH); //the left bar
			StdDraw.filledRectangle(rightX, rightY, HalfW, HalfH);//the right bar
			xBall +=v_x;
			yBall +=v_y;

			//makes the left bar go up if the "A" key is being pressed
			if (StdDraw.isKeyPressed(65)){
				leftY = leftY+1;
			} 

			//if the y value of the left bar is greater than 440 y will equal 440
			//this is to make sure that the left bar doesnt go passed the canvas
			if (leftY>440){
				leftY = 440;
			}

			//makes the left bar go down if you pressed the z key
			else if (StdDraw.isKeyPressed(90)){
				leftY = leftY-1;

			}

			//if the y value gets lower than 80 then the y will equal 80
			//this makes sure that the left bar doesnt go all the way down the canvas
			if (leftY<80){
				leftY = 80;
			}

			//makes the right bar go up by pressing the k key
			else if (StdDraw.isKeyPressed(75)){
				rightY = 1+rightY;

			}

			//if the y1 value of the right bar is left than 75 then the y1 value will equal 75
			//makes sure that the right bar doesnt go all the way down the canvas
			if (rightY<75){
				rightY=75;
			}

			//if you press the m key the right bar will go down
			else if (StdDraw.isKeyPressed(77)){
				rightY = rightY-1;
			} 

			//if the y1 value is greater than 440 than the y1 value will equal 440
			//makes sure that the bar doesnt go all the way up the canvas
			if (rightY>440){
				rightY=440;
			}

			//code for making the ball bounce off the y boundaries
			if(yBall>512){
				v_y=-v_y;
			}
			if (yBall<10){
				v_y=-v_y;
			}

			//Makes the ball bounce of the left paddle
			if(xBall==(leftX+HalfW)&&yBall<=leftY+HalfH&&yBall>=leftY-HalfH){
				v_x=-v_x;
				Red=Red+40;




			} 

			//makes the ball bounce of the right paddle
			if  (xBall==(462)&&yBall<=rightY+HalfH&&yBall>=rightY-HalfH){
				v_x=-v_x;

				Blue=Blue-40;
				Green=50+Green;



			}
			System.out.println(v_x);

			//ends game if the ball touches the x boundaries
			if  (xBall<10 || xBall>512){
				StdDraw.text(256, 400, "Game Over");
				Game=false;
				{
				}
			}

			//Ends the program by pressing q
			if (StdDraw.isKeyPressed(81)){
				System.exit(0);
			}

			//Restarts everything by pressing spacebar
			if(StdDraw.isKeyPressed(32)){
				StdDraw.clear();
				StdDraw.clear(Color.BLACK  );
				xBall=256;
				yBall=256;
				StdDraw.filledCircle(xBall, yBall, radius);
				StdDraw.filledRectangle(leftX, leftY, HalfW, HalfH);
				StdDraw.filledRectangle(rightX, rightY, HalfW, HalfH);
			}

			StdDraw.show(15);


		}

	}







	public static void main(String[] args) {
		ponggame();



	}
}
