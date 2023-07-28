import java.awt.*;
import java.util.ArrayList;
//simal guven 2021400153 17/04/2023

public class Environment {
    public static int canvasWidth = 800;//initializing canvas
    public static int canvasHeight = 500;//initializing canvas
    public static int totalGameDuration = 40000;//total duration of one game
    public static double startTime = System.currentTimeMillis() ; // starting time
    public static int pauseDuration = 15;
    public static double scaleY = 9.0;//initializing canvas
    public static double scaleX = 16.0;//initializing canvas
    public static void prompt(String str){//called everytime when flag becomes false, in other words, after everytime game has ended
        StdDraw.picture(Environment.scaleX/2, Environment.scaleY/2.18,"game_screen.png", Environment.scaleX/3.8, Environment.scaleY/4);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(new Font("Helvetica", Font.BOLD, 30));
        StdDraw.text(Environment.scaleX/2, Environment.scaleY/2.0,str);// only game over/ you won changes
        StdDraw.setFont(new Font("Helvetica", Font.ITALIC, 15));
        StdDraw.text(Environment.scaleX/2, Environment.scaleY/2.3,"To Replay Click 'Y'");
        StdDraw.text(Environment.scaleX/2, Environment.scaleY/2.6,"To Quit Click 'N'");

    }

    public static void show(){//main method where the game is played


        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0.0, scaleX);
        StdDraw.setYscale(-1.0,scaleY);
        Ball ball0 = new Ball(0, Environment.scaleX/4, 0.5,16.0/500, Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,0));//initial balls of the game-exactly the same in each replayed game
        Ball ball1 = new Ball(1, Environment.scaleX/3, 0.5,-16.0/500,Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,1));//initial balls of the game-exactly the same in each replayed game
        Ball ball2 = new Ball(2, Environment.scaleX/4,0.5,16.0/500,Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,2));//initial balls of the game-exactly the same in each replayed game
        ArrayList<Ball> ballArrayList= new ArrayList<Ball>();//initial arraylist that contains 3 initial balls in the beginning of every replayed game
        ballArrayList.add(ball0);//adding initial balls to the list
        ballArrayList.add(ball1);//adding initial balls to the list
        ballArrayList.add(ball2);//adding initial balls to the list



        do {// main animation loop

            StdDraw.picture(8.0, 5, "background.png", 16 , 10);//setting the background in order
            Bar.draw_bar();//setting the background in order
            Arrow.isactive();// setting the background in order - arrow before player
            Player.display_player();// setting the background in order

            if(ballArrayList.size()==0){// checking the updated ballArrayList in the beginning of every iteration
                Bar.flag=false;// if no balls left to pop terminate the loop
                prompt("You Won!");

            }

            double time = System.currentTimeMillis();//taken to update arrow's scaled-height in order to check ball-arrow intersections
            double passed_time = time - Arrow.spacebarClickedTime;//calculated to update arrow's scaled-height in order to check ball-arrow intersections
            for(Ball ball : ballArrayList){// iterate inside ballArrayList -iterating inside the main iteration-every iteration represents one specific ball's movement-inside current ballArrayList
                ball.ball_movement();//showing its current position
                if(ball.getRadius()==Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,0)){//if the ball we currently iterate is level0
                    double max= (Player.playerHalfDiagonal+Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,0));//max possible distance ball can have to the player without colliding it is diagonal length plus radius
                    double distance= Math.sqrt(Math.pow(ball.getX()-Player.x_player,2)+Math.pow(ball.getY()-Player.y_player,2));// current distance in current positions of ball and the player
                    if(distance<=max){//detects ball-player collision
                        Bar.flag=false;// if ball has collided with the player terminate the loop
                        prompt("Game Over!");

                    }

                }
                if(ball.getRadius()==Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,1)){//if the ball we currently iterate is level1
                    double max= (Player.playerHalfDiagonal+Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,1));//max possible distance ball can have to the player without colliding it is diagonal length plus radius
                    double distance= Math.sqrt(Math.pow(ball.getX()-Player.x_player,2)+Math.pow(ball.getY()-Player.y_player,2));// current distance in current positions of ball and the player
                    if(distance<=max){//detects ball-player collision
                        Bar.flag=false;// if ball has collided with the player terminate the loop
                        prompt("Game Over!");

                    }

                }
                if(ball.getRadius()==Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,2)){//if the ball we currently iterate is level2
                    double max= (Player.playerHalfDiagonal+Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,2));//max possible distance ball can have to the player without colliding it is diagonal length plus radius
                    double distance= Math.sqrt(Math.pow(ball.getX()-Player.x_player,2)+Math.pow(ball.getY()-Player.y_player,2));// current distance in current positions of ball and the player
                    if(distance<=max){//detects ball-player collision
                        Bar.flag= false;// if ball has collided with the player terminate the loop
                        prompt("Game Over!");



                    }

                }

                if(Math.abs(Arrow.arrow_x-ball.getX())<=ball.getRadius() && ball.getY()-9*passed_time/1500 <= ball.getRadius()){//9*passed_time/1500 equals arrow's scaledHeight related to passed_time
                    Arrow.arrow_x=-1;//until new arrow is created it prevents the location of previous arrow to pop other balls
                    if(ball.getRadius()==Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,0)){//if ball that has intersected with the arrow is level0
                        ballArrayList.remove(ball);//remove the level0 ball-has been popped
                    }
                    if(ball.getRadius()==Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,1)){//if ball that has intersected with the arrow is level1
                        ballArrayList.remove(ball);//remove the level1 ball-has been popped
                        ballArrayList.add(new Ball(0,ball.getX(), ball.getY(), 16.0/500, Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,0)));//create 2 level(1-0) balls with opposite vx
                        ballArrayList.add(new Ball(0,ball.getX(), ball.getY(), -16.0/500, Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,0)));//create 2 level(1-0) balls with opposite vx
                    }
                    if(ball.getRadius()==Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,2)){//if ball that has intersected with the arrow is level2
                        ballArrayList.remove(ball);//remove the level2 ball-has been popped
                        ballArrayList.add(new Ball(1,ball.getX(), ball.getY(), 16.0/500, Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,1)));//create 2 level(2-1) balls with opposite vx
                        ballArrayList.add(new Ball(1,ball.getX(), ball.getY(), -16.0/500, Ball.minPossibleRadius*Math.pow(Ball.radiusMultiplier,1)));//create 2 level(2-1) balls with opposite vx
                    }

                    break;//if a ball-arrow intersection occurred go at the beginning of the iteration with updated ballArrayList-used to exit the loop early
                }

            }

            StdDraw.show();//show in the canvas
            StdDraw.clear();//clear the canvas-will be printed again at each and every iteration
            StdDraw.pause(pauseDuration);


        } while (Bar.flag);// main loop is iterated with boolean flag




    }



}
