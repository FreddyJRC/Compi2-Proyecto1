/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 *
 * @author freddy
 */
public class OPE extends nodo {
    
    //String id;
    nodo id, e;

    public OPE(nodo i, nodo e) {
        this.id = i;
        this.e = e;
    }

    @Override
    public nodo run(env ambiente) {
        Hashtable tmp = (Hashtable) this.id.run(ambiente).val;
        LinkedList res = new LinkedList();
        
        Object e = this.e.run(ambiente).val;
        
        tmp.forEach((k, v) -> {
            LinkedList<Obj_a> attrs = (LinkedList<Obj_a>) ((simbol) v).val;
            for(Object a : attrs){
                if(a instanceof Obj_a && ((Obj_a)a).id.equalsIgnoreCase("etiqueta") && ((Obj_a)a).val.toString().equalsIgnoreCase(e.toString())){
                    res.add(v);
                }
            }
        });
        
        this.val = res;
        return this;
    }
    
}
