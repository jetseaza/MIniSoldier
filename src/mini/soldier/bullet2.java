
package mini.soldier;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class bullet2 extends JPanel{
    public ImageIcon[] bullet2 = new ImageIcon[5];
    public int y;
    public int x;
    public int count=0;
    bullet2(int x,int y){
        for(int i=0;i<bullet2.length;i++){
            String imageLocation = "bb"+(i+1)+".png";
            bullet2[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
            this.x=x;
            this.y=y;
    }
	
    public void move(){
	this.x -= 20;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
}
