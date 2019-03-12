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
public class getArr extends nodo {

    String id;
    int pos;
    
    public getArr(String id, int pos){
        this.id = id;
        this.pos = pos;
    }
    
    @Override
    public nodo run(env ambiente) {
        simbol arr = ambiente.get(this.id);
        if(arr.val instanceof LinkedList){
            this.val = ((LinkedList<nodo>)arr.val).get(pos).val;
        }
        
        return this;
    }
    
}
