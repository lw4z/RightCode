/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fafica.pi1.rightcode.telas;

import br.fafica.pi1.rightcode.exception.UsuariolistaVaziaException;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author EDWARD
 */

public class SplashRc extends JWindow {
    
    AbsoluteLayout absoluto;
    AbsoluteConstraints absimage, absbarra;
    ImageIcon  image;
    JLabel jlabel;
    JProgressBar barra  ;
    public SplashRc(){
       
        absoluto = new AbsoluteLayout();
        absbarra = new  AbsoluteConstraints(120,158);
        absimage = new  AbsoluteConstraints(0,0);
        
        jlabel   = new JLabel();
        image = new ImageIcon(this.getClass().getResource("rcode.png"));
        jlabel.setIcon(image);
        barra= new JProgressBar();
        barra.setPreferredSize(new Dimension(210,12));
        barra.setForeground(Color.GREEN);
        barra.setBackground(Color.gray);
        
        this.getContentPane().setLayout(absoluto);
        this.getContentPane().add(jlabel,absimage);
        this.getContentPane().add(barra,absbarra);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        new Thread(){
            public void run(){
              int i=0;
              while(i <101){
                  barra.setValue(i);
                  i++;
                  try {
                      sleep(35);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(SplashRc.class.getName()).log(Level.SEVERE, null, ex);
                      
                  }
                  
              }
           
           setVisible(false);
            try {  
        for (UIManager.LookAndFeelInfo info :UIManager.getInstalledLookAndFeels() ) {  
            if ( "Nimbus".equals( info.getName() ) ) {  
               UIManager.setLookAndFeel( info.getClassName() );
              
                 UIManager.put("nimbusBase", new Color(59, 110, 47 ));
                 UIManager.put("nimbusBlueGrey", new Color(150,195,180));
                 UIManager.put("control", new Color(100,197,200));
               
                break;  
            }  
        }  
    } catch ( ClassNotFoundException ex ) {  
        ex.printStackTrace();  
    } catch ( InstantiationException ex ) {  
        ex.printStackTrace();  
    } catch ( IllegalAccessException ex ) {  
        ex.printStackTrace();  
    } catch ( javax.swing.UnsupportedLookAndFeelException ex ) {  
        ex.printStackTrace();  
    }  
  
    java.awt.EventQueue.invokeLater( new Runnable() {  
        public void run() {  
                   
                new RightCode().setVisible( true );
        }  
    });    
            }
            
        }.start();
    }
    
     public static void main(String[]args){
        new SplashRc();
        
        
     }
     
}
