/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhr;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JComponent;

/**
 *
 * @author brunhuberfa82110
 */
public class Zeiger extends JComponent implements Runnable
{
    private static final float DICKE = 4f;
    private BasicStroke stift;
    private Line2D.Float line;
    private volatile float winkel;
    private float laenge;
    private long schlafzeit;
    private ExecutorService eService;
    private Future task;
    
    private AffineTransform at;
    
    public Zeiger(long schlafzeit)
    {
        this.schlafzeit = schlafzeit;
        line = new Line2D.Float();
        stift = new BasicStroke(DICKE);
        winkel = 0;
        laenge = 90;
        
        eService = Executors.newSingleThreadExecutor();
        task = null;
        
        this.at = new AffineTransform();
    }
    
    public void start()
    {
        if(task == null)
        {
            task = eService.submit(this);
        }
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        float breite = this.getWidth() - 1;
        float hoehe = this.getHeight() - 1;
        
        float x1 = breite/2;
        float y1 = hoehe/2;
        float x2 = x1 + laenge;
        float y2 = y1;
        
        line.setLine(x1,y1, x2, y2);
        
        g2.rotate(Math.toRadians(winkel), x1, y1);
        g2.setStroke(stift);
        g2.draw(line);
    }

    @Override
    public void run()
    {
        while(true)
        {
            winkel += 1;
            this.repaint();
            
            try
            {
                Thread.sleep(schlafzeit);
            }
            catch(Exception ex)
            {
                System.err.println(ex.toString());
            }
        }
    }
}
