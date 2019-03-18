/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author freddy
 */
public class AreaTexto extends nodo{
    
    String id;
    nodo alto, ancho, fuente, tamano, color, x, y, negrita, cursiva, defecto, nombre;
    
    public AreaTexto(String i, nodo h, nodo w, nodo f, nodo t, nodo c, nodo x, nodo y, nodo n, nodo cur, nodo d, nodo name) {
        this.id = i;
        this.alto = h;
        this.ancho = w;
        this.fuente = f;
        this.tamano = t;
        this.color = c;
        this.x = x;
        this.y = y;
        this.negrita = n;
        this.cursiva = cur;
        this.defecto = d;
        this.nombre = name;
    }

    @Override
    public nodo run(env ambiente) {
        Object panel = ambiente.get(id).val;
        
        if(panel instanceof JPanel){
            JTextArea caja = new JTextArea();
            
            Object alto = this.alto.run(ambiente).val;
            Object ancho = this.ancho.run(ambiente).val;
            Object fuente = this.fuente.run(ambiente).val;
            Object tamano = this.tamano.run(ambiente).val;
            Object color = this.color.run(ambiente).val;
            Object x = this.x.run(ambiente).val;
            Object y = this.y.run(ambiente).val;
            Object negrita = this.negrita.run(ambiente).val;
            Object cursiva = this.cursiva.run(ambiente).val;
            Object defecto = this.defecto.run(ambiente).val;
            Object nombre = this.nombre.run(ambiente).val;
            
            if(alto instanceof Integer && ancho instanceof Integer)
                caja.setSize((int) ancho, (int) alto);
            
            if(fuente instanceof String && tamano instanceof Integer && negrita instanceof Boolean && cursiva instanceof Boolean){
                if((boolean) negrita && (boolean) cursiva)
                    caja.setFont(new Font((String) fuente, Font.BOLD | Font.ITALIC, (int) tamano));
                
                else if((boolean) negrita)
                    caja.setFont(new Font((String) fuente, Font.BOLD, (int) tamano));
                
                else if((boolean) cursiva)
                    caja.setFont(new Font((String) fuente, Font.ITALIC, (int) tamano));
                
                else
                    caja.setFont(new Font((String) fuente, Font.PLAIN, (int) tamano));
            }
            
            if(x instanceof Integer && y instanceof Integer)
                caja.setLocation((int) x, (int) y);
            
            if(defecto instanceof String)
                caja.setText((String) defecto);
            
            if(nombre instanceof String)
                caja.setName((String) nombre);
            
            ((JPanel) panel).add(caja);
        }
        
        return this;
    }
    
}
