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
public class Obj_putArr extends nodo {

    String obj, id;
    int i;
    nodo e;
    
    public Obj_putArr(String obj, String id, int i, nodo e){
        this.obj = obj;
        this.id = id;
        this.i = i;
        this.e = e;
    }
    
    @Override
    public nodo run(env ambiente) {
        nodo e = this.e.run(ambiente);
        
        simbol obj = ambiente.get(this.obj);
        if(obj.tipo.equalsIgnoreCase("objeto")){
            ((LinkedList)obj.val).forEach((a) -> {
                if(a instanceof Obj_a_arr && ((Obj_a_arr)a).id.equalsIgnoreCase(this.id)){
                    ((LinkedList<nodo>)((Obj_a_arr)a).val).get(i).val = e.val;
                    this.val = ((LinkedList<nodo>)((Obj_a_arr)a).val).get(i).val;
                }
            });
        }
        
        return this;    
    }
    
}
