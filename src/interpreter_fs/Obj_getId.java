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
public class Obj_getId extends nodo {
    
    nodo obj;
    String id;
    
    public Obj_getId(nodo obj, String id){
        this.obj = obj;
        this.id = id;
    }
    
    @Override
    public nodo run(env ambiente) {
        nodo obj = this.obj.run(ambiente);
        if(obj.val instanceof LinkedList){
            ((LinkedList)obj.val).forEach((a) -> {
                if(a instanceof Obj_a && ((Obj_a)a).id.equalsIgnoreCase(this.id)){
                    this.val = ((Obj_a)a).val;
                }
            });
        }
        
        return this;    
    }
    
}
