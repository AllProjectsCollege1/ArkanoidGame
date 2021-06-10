package Game.Component;

import Game.Gameplay.BricksPatternInLevels;
import Game.Gameplay.GamePlay;
import Game.Gameplay.Player;
import Game.Package.Boss.Boss;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Board  {

    private static Player player = new Player("");
    private static Paddle paddle = new Paddle();
    private static Ball ball = new Ball();
    private static Enemies enemies = new Enemies(new Random().nextInt(2) + 1);
    private static Boss boss = new Boss();



    public static void draw (Graphics2D g , JPanel panel) {

        //
        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);
        //


        g.drawImage(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\Backgrounds\\Blue.png").getImage(), 5, 12, 490, 600, panel);

        g.drawImage(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\Board-Img.png").getImage(), 0, 0, 500, 600, panel);
        //Draw Pattern
        switch (GamePlay.getNumber_of_level()) {

            case 1:
                BricksPatternInLevels.level1_display(g, panel);
                break;
            case 2:
                BricksPatternInLevels.level2_display(g, panel);
                break;
            case 3:
                BricksPatternInLevels.level3_display(g, panel);
                break;
            case 4:
                BricksPatternInLevels.level4_display(g, panel);
                break;
            case 5:
                BricksPatternInLevels.level5_display(g, panel);
                break;
            case 6:
                BricksPatternInLevels.level6_display(g, panel);
                break;
            case 7:
                BricksPatternInLevels.level7_display(g, panel);
                break;
            case 8:
                BricksPatternInLevels.level8_display(g, panel);
                break;
            case 9:
                BricksPatternInLevels.level9_display(g, panel);
                break;
            case 10:
                BricksPatternInLevels.level10_display(g, panel);
                break;
            case 11:
                BricksPatternInLevels.level11_display(g, panel);
                break;
            case 12:
                BricksPatternInLevels.level12_display(g, panel);
                break;
            case 13:
                BricksPatternInLevels.level13_display(g, panel);
                break;
            case 14:
                BricksPatternInLevels.level14_display(g, panel);
                break;
            case 15:
                BricksPatternInLevels.level15_display(g, panel);
                break;
            case 16:
                if(boss.getHit_Counter()>0) {
                    g.drawImage(boss.getBoss_Sprite(), boss.getBrickPosX(), 50, 220, 300, panel);
                }
                break;
        }


        //Draw Paddle

        if (!paddle.getLaser().isPaddleGetLaser()){
            g.drawImage(paddle.getPaddleSprite(), paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleLong(), paddle.getPaddleHeight(), panel);}
        else if(paddle.getLaser().isPaddleGetLaser()){
            g.drawImage(paddle.getLaser().getPaddleLaserImg(), paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleLong(), paddle.getPaddleHeight(), panel);
        }
        //Draw Ball
        g.drawImage(ball.getBallSprite(), ball.getBallPosX(), ball.getBallPosY(), ball.getBallSizeX(), ball.getBallSizeY(), panel);


        //draw Sides
        g.drawImage(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\side2.png").getImage(), 29, 3, 111, 18, panel);

        g.drawImage(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\side2.png").getImage(), 360, 4, 110, 18, panel);

        if(GamePlay.getNumber_of_level() <16)
        //draw Enemies
        // draw enemy&bullets
        if (enemies.getEnemiesTimer().getSecond_TIME() <= 30) {
            if (enemies.getEnemiesID() == 1)
            {
                g.drawImage(enemies.getEnemyWeapon().getWeaponImage(), enemies.getEnemyWeapon().getBulletsPosX(), enemies.getEnemyWeapon().getBulletsPosY(), 20, 20, panel);
            }

            g.drawImage(enemies.getEnemiesImage(), enemies.EnemiesGetPosX(), enemies.EnemiesGetPosY(), 37, 44, panel);
        }



        //LifePoints
        g.setColor(Color.decode("#1cf4a2"));
        g.setFont(new Font("Arkanoid Solid", Font.PLAIN, 25));
        g.drawString("LIFE POINTS", 520, 340);
        for (int i = 0; i < paddle.getLifePoint(); i++) {
            g.drawImage(paddle.getPaddleSprite(), 490 + (i + 1) * 30, 350, 30, 7, panel);
        }


    }

    public static Paddle getPaddle() {
        return paddle;
    }

    public static Ball getBall() {
        return ball;
    }

    public static Player getPlayer() {
        return player;
    }
    // enemy's functions
    public static Enemies getEnemies() {
        return enemies;
    }

  public static void enemiesNormStat(){
      int random_number_of_enemy = new Random().nextInt(2) + 1;
      Board.getEnemies().setEnemiesID(random_number_of_enemy);
      Board.getEnemies().setEnemiesImage(random_number_of_enemy);
      Board.getEnemies().setEnemiesPosX(400);
      Board.getEnemies().setEnemiesPosY(25);
      Board.getEnemies().getEnemyWeapon().setBulletsPosX(415);
      Board.getEnemies().getEnemyWeapon().setBulletsPosY(28);
      Board.getEnemies().getEnemiesTimer().setSecond_TIME(0);

  }

    public static Boss getBoss() {
        return boss;
    }


}
