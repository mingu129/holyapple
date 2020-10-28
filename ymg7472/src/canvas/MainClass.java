package canvas; 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * <pre>
 * canvas 
 * CanvasTest.java
 *
 * ���� :	
 * </pre>
 * 
 * @since : 2020. 10. 25.
 * @author : ymg74
 * @version : v1.0
 */
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
  
public class MainClass {    
    
    public static void main(String[] a) {
        
        JFrame f = new JFrame();
        f.setSize(1000,1000);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible( true );
                
        BufferedImage bi = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB );
        
        JLabel l = new JLabel(new ImageIcon(bi) );
        l.setBounds(20,20,160,160);
        f.add(l);
        
        // �귯����� Ŭ������ �����Ѵ�. �Ʒ��ʿ� ������.
        Brush b = new Brush();
        b.setBounds(20,20,160,160); //ũ�Ⱑ l�� ���ƾ� �Ѵ�.
        f.add(b);
        
        
        // ���콺 ��� �̺�Ʈ
        l.addMouseMotionListener( new MouseMotionListener() {
            
            public void mouseDragged(MouseEvent e) {
                
                b.xx=e.getX();
                b.yy=e.getY();
                b.repaint();                            
                b.printAll(  bi.getGraphics() ); //�귯���� BufferedImage �� �׸���.                
            }
            
            public void mouseMoved(MouseEvent e) {

            }           
        });
        
    }   
}


class Brush extends JLabel{
        
    public int xx, yy;
    public Color col=new Color(255,0,0);
    
    public void paint(Graphics g) {     
    
        g.setColor( col );
        g.fillOval(xx-10, yy-10, 20, 20);
        
    }   
}