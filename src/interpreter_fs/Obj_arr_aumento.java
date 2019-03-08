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
public class Obj_arr_aumento extends nodo {

    String obj, id;
    int i, aumento;
    
    public Obj_arr_aumento(String obj, String id, int i, int aumento) {
        this.obj = obj;
        this.id = id;
        this.i = i;
        this.aumento = aumento;
    }
    
    @Override
    public nodo run(env ambiente) {
        simbol obj = ambiente.get(this.obj);
        if(obj.tipo.equalsIgnoreCase("objeto")){
            ((LinkedList)obj.val).forEach((a) -> {
                if(a instanceof Obj_a_arr && ((Obj_a_arr)a).id.equalsIgnoreCase(this.id)){
                    this.val = ((LinkedList<nodo>)((Obj_a_arr)a).val).get(i).val;
                    ((LinkedList<nodo>)((Obj_a_arr)a).val).get(i).val = setVal(((LinkedList<nodo>)((Obj_a_arr)a).val).get(i).val);
                }
            });
        }
        
        return this;   
    }

    private Object setVal(Object val) {
        if(val instanceof Integer){
            return (int)val + aumento;
        }else if(val instanceof Double){
            return (double)val + aumento;
        }else if(val instanceof String){
            return (String)val + aumento;
        }else{
            // throw aritmetic error
            return val;
        }
    }
    
}
