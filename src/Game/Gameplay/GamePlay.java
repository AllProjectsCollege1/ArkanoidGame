package Game.Gameplay;

import Game.Component.Board;
import Game.Component.PowerUPs;
import Game.Component.ShootGun;
import Game.Windows.MainClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GamePlay extends JPanel  {


    //Actions
    private static Actions actions = new Actions();


    private static boolean is_Playing = false;
    private static int number_of_level = 16;
    private static boolean finish_game = false;
    private static PowerUPs power = new PowerUPs();
    private static Timer timer = new Timer(5,actions);


    JButton PauseB = new JButton(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\Menu\\Pause.png"));


    private static ShootGun shot_gun;

    public GamePlay() {

        PauseB.setBounds(700,500,40,40);
        shot_gun=new ShootGun();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);


        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);


        g.setColor(Color.black);
        g.fillRect(0,0,800,600);


        //HighScore
        g.setColor(Color.decode("#d4af37"));
        g.setFont(new Font("Arkanoid Solid", Font.PLAIN, 25));
        g.drawString("HIGH SCORE", 520, 50);

        g.setColor(Color.decode("#d4af37"));
        g.setFont(new Font("Haettenschweiler", Font.PLAIN, 50));
        g.drawString(""+Player.getHigh_Score(), 565, 95);


        //Current Score
        g.setColor(Color.decode("#dc214e"));
        g.setFont(new Font("Arkanoid Solid", Font.PLAIN, 25));
        g.drawString("SCORE", 520, 215);


        g.setColor(Color.decode("#d4af37"));
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("Shoot Gun : ", 520, 290);
        g.setColor(Color.decode("#f5f5f5"));
        g.drawString(""+shot_gun.getNumberShoot() ,670 ,290);

        g.setColor(Color.decode("#f5f5f5"));
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString(""+Board.getPlayer().getScore() ,625 ,212);


        //timer
        timer.start();

        this.add(PauseB);


        PauseB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                timer.stop();
                is_Playing = false;
                MainClass.getWindow().drawPause();
            }
        });


        //Draw Board
        Board.draw((Graphics2D) g  , this);

        //Draw Power Up
        if (power.getFall()) {
            g.drawImage(power.getPower_sprite(), power.getPowerPX(), power.getPowerPY(), 22, 11, this);
            power.setPowerPY(power.getPowerPY() + 1);
        }



        g.drawImage(shot_gun.getShootSprite(),shot_gun.getShootPosX(),shot_gun.getShootPosY(),shot_gun.getShootSizeX(),shot_gun.getShootSizeY(),this);
        shot_gun.setShootPosY(shot_gun.getShootPosY()-1);
        //Draw Laser
        //draw laser with paddle
        if(Board.getPaddle().getLaser().isShowLaser()){
            g.drawImage(Board.getPaddle().getLaser().getLaserImage(), Board.getPaddle().getLaser().getLaserPosX(), Board.getPaddle().getLaser().getLaserPosY(), 20,50,this);
        }


        // draw Boss laser
        if(Board.getBoss().getWeapons().isShowLaser()){

            g.drawImage(Board.getBoss().getWeapons().getLaserImage(), Board.getBoss().getWeapons().getLaserPosX(), Board.getBoss().getWeapons().getLaserPosY(), 20, 50, this);
            Board.getBoss().getWeapons().laser_Move();
        }
        else {
            Board.getBoss().getWeapons().setLaserPosY(0);
            Board.getBoss().getWeapons().setAngle(new Random().nextInt(350)+50);

        }



        if(Board.getPaddle().getLifePoint() == 0){
            timer.stop();
            MainClass.getWindow().drawGameOver();
        }
        if(finish_game){
            MainClass.getWindow().drawYouWin();
        }

        if(isIs_Playing()) {
            repaint();
        }
    }





    public static void setNumber_of_level(int number_of_level) {
        GamePlay.number_of_level = number_of_level;
    }

    public static int getNumber_of_level() {
        return number_of_level;
    }

    public static boolean isIs_Playing() {
        return is_Playing;
    }

    public static void setIs_Playing(boolean is_Playing) {
        GamePlay.is_Playing = is_Playing;
    }

    public static PowerUPs getPower() {
        return power;
    }

    public static void setPower(PowerUPs power) {
        GamePlay.power = power;
    }

    public static void setFinish_game(boolean finish_game) {
        GamePlay.finish_game = finish_game;
    }


    public static ShootGun Get_Shot_gun() {
        return shot_gun;
    }

    public static Timer getTimer() {
        return timer;
    }
}
