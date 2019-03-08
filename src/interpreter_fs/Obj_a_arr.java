/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.LinkedList;

/**
 *
 * @author freddy
 */
public class Obj_a_arr extends nodo {
        
    String id;
    LinkedList<nodo> elementos;

    public Obj_a_arr(String id, LinkedList elementos){
        this.id = id;
        this.elementos = elementos;
    }
    
    @Override
    public nodo run(env ambiente) {
        if(elementos != null){
            this.elementos.forEach((nodo e) -> {
                nodo run = e.run(ambiente);
            });
        }
        
        this.val = elementos;
        
        return this;
    }
    
}
