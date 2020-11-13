
package mini.soldier;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Enter extends JPanel{
    private ImageIcon background = new ImageIcon(this.getClass().getResource("background.jpg"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("startbutton.png"));
    private ImageIcon Mini = new ImageIcon(this.getClass().getResource("Mini.png"));
    private ImageIcon howto = new ImageIcon(this.getClass().getResource("howtoplay.png"));
    public JButton Start = new JButton(start);
    public JButton how = new JButton(howto);
    Enter(){
        setLayout(null);
        Start.setBounds(390, 420, 400, 100);
        Start.setBorderPainted(false);
        Start.setBorder(null);
        Start.setOpaque(false);
        Start.setContentAreaFilled(false);
        add(Start);
        
        how.setBounds(390, 520, 400, 100); 
        how.setBorderPainted(false);
        how.setBorder(null);
        how.setOpaque(false);
        how.setContentAreaFilled(false);
        add(how);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, 1200, 665, this);
        g.drawImage(Mini.getImage(), 320, 100, 550, 250, this);
    
    }
}

