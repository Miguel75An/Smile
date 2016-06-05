import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Eyes extends JApplet
{
   private int x  ;
   private int y ;
   private JTextField theX;
   private JTextField theY;
   private int outX1 = 149;
   private int outY1 = 169;
   private int outWidth1 = 40;
   private int outHeight1 = 60;
   //yield2
   private int outX2 = 209;
   private int outY2 = 169;
   private int outWidth2 = 40;
   private int outHeight2 = 60;
   //eye1
   private int inX1 = 164;
   private int inY1 = 199;
   private int inWidth1 = 10;
   private int inHeight1 = 10;
   //eye2
   private int inX2 = 224;
   private int inY2 = 199;
   private int inWidth2 = 10;
   private int inHeight2 = 10;
   
      

      
   //init
   
   public void init()
   {
      setLayout(new FlowLayout());
      //create
      theX = new JTextField( 10);
      //theX.setEditable(false);
      theX.setText("" + x);
      theY = new JTextField( 10);
      theY.setText("" + y);
      //Add
      add(theX);
      add(theY);
      //Mouse Listener
      addMouseListener(new theMouseListener());
      addMouseMotionListener(new MotionListener());
   }
   //To draw in panel
   
   public void paint(Graphics m)
   {
      super.paint(m);
      theX.setText("" + x);
      theY.setText("" + y);
      //Yellow face
      m.setColor(Color.yellow);
      m.fillOval(129, 129, 140,140);
      //Two yields and 2 eyes
         m.setColor(Color.white);
         //Yields
         m.fillOval(outX1,outY1,outWidth1,outHeight1);
         m.fillOval(outX2,outY2,outWidth2,outHeight2);
         //EYes
         m.setColor(Color.black);
         m.fillOval(inX1,inY1,inWidth1,inHeight1);
         m.fillOval(inX2,inY2,inWidth2,inHeight2); 
         
         //Smile
         m.setColor(Color.white);
         m.fillArc(160, 215, 80, 50, 180, 180); 
         //Smile Line
         m.setColor(Color.black);
         m.fillRect(165,250, 70,3);
         m.fillRect(200, 240, 3, 25);
         m.fillRect(180, 240, 3, 20);
         m.fillRect(220, 240, 3, 20);     
   }
   
    private class theMouseListener
                          implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
      }

      public void mouseClicked(MouseEvent e)
      {
                 
      }

      public void mouseReleased(MouseEvent e)
      {
      }

      public void mouseEntered(MouseEvent e)
      {
         
      }

      public void mouseExited(MouseEvent e)
      {
         inX1 = 166;
         inY1 = 199;
         inX2 = 224;
         inY2 = 199;
         repaint();
          
      }
   }

    ///Motion
    
      
   private class MotionListener
                         implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
       }

      public void mouseMoved(MouseEvent e)
      {
         //theX.setText("X: " + e.getX());
         x = e.getX();
         //System.out.println("Motion" + x);
         
         inX1 = x - 35; //Moves X1 eye
         inX2 = x + 25; //Moves X2 eye
         //MinIRectangle X
         if(inX1 > 175)
         {
            inX1 = 175;
         }
         if(inX1 < 154)
         {
            inX1 = 154;
         }
         if(inX2 < 215)
         {
            inX2 = 215;
         }
         if(inX2 > 234)
         {
            inX2 = 234;
         }
         
         //theY.setText("Y: " + e.getY()); 
         y = e.getY();
          inY1 = y ; //Moves Y1 eye
          inY2 = y ; //Moves Y2 eye
          //MIni Rectangle Y 
          if(inY1 < 179)
          {
             inY1 = 179;
          }
          if(inY1 > 210)
          {
             inY1 = 210;
          }
           if(inY2 < 179)
          {
             inY2 = 179;
          }
          if(inY2 > 210)
          {
             inY2 = 210;
          }
          
         
                    
 
          
         //Use repaint so the graphs are drawin with NEW CORDINATES
         repaint();   
      }
   }
   
   
}