package Game.Windows;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreditWindow extends JPanel {

    JButton BackB = new JButton(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\Menu\\back.png"));

    public CreditWindow(){
        BackB.setBounds(625,10,140,40);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);

        g.drawImage(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\Backgrounds\\Credits-last-update.png").getImage(),0,0,800,570,this);
        this.add(BackB);

        BackB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainClass.getWindow().drawMenu();
            }

        });

    }

}