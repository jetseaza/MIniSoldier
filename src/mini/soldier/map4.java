
package mini.soldier;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;

public class map4 extends JPanel implements ActionListener{
    
    private ImageIcon background = new ImageIcon(this.getClass().getResource("city4.png"));
    private ImageIcon Box = new ImageIcon(this.getClass().getResource("box.png"));
    private ImageIcon champion = new ImageIcon(this.getClass().getResource("city5.png"));
    private ImageIcon youlose = new ImageIcon(this.getClass().getResource("youlose.png"));
    private ImageIcon Go = new ImageIcon(this.getClass().getResource("Gobutton.png"));
    soldier mychar = new soldier();
    bomp bomp1 = new bomp();
    boss boss = new boss();
    
    public int checkbacktofront = 0;
    public int checknearsrus = 0;
    public int times = 60;
    public int score;
    
    public int shoot;
    public boolean checkstart = false ;
    public int checkfix = 0;
    public boolean checkshooting = false;
    public boolean checkammo = false;
    public int timeammo = 0;
    
    public ArrayList<Bullet> bullet = new ArrayList<Bullet>();
    public ArrayList<bullet2> bullet2 = new ArrayList<bullet2>();
    public ArrayList<bomp> bomp = new ArrayList<bomp>();
    public ArrayList<bomp1> bompp1 = new ArrayList<bomp1>();
    public ArrayList<bompfire> bompf = new ArrayList<bompfire>();
    
 
    public boolean checkheartinchar = false;
    
    public JButton NextLevel = new JButton(Go);
    public boolean checktime = false;
    boolean timestart = true;
    private Timer timer = new Timer(30, new Listener());
 
    private Timer timercount = new Timer(1000, new Listener());

    public int checknearbadguys;
    public int checkdelay = 0;
  
    boolean startbomp = false;

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
                             Thread.sleep((long)(Math.random()*10000)+2000);
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
    Thread timebompf = new Thread(new Runnable(){
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
                        bompf.add(new bompfire());
                     }
             }
         }
     });

    Thread timechecknear = new Thread(new Runnable(){
         public void run() {
             while(true){
                try{
                    if(checkstart == true){
                        if(boss.alive == true){
                            if(boss.back == false){
                                if(boss.x<=0) 
                                    boss.x=1000;
                                else 
                                    boss.x= boss.x-20;
                            }
                            else{
                                if(boss.x<=0) 
                                    boss.x=1000;
                                else 
                                    boss.x= boss.x+20;
                            }
                            boss.distanceP = (int)Math.sqrt((Math.pow(Math.abs(boss.x-mychar.x),2))+(Math.pow(Math.abs(boss.y-mychar.y),2)));

                            if(boss.distanceP <= 100){
                                checknearsrus = 1;
                            }
                            else{
                                checknearsrus = 0;
                            } 

                            if(checkbacktofront == 0){  
                                if(boss.distanceP <= 100){
                                    boss.x = mychar.x+200;
                                    mychar.alive-=20;
                                }
                            }
                            else if(checkbacktofront == 1){

                                if(boss.distanceP <= 100){
                                    boss.x = mychar.x-200;
                                    mychar.alive-=20;
                                }
                            }


                            if(boss.x <= 50){
                                boss.back = true;
                            }
                            else if(boss.x >= 1100){
                                boss.back = false;
                            }

                        } 

                        if(checkammo == true){
                            timeammo++;
                        }

                        for(int i=0; i<bullet.size(); i++){
                            if(timeammo >= 2){
                                if(mychar.checkshoot == 1){
                                    boss.health -= 10;
                                    score += 1000;
                                    bullet.remove(i);
                                    checkammo = false;
                                    timeammo = 0;
                                    mychar.checkshoot = 0;
                                    checkshooting = false;
                                }
                            }
                        }               
                    for(int i=0; i<bullet2.size(); i++){
                        if(timeammo >= 2){
                            if(mychar.checkshoot == 1){
                                boss.health -= 10;
                                score += 1000;
                                bullet2.remove(i);
                                checkammo = false;
                                timeammo = 0;
                                mychar.checkshoot = 0;
                                checkshooting = false;
                            }
                        }
                    }
                }
                
                    
                    
                    Thread.sleep(100);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
             }
         }
     });
    map4(){
        this.setFocusable(true);
        this.setLayout(null);
        
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a == KeyEvent.VK_D){
                    if(checkshooting == false){
                        checkbacktofront = 0;
                        checktime = true;
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
                        checktime = true;
                        
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
        timebomp.start();
        timebomp1.start();
        timebompf.start();
        timechecknear.start();
        timercount.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
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
        g.setColor(Color.BLUE);
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
        for(int i=0 ; i<bompf.size();i++){
            g.drawImage( bompf.get(i).getImage() ,bompf.get(i).getX(),bompf.get(i).getY(),70,90,this);
            mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-bompf.get(i).getX()),2))+(Math.pow(Math.abs(mychar.y-bompf.get(i).getY()),2)));
            
            if(mychar.distanceP <= 50){
                bompf.remove(i);
                mychar.alive -= 20;
            }
        }
        
        if(boss.alive == true)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE, 15));	
            g.drawString("BOSS HP: "+boss.health, boss.x+10, boss.y-10);  
            
            if(boss.back == true){
                g.drawImage(boss.imb.getImage(), boss.x, boss.y, 150, 150, this); 
            }
            else{
               g.drawImage(boss.im.getImage(), boss.x, boss.y, 150, 150, this); 
            }
        }
        
        
        
        //badright
        if(checkbacktofront == 0){
            if(mychar.checkshoot == 1){
                for(int i=0; i<bullet.size(); i++){
                    mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-boss.x),2))+(Math.pow(Math.abs(mychar.y-boss.y),2)));
                    if(mychar.distanceP <= 300){
                        checkammo = true;
                    }
                }
            }
        }
        else if(checkbacktofront == 1){
            if(mychar.checkshoot == 1){
                for(int i=0; i<bullet2.size(); i++){
                    mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-boss.x),2))+(Math.pow(Math.abs(mychar.y-boss.y),2)));
                    if(mychar.distanceP <= 300){
                        checkammo = true;
                    }
                }
            }
        }
        
        //badleft

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
            g.setColor(Color.RED);
            g.drawImage(background.getImage(), 0, 0, 1200, 800, this);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,50));		
            g.drawString("SCORE   "+score,450,300);	     
            g.drawImage(youlose.getImage(), 400, 0, 400, 200, this);
            timer.stop();
            timercount.stop();
        } 
        if(boss.health == 0){
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(champion.getImage(), 0, 0, 1200, 800, this);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,50));		
            g.drawString("SCORE   "+score,450,300);	     
            timer.stop();
            timercount.stop();       
        }
    }
}
