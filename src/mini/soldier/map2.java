
package mini.soldier;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;

public class map2 extends JPanel implements ActionListener{
    
    private ImageIcon background = new ImageIcon(this.getClass().getResource("city3.png"));
    private ImageIcon Box = new ImageIcon(this.getClass().getResource("box.png"));
    private ImageIcon youwin = new ImageIcon(this.getClass().getResource("youwin.png"));
    private ImageIcon youlose = new ImageIcon(this.getClass().getResource("youlose.png"));
    private ImageIcon Go = new ImageIcon(this.getClass().getResource("Gobutton.png"));
    soldier mychar = new soldier();
 
    
    public int checkbacktofront = 0;
    public int checknearsrus = 0;
    public int times = 60;
    public int score;
    
    public int shoot;
    public boolean checkstart;
    public int checkfix = 0;
    public boolean checkshooting = false;
    
    public ArrayList<Bullet> bullet = new ArrayList<Bullet>();
    public ArrayList<bullet2> bullet2 = new ArrayList<bullet2>();
    public ArrayList<bomp> bomp = new ArrayList<bomp>();
    public ArrayList<bomp1> bompp1 = new ArrayList<bomp1>();
    public ArrayList<badguy> mybad = new ArrayList<badguy>();
    public ArrayList<badguy1> mybad1 = new ArrayList<badguy1>();
    public ArrayList<badguy2> mybad2 = new ArrayList<badguy2>();
    public ArrayList<badguy3> mybad3 = new ArrayList<badguy3>();
    public boolean checkheartinchar = false;
    
    public JButton Go1 = new JButton(Go);
    
    boolean timestart = true;
    private Timer timer = new Timer(30, new Listener());
 
    private Timer timercount = new Timer(1000, new Listener());

    public int checknearbadguys;
    public int checkdelay = 0;
    
