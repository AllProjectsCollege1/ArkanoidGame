package Game.Package.Boss;

import Game.Component.Bricks;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Boss extends Bricks {
    private  int hit_Counter;
    private final Image Boss_Sprite;
    private final int posX;
    private boolean active_weapons = true;
    private BossWeapon weapons ;


    public Boss() {
        super();
        hit_Counter = 25;
        Boss_Sprite = new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\Boss.png").getImage();
        posX = 135;
        super.setDestroy(false);
        weapons = new BossWeapon(new Random().nextInt(400) , super.getBrickPosY() , new ImageIcon("E:\\FCIS Researches\\OOP\\Arkanoid4\\src\\Data\\Images\\Laser_Shoot.png").getImage() , 5);


    }

    @Override
    public void setDestroy(boolean destroy) {
        super.setDestroy(destroy);
    }

    @Override
    public boolean isDestroy() {
        return super.isDestroy();
    }

    @Override
    public void setHitCounter(int hitCounter) {
        this.hit_Counter = hitCounter;
    }

    public int getHit_Counter() {
        return this.hit_Counter;
    }


    public Image getBoss_Sprite() {
        return Boss_Sprite;
    }



    @Override
    public int getBrickPosX() {
        return posX;
    }

    public BossWeapon getWeapons() {
        return weapons;
    }

}
