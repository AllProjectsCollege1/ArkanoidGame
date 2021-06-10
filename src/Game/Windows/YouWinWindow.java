package Game.Windows;

import Game.Component.Board;
import Game.Gameplay.BricksPatternInLevels;
import Game.Gameplay.Current_Time;
import Game.Gameplay.GamePlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YouWinWindow extends JPanel implements ActionListener {


    Current_Time timer = new Current_Time();

    public YouWinWindow(){
        timer.setSecond_TIME(0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);

        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.white);
        g.setFont(new Font("Arkanoid Solid", Font.PLAIN, 50));
        g.drawString("You Win", 250, 300);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arkanoid Solid", Font.PLAIN, 35));
        g.drawString("Your HighScore", 240, 350);

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString(String.valueOf(Board.getPlayer().getScore()), 350, 390);


        if(timer.getSecond_TIME() > 3){
            MainWindow.setGamePlayActive(false);
            Board.getPaddle().setLifePoint(3);
            Board.getEnemies().setEnemiesPosX(400);
            Board.getEnemies().setEnemiesPosY(25);
            GamePlay.Get_Shot_gun().setShootPosX(10000);
            Board.getEnemies().getEnemyWeapon().setBulletsPosX(Board.getEnemies().EnemiesGetPosX());
            Board.getEnemies().getEnemyWeapon().setBulletsPosY(Board.getEnemies().EnemiesGetPosY());
            GamePlay.getPower().setFall(false);
            GamePlay.Get_Shot_gun().setNumberShoot(5);
            BricksPatternInLevels.setBasicPatterns();
            GamePlay.setIs_Playing(false);
            GamePlay.setFinish_game(false);
            GamePlay.setNumber_of_level(1);
            MainClass.getWindow().drawEnterName();
        }
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
