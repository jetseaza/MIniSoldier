package mini.soldier;;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class howplay extends JPanel implements ActionListener{

    private final ImageIcon howtoplay1 = new ImageIcon(this.getClass().getResource("howtoplay1.png"));
    private final ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
    
    JButton Back = new JButton(back);
    
    howplay(){
        setLayout(null);
        Back.setBounds(900, 530, 200, 100); 
        Back.setBorderPainted(true);
        Back.setBorder(null);
        Back.setOpaque(false);
        Back.setContentAreaFilled(false);
        add(Back);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(howtoplay1.getImage(), 0, 0, 1200, 800, this);
       
    }
    
}
