package Game.Package.Boss;

import Game.Component.Laser;
import Game.Gameplay.Current_Time;

import java.awt.*;

public class BossWeapon extends Laser {

    private Current_Time time = new Current_Time();
    int angle ;
    public BossWeapon(int x , int y , Image laser_img , int velocity){
        super(x,y,laser_img,velocity);
        angle=x;
        //angle = new Random().nextInt(350)+50;
        //time.setSecond_TIME(0);
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public int getLaserPosY() {
        return super.getLaserPosY();
    }

    @Override
    public int getLaserPosX() {
        return super.getLaserPosX();
    }

    @Override
    public int getLaserVelocity() {
        return super.getLaserVelocity();
    }

    @Override
    public Image getLaserImage() {
        return super.getLaserImage();
    }

    public Current_Time getTime() {
        return time;
    }
    @Override
    public void laser_Move() {
        this.setLaserPosY(getLaserPosY() + getLaserVelocity());

        this.setLaserPosX(angle + getLaserVelocity());
    }



}
