import java.awt.event.KeyEvent;
//simal guven 2021400153 17/04/2023

public class Arrow {
    public static double arrow_x;
    public static double spacebarClickedTime;
    public static boolean active = false;//initially arrow is not active
    public static void isactive() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)&&!active) {//arrow can be activated only when key is pressed and arrow is not currently active-only one arrow can be created at the same time
            active = true;//activate the arrow so another arrow cannot be created
            spacebarClickedTime = System.currentTimeMillis();//getting the exact time of activation of the arrow
            arrow_x = Player.x_player;// set the arrows initial x position to the player's position at exact time space key was pressed
        }
        if(System.currentTimeMillis()-spacebarClickedTime>=1500){
            active= false;//arrow become inactive-period of the arrow has been reached-arrow reach the upper border of the canvas
            spacebarClickedTime = 0;//clear previously set clicked time to generate new arrows with new click times
        }
        if(active){
            double time = System.currentTimeMillis();//get current time
            double passed_time = time - spacebarClickedTime;//calculate passed time(increasing) with respect to the time space bar was clicked(was activated)

            StdDraw.picture(arrow_x,9*passed_time/3000, "arrow.png",0.2,9*passed_time/1500 );// 9/1500 = scaleY/period of the arrow = speed of the arrow

        }

    }


}




