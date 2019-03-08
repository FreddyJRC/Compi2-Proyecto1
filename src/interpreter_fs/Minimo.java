/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 *
 * @author freddy
 */
public class Minimo extends nodo {
    
    nodo arr;
    
    public Minimo(nodo arr){
        this.arr = arr;
    }

    @Override
    public nodo run(env ambiente) {
        nodo arr = this.arr.run(ambiente);
        if(arr.val instanceof LinkedList){
            int min = (int) ((nodo) ((LinkedList)arr.val).get(0)).val;
            for(nodo str: ((LinkedList<nodo>)arr.val)){
                if(str.val instanceof Integer)
                    min = Math.min(min, (int)str.val);
                else if(str.val instanceof Double)
                    min = (int) Math.min(min, (double)str.val);
            }
            this.val = min;
        }
        
        return this;
    }
    
}
