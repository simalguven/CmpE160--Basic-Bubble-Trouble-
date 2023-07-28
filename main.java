import java.awt.event.KeyEvent;
//simal guven 2021400153 17/04/2023

public class simal_guven {
    public static void main(String[] args) {
        while(Bar.flag) {
            StdDraw.enableDoubleBuffering();// for faster animations
            Environment.show();
            // everytime show() main function is called it finishes with flag = false

            while (true) {//loop that is constantly iterating - cannot calculate exact time when Y or N would be clicked, constantly check it
                if (StdDraw.isKeyPressed(KeyEvent.VK_Y)) {
                    Bar.flag = true;//make flag true and break the loop, call show() function again
                    Environment.startTime = System.currentTimeMillis();// time bar should start from the beginning after every replay
                    Player.x_player = 8;// player's initial position is set after replay
                    Player.y_player = 5.0/8.0;// player's initial position is set after replay
                    break;
                }

                if (StdDraw.isKeyPressed(KeyEvent.VK_N)) {
                    System.exit(0);// exit if N is pressed
                }

            }

        }

    }
}
