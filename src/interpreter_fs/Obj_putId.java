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
public class Obj_putId extends nodo {

    String obj, id;
    nodo e;
    
    public Obj_putId(String obj, String id, nodo e){
        this.obj = obj;
        this.id = id;
        this.e = e;
    }
    
    @Override
    public nodo run(env ambiente) {
        nodo e = this.e.run(ambiente);
        
        simbol obj = ambiente.get(this.obj);
        if(obj.val instanceof LinkedList){
            ((LinkedList)obj.val).forEach((a) -> {
                if(a instanceof Obj_a && ((Obj_a)a).id.equalsIgnoreCase(this.id)){
                    ((Obj_a)a).val = e.val;
                    this.val = ((Obj_a)a).val;
                }
            });
        }
        
        return this;    
    }
    
}
