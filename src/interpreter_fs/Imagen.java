/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author freddy
 */
public class Imagen extends nodo {

    String id;
    nodo path, x, y, alto, ancho;
    
    public Imagen(String i, nodo r, nodo x, nodo y, nodo h, nodo w) {
        this.id = i;
        this.path = r;
        this.x = x;
        this.y = y;
        this.alto = h;
        this.ancho = w;
    }

    @Override
    public nodo run(env ambiente) {
        Object panel = ambiente.get(id).val;
        
        if(panel instanceof JPanel){
            Object path = this.path.run(ambiente).val;
            Object x = this.x.run(ambiente).val;
            Object y = this.y.run(ambiente).val;
            Object alto = this.alto.run(ambiente).val;
            Object ancho = this.ancho.run(ambiente).val;
            
            BufferedImage myPicture = null;
            
            if(path instanceof String){
                try {
                    myPicture = ImageIO.read(new File((String) path));
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            
            JLabel img = new JLabel(new ImageIcon(myPicture));
            
            if(x instanceof Integer && y instanceof Integer)
                img.setLocation((int) x, (int) y);
            
            if(alto instanceof Integer && ancho instanceof Integer)
                img.setSize((int) ancho, (int) alto);
            
            ((JPanel) panel).add(img);
            
        }
        
        return this;
    }
    
}
