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
public class Obj_getArr extends nodo {

    nodo obj;
    String id;
    int i;
    
    public Obj_getArr(nodo obj, String id, int i){
        this.obj = obj;
        this.id = id;
        this.i = i;
    }
    
    @Override
    public nodo run(env ambiente) {
        nodo obj = this.obj.run(ambiente);
        if(obj.val instanceof LinkedList){
            ((LinkedList)obj.val).forEach((a) -> {
                if(a instanceof Obj_a_arr && ((Obj_a_arr)a).id.equalsIgnoreCase(this.id)){
                    this.val = ((LinkedList<nodo>)((Obj_a_arr)a).val).get(i).val;
                }
            });
        }
        
        return this;    
    }
    
}
