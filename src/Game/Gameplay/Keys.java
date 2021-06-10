package Game.Gameplay;

import Game.Component.Board;
import Game.Windows.MainClass;
import Game.Windows.MainWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener {


    @Override
    public void keyPressed(KeyEvent e) {

        if(MainWindow.isGamePlayActive()) {

            if (e.getKeyCode() == KeyEvent.VK_A) {
                if(GamePlay.isIs_Playing()) {
                    if (!GamePlay.Get_Shot_gun().getShoot() && GamePlay.Get_Shot_gun().getWork() && GamePlay.Get_Shot_gun().getNumberShoot() > 0) {
                        GamePlay.Get_Shot_gun().setShootPosX(Board.getPaddle().getPaddleX() + Board.getPaddle().getPaddleLong() / 2);
                        GamePlay.Get_Shot_gun().setShootPosY(Board.getPaddle().getPaddleY());
                        GamePlay.Get_Shot_gun().setShoot(true);
                    }
                }

            }


            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (!GamePlay.isIs_Playing()) {
                    if (Board.getPaddle().getPaddleX() >= 370) {
                        Board.getPaddle().setPaddleX(370);
                    } else {
                        Board.getPaddle().moveRight();
                        Board.getBall().setBallPosX(Board.getBall().getBallPosX() + 20);

                    }
                }

                if (GamePlay.isIs_Playing()) {
                    if (Board.getPaddle().getPaddleX() >= 370) {
                        Board.getPaddle().setPaddleX(370);
                    } else {
                        Board.getPaddle().moveRight();
                    }
                    if (Board.getPaddle().isPaddleGetLong()) {
                        if (Board.getPaddle().getPaddleX() >= 320) {
                            Board.getPaddle().setPaddleX(320);
                        } else {
                            Board.getPaddle().moveRight();
                        }
                    }
                }

                MainClass.getWindow().repaint();
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (!GamePlay.isIs_Playing()) {
                    if (Board.getPaddle().getPaddleX() <= 25) {
                        Board.getPaddle().setPaddleX(25);

                    } else {
                        Board.getPaddle().moveLeft();
                        Board.getBall().setBallPosX(Board.getBall().getBallPosX() - 20);

                    }
                }
                if (GamePlay.isIs_Playing()) {
                    if (Board.getPaddle().getPaddleX() <= 25) {
                        Board.getPaddle().setPaddleX(25);

                    } else {
                        Board.getPaddle().moveLeft();
                    }
                }

                MainClass.getWindow().repaint();
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (Board.getPaddle().getLifePoint() > 0) {
                    if (!GamePlay.isIs_Playing()) {
                        System.out.println(0);
                        GamePlay.setIs_Playing(true);
                    }

                    MainClass.getWindow().repaint();
                }

            }

            if (e.getKeyCode() == KeyEvent.VK_Z) {
                if (GamePlay.isIs_Playing()) {
                    /////////// laser movement
                    if (Board.getPaddle().getLaser().isPaddleGetLaser()) {
                        if (!Board.getPaddle().getLaser().isKeyLaserPressed()) {
                            Board.getPaddle().getLaser().setKeyLaserPressed(true);

                            Board.getPaddle().getLaser().setLaserPosY(Board.getPaddle().getPaddleY());
                            Board.getPaddle().getLaser().setLaserPosX(Board.getPaddle().getPaddleX() + 50);
                        }
                    }
                }
                MainClass.getWindow().repaint();
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}



}
