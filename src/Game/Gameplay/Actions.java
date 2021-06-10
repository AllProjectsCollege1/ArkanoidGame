package Game.Gameplay;

import Game.Component.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Actions implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

            if (GamePlay.getNumber_of_level() > 0 && GamePlay.getNumber_of_level() <= 16) {

                int[][] Matrix2D = BricksPatternInLevels.getMatrix2D(GamePlay.getNumber_of_level());
                Bricks[][] bricks = BricksPatternInLevels.getBricks();

                int brick_posX = 0;
                int brick_posY = 0;


                Rectangle brickRect;
                Rectangle ballRect = new Rectangle(Board.getBall().getBallPosX(), Board.getBall().getBallPosY(), Board.getBall().getBallSizeX(), Board.getBall().getBallSizeY());
                Rectangle boss_rect = new Rectangle(Board.getBoss().getBrickPosX(), 50, 220, 300);
                Rectangle EnemiesRect = new Rectangle(Board.getEnemies().EnemiesGetPosX(), Board.getEnemies().EnemiesGetPosY(), 37, 36);
                if (GamePlay.isIs_Playing()) {
                    Board.getBall().setBallPosY(Board.getBall().getBallPosY() - Board.getBall().getBallDirY());
                    Board.getBall().setBallPosX(Board.getBall().getBallPosX() - Board.getBall().getBallDirX());

                    ////laser shoot movement
                    if (Board.getPaddle().getLaser().isPaddleGetLaser()) {
                        if (Board.getPaddle().getLaser().isKeyLaserPressed()) {


                            Board.getPaddle().getLaser().setShowLaser(true, 1);
                            Board.getPaddle().getLaser().laser_Move();
                        }
                    }


                    if (GamePlay.getNumber_of_level() < 16) {
                        //Enemies Motion
                        Board.getEnemies().setEnemiesPosX(Board.getEnemies().EnemiesGetPosX() + Board.getEnemies().getEnemiesVelX());
                        Board.getEnemies().setEnemiesPosY(Board.getEnemies().EnemiesGetPosY() + Board.getEnemies().getEnemiesVelY());

                        if (Board.getEnemies().getEnemiesID() == 1)
                            //BulletMotion
                            Board.getEnemies().getEnemyWeapon().setBulletsPosY(Board.getEnemies().getEnemyWeapon().getBulletsPosY() + Board.getEnemies().getEnemyWeapon().getBulletsVelY());
                    }
                    // set enemies to normal state
                    if (Board.getEnemies().getEnemiesTimer().getSecond_TIME() > 30) {
                        int random = new Random().nextInt(10) + 1;
                        if (random == 1) {
                          Board.enemiesNormStat();
                        }
                    }

                    if (new Rectangle(GamePlay.getPower().getPowerPX(), GamePlay.getPower().getPowerPY(), 22, 11).intersects(new Rectangle(Board.getPaddle().getPaddleX(), Board.getPaddle().getPaddleY(), Board.getPaddle().getPaddleLong(), Board.getPaddle().getPaddleHeight()))) {
                        System.out.println("collison");
                        GamePlay.getPower().setPowerPY(900);
                        GamePlay.getPower().getTimer().setSecond_TIME(0);
                        System.out.println(GamePlay.getPower().getTimer().getSecond_TIME());
                        if (GamePlay.getPower().getPowerID() == 1) {
                            Board.getPaddle().powerUpLongPaddle();
                        }
                        if (GamePlay.getPower().getPowerID() == 2) {
                            Board.getPaddle().powerUpShortPaddle();
                        }
                        if (GamePlay.getPower().getPowerID() == 3) {
                            Board.getBall().ballGetBig();
                        }
                        if (GamePlay.getPower().getPowerID() == 4) {
                            Board.getPaddle().lifePointsInc();
                        }
                        if (GamePlay.getPower().getPowerID() == 5) {
                            GamePlay.Get_Shot_gun().setWork(true);
                            int Random_number = new Random().nextInt(5) + 1;
                            GamePlay.Get_Shot_gun().setNumberShoot(Random_number);
                            System.out.println("Total Number Of Shoot Is " + (Random_number + 5));
                        }
                        if (GamePlay.getPower().getPowerID() == 6) {
                            Board.getBall().ballGetSmall();
                        }
                        /////laser power up
                        if (GamePlay.getPower().getPowerID() == 7) {
                            Board.getPaddle().getLaser().setPaddleGetLaser(true);

                        }

                    }


                    if (GamePlay.getPower().getTimer().getSecond_TIME() > 10) {
                        Board.getBall().ballGetNormal();
                        Board.getPaddle().paddleGetNormal();
                        Board.getPaddle().getLaser().setShowLaser(false, 1);
                        Board.getPaddle().getLaser().setKeyLaserPressed(false);
                        Board.getPaddle().getLaser().setPaddleGetLaser(false);


                    }


                    if (GamePlay.getNumber_of_level() < 16) {
                        for (int i = 0; i < Matrix2D.length; i++) {
                            for (int j = 0; j < Matrix2D[0].length; j++) {

                                if (Matrix2D[i][j] >= 1) {
                                    switch (BricksPatternInLevels.getNumber_of_level()) {

                                        case 1:
                                        case 15:
                                            brick_posX = bricks[i][j].getBrickPosX() + 32 * (j) + 15;
                                            brick_posY = bricks[i][j].getBrickPosY() + 16 * (i + 4);

                                            break;
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 14:
                                            brick_posX = bricks[i][j].getBrickPosX() + 32 * (j + 1) + 15;
                                            brick_posY = bricks[i][j].getBrickPosY() + 16 * (i + 4);

                                            break;
                                        case 7:
                                            brick_posX = bricks[i][j].getBrickPosX() + 32 * (j + 3) + 10;
                                            brick_posY = bricks[i][j].getBrickPosY() + 16 * (i + 4);

                                            break;
                                        case 8:
                                            brick_posX = bricks[i][j].getBrickPosX() + 32 * (j + 1) + 68;
                                            brick_posY = bricks[i][j].getBrickPosY() + 16 * (i) + 6;

                                            break;
                                        case 9:
                                            brick_posX = bricks[i][j].getBrickPosX() + 32 * (j + 1) + 50;
                                            brick_posY = bricks[i][j].getBrickPosY() + 16 * (i + 4);

                                            break;
                                        case 10:
                                            brick_posX = bricks[i][j].getBrickPosX() + 32 * (j + 1) + 10;
                                            brick_posY = bricks[i][j].getBrickPosY() + 16 * (i + 4);

                                            break;
                                        case 11:
                                            brick_posX = bricks[i][j].getBrickPosX() + 32 * (j + 1) + 13;
                                            brick_posY = bricks[i][j].getBrickPosY() + 16 * (i + 4);

                                            break;
                                        case 12:
                                            brick_posX = bricks[i][j].getBrickPosX() + 32 * (j) + 16;
                                            brick_posY = bricks[i][j].getBrickPosY() + 16 * (i + 4);

                                            break;
                                        case 13:
                                            brick_posX = bricks[i][j].getBrickPosX() + 32 * (j);
                                            brick_posY = bricks[i][j].getBrickPosY() + 16 * (i + 4);
                                            break;

                                    }
                                    brickRect = new Rectangle(brick_posX, brick_posY, 32, 16);
                                    Rectangle shotRect = new Rectangle(GamePlay.Get_Shot_gun().getShootPosX(), GamePlay.Get_Shot_gun().getShootPosY(), GamePlay.Get_Shot_gun().getShootSizeX(), GamePlay.Get_Shot_gun().getShootSizeY());

                                    if (shotRect.intersects(brickRect)) {


                                        GamePlay.Get_Shot_gun().setShootPosY(-600);
                                        GamePlay.Get_Shot_gun().setShoot(false);
                                        GamePlay.Get_Shot_gun().Decrease_number_shoot();
                                        System.out.println("ahmed");
                                        switch (bricks[i][j].getColorID()) {
                                            case 1:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + GamePlay.getNumber_of_level() * 50);
                                                break;
                                            case 2:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 20);
                                                break;
                                            case 3:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 40);
                                                break;
                                            case 4:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 60);
                                                break;
                                            case 5:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 80);
                                                break;
                                            case 6:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 100);
                                                break;
                                            case 7:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 110);
                                                break;
                                            case 8:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 120);
                                                break;
                                            case 9:
                                                break;

                                        }
                                        if (bricks[i][j].getHitCounter() > 0) {
                                            bricks[i][j].setHitCounter(bricks[i][j].getHitCounter() - 1);
                                        }
                                        if (bricks[i][j].getHitCounter() == 0) {

                                            BricksPatternInLevels.set_Destroy_Matrix2D(Matrix2D, i, j, GamePlay.getNumber_of_level());
                                            bricks[i][j].setDestroy(true);
                                        }
                                    }


                                    if (new Rectangle(Board.getBall().getBallPosX(), Board.getBall().getBallPosY(), Board.getBall().getBallSizeX(), Board.getBall().getBallSizeY()).intersects(brickRect)) {

                                        if (bricks[i][j].getColorID() < 9) {
                                            if (!GamePlay.getPower().getFall()) {
                                                //Get Power Up
                                                int Random_number = new Random().nextInt(20) + 1;
                                                int x;
                                                if (Random_number == 1) {
                                                    x = new Random().nextInt(7) + 1;
                                                    GamePlay.setPower(new PowerUPs(x));
                                                    GamePlay.getPower().setPowerPX(brickRect.x);
                                                    GamePlay.getPower().setPowerPY(ballRect.y);
                                                    GamePlay.getPower().setFall(true);
                                                }
                                            }
                                        }

                                        switch (bricks[i][j].getColorID()) {
                                            case 1:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + GamePlay.getNumber_of_level() * 50);
                                                break;
                                            case 2:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 20);
                                                break;
                                            case 3:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 40);
                                                break;
                                            case 4:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 60);
                                                break;
                                            case 5:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 80);
                                                break;
                                            case 6:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 100);
                                                break;
                                            case 7:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 110);
                                                break;
                                            case 8:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 120);
                                                break;
                                            case 9:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + GamePlay.getNumber_of_level() * 100);
                                                break;

                                        }

                                        if (bricks[i][j].getHitCounter() > 0) {
                                            bricks[i][j].setHitCounter(bricks[i][j].getHitCounter() - 1);
                                        }
                                        if (bricks[i][j].getHitCounter() == 0) {

                                            BricksPatternInLevels.set_Destroy_Matrix2D(Matrix2D, i, j, GamePlay.getNumber_of_level());
                                            bricks[i][j].setDestroy(true);
                                        }

                                        if ((ballRect.x + Board.getBall().getBallRadius() >= brickRect.x) && (ballRect.x + Board.getBall().getBallRadius() <= brickRect.x + 32)) {
                                            Board.getBall().setBallDirY(-Board.getBall().getBallDirY());

                                        } else {
                                            Board.getBall().setBallDirX(-Board.getBall().getBallDirX());
                                        }

                                    }

                                    if (GamePlay.getPower().getFall() && GamePlay.getPower().getPowerPY() > 600) {
                                        GamePlay.getPower().setFall(false);
                                    }
                                    ////////// laser intersection/////////
                                    if (new Rectangle(Board.getPaddle().getLaser().getLaserPosX(), Board.getPaddle().getLaser().getLaserPosY(), 20, 50).intersects(brickRect)) {

                                        switch (bricks[i][j].getColorID()) {
                                            case 1:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + GamePlay.getNumber_of_level() * 50);
                                                break;
                                            case 2:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 20);
                                                break;
                                            case 3:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 40);
                                                break;
                                            case 4:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 60);
                                                break;
                                            case 5:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 80);
                                                break;
                                            case 6:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 100);
                                                break;
                                            case 7:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 110);
                                                break;
                                            case 8:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + 120);
                                                break;
                                            case 9:
                                                Board.getPlayer().setScore(Board.getPlayer().getScore() + GamePlay.getNumber_of_level() * 100);
                                                break;

                                        }
                                        BricksPatternInLevels.set_Destroy_Matrix2D(Matrix2D, i, j, GamePlay.getNumber_of_level());
                                        bricks[i][j].setDestroy(true);
                                    }
                                }
                            }


                            //System.out.println(BricksPatternInLevels.getTotal_number_of_bricks(number_of_level));
                            if (BricksPatternInLevels.getTotal_number_of_bricks(GamePlay.getNumber_of_level()) == 0) {
                                GamePlay.setIs_Playing(false);
                                Board.getPaddle().setPaddleX(170);
                                Board.getPaddle().setPaddleY(520);
                                Board.getBall().setBallPosX(Board.getPaddle().getPaddleX() + Board.getPaddle().getPaddleX() / 4);
                                Board.getBall().setBallPosY(Board.getPaddle().getPaddleY() - 15);
                                GamePlay.setNumber_of_level(GamePlay.getNumber_of_level() + 1);
                            }
                        }
                    } else {

                        System.out.println(Board.getBoss().getHit_Counter());
                        if (new Rectangle(Board.getBall().getBallPosX(), Board.getBall().getBallPosY(), Board.getBall().getBallSizeX(), Board.getBall().getBallSizeY()).intersects(new Rectangle(Board.getBoss().getBrickPosX(), 50, 220, 300))) {
                            Board.getBoss().setHitCounter(Board.getBoss().getHit_Counter() - 1);
                            if (Board.getBoss().getHit_Counter() == 0) {
                                Board.getPlayer().setScore(Board.getPlayer().getScore() * 2);
                                Board.getBoss().setDestroy(true);
                                GamePlay.setFinish_game(true);
                            }

                            if (ballRect.x + Board.getBall().getBallRadius() > boss_rect.x && ballRect.x + Board.getBall().getBallRadius() < boss_rect.x + boss_rect.width) {
                                Board.getBall().setBallDirY(-Board.getBall().getBallDirY());

                            } else {
                                Board.getBall().setBallDirX(-Board.getBall().getBallDirX());
                            }
                        }

                        //laser weapon logic
                        if(Board.getBoss().getWeapons().getTime().getSecond_TIME()>=4){
                            Board.getBoss().getWeapons().setShowLaser(true,2);
                            //Board.getBoss().setBossAttack(true);

                        }
                        else if(Board.getBoss().getWeapons().getTime().getSecond_TIME()<4){
                            Board.getBoss().getWeapons().setShowLaser(false,2);
                            //Board.getBoss().setBossAttack(false);
                        }
                        //////
                        if(Board.getBoss().getWeapons().isShowLaser()){
                            if(Board.getBoss().getWeapons().getLaserPosY()>=Board.getPaddle().getPaddleY()){
                                if(new Rectangle(Board.getBoss().getWeapons().getLaserPosX(),Board.getBoss().getWeapons().getLaserPosY(),20,50).intersects(new Rectangle(Board.getPaddle().getPaddleX(),Board.getPaddle().getPaddleY(), Board.getPaddle().getPaddleLong(), Board.getPaddle().getPaddleHeight()))){
                                    Board.getPlayer().setScore(Board.getPlayer().getScore()-100);
                                    Board.getBoss().getWeapons().setLaserPosY(-1000);
                                    Board.getBoss().getWeapons().getTime().setSecond_TIME(0);
                                }
                                else if(Board.getBoss().getWeapons().getLaserPosY()>=600) {
                                    Board.getBoss().getWeapons().getTime().setSecond_TIME(0);


                                }
                            }
                        }


                    }






                    //top
                    if (Board.getBall().getBallPosY() <= 18) {
                        Board.getBall().setBallDirY(-Board.getBall().getBallDirY());
                    }
                    //right
                    if (Board.getBall().getBallPosX() >= 465) {
                        Board.getBall().setBallDirX(-Board.getBall().getBallDirX());
                    }
                    //left
                    if (Board.getBall().getBallPosX() <= 20) {
                        Board.getBall().setBallDirX(-Board.getBall().getBallDirX());
                    }


                    //Enemies
                    if (Board.getEnemies().EnemiesGetPosY() <= 18) {
                        Board.getEnemies().setEnemiesVelY(-Board.getEnemies().getEnemiesVelY());
                    }

                    if (Board.getEnemies().EnemiesGetPosX() >= 465) {
                        Board.getEnemies().setEnemiesVelX(-Board.getEnemies().getEnemiesVelX());
                    }

                    if (Board.getEnemies().EnemiesGetPosX() <= 20) {
                        Board.getEnemies().setEnemiesVelX(-Board.getEnemies().getEnemiesVelX());
                    }

                    //bullets move
                    if (Board.getEnemies().getEnemyWeapon().getBulletsPosY() > 600) {
                        Board.getEnemies().getEnemyWeapon().setBulletsPosX(Board.getEnemies().EnemiesGetPosX());
                        Board.getEnemies().getEnemyWeapon().setBulletsPosY(Board.getEnemies().EnemiesGetPosY());

                    }
                    //enemies intersect with ball

                    Rectangle ball_rect = new Rectangle(Board.getBall().getBallPosX(), Board.getBall().getBallPosY(), Board.getBall().getBallSizeX(), Board.getBall().getBallSizeY());
                    if (EnemiesRect.intersects(ball_rect)) {
                        Board.getEnemies().setEnemiesPosX(1000);
                        Board.getEnemies().setEnemiesPosY(1000);


                    }
                    // Decrease Life Points till zero
                    if (Board.getBall().getBallPosY() > 600) {
                        Board.getPaddle().getLaser().setPaddleGetLaser(false);
                        Board.getPaddle().getLaser().setKeyLaserPressed(false);
                        GamePlay.Get_Shot_gun().setWork(false);
                        GamePlay.setIs_Playing(false);
                        GamePlay.Get_Shot_gun().setShootPosX(10000);
                        Board.getPaddle().setPaddleX(170);
                        Board.getPaddle().setPaddleY(520);
                        Board.getBall().setBallPosX(Board.getPaddle().getPaddleX() + Board.getPaddle().getPaddleX() / 4);
                        Board.getBall().setBallPosY(Board.getPaddle().getPaddleY() - 15);
                        Board.getPaddle().setPaddleLong(100);
                        Board.getPaddle().paddleGetNormal();
                        Board.getBall().ballGetNormal();
                        Board.getPaddle().lifePointDec();
                    }

                    if (GamePlay.Get_Shot_gun().getShootPosY() < -1) {
                        if (GamePlay.Get_Shot_gun().getShoot())
                            GamePlay.Get_Shot_gun().Decrease_number_shoot();

                        GamePlay.Get_Shot_gun().setShoot(false);
                    }
                    if (Board.getEnemies().EnemiesGetPosY() > 600) {
                        Board.getPlayer().setScore(Board.getPlayer().getScore() - 20);
                        Board.getEnemies().setEnemiesPosX(400);
                        Board.getEnemies().setEnemiesPosY(25);
                    }

                    Rectangle paddle_rec = new Rectangle(Board.getPaddle().getPaddleX(), Board.getPaddle().getPaddleY(), Board.getPaddle().getPaddleLong(), Board.getPaddle().getPaddleHeight());

                    if (paddle_rec.intersects(new Rectangle(Board.getEnemies().EnemiesGetPosX(), Board.getEnemies().EnemiesGetPosY(), 37, 44))) {
                        Board.getEnemies().setEnemiesPosX(-1000);
                        Board.getEnemies().setEnemiesPosY(-1000);
                    }
                    //enemies intersect with ball

                    if (EnemiesRect.intersects(new Rectangle(Board.getBall().getBallPosX(), Board.getBall().getBallPosY(), Board.getBall().getBallSizeX(), Board.getBall().getBallSizeY()))) {
                        Board.getEnemies().setEnemiesPosX(1000);
                        Board.getEnemies().setEnemiesPosY(1000);


                    }

                    if (paddle_rec.intersects(new Rectangle(Board.getEnemies().getEnemyWeapon().getBulletsPosX(), Board.getEnemies().getEnemyWeapon().getBulletsPosY(), 20, 20))) {
                        Board.getPlayer().setScore(Board.getPlayer().getScore() - 50);
                        Board.getEnemies().getEnemyWeapon().setBulletsPosY(100000);
                    }
                    if (paddle_rec.intersects(ball_rect)) {
                        if (ball_rect.x <= paddle_rec.x) {
                            if (Board.getBall().getBallDirX() < 0) {
                                Board.getBall().setBallDirY(Board.getBall().getBallDirY() * -1);
                                Board.getBall().setBallDirX(Board.getBall().getBallDirX() * -1);
                            } else if (Board.getBall().getBallDirX() > 0) {
                                Board.getBall().setBallDirY(Board.getBall().getBallDirY() * -1);
                            }

                        } else if (ball_rect.x >= paddle_rec.x + Board.getPaddle().getPaddleLong()) {
                            if (Board.getBall().getBallDirX() > 0) {
                                Board.getBall().setBallDirY(Board.getBall().getBallDirY() * -1);
                                Board.getBall().setBallDirX(Board.getBall().getBallDirX() * -1);
                            } else if (Board.getBall().getBallDirX() < 0) {
                                Board.getBall().setBallDirY(Board.getBall().getBallDirY() * -1);
                            }
                        } else {
                            Board.getBall().setBallDirY(Board.getBall().getBallDirY() * -1);
                        }
                    }
                }
            }
    }

}
