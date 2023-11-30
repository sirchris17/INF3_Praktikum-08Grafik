/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uhr;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.OverlayLayout;
import javax.swing.WindowConstants;

/**
 *
 * @author brunhuberfa82110
 */
public class Start
{
    public Start()
    {
        JFrame frm = new JFrame();
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c = frm.getContentPane();
        
        c.setLayout(new OverlayLayout(c));
        
        Kreis kreis = new Kreis();
        kreis.setOpaque(false);
        c.add(kreis);
        
        Zeiger sekundenZeiger = new Zeiger(10);
        Zeiger minutenZeiger = new Zeiger(600);
        Zeiger stundenZeiger = new Zeiger(36000);
        
        sekundenZeiger.setOpaque(false);
        c.add(sekundenZeiger);
        sekundenZeiger.start();
        
        minutenZeiger.setOpaque(false);
        c.add(minutenZeiger);
        minutenZeiger.start();
        
        stundenZeiger.setOpaque(false);
        c.add(stundenZeiger);
        stundenZeiger.start();
        
        frm.setSize(300, 300);
        frm.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new Start();
    }
    
}
