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
    
    String obj, id;
    
    public Obj_getId(String obj, String id){
        this.obj = obj;
        this.id = id;
    }
    
    @Override
    public nodo run(env ambiente) {
        simbol obj = ambiente.get(this.obj);
        if(obj.tipo.equalsIgnoreCase("objeto")){
            ((LinkedList<Obj_a>)obj.val).forEach((a) -> {
                if((a).id.equalsIgnoreCase(this.id)){
                    this.val = a.val;
                }
            });
        }
        
        return this;    
    }
    
}
