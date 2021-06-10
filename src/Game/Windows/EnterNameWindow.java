package Game.Windows;



import Game.Component.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterNameWindow extends JPanel {

    private boolean valid_name = false;
    JTextField textName = new JTextField("Enter Your Name");
    JButton Enter = new JButton(new ImageIcon("D:\\Computer Science ASU\\Project\\Arkanoid\\src\\Data\\Images\\Menu\\Enter.png"));

    public EnterNameWindow(){
        textName.setBounds(280,300,200,20);
        Enter.setBounds(280,360,200,65);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);

        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);

        this.add(textName);
        this.add(Enter);

        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString("Please Make Sure Your Name dosen't Have Spaces or Special Characters", 150, 480);


        draw();

    }

    private boolean checkNameValidation(String name){
        for(int i = 0 ; i< name.length();i++){
            if(name.charAt(i) == ' ' || name.charAt(i) == '$' || name.charAt(i) == '!' || name.charAt(i)=='@' || name.charAt(i) == '~'){
                return false;
            }
        }
        return true;
    }

   private void draw(){
       Enter.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println(textName.getText());

               valid_name = checkNameValidation(textName.getText());

               if(valid_name) {
                   valid_name = false;
                   Board.getPlayer().setName(textName.getText());
                   Board.getPlayer().saveScore(Board.getPlayer().getName(), String.valueOf(Board.getPlayer().getScore()));
                   Board.getPlayer().setScore(0);

                   MainClass.getWindow().drawMenu();
               }
               else{
                   MainClass.getWindow().drawEnterName();
               }
           }
       });
   }
}
