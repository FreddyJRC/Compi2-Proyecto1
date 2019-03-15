/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author freddy
 */
public class AlClic extends nodo{

    String id;
    nodo funcion; 
    
    public AlClic(String i, nodo f) {
        this.id = i;
        this.funcion = f;
    }

    @Override
    public nodo run(env ambiente) {
        Object boton = ambiente.get(id).val;
        if(boton instanceof JButton){
            ((JButton) boton).addActionListener((java.awt.event.ActionEvent evt) -> {
                this.funcion.run(ambiente);
            });
        }
        
        return this;
    }
    
}
