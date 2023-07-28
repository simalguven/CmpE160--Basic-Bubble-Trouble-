//simal guven 2021400153 17/04/2023
public class Bar {
    public static boolean flag = true;//flag starts true and is false when game duration is passed, every ball is popped, or player interacted with the ball
    public static void draw_bar(){// called in the main animation loop for decreasing time animation-simple rectangle is used
        double start_time = System.currentTimeMillis();//getting current computer time everytime when method is called
        double passed_time = start_time - Environment.startTime;//calculating the time difference-updated at every iteration
        StdDraw.picture(8, -0.5,"bar.png");// does not change location, stable
        if(passed_time<=Environment.totalGameDuration){// if passed time is in the total game time limits
            StdDraw.setPenColor(225, (int) (225-(225*passed_time/40000)),0);//time bar goes yellow to red with correct proportion
            StdDraw.filledRectangle((16-(16*passed_time/40000))/2, -0.5, (16-(16*passed_time/40000))/2, 0.25);//x_coordinate goes from scaleX to 0 with correct proportion and its halfWidth exactly equals its x coordinate at all times because of the shape rectangle

        }else{
            Environment.prompt("Game Over!");//passed time is not in the total game time limits
            flag = false;//terminate form the main animation loop-occurs when all balls have not been popped and player not collided with a ball-

        }










    }
}
