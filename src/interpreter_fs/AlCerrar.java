/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import javax.swing.JFrame;

/**
 *
 * @author freddy
 */
public class AlCerrar extends nodo {

    String id;
    nodo funcion;
    
    public AlCerrar(String i, nodo f) {
        this.id = i;
        this.funcion = f;
    }

    @Override
    public nodo run(env ambiente) {
        
        simbol v = ambiente.get(this.id);
        
        if(v.val instanceof JFrame){
            if(funcion == null){
                
                ((JFrame) v.val).addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        if(v.exit != null)
                            if(v.exit instanceof nodo)
                                ((nodo) v.exit).run(ambiente);
                        
                        System.exit(0);
                    }
                });
                
            } else {
                v.exit = funcion;
            }
        }
        
        return this;
    }
    
}
