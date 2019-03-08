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
public class Maximo extends nodo {
    
    nodo arr;
    
    public Maximo(nodo arr){
        this.arr = arr;
    }

    @Override
    public nodo run(env ambiente) {
        nodo arr = this.arr.run(ambiente);
        if(arr.val instanceof LinkedList){
            int max = (int) ((nodo) ((LinkedList)arr.val).get(0)).val;
            for(nodo str: ((LinkedList<nodo>)arr.val)){
                if(str.val instanceof Integer)
                    max = Math.max(max, (int)str.val);
                else if(str.val instanceof Double)
                    max = (int) Math.max(max, (double)str.val);
            }
            this.val = max;
        }
        
        return this;
    }
    
}
