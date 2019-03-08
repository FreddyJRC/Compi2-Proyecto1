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
public class aumento_Arr extends nodo {

    String id;
    int i, aumento;
    
    public aumento_Arr(String id, int i, int aumento){
        this.id = id;
        this.i = i;
        this.aumento = aumento;
    }
    
    @Override
    public nodo run(env ambiente) {
        simbol arr = ambiente.get(this.id);
        if(arr.tipo.equalsIgnoreCase("array")){
            this.val = ((LinkedList<nodo>)arr.val).get(i).val;
            ((LinkedList<nodo>)arr.val).get(i).val = setVal(((LinkedList<nodo>)arr.val).get(i).val);
        }
        
        return this;
    }

    private Object setVal(Object val) {
        if(val instanceof Integer){
            return (int)val + this.aumento;
        }else if(val instanceof Double){
            return (double)val + this.aumento;
        }else if(val instanceof String){
            return (String)val + this.aumento;
        }else{
            // throw aritmetic error
            return val;
        }
    }
    
}
