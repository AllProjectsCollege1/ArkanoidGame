package Game.Gameplay;
import Game.Component.Bricks;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BricksPatternInLevels {

    static  int total_number_of_bricks_level1 = 8 * 13 ;
    static  int total_number_of_bricks_level2 = 66;
    static  int total_number_of_bricks_level3 = 88;
    static  int total_number_of_bricks_level4 = 114;
    static  int total_number_of_bricks_level5 = 70 ;
    static  int total_number_of_bricks_level6 = 79;
    static  int total_number_of_bricks_level7 = 68;
    static  int total_number_of_bricks_level8 = 50;
    static  int total_number_of_bricks_level9 = 49;
    static  int total_number_of_bricks_level10 =66;
    static  int total_number_of_bricks_level11 =85;
    static  int total_number_of_bricks_level12 =81;
    static  int total_number_of_bricks_level13 =140;
    static  int total_number_of_bricks_level14 =132;
    static  int total_number_of_bricks_level15 =93;



    static int number_of_level;

    static int[][] Matrix2D1={
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {2,2,2,2,2,2,2,2,2,2,2,2,2},
            {3,3,3,3,3,3,3,3,3,3,3,3,3},
            {4,4,4,4,4,4,4,4,4,4,4,4,4},
            {5,5,5,5,5,5,5,5,5,5,5,5,5},
            {6,6,6,6,6,6,6,6,6,6,6,6,6},
            {7,7,7,7,7,7,7,7,7,7,7,7,7},
            {8,8,8,8,8,8,8,8,8,8,8,8,8}
    };

    static int[][] Matrix2D2= {
            {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {8, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {8, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0},
            {8, 7, 6, 4, 0, 0, 0, 0, 0, 0, 0},
            {8, 7, 6, 4, 2, 0, 0, 0, 0, 0, 0},
            {8, 7, 6, 4, 2, 6, 0, 0, 0, 0, 0},
            {8, 7, 6, 4, 2, 6, 8, 0, 0, 0, 0},
            {8, 7, 6, 4, 2, 6, 8, 7, 0, 0, 0},
            {8, 7, 6, 4, 2, 6, 8, 7, 6, 0, 0},
            {8, 7, 6, 4, 2, 6, 8, 7, 6, 4, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8}
    };

    static int[][] Matrix2D3 = {
            {6,6,6,6,6,6,6,6,6,6,6},
            {0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,9,9,9,9,9,9,9,9},
            {0,0,0,0,0,0,0,0,0,0,0},
            {2,2,2,2,2,2,2,2,2,2,2},
            {0,0,0,0,0,0,0,0,0,0,0},
            {9,9,9,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,0,0},
            {8,8,8,8,8,8,8,8,8,8,8},
            {0,0,0,0,0,0,0,0,0,0,0},
            {4,4,4,9,9,9,9,9,9,9,9},
            {0,0,0,0,0,0,0,0,0,0,0},
            {4,4,4,4,4,4,4,4,4,4,4},
            {0,0,0,0,0,0,0,0,0,0,0},
            {9,9,9,4,4,4,4,4,4,4,4}
    };

    static int [][] Matrix2D4 = {
            {0,2,2,2,2,0,3,3,3,3,0},
            {0,5,5,5,5,0,4,4,4,4,0},
            {0,7,7,7,7,0,5,5,5,5,0},
            {0,2,2,2,2,0,6,6,6,6,0},
            {0,1,1,1,1,0,1,1,1,1,0},
            {0,4,4,4,4,0,8,8,8,8,0},
            {0,6,6,6,6,0,2,2,2,2,0},
            {0,7,7,7,7,0,3,3,3,3,0},
            {0,4,4,4,4,0,5,5,5,5,0},
            {0,1,1,1,1,0,1,1,1,1,0},
            {0,2,2,2,2,0,2,2,2,2,0},
            {0,4,4,4,4,0,3,3,3,3,0},
            {0,5,5,5,5,0,6,6,6,6,0},
            {0,8,8,8,8,0,7,7,7,7,0}
    };

    static int[][] Matrix2D5 = {
            {0,0,0,5,0,0,0,5,0,0,0},
            {0,0,0,0,5,0,5,0,0,0,0},
            {0,0,0,0,5,0,5,0,0,0,0},
            {0,0,0,1,1,1,1,1,0,0,0},
            {0,0,0,1,1,1,1,1,0,0,0},
            {0,0,1,1,2,1,2,1,1,0,0},
            {0,0,1,1,2,1,2,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,0},
            {1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,0,0,0,0,1,0,1},
            {1,0,1,0,0,0,0,0,1,0,1},
            {1,0,1,1,0,0,0,1,1,0,1},
            {0,0,0,0,1,0,1,0,0,0,0},
            {0,0,0,0,1,0,1,0,0,0,0}
    };

    static int[][] Matrix2D6 = {
            {1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,1,1,1,1,1,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1}
    };

    static int[][] Matrix2D7 = {
            {0,0,1,1,1,0,0},
            {0,1,2,2,2,1,0},
            {0,1,3,3,3,1,0},
            {1,4,4,4,4,4,1},
            {1,5,5,5,5,5,1},
            {1,4,4,4,4,4,1},
            {1,6,6,6,6,6,1},
            {1,7,7,7,7,7,1},
            {1,8,8,8,8,8,1},
            {0,1,2,2,2,1,0},
            {0,1,4,4,4,1,0},
            {0,0,1,1,1,0,0}
    };

    static int[][] Matrix2D8 = {
            {9,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
            {9,0,0,0,0,0,0,0,0,0,0},
            {9,0,0,0,0,0,0,0,0,0,0},
            {9,0,0,0,0,4,0,0,0,0,0},
            {9,0,0,0,4,7,4,0,0,0,0},
            {9,0,0,4,7,4,7,4,0,0,0},
            {9,0,4,7,4,1,4,7,4,0,0},
            {9,0,0,4,7,4,7,4,0,0,0},
            {9,0,0,0,4,7,4,0,0,0,0},
            {9,0,0,0,0,4,0,0,0,0,0},
            {9,0,0,0,0,0,0,0,0,0,0},
            {9,0,0,0,0,0,0,0,0,0,0},
            {9,0,0,0,0,0,0,0,0,0,0},
            {9,0,0,0,0,0,0,0,0,0,0},
            {9,9,9,9,9,9,9,9,9,9,9}
    };

    static int[][] Matrix2D9 = {
            {1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,0,1},
            {1,0,1,0,0,0,1,0,1},
            {1,0,1,0,1,0,1,0,1},
            {1,0,1,0,0,0,1,0,1},
            {1,0,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1}
    };

    static int[][] Matrix2D10 = {
            {9,9,9,9,9,9,9,9,9,9,9},
            {0,0,0,0,9,0,0,0,9,8,0},
            {0,9,6,0,9,0,0,0,9,0,0},
            {0,9,0,0,9,0,9,0,9,0,0},
            {0,9,0,0,9,0,9,0,9,0,0},
            {0,9,0,0,9,6,9,0,9,0,0},
            {0,9,0,8,9,0,9,4,9,0,0},
            {0,9,0,0,9,2,9,0,9,0,0},
            {0,9,0,0,9,0,9,0,9,0,0},
            {0,9,0,0,9,0,9,0,9,0,0},
            {0,9,7,0,0,0,9,0,0,0,0},
            {0,9,0,0,0,0,9,0,0,0,8},
            {0,9,9,9,9,9,9,9,9,9,9},
    };


    static int[][] Matrix2D11 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
            {9, 9, 9, 9, 2, 2, 2, 9, 9, 9, 9},
            {9, 6, 6, 9, 1, 1, 1, 9, 6, 6, 9},
            {9, 2, 2, 9, 0, 0, 0, 9, 4, 4, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 9, 6, 6, 6, 9, 0, 0, 9},
            {9, 1, 1, 9, 9, 9, 9, 9, 1, 1, 9},
    };

    static int[][] Matrix2D12 = {
            {0,0,1,1,1,0,1,1,1,0,1,1,1},
            {0,0,1,6,1,0,1,6,1,0,1,6,1},
            {0,0,1,1,1,0,1,1,1,0,1,1,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,1,1,1,0,1,1,1,0},
            {0,1,2,1,0,1,2,1,0,1,2,1,0},
            {0,1,1,1,0,1,1,1,0,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,0,1,1,1,0,1,1,1,0,0},
            {1,4,1,0,1,4,1,0,1,4,1,0,0},
            {1,1,1,0,1,1,1,0,1,1,1,0,0}
    };

    static int[][] Matrix2D13 = {
            {0,0,0,0,0,9,0,0,0,0,0,0,0,0},
            {0,0,0,0,9,4,9,0,0,0,0,0,0,0},
            {0,0,0,9,4,1,4,9,0,0,0,0,0,0},
            {0,0,9,4,1,4,1,4,9,0,0,0,0,0},
            {0,9,4,1,4,6,4,1,4,9,0,0,0,0},
            {9,4,1,4,6,7,6,4,1,4,9,0,0,0},
            {4,1,4,6,7,2,7,6,4,1,4,9,9,9},
            {1,4,6,7,2,8,2,7,6,4,1,4,4,4},
            {4,6,7,2,8,3,8,2,7,6,4,1,1,1},
            {6,7,2,8,3,1,3,8,2,7,6,4,4,4},
            {7,2,8,3,1,0,1,3,8,2,7,6,6,6},
            {2,8,3,1,0,0,0,1,3,8,2,7,7,7},
            {8,3,1,0,0,0,0,0,1,3,8,2,2,2},
            {3,1,0,0,0,0,0,0,0,1,3,8,8,8},
            {1,0,0,0,0,0,0,0,0,0,1,3,3,3},
            {0,0,0,0,0,0,0,0,0,0,0,1,1,1}
    };

    static int [][] Matrix2D14 = {
            {7,1,1,7,7,7,7,7,1,1,7},
            {7,1,5,1,7,7,7,1,6,1,7},
            {7,1,5,5,1,1,1,6,6,1,7},
            {7,1,5,5,5,1,6,6,6,1,7},
            {7,1,5,5,5,1,6,6,6,1,7},
            {7,1,5,5,5,1,6,6,6,1,7},
            {7,1,5,5,5,1,6,6,6,1,7},
            {7,1,5,5,5,1,6,6,6,1,7},
            {7,1,5,5,5,1,6,6,6,1,7},
            {7,7,1,5,5,1,6,6,1,7,7},
            {7,7,7,1,5,1,6,1,7,7,7},
            {7,7,7,7,1,1,1,7,7,7,7}

    };

    static int[][] Matrix2D15 = {
            {0,0,0,0,0,0,0,1,5,1,0,0,0},
            {0,0,0,0,0,0,0,1,5,1,0,0,0},
            {0,0,0,9,9,9,9,1,5,1,9,9,9},
            {0,0,0,9,0,0,0,1,5,1,0,0,0},
            {0,0,0,9,4,4,4,1,5,1,4,4,4},
            {0,0,0,9,7,9,9,1,5,1,9,9,9},
            {0,0,0,9,7,9,0,1,5,1,0,0,0},
            {0,0,0,9,7,9,0,1,5,1,0,0,0},
            {1,1,1,9,7,9,1,1,5,1,0,0,0},
            {0,0,0,9,7,9,0,0,5,1,0,0,0},
            {2,2,2,9,7,9,2,2,2,1,0,0,0},
            {1,1,1,9,7,9,1,1,1,1,0,0,0},
            {0,0,0,9,7,9,0,0,0,0,0,0,0},
            {0,0,0,9,7,9,0,0,0,0,0,0,0}
    };

    static Bricks[][] bricks;

    public static void level1_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[8][13];

        number_of_level = 1;

        for (int i = 0 ; i < 8 ;i++){
            for (int j=0 ; j < 13 ;j++){
                bricks[i][j] = new Bricks(Matrix2D1[i][j]);
                if(Matrix2D1[i][j] >= 1) {
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j) + 15, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }

    }

    public static void level2_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[11][11];

        number_of_level = 2;

        for (int i = 0 ; i < 11 ;i++){
            for (int j = 0 ; j < 11 ;j++){
                if(Matrix2D2[i][j]>=1) {
                    bricks[i][j] = new Bricks(Matrix2D2[i][j]);
                }
                else{
                    bricks[i][j]= new Bricks(new Random().nextInt(5)+1);
                }

                if(Matrix2D2[i][j] >= 1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j + 1) + 15, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level3_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[15][11];
        number_of_level = 3;

        for (int i = 0; i < 15 ;i++){
            for (int j=0 ; j < 11 ;j++){
                if(Matrix2D3[i][j]>=1) {
                    bricks[i][j] = new Bricks(Matrix2D3[i][j]);
                }
                else{
                    bricks[i][j]= new Bricks(new Random().nextInt(5)+1);
                }
                if(Matrix2D3[i][j] >= 1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j+1)+15, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level4_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[14][11];
        number_of_level = 4;

        for(int i = 0;i<14;i++){
            for(int j = 0; j<11;j++){
                bricks[i][j] = new Bricks(Matrix2D4[i][j]);
                if(Matrix2D4[i][j] >= 1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j+1)+15, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level5_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[14][11];
        number_of_level = 5;


        for(int i = 0;i<14;i++){
            for(int j =0;j<11;j++){
                if(Matrix2D5[i][j]>=1) {
                    bricks[i][j] = new Bricks(Matrix2D5[i][j]);
                }
                else{
                    bricks[i][j]= new Bricks(new Random().nextInt(5)+1);
                }
                if(Matrix2D5[i][j] >= 1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j+1)+15, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level6_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[11][11];
        number_of_level = 6;


        for(int i = 0;i<11;i++){
            for(int j = 0 ; j<11; j++){
                switch (j){
                    case 0:
                    case 10:
                        if(i!=9){
                            bricks[i][j]=new Bricks(4);
                        }
                        else {
                            bricks[i][j] = new Bricks(8);
                        }
                        break;
                    case 2:
                    case 8:
                        if(i==3||i==Math.pow(3,2)){
                            bricks[i][j] = new Bricks(9);
                        }
                        else {
                            bricks[i][j]=new Bricks(2);
                        }
                        break;
                    case 4:
                    case 6:
                        if(i==3||i==Math.pow(3,2)){
                            bricks[i][j] = new Bricks(9);
                        }
                        else {
                            bricks[i][j]=new Bricks(6);
                        }
                        break;

                    default:
                        bricks[i][j] = new Bricks(8);

                }
                if(Matrix2D6[i][j] == 1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j+1)+15, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level7_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[12][7];
        number_of_level = 7;



        for(int i = 0;i<12;i++){
            for(int j = 0; j<7;j++){
                bricks[i][j] = new Bricks(Matrix2D7[i][j]);
                if(Matrix2D7[i][j] >= 1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(),bricks[i][j].getBrickPosX() + 32 * (j+3)+10, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level8_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[16][11];
        number_of_level = 8;


        for(int i = 0;i<16;i++){
            for (int j = 0 ;j<11;j++){
                if(Matrix2D8[i][j]>=1) {
                    bricks[i][j] = new Bricks(Matrix2D8[i][j]);
                }
                else{
                    bricks[i][j]= new Bricks(new Random().nextInt(5)+1);
                }
                if(Matrix2D8[i][j] >= 1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j+1)+68, bricks[i][j].getBrickPosY() + 16 * (i) + 6, 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level9_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[9][9];
        number_of_level = 9;


        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                bricks[i][j]=new Bricks(1);
                if(Matrix2D9[i][j] == 1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j+1) + 50, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level10_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[13][11];
        number_of_level = 10;


        for(int i = 0;i<13;i++){
            for (int j = 0 ;j<11;j++){
                if(Matrix2D10[i][j]>=1) {
                    bricks[i][j] = new Bricks(Matrix2D10[i][j]);
                }
                else{
                    bricks[i][j]= new Bricks(new Random().nextInt(5)+1);
                }
                if(Matrix2D10[i][j] >= 1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j+1) + 10, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level11_display(Graphics2D g , JPanel panel)
    {
        bricks=new Bricks[11][11];
        number_of_level = 11;

        for (int i=0;i<11;i++) {
            for (int j = 0; j < 11; j++) {
                if (Matrix2D11[i][j] >= 1) {
                    bricks[i][j] = new Bricks(Matrix2D11[i][j]);
                } else {
                    bricks[i][j] = new Bricks(new Random().nextInt(9) + 1);
                }
                if (Matrix2D11[i][j] >= 1) {
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j+1)+13, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level12_display(Graphics2D g , JPanel panel){
        bricks=new Bricks[11][13];
        number_of_level = 12;


        for(int i=0;i<11;i++){
            for(int j=0;j<13;j++){
                switch (Matrix2D12[i][j]){
                    case 1:
                        bricks[i][j]=new Bricks(1);
                        break;
                    case 2:
                        bricks[i][j]=new Bricks(2);
                        break;
                    case 3:
                        bricks[i][j]=new Bricks(3);
                        break;
                    case 4:
                        bricks[i][j]=new Bricks(4);
                        break;
                    case 6:
                        bricks[i][j]=new Bricks(6);
                        break;
                    case 7:
                        bricks[i][j]=new Bricks(7);
                        break;
                    case 8:
                        bricks[i][j]=new Bricks(8);
                        break;
                    case 9:
                        bricks[i][j]=new Bricks(9);
                        break;
                    default:
                        bricks[i][j]= new Bricks(new Random().nextInt(5)+1);
                }
                if(Matrix2D12[i][j]>=1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j) + 16, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }

            }
        }
    }

    public static void level13_display(Graphics2D g , JPanel panel){
        bricks=new Bricks[16][14];
        number_of_level = 13;


        for(int i=0;i<16;i++){
            for(int j=0;j<14;j++){
                switch (Matrix2D13[i][j]){
                    case 1:
                        bricks[i][j]=new Bricks(1);
                        break;
                    case 2:
                        bricks[i][j]=new Bricks(2);
                        break;
                    case 3:
                        bricks[i][j]=new Bricks(3);
                        break;
                    case 4:
                        bricks[i][j]=new Bricks(4);
                        break;
                    case 6:
                        bricks[i][j]=new Bricks(6);
                        break;
                    case 7:
                        bricks[i][j]=new Bricks(7);
                        break;
                    case 8:
                        bricks[i][j]=new Bricks(8);
                        break;
                    case 9:
                        bricks[i][j]=new Bricks(9);
                        break;
                    default:
                        bricks[i][j]= new Bricks(new Random().nextInt(5)+1);
                }
                if(Matrix2D13[i][j]>=1){
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j), bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }

            }
        }
    }

    public static void level14_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[12][11];


        number_of_level = 14;


        for(int i=0;i<12;i++) {
            for (int j = 0; j < 11; j++) {
                switch (Matrix2D14[i][j]) {
                    case 1:
                        bricks[i][j] = new Bricks(1);
                        break;
                    case 2:
                        bricks[i][j] = new Bricks(2);
                        break;
                    case 3:
                        bricks[i][j] = new Bricks(3);
                        break;
                    case 4:
                        bricks[i][j] = new Bricks(4);
                        break;
                    case 5:
                        bricks[i][j] = new Bricks(5);
                        break;
                    case 6:
                        bricks[i][j] = new Bricks(6);
                        break;
                    case 7:
                        bricks[i][j] = new Bricks(7);
                        break;
                    case 8:
                        bricks[i][j] = new Bricks(8);
                        break;
                    case 9:
                        bricks[i][j] = new Bricks(9);
                        break;
                    default:
                        bricks[i][j] = new Bricks(new Random().nextInt(5) + 1);
                }
                if (Matrix2D14[i][j] >= 1) {
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j+1) + 15, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static void level15_display(Graphics2D g , JPanel panel){
        bricks = new Bricks[14][13];


        number_of_level = 15;


        for(int i=0;i<14;i++) {
            for (int j = 0; j < 13; j++) {
                switch (Matrix2D15[i][j]) {
                    case 1:
                        bricks[i][j] = new Bricks(1);
                        break;
                    case 2:
                        bricks[i][j] = new Bricks(2);
                        break;
                    case 3:
                        bricks[i][j] = new Bricks(3);
                        break;
                    case 4:
                        bricks[i][j] = new Bricks(4);
                        break;
                    case 5:
                        bricks[i][j] = new Bricks(5);
                        break;
                    case 6:
                        bricks[i][j] = new Bricks(6);
                        break;
                    case 7:
                        bricks[i][j] = new Bricks(7);
                        break;
                    case 8:
                        bricks[i][j] = new Bricks(8);
                        break;
                    case 9:
                        bricks[i][j] = new Bricks(9);
                        break;
                    default:
                        bricks[i][j] = new Bricks(new Random().nextInt(5) + 1);
                }
                if (Matrix2D15[i][j] >= 1) {
                    if (!bricks[i][j].isDestroy()) {
                        g.drawImage(bricks[i][j].getBrickImage(), bricks[i][j].getBrickPosX() + 32 * (j) + 15, bricks[i][j].getBrickPosY() + 16 * (i + 4), 32, 16, panel);
                    }
                }
            }
        }
    }

    public static int[][] getMatrix2D(int level_number) {
        if(level_number == 1) {
            return Matrix2D1;
        }
        if(level_number == 2) {
            return Matrix2D2;
        }
        if(level_number == 3) {
            return Matrix2D3;
        }
        if(level_number == 4) {
            return Matrix2D4;
        }
        if(level_number == 5) {
            return Matrix2D5;
        }
        if(level_number == 6) {
            return Matrix2D6;
        }
        if(level_number == 7) {
            return Matrix2D7;
        }
        if(level_number == 8) {
            return Matrix2D8;
        }
        if(level_number == 9) {
            return Matrix2D9;
        }
        if(level_number == 10) {
            return Matrix2D10;
        }
        if(level_number == 11) {
            return Matrix2D11;
        }
        if(level_number == 12) {
            return Matrix2D12;
        }
        if(level_number == 13) {
            return Matrix2D13;
        }
        if(level_number == 14){
            return Matrix2D14;
        }
        if(level_number == 15){
            return  Matrix2D15;
        }

        return null;
    }

    public static Bricks[][] getBricks() {
        return bricks;
    }

    public static void set_Destroy_Matrix2D(int[][] Matrix2D , int i , int j , int number_of_level){
        Matrix2D[i][j] = 0;
        switch (number_of_level){
            case 1 :
                total_number_of_bricks_level1--;
                break;
            case 2:
                total_number_of_bricks_level2--;
                break;
            case 3:
                total_number_of_bricks_level3--;
                break;
            case 4:
                total_number_of_bricks_level4--;
                break;
            case 5:
                total_number_of_bricks_level5--;
                break;
            case 6:
                total_number_of_bricks_level6--;
                break;
            case 7:
                total_number_of_bricks_level7--;
                break;
            case 8:
                total_number_of_bricks_level8--;
                break;
            case 9:
                total_number_of_bricks_level9--;
                break;
            case 10:
                total_number_of_bricks_level10--;
                break;
            case 11:
                total_number_of_bricks_level11--;
                break;
            case 12:
                total_number_of_bricks_level12--;
                break;
            case 13:
                total_number_of_bricks_level13--;
                break;
            case 14:
                total_number_of_bricks_level14--;
                break;
            case 15:
                total_number_of_bricks_level15--;
                break;
        }

    }
    public static int getTotal_number_of_bricks(int number_of_level) {
        switch (number_of_level) {
            case 1:
                return total_number_of_bricks_level1;
            case 2:
                return total_number_of_bricks_level2;
            case 3:
                return total_number_of_bricks_level3;
            case 4:
                return total_number_of_bricks_level4;
            case 5:
                return total_number_of_bricks_level5;
            case 6:
                return total_number_of_bricks_level6;
            case 7:
                return total_number_of_bricks_level7;
            case 8:
                return total_number_of_bricks_level8;
            case 9:
                return total_number_of_bricks_level9;
            case 10:
                return total_number_of_bricks_level10;
            case 11:
                return total_number_of_bricks_level11;
            case 12:
                return total_number_of_bricks_level12;
            case 13:
                return total_number_of_bricks_level13;
            case 14:
                return total_number_of_bricks_level14;
            case 15:
                return total_number_of_bricks_level15;
        }
        return 0;
    }

    public static int getNumber_of_level() {
        return number_of_level;
    }

    public static void setBasicPatterns(){

        total_number_of_bricks_level1 = 8 * 13 ;
      total_number_of_bricks_level2 = 66;
        total_number_of_bricks_level3 = 88;
        total_number_of_bricks_level4 = 114;
        total_number_of_bricks_level5 = 70 ;
        total_number_of_bricks_level6 = 79;
        total_number_of_bricks_level7 = 68;
         total_number_of_bricks_level8 = 50;
        total_number_of_bricks_level9 = 49;
        total_number_of_bricks_level10 =66;
        total_number_of_bricks_level11 =85;
         total_number_of_bricks_level12 =81;
         total_number_of_bricks_level13 =140;
         total_number_of_bricks_level14 =132;
         total_number_of_bricks_level15 =93;




         Matrix2D1= new int[][]{
                 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                 {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                 {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                 {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
                 {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
                 {6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
                 {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
                 {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}
         };

        Matrix2D2= new int[][]{
                {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 7, 6, 4, 0, 0, 0, 0, 0, 0, 0},
                {8, 7, 6, 4, 2, 0, 0, 0, 0, 0, 0},
                {8, 7, 6, 4, 2, 6, 0, 0, 0, 0, 0},
                {8, 7, 6, 4, 2, 6, 8, 0, 0, 0, 0},
                {8, 7, 6, 4, 2, 6, 8, 7, 0, 0, 0},
                {8, 7, 6, 4, 2, 6, 8, 7, 6, 0, 0},
                {8, 7, 6, 4, 2, 6, 8, 7, 6, 4, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8}
        };

         Matrix2D3 = new int[][]{
                {6,6,6,6,6,6,6,6,6,6,6},
                {0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,9,9,9,9,9,9,9,9},
                {0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,2,2,2,2,2,2,2},
                {0,0,0,0,0,0,0,0,0,0,0},
                {9,9,9,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,0,0},
                {8,8,8,8,8,8,8,8,8,8,8},
                {0,0,0,0,0,0,0,0,0,0,0},
                {4,4,4,9,9,9,9,9,9,9,9},
                {0,0,0,0,0,0,0,0,0,0,0},
                {4,4,4,4,4,4,4,4,4,4,4},
                {0,0,0,0,0,0,0,0,0,0,0},
                {9,9,9,4,4,4,4,4,4,4,4}
        };

        Matrix2D4 = new int[][]{
                {0,2,2,2,2,0,3,3,3,3,0},
                {0,5,5,5,5,0,4,4,4,4,0},
                {0,7,7,7,7,0,5,5,5,5,0},
                {0,2,2,2,2,0,6,6,6,6,0},
                {0,1,1,1,1,0,1,1,1,1,0},
                {0,4,4,4,4,0,8,8,8,8,0},
                {0,6,6,6,6,0,2,2,2,2,0},
                {0,7,7,7,7,0,3,3,3,3,0},
                {0,4,4,4,4,0,5,5,5,5,0},
                {0,1,1,1,1,0,1,1,1,1,0},
                {0,2,2,2,2,0,2,2,2,2,0},
                {0,4,4,4,4,0,3,3,3,3,0},
                {0,5,5,5,5,0,6,6,6,6,0},
                {0,8,8,8,8,0,7,7,7,7,0}
        };

        Matrix2D5 = new int[][]{
                {0,0,0,5,0,0,0,5,0,0,0},
                {0,0,0,0,5,0,5,0,0,0,0},
                {0,0,0,0,5,0,5,0,0,0,0},
                {0,0,0,1,1,1,1,1,0,0,0},
                {0,0,0,1,1,1,1,1,0,0,0},
                {0,0,1,1,2,1,2,1,1,0,0},
                {0,0,1,1,2,1,2,1,1,0,0},
                {0,1,1,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,0,1,0,0,0,0,0,1,0,1},
                {1,0,1,0,0,0,0,0,1,0,1},
                {1,0,1,1,0,0,0,1,1,0,1},
                {0,0,0,0,1,0,1,0,0,0,0},
                {0,0,0,0,1,0,1,0,0,0,0}
        };

        Matrix2D6 =  new int[][]{
                {1,0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0,1},
                {1,0,1,1,1,1,1,1,1,0,1},
                {1,0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0,1}
        };

        Matrix2D7 = new int[][]{
                {0,0,1,1,1,0,0},
                {0,1,2,2,2,1,0},
                {0,1,3,3,3,1,0},
                {1,4,4,4,4,4,1},
                {1,5,5,5,5,5,1},
                {1,4,4,4,4,4,1},
                {1,6,6,6,6,6,1},
                {1,7,7,7,7,7,1},
                {1,8,8,8,8,8,1},
                {0,1,2,2,2,1,0},
                {0,1,4,4,4,1,0},
                {0,0,1,1,1,0,0}
        };

         Matrix2D8 = new int[][] {
                {9,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {9,0,0,0,0,0,0,0,0,0,0},
                {9,0,0,0,0,0,0,0,0,0,0},
                {9,0,0,0,0,4,0,0,0,0,0},
                {9,0,0,0,4,7,4,0,0,0,0},
                {9,0,0,4,7,4,7,4,0,0,0},
                {9,0,4,7,4,1,4,7,4,0,0},
                {9,0,0,4,7,4,7,4,0,0,0},
                {9,0,0,0,4,7,4,0,0,0,0},
                {9,0,0,0,0,4,0,0,0,0,0},
                {9,0,0,0,0,0,0,0,0,0,0},
                {9,0,0,0,0,0,0,0,0,0,0},
                {9,0,0,0,0,0,0,0,0,0,0},
                {9,0,0,0,0,0,0,0,0,0,0},
                {9,9,9,9,9,9,9,9,9,9,9}
        };

        Matrix2D9 =new int[][] {
                {1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,1},
                {1,0,1,1,1,1,1,0,1},
                {1,0,1,0,0,0,1,0,1},
                {1,0,1,0,1,0,1,0,1},
                {1,0,1,0,0,0,1,0,1},
                {1,0,1,1,1,1,1,0,1},
                {1,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1}
        };

        Matrix2D10 = new int[][]{
                {9,9,9,9,9,9,9,9,9,9,9},
                {0,0,0,0,9,0,0,0,9,8,0},
                {0,9,6,0,9,0,0,0,9,0,0},
                {0,9,0,0,9,0,9,0,9,0,0},
                {0,9,0,0,9,0,9,0,9,0,0},
                {0,9,0,0,9,6,9,0,9,0,0},
                {0,9,0,8,9,0,9,4,9,0,0},
                {0,9,0,0,9,2,9,0,9,0,0},
                {0,9,0,0,9,0,9,0,9,0,0},
                {0,9,0,0,9,0,9,0,9,0,0},
                {0,9,7,0,0,0,9,0,0,0,0},
                {0,9,0,0,0,0,9,0,0,0,8},
                {0,9,9,9,9,9,9,9,9,9,9},
        };


        Matrix2D11 = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
                {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
                {9, 9, 9, 9, 2, 2, 2, 9, 9, 9, 9},
                {9, 6, 6, 9, 1, 1, 1, 9, 6, 6, 9},
                {9, 2, 2, 9, 0, 0, 0, 9, 4, 4, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 9, 6, 6, 6, 9, 0, 0, 9},
                {9, 1, 1, 9, 9, 9, 9, 9, 1, 1, 9},
        };

        Matrix2D12 = new int[][]{
                {0,0,1,1,1,0,1,1,1,0,1,1,1},
                {0,0,1,6,1,0,1,6,1,0,1,6,1},
                {0,0,1,1,1,0,1,1,1,0,1,1,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,1,1,0,1,1,1,0,1,1,1,0},
                {0,1,2,1,0,1,2,1,0,1,2,1,0},
                {0,1,1,1,0,1,1,1,0,1,1,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,0,1,1,1,0,1,1,1,0,0},
                {1,4,1,0,1,4,1,0,1,4,1,0,0},
                {1,1,1,0,1,1,1,0,1,1,1,0,0}
        };

        Matrix2D13 = new int[][]{
                {0,0,0,0,0,9,0,0,0,0,0,0,0,0},
                {0,0,0,0,9,4,9,0,0,0,0,0,0,0},
                {0,0,0,9,4,1,4,9,0,0,0,0,0,0},
                {0,0,9,4,1,4,1,4,9,0,0,0,0,0},
                {0,9,4,1,4,6,4,1,4,9,0,0,0,0},
                {9,4,1,4,6,7,6,4,1,4,9,0,0,0},
                {4,1,4,6,7,2,7,6,4,1,4,9,9,9},
                {1,4,6,7,2,8,2,7,6,4,1,4,4,4},
                {4,6,7,2,8,3,8,2,7,6,4,1,1,1},
                {6,7,2,8,3,1,3,8,2,7,6,4,4,4},
                {7,2,8,3,1,0,1,3,8,2,7,6,6,6},
                {2,8,3,1,0,0,0,1,3,8,2,7,7,7},
                {8,3,1,0,0,0,0,0,1,3,8,2,2,2},
                {3,1,0,0,0,0,0,0,0,1,3,8,8,8},
                {1,0,0,0,0,0,0,0,0,0,1,3,3,3},
                {0,0,0,0,0,0,0,0,0,0,0,1,1,1}
        };

         Matrix2D14 = new int[][]{
                {7,1,1,7,7,7,7,7,1,1,7},
                {7,1,5,1,7,7,7,1,6,1,7},
                {7,1,5,5,1,1,1,6,6,1,7},
                {7,1,5,5,5,1,6,6,6,1,7},
                {7,1,5,5,5,1,6,6,6,1,7},
                {7,1,5,5,5,1,6,6,6,1,7},
                {7,1,5,5,5,1,6,6,6,1,7},
                {7,1,5,5,5,1,6,6,6,1,7},
                {7,1,5,5,5,1,6,6,6,1,7},
                {7,7,1,5,5,1,6,6,1,7,7},
                {7,7,7,1,5,1,6,1,7,7,7},
                {7,7,7,7,1,1,1,7,7,7,7}

        };

         Matrix2D15 = new int[][]{
                {0,0,0,0,0,0,0,1,5,1,0,0,0},
                {0,0,0,0,0,0,0,1,5,1,0,0,0},
                {0,0,0,9,9,9,9,1,5,1,9,9,9},
                {0,0,0,9,0,0,0,1,5,1,0,0,0},
                {0,0,0,9,4,4,4,1,5,1,4,4,4},
                {0,0,0,9,7,9,9,1,5,1,9,9,9},
                {0,0,0,9,7,9,0,1,5,1,0,0,0},
                {0,0,0,9,7,9,0,1,5,1,0,0,0},
                {1,1,1,9,7,9,1,1,5,1,0,0,0},
                {0,0,0,9,7,9,0,0,5,1,0,0,0},
                {2,2,2,9,7,9,2,2,2,1,0,0,0},
                {1,1,1,9,7,9,1,1,1,1,0,0,0},
                {0,0,0,9,7,9,0,0,0,0,0,0,0},
                {0,0,0,9,7,9,0,0,0,0,0,0,0}
        };
    }
}