/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author freddy
 */
public class Ventana extends nodo {
    
    nodo id, color, ancho, alto;
    
    public Ventana(nodo color, nodo ancho, nodo alto, nodo id){
        this.color = color;
        this.ancho = ancho;
        this.alto = alto;
        this.id = id;
    }

    @Override
    public nodo run(env ambiente) {
        String id = this.id.run(ambiente).val.toString();
        JFrame ventana = new JFrame(id);
        
        nodo c = this.color.run(ambiente);
        if(c.val instanceof String)
            ventana.getContentPane().setBackground(Color.decode((String) c.val));
        
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        nodo e1 = this.alto.run(ambiente);
        nodo e2 = this.ancho.run(ambiente);
        ventana.setSize(
                (e2.val instanceof Integer)? (int) e2.val : 10,
                (e1.val instanceof Integer)? (int) e1.val : 10);
        
        ventana.getContentPane().setLayout(null);
        this.val = ventana;

        return this;
    }
    
}
