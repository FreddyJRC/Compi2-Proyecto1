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
public class AlCargar extends nodo {
    
    String id;
    nodo funcion;
    
    public AlCargar(String id, nodo funcion){
        this.id = id;
        this.funcion = funcion;
    }

    @Override
    public nodo run(env ambiente) {
        simbol v = ambiente.get(this.id);
        
        if(v.val instanceof JFrame){
            if(funcion == null){

                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if(v.start != null){
                            if(v.start instanceof nodo){
                                ((nodo) v.start).run(ambiente);
                            }
                        }
                        
                        ((JFrame) v.val).setVisible(true);
                    }
                });
                
            } else {
                
                v.start = funcion;
                
            }
        }
        
        return this;
    }
    
}
