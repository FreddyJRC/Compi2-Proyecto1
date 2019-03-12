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
public class Obj_aumento extends nodo {
    
    String obj, id;
    int aumento;

    public Obj_aumento(String obj, String id, int aumento) {
        this.obj = obj;
        this.id = id;
        this.aumento = aumento;
    }

    @Override
    public nodo run(env ambiente) {
        simbol obj = ambiente.get(this.obj);
        if(obj.val instanceof LinkedList){
            ((LinkedList<Obj_a>)obj.val).forEach((a) -> {
                if((a).id.equalsIgnoreCase(this.id)){
                    this.val = a.val;
                    if(a.val instanceof Integer){
                        a.val = (int)a.val + aumento;
                    }else if(a.val instanceof Double){
                        a.val = (double)a.val + aumento;
                    }
                }
            });
        }
        
        return this;
    }
    
}
