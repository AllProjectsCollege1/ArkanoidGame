package Game.Windows;

import Game.Component.Board;
import Game.Gameplay.BricksPatternInLevels;
import Game.Gameplay.GamePlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseMenuWindow extends JPanel {

    JButton BackB = new JButton(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\Menu\\Resume.png"));
    JButton exitB = new JButton(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\Menu\\EXIT.png"));

    public PauseMenuWindow(){
        BackB.setBounds(295,250,190,65);
        exitB.setBounds(295, 350, 190, 65);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);

        g.setColor(Color.black);
        g.fillRect(0,0,800,600);


        this.add(BackB);
        this.add(exitB);


        BackB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainClass.getWindow().drawGamePlay();
            }

        });

        exitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.setGamePlayActive(false);
                Board.getPlayer().setScore(0);
                Board.getPaddle().setLifePoint(3);
                Board.getEnemies().setEnemiesPosX(400);
                Board.getEnemies().setEnemiesPosY(25);
                Board.getPaddle().getLaser().setPaddleGetLaser(false);
                Board.getPaddle().getLaser().setKeyLaserPressed(false);
                GamePlay.Get_Shot_gun().setWork(false);
                GamePlay.setIs_Playing(false);
                Board.getPaddle().setPaddleX(170);
                Board.getPaddle().setPaddleY(520);
                Board.getBall().setBallPosX(Board.getPaddle().getPaddleX() + Board.getPaddle().getPaddleX() / 4);
                Board.getBall().setBallPosY(Board.getPaddle().getPaddleY() - 15);
                Board.getPaddle().setPaddleLong(100);
                Board.getPaddle().paddleGetNormal();
                Board.getBall().ballGetNormal();
                Board.getEnemies().getEnemyWeapon().setBulletsPosX(Board.getEnemies().EnemiesGetPosX());
                Board.getEnemies().getEnemyWeapon().setBulletsPosY(Board.getEnemies().EnemiesGetPosY());
                GamePlay.Get_Shot_gun().setShootPosX(10000);
                GamePlay.getPower().setFall(false);
                GamePlay.Get_Shot_gun().setNumberShoot(5);
                BricksPatternInLevels.setBasicPatterns();
                GamePlay.setIs_Playing(false);
                GamePlay.setFinish_game(false);
                GamePlay.setNumber_of_level(1);
                MainClass.getWindow().drawMenu();
            }

        });

    }


}
