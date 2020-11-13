package mini.soldier;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class boss {
    public ImageIcon im = new ImageIcon(this.getClass().getResource("bossrb.png"));
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("bossr.png"));
    public int x = 0;
    public int y = 500;
    public int count = 0;
    public boolean alive = true;
    int distanceP;
    public boolean back = false;
    public int health = 200;
    boss(){
        
    }
}
