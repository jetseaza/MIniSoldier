
package mini.soldier;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class soldier {
    
    public ImageIcon cw = new ImageIcon(this.getClass().getResource("cw.png"));
    public ImageIcon cwb = new ImageIcon(this.getClass().getResource("cwb.png"));
    public ImageIcon cwrun = new ImageIcon(this.getClass().getResource("cr.png"));
    public ImageIcon cwbrun = new ImageIcon(this.getClass().getResource("crb.png"));
    public ImageIcon cshootw = new ImageIcon(this.getClass().getResource("cs.png"));
    public ImageIcon cshootwb = new ImageIcon(this.getClass().getResource("csb.png"));

    public int alive = 200;
    public int x = 500;
    public int y = 533;
    public int count = 0;
    public int checkfloor = 0;
    public int checkshoot = 0;
    public int distanceP = 0;
}
