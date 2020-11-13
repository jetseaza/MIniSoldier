
package mini.soldier;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiniSoldier extends JFrame implements ActionListener{
        
    Enter entergame = new Enter();
    howplay howplay = new howplay();
    map1 map1 = new map1();
    map2 map2 = new map2();
    map3 map3 = new map3();
    map4 map4 = new map4();
    
    public MiniSoldier(){
        this.setSize(1200,700);
        this.add(entergame);
        entergame.requestFocusInWindow();
        entergame.Start.addActionListener(this);
        entergame.how.addActionListener(this);
        map1.Go1.addActionListener(this);
        map2.Go1.addActionListener(this);
        map3.Go1.addActionListener(this);
        howplay.Back.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == entergame.Start){
            this.setLocationRelativeTo(null);
            this.remove(entergame);
            this.setSize(1200,700);
            this.setTitle("Mini Soldier Level 1");
            this.add(map1);
            map1.checkstart = true;
            map1.requestFocusInWindow();
        }
        if(e.getSource() == map1.Go1){
            this.setLocationRelativeTo(null);
            this.remove(map1);
            this.setSize(1200,700);
            this.setTitle("Mini Soldier Level 2");
            this.add(map2);
            map2.times = 60;
            map2.score = map1.score;
            map2.checkstart = true;
            map2.requestFocusInWindow();
        }
        if(e.getSource() == map2.Go1){
            this.setLocationRelativeTo(null);
            this.remove(map2);   
            this.setSize(1200,700);
            this.setTitle("Mini Soldier Level 3");
            this.add(map3);
            map3.times = 60;
            map3.score = map2.score;
            map3.checkstart = true;
            map3.requestFocusInWindow();
        }
          if(e.getSource() == map3.Go1){
            this.setLocationRelativeTo(null);
            this.remove(map3);   
            this.setSize(1200,700);
            this.setTitle("Mini Soldier Level 4");
            this.add(map4);
            map4.times = 60;
            map4.score = map3.score;
            map4.checkstart = true;
            map4.requestFocusInWindow();
        }
        if(e.getSource() == entergame.how){
            this.setLocationRelativeTo(null);
            this.remove(entergame);
            this.setSize(1200,700);
            this.setTitle("How to play");
            this.add(howplay);
            howplay.requestFocusInWindow();
        }
        if(e.getSource() == howplay.Back){
            this.setLocationRelativeTo(null);
            this.remove(howplay);
            this.setSize(1200,700);
            this.setTitle("Mini Soldier");
            this.add(entergame);
            entergame.requestFocusInWindow();
        }
        this.validate();
        this.repaint();
    }
    
    public static void main(String[] args){
        JFrame gui = new MiniSoldier();
        gui.setSize(1200,700);
        gui.setVisible(true);
        gui.setTitle("Mini Soldier");
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
    }
}
