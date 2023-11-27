/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhr;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

/**
 *
 * @author brunhuberfa82110
 */
public class Kreis extends JComponent
{
    private static final float DICKE = 4f;
    private BasicStroke stift;
    private Ellipse2D.Float ellipse;
    private float radius;
    
    public Kreis()
    {
        ellipse = new Ellipse2D.Float();
        stift = new BasicStroke(DICKE);
        radius = 100;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        float breite = this.getWidth() - 1;
        float hoehe = this.getHeight() - 1;
        
        float x = breite/2 - radius;
        float y = hoehe/2 - radius;
        
        ellipse.setFrame(x,y, 2*radius, 2*radius);
        
        g2.setStroke(stift);
        g2.draw(ellipse);
    }
}