    boolean startbomp = false;
    public boolean checktime = false;
    Thread timebad = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{       
                    if(checkstart == true){
                        mybad.add(new badguy());
                        
                    }
                    Thread.sleep(3000);
                    
                }catch(Exception e){
                 
                }
         
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    Thread timebad1 = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{                          
                    if(checkstart == true){
                        mybad1.add(new badguy1());
                        
                    }
                    Thread.sleep(5000);
                    
                }catch(Exception e){
                 
                }
         
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    Thread timebad2 = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{                          
                    if(checkstart == true){
                        mybad2.add(new badguy2());
                        
                    }
                    Thread.sleep(4000);
                    
                }catch(Exception e){
                 
                }
         
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    Thread timebad3 = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{                          
                    if(checkstart == true){
                        mybad3.add(new badguy3());
                        
                    }
                    Thread.sleep(6000);
                    
                }catch(Exception e){
                 
                }
         
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    Thread timebomp = new Thread(new Runnable(){
         public void run() {
             while(true){
                     try{
                         if(startbomp == false){
                             Thread.sleep((long)(Math.random()*10000)+2000);
                         }
                     }catch(InterruptedException e){
                         e.printStackTrace();
                     }
                     if(startbomp == false){
                         bomp.add(new bomp());
                     }
             }
         }
     });
     Thread timebomp1 = new Thread(new Runnable(){
         public void run() {
             while(true){
                     try{
                         if(startbomp == false){
                             Thread.sleep((long)(Math.random()*10000)+1000);
                         }
                     }catch(InterruptedException e){
                         e.printStackTrace();
                     }
                     if(startbomp == false){
                         bompp1.add(new bomp1());
                     }
             }
         }
     });
    Thread timechecknear = new Thread(new Runnable(){
         public void run() {
             while(true){
                try{
                    for(int i=0; i<mybad.size(); i++){
                        mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-mybad.get(i).getX()),2))+(Math.pow(Math.abs(mychar.y-mybad.get(i).getY()),2)));
                        if(mychar.distanceP <= 80){
                            checknearsrus = 1;
                            mychar.alive -= 1;
                            
                        }
                        else
                            checknearsrus = 0;
                    }
                    for(int i=0; i<mybad1.size(); i++){
                        mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-mybad1.get(i).getX()),2))+(Math.pow(Math.abs(mychar.y-mybad1.get(i).getY()),2)));
                        if(mychar.distanceP <= 80){
                            checknearsrus = 1;
                            mychar.alive -= 1;
                        }
                        else
                            checknearsrus = 0;
                    }
                    for(int i=0; i<mybad2.size(); i++){
                        mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-mybad2.get(i).getX()),2))+(Math.pow(Math.abs(mychar.y-mybad2.get(i).getY()),2)));
                        if(mychar.distanceP <= 80){
                            checknearsrus = 1;
                            mychar.alive -= 1;
                        }
                        else
                            checknearsrus = 0;
                    }
                    for(int i=0; i<mybad3.size(); i++){
                        mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-mybad3.get(i).getX()),2))+(Math.pow(Math.abs(mychar.y-mybad3.get(i).getY()),2)));
                        if(mychar.distanceP <= 80){
                            checknearsrus = 1;
                            mychar.alive -= 1;
                        }
                        else
                            checknearsrus = 0;
                    }

                    Thread.sleep(100);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
             }
         }
     });
    map2(){
        this.setFocusable(true);
        this.setLayout(null);
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
       
                if(a == KeyEvent.VK_D){
                    if(checkshooting == false){
                        checkbacktofront = 0;
                        if(checkbacktofront == 0){
                            if(mychar.x >= 1100){
                                mychar.x = 1100;
                            }
                            else{

                                if(mychar.checkfloor == 1){
                                    if(mychar.x >= 595)
                                        mychar.x = 595;
                                }

                                mychar.x+=30;
                                mychar.count++;

                                if(mychar.count >= 2){
                                    mychar.count = 0;
                                }
                            }
                        }
                    }
                }
                else if(a == KeyEvent.VK_A){
                    if(checkshooting == false){
                        checkbacktofront = 1;
                        if(checkbacktofront == 1){
                            if(mychar.x <= 0){
                                mychar.x = 0;
                            }
                            else{

                                if(mychar.checkfloor == 1){
                                    if(mychar.x <= 440)
                                        mychar.x = 440;
                                }                          
                                mychar.x-=30;
                                mychar.count++;

                                if(mychar.count >= 2){
                                    mychar.count = 0;
                                }
                            }
                        }
                    }
                }
               else if(a == KeyEvent.VK_W){
                    if(mychar.checkfloor == 0){
                        if(mychar.x >= 440 && mychar.x <= 600){
                            mychar.checkfloor = 1;
                            mychar.y -= 188;
                        }
                    }
                }
                else if(a == KeyEvent.VK_S){
                    if(mychar.checkfloor == 1){
                        if(mychar.x >= 440 && mychar.x <= 600){
                            mychar.checkfloor = 0;
                            mychar.y = 530;
                        }
                    }
                }
                else if(a == KeyEvent.VK_SPACE){
                    if(checkbacktofront == 0){
                        if(mychar.checkfloor == 0){
                            if(mychar.checkshoot == 0){
                                mychar.checkshoot = 1;
                                checkshooting = true;
                                bullet.add(new Bullet(mychar.x+100,550));
                            }
                        }
                    }
                    else if(checkbacktofront == 1){
                        if(mychar.checkfloor == 0){
                            if(mychar.checkshoot == 0){
                                mychar.checkshoot = 1;
                                checkshooting = true;
                                bullet2.add(new bullet2(mychar.x-100,550));
                            }
                        }
                    }
                    
                }
            }
            public void keyReleased(KeyEvent e){
                mychar.count = 0;
               
            }
        });
        
        timer.start();
        timebad.start();
        timebad1.start();
        timebad2.start();
        timebad3.start();
        timebomp.start();
        timebomp1.start();
        timechecknear.start();
        timercount.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timercount){
                times--;
            }
            repaint();
        }
    }
    
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
            return (a.intersects(b));
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
       
     
        
        g.drawImage(background.getImage(), 0, 0, 1200, 800, this);
        g.drawImage(Box.getImage(), 450, 440, 221, 186, this);
        g.setColor(Color.RED);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 40));	
        g.drawString("Time: "+times, 520, 50);
        g.drawString("Score: "+score, 250, 50);
        g.drawString("HP: "+mychar.alive, 800, 50); 
    
        for(int i=0 ; i<bomp.size();i++){
            g.drawImage( bomp.get(i).getImage() ,bomp.get(i).getX(),bomp.get(i).getY(),70,60,this);
            mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-bomp.get(i).getX()),2))+(Math.pow(Math.abs(mychar.y-bomp.get(i).getY()),2)));
            
            if(mychar.distanceP <= 50){
                bomp.remove(i);
                mychar.alive += 10;
            }

        }
        for(int i=0 ; i<bompp1.size();i++){
            g.drawImage( bompp1.get(i).getImage() ,bompp1.get(i).getX(),bompp1.get(i).getY(),90,60,this);
            mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-bompp1.get(i).getX()),2))+(Math.pow(Math.abs(mychar.y-bompp1.get(i).getY()),2)));
            
            if(mychar.distanceP <= 50){
                bompp1.remove(i);
                mychar.alive -= 10;
            }
        }
        
        //addbad
        for(int i=0 ; i<mybad.size();i++){
            g.drawImage( mybad.get(i).getImage() ,mybad.get(i).getX(),mybad.get(i).getY(),100,100,this);
        }
        for(int i=0 ; i<mybad1.size();i++){
            g.drawImage(mybad1.get(i).getImage() ,mybad1.get(i).getX(),mybad1.get(i).getY(),100,100,this);
        }
        for(int i=0 ; i<mybad2.size();i++){
            g.drawImage(mybad2.get(i).getImage() ,mybad2.get(i).getX(),mybad2.get(i).getY(),100,100,this);
        }
        for(int i=0 ; i<mybad3.size();i++){
            g.drawImage(mybad3.get(i).getImage() ,mybad3.get(i).getX(),mybad3.get(i).getY(),100,100,this);
        }
        
        //badright
        if(mychar.checkshoot == 1){
            for(int i=0; i<bullet.size(); i++){
                for(int j=0; j<mybad.size(); j++){
                    if(Intersect(bullet.get(i).getbound(),mybad.get(j).getbound())){
                        bullet.remove(i);
                        mybad.remove(j);
                        score += 10;
                        mychar.checkshoot = 0;
                        checkshooting = false;
                    }
                }  
            }
            for(int i=0; i<bullet.size(); i++){
                for(int j=0; j<mybad1.size(); j++){
                    if(Intersect(bullet.get(i).getbound(),mybad1.get(j).getbound())){
                        bullet.remove(i);
                        mybad1.remove(j);
                        score += 10;
                        mychar.checkshoot = 0;
                        checkshooting = false;
                    }
                }  
            }
        }
        
        //badleft
        if(mychar.checkshoot == 1){
            for(int i=0; i<bullet2.size(); i++){
                for(int j=0; j<mybad2.size(); j++){
                    if(Intersect(bullet2.get(i).getbound(),mybad2.get(j).getbound())){
                        bullet2.remove(i);
                        mybad2.remove(j);
                        score += 10;
                        mychar.checkshoot = 0;
                        checkshooting = false;
                    }
                }  
            }
        }
        if(mychar.checkshoot == 1){
            for(int i=0; i<bullet2.size(); i++){
                for(int j=0; j<mybad3.size(); j++){
                    if(Intersect(bullet2.get(i).getbound(),mybad3.get(j).getbound())){
                        bullet2.remove(i);
                        mybad3.remove(j);
                        score += 10;
                        mychar.checkshoot = 0;
                        checkshooting = false;
                    }
                }  
            }
        }
        
        if(checkbacktofront == 0){
            if(mychar.checkshoot == 1){
                g.drawImage(mychar.cshootw.getImage(), mychar.x, mychar.y, 100, 100, this);
                for(int i=0;i<bullet.size();i++){
                Bullet ba = bullet.get(i);
                g.drawImage(ba.bullet1[ba.count%5].getImage(), ba.x, ba.y,80,50, null);
                ba.move();
                ba.count++;
                if(ba.x>=mychar.x+300){
                    bullet.remove(i);
                    mychar.checkshoot = 0;
                    checkshooting = false;
                } 
            }

            }
            else{ 
                if(mychar.count > 0){
                    g.drawImage(mychar.cwrun.getImage(), mychar.x, mychar.y, 80, 100, this);
                }
                else if(mychar.count == 0){
                    g.drawImage(mychar.cw.getImage(), mychar.x, mychar.y, 100, 100, this);
                }    
            }
        }           
        else if(checkbacktofront == 1){
            if(mychar.checkshoot == 1){
                g.drawImage(mychar.cshootwb.getImage(), mychar.x, mychar.y, 100, 100, this);
                for(int i=0;i<bullet2.size();i++){
                    bullet2 ba2 = bullet2.get(i);
                    g.drawImage(ba2.bullet2[ba2.count%5].getImage(), ba2.x, ba2.y,80,50, null);
                    ba2.move();
                    ba2.count++;
                    if(ba2.x<=mychar.x-300){
                        bullet2.remove(i);
                        mychar.checkshoot = 0;
                        checkshooting = false;
                    }
                }      
            }
            else{
                if(mychar.count > 0){
                    g.drawImage(mychar.cwbrun.getImage(), mychar.x+18, mychar.y, 80, 100, this);
                }
                else if(mychar.count == 0){
                    g.drawImage(mychar.cwb.getImage(), mychar.x, mychar.y, 100, 100, this);
                }  
            }
        }

         if(mychar.alive <= 0 || times == 0){
            this.setLayout(null);
            g.setColor(Color.BLUE);
            g.drawImage(background.getImage(), 0, 0, 1200, 800, this);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,50));		
            g.drawString("SCORE   "+score,450,300);	     
            g.drawImage(youlose.getImage(), 400, 0, 400, 200, this);
            timer.stop();
            timercount.stop();
        } 
        if(score == 250){
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(background.getImage(), 0, 0, 1200, 800, this);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,50));		
            g.drawString("SCORE   "+score,450,300);	     
            g.drawImage(youwin.getImage(), 400, 0, 400, 200, this);
            timer.stop();
            timercount.stop();
            timestart = false;
            Go1.setBounds(800, 350, 404, 400);
            Go1.setBorderPainted(false);
            Go1.setBorder(null);
            Go1.setOpaque(false);
            Go1.setContentAreaFilled(false); 
            add(Go1);
        }
    }
}
