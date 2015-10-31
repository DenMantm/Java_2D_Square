/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dencorp.java2d;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Deniss
 */
public class Test extends Canvas{

    	private BufferStrategy strategy;
      final static int interval = 24;
      final static int interval2 = 1000;
       final static int interval3 = 24;
private int time =0 ,left;
private int x = 400, y = 300;
private int z= 10;
private int m = 10;
private String timeLeft = "0";
//Creating new timer
javax.swing.Timer t;
javax.swing.Timer t2;
javax.swing.Timer t3;
    public Test() {
		// create a frame to contain our game
		JFrame container = new JFrame("Java 2D Test");
		
		// get hold the content of the frame and set up the resolution of the game
		JPanel panel = (JPanel) container.getContentPane();
		panel.setPreferredSize(new Dimension(800,600));
		panel.setLayout(null);
		
		// setup our canvas size and put it into the content of the frame
		setBounds(0,0,800,600);
		panel.add(this);
		
		// Tell AWT not to bother repainting our canvas since we're
		// going to do that our self in accelerated mode
		setIgnoreRepaint(true);
		
		// finally make the window visible 
		container.pack();
		container.setResizable(false);
		container.setVisible(true);
		
		// add a listener to respond to the user closing the window. If they
		// do we'd like to exit the game
		container.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		                //Create Timer1:
                 t = new javax.swing.Timer(interval,new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                if(x==720)z = -10;
                else if(x==0)z = 10;
                if(y==0) m = 10;
                if(y==520) m = -10;
                x= x+z;
                y = y+m;
            }
});  
                  t2 = new javax.swing.Timer(interval2,new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                        //Time left
                time++;
                timeLeft = Integer.toString(time);  
            }
});     
                  
                TimerStart();               
                 Game();     
    }
   public void TimerStart(){
        time = 0;
        t.start();
        t2.start();
   }
    public void Game(){
        //Main Game Timed loop
      t3 = new javax.swing.Timer(interval3,new ActionListener(){
     public void actionPerformed(ActionEvent e) {
    Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
    g.setColor(Color.black);
    g.fillRect(0,0,800,600);
    g.setColor(Color.white);
    g.drawString(timeLeft+" sec",(50),60);
    g.setColor(Color.blue);
    g.fillRect(x,y,80,60);
    g.dispose();
    strategy.show();
                }
});     
     //Starting game timer
      t3.start();       
    }
    
    
    
}
