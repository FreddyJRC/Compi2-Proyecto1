/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author freddy
 */
public class Texto extends nodo {

    String id;
    nodo fuente, tamano, color, x, y, negrita, cursiva, valor;
    
    public Texto(String id, nodo f, nodo t, nodo c, nodo x, nodo y, nodo n, nodo cur, nodo v) {
        this.id = id;
        this.fuente = f;
        this.tamano = t;
        this.color = c;
        this.x = x;
        this.y = y;
        this.negrita = n;
        this.cursiva = cur;
        this.valor = v;
    }

    @Override
    public nodo run(env ambiente) {
        
        Object panel = ambiente.get(id).val;
        
        if (panel instanceof JPanel){
            JLabel texto = new JLabel();
            
            Object fuente = this.fuente.run(ambiente).val;
            Object tamano = this.tamano.run(ambiente).val;
            Object color = this.color.run(ambiente).val;
            Object x = this.x.run(ambiente).val;
            Object y = this.y.run(ambiente).val;
            Object negrita = this.negrita.run(ambiente).val;
            Object cursiva = this.cursiva.run(ambiente).val;
            Object valor = this.valor.run(ambiente).val;
            
            if(valor instanceof String){
                texto = new JLabel((String) valor);
                texto.setSize(texto.getPreferredSize());
            }
            
            if(fuente instanceof String && tamano instanceof Integer && negrita instanceof Boolean && cursiva instanceof Boolean){
                if((boolean) negrita && (boolean) cursiva)
                    texto.setFont(new Font((String) fuente, Font.BOLD | Font.ITALIC, (int) tamano));
                
                else if((boolean) negrita)
                    texto.setFont(new Font((String) fuente, Font.BOLD, (int) tamano));
                
                else if((boolean) cursiva)
                    texto.setFont(new Font((String) fuente, Font.ITALIC, (int) tamano));
                
                else
                    texto.setFont(new Font((String) fuente, Font.PLAIN, (int) tamano));
            }
            
            if(color instanceof String)
                texto.setForeground(Color.decode((String) color));
            
            if(x instanceof Integer && y instanceof Integer)
                texto.setLocation((int) x, (int) y);
            
            texto.setSize(texto.getPreferredSize());
            ((JPanel) panel).add(texto);
            
            this.val = texto;
            
        }
        
        
        return this;
    }
    
}
