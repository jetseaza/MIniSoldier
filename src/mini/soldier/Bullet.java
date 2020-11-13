
package mini.soldier;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bullet extends JPanel{
    public ImageIcon[] bullet1 = new ImageIcon[5];
    public int y;
    public int x;
    public int count=0;
    Bullet(int x,int y){
        for(int i=0;i<bullet1.length;i++){
            String imageLocation = "b"+(i+1)+".png";
            bullet1[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
            this.x=x;
            this.y=y;
    }
	
    public void move(){
	this.x += 20;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
}
