//simal guven 2021400153 17/04/2023
public class Ball {
    public static double radiusMultiplier = 2.0;//suggested constant
    public static double minPossibleRadius = Environment.scaleY*0.0175;//suggested constant
    public static double gravity = 0.0024;//my constant-via trial and error
    private  double vy;
    private  double vx;
    private  double x;
    private  double y;
    private  double radius;
    public Ball(){
        //Default constructor
    }
    public Ball(int ball_level,double x,double y,double vx,double radius){
        this.radius= radius;//equalizing private radius variable of the current Ball object to the radius parameter the current Ball object instance gives
        this.y =y;//equalizing private y_position variable of the current Ball object to the y_position parameter the current Ball object instance gives
        this.x =x;//equalizing private x_position variable of the current Ball object to the x_position parameter the current Ball object instance gives
        this.vx= vx;//equalizing private vx variable of the current Ball object to the vx parameter the current Ball object instance gives
        if (ball_level==0){//smaller ball smaller initial_vy
            this.vy=0.12;//my constant - via trial and error-//equalizing private vy variable of the current Ball object to the vy parameter the current Ball object instance gives
        }
        if (ball_level==1){
            this.vy=0.14;//my constant - via trial and error-//equalizing private vy variable of the current Ball object to the vy parameter the current Ball object instance gives
        }
        if (ball_level==2){
            this.vy=0.16;//my constant - via trial and error-//equalizing private vy variable of the current Ball object to the vy parameter the current Ball object instance gives
        }

    }

    public void ball_movement(){
        x += vx;// change x position in every millisecond(at each iteration) by adding the velocity(x_f = x_i + vx*time_passed since time_passed = 1 ....)
        y += vy;// change y position in every millisecond(at each iteration) by adding the velocity(y_f = y_i + vy*time_passed since time_passed = 1 ....)
        vy -= gravity;//vy decreases as equal to the amount of gravity in every millisecond(at each iteration)
        if(x+ radius > Environment.scaleX){//doing elastic collision with the right border of the canvas
            x = Environment.scaleX-radius;// x_position of the current ball can maximum be scaleX- its current radius, make it equal to it just for a moment and then main animation loop will continue changing it
            vx = -Math.abs(vx);//after colliding right border vx should be negative
        }
        if(x- radius <0.0){//doing elastic collision with the left border the canvas
            x =radius;// x_position of the current ball can minimum be its radius, make it equal to it just for a moment and then main animation loop will continue changing it
            vx = Math.abs(vx);//after colliding left border vx should be positive
        }
        if(y - radius<0.0){//doing elastic collision with the bottom ground of the canvas
            y = radius;// y_position of the current ball can minimum be its radius, make it equal to it just for a moment and then main animation loop will continue changing it
            vy = Math.abs(vy);//vy will be always (-) when touching the bottom ground so change its sign(make it positive)
        }
        if(y > radius*4){//to not disappear from the canvas
            y -= Math.abs(vy)/2;//trial and error constants
        }
        StdDraw.picture(x,y,"ball.png",radius*2,radius*2);// showing the picture in the canvas

    }

    public double getX() {//setting a getter to acquire the current value of currently iterated ball's x position (to construct inequalities in Environment)
        return x;
    }

    public double getY() {//setting a getter to acquire the current value of currently iterated ball's y position (to construct inequalities in Environment)
        return y;
    }

    public double getRadius() {//setting a getter to acquire the value of currently iterated ball's radius (to construct inequalities in Environment)
        return radius;
    }
}
