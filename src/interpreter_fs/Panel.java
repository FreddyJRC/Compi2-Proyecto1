/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author freddy
 */
public class Panel extends nodo {
    
    String id;
    nodo alto, ancho, color, borde, x, y;

    public Panel(String i, nodo h, nodo w, nodo c, nodo b, nodo x, nodo y) {
        this.id = i;
        this.alto = h;
        this.ancho = w;
        this.color = c;
        this.borde = b;
        this.x = x;
        this.y = y;
    }

    @Override
    public nodo run(env ambiente) {
        Object ventana = ambiente.get(id).val;
        if(ventana instanceof JFrame){
            JPanel panel = new JPanel();
            Object alto = this.alto.run(ambiente).val;
            Object ancho = this.ancho.run(ambiente).val;
            Object color = this.color.run(ambiente).val;
            Object borde = this.borde.run(ambiente).val;
            Object x = this.x.run(ambiente).val;
            Object y = this.y.run(ambiente).val;
            
            if(alto instanceof Integer && ancho instanceof Integer)
                panel.setSize((int)alto, (int)ancho);
            
            if(color instanceof String)
                panel.setBackground(Color.decode((String) color));
            
            if(borde instanceof Boolean && (Boolean)borde)
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
            
            if(x instanceof Integer && y instanceof Integer)
                panel.setLocation((int) x, (int) y);
            panel.setLayout(null);
            ((JFrame) ventana).getContentPane().add(panel);
            
            this.val = panel;
        }
        
        return this;
    }
    
}
