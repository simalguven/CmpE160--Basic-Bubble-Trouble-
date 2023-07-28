import java.awt.event.KeyEvent;
//simal guven 2021400153 17/04/2023

public class Player {
    public static double x_player = 8;//initial x_position of the player (scaleX/2)
    public static double y_player =  5.0/8.0;//initial y_position of the player (calculated with its scaledHeight and scaleY of the canvas)
    public static final double playerHalfDiagonal = 0.3845;// player's half diagonal length used for ball-player collisions(calculated with player's scaledWidth and scaledHeight)

    public static void display_player(){// called in the main animation loop-displaying the player with its updated positions

        if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)&&x_player>=0.41){//0.41= half of its width//updating the position only when there is space left to go in the left border

            x_player = x_player- 0.1;//position is updated-related to the player's speed (0.1)
        }
        if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)&&x_player<=15.59){//15.59 = scaleX- half of its width//updating the position only when there is space left to go in the right border

            x_player = x_player+ 0.1;//position is updated-related to the player's speed (0.1)
        }
        StdDraw.picture(x_player,y_player,"player_back.png",0.821,1.125);// displaying the player with its updated coordinates

    }


}

