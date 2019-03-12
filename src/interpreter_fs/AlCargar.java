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
        Object v = ambiente.get(this.id).val;
        
        if(funcion == null){
            if(v instanceof JFrame){
                //System.out.println(((JFrame) v).getBackground());
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ((JFrame) v).setVisible(true);
                    }
                });
            }
        }
        
        return this;
    }
    
}
