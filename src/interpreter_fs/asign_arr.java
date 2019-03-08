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
public class asign_arr extends nodo {

    String id;
    int i;
    nodo e;
    
    public asign_arr(String id, int i, nodo e){
        this.id = id;
        this.i = i;
        this.e = e;
    }
    
    @Override
    public nodo run(env ambiente) {
        nodo e = this.e.run(ambiente);
        
        simbol arr = ambiente.get(this.id);
        if(arr.tipo.equalsIgnoreCase("array")){
            ((LinkedList<nodo>)arr.val).get(i).val = e.val;
            this.val = ((LinkedList<nodo>)arr.val).get(i).val;
        }
        
        return this;
    }
    
}
