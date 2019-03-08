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

    String objeto, id;
    int i;
    
    public Obj_getArr(String objeto, String id, int i){
        this.objeto = objeto;
        this.id = id;
        this.i = i;
    }
    
    @Override
    public nodo run(env ambiente) {
        simbol obj = ambiente.get(this.objeto);
        if(obj.tipo.equalsIgnoreCase("objeto")){
            ((LinkedList)obj.val).forEach((a) -> {
                if(a instanceof Obj_a_arr && ((Obj_a_arr)a).id.equalsIgnoreCase(this.id)){
                    this.val = ((LinkedList<nodo>)((Obj_a_arr)a).val).get(i).val;
                }
            });
        }
        
        return this;    
    }
    
}
