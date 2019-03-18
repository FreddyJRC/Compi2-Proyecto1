/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author freddy
 */
public class Boton extends nodo {

    String id;
    nodo fuente, tamano, color, x, y, referencia, valor, alto, ancho;
    
    public Boton(String i, nodo f, nodo t, nodo c, nodo x, nodo y, nodo r, nodo v, nodo h, nodo w) {
        this.id = i;
        this.fuente = f;
        this.tamano = t;
        this.color = c;
        this.x = x;
        this.y = y;
        this.referencia = r;
        this.valor = v;
        this.alto = h;
        this.ancho = w;
    }

    @Override
    public nodo run(env ambiente) {
        
        Object panel = ambiente.get(id).val;
        
        if(panel instanceof JPanel){
            JButton btn = new JButton();
            
            Object fuente = this.fuente.run(ambiente).val;
            Object tamano = this.tamano.run(ambiente).val;
            Object color = this.color.run(ambiente).val;
            Object x = this.x.run(ambiente).val;
            Object y = this.y.run(ambiente).val;
            Object referencia = this.referencia.run(ambiente).val;
            Object valor = this.valor.run(ambiente).val;
            Object alto = this.alto.run(ambiente).val;
            Object ancho = this.ancho.run(ambiente).val;
            
            if(valor instanceof String)
                btn.setText((String) valor);
            
            if(fuente instanceof String && tamano instanceof Integer)
                btn.setFont(new Font((String) fuente, 0, (int) tamano));
            
            if(x instanceof Integer && y instanceof Integer)
                btn.setLocation((int) x, (int) y);
            
            if(alto instanceof Integer && ancho instanceof Integer)
                btn.setSize((int) ancho, (int) alto);
            else
                btn.setSize(btn.getPreferredSize());
            
            if(referencia instanceof String){
                Object f = ambiente.get((String) referencia).val;
                if(f instanceof JFrame){
                    btn.addActionListener((java.awt.event.ActionEvent evt) -> {
                        ((JFrame) f).setVisible(true);
                    });
                }
            }
            
            ((JPanel) panel).add(btn);
            this.val = btn;
        }
        
        return this;
    }
    
}
