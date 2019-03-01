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
public class dec_arr extends nodo{

    String id;
    LinkedList<nodo> elementos;
    
    public dec_arr(String id, LinkedList<nodo> elementos){
        this.id = id;
        this.elementos = elementos;
    }
    
    @Override
    public nodo run(env ambiente) {
        if(elementos != null){
            this.elementos.forEach((e) -> {
                e.run(ambiente);
            });
        }
        ambiente.put(id, "array", elementos);
        
        return this;
    }
    
}
