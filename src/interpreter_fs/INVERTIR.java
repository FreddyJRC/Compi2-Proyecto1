/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author freddy
 */
public class INVERTIR extends nodo{
    
    String obj, id;
    
    public INVERTIR(String obj, String id){
        this.obj = obj;
        this.id = id;
    }

    @Override
    public nodo run(env ambiente) {
        if(obj == null){
            simbol arr = ambiente.get(id);
            if(arr.tipo.equalsIgnoreCase("array")){
                Iterator<nodo> it = ((LinkedList)arr.val).descendingIterator();
                LinkedList reverse = new LinkedList();
                it.forEachRemaining(a -> {
                    reverse.add(a);
                });
                arr.val = reverse;
            }
        }else{
            simbol obj = ambiente.get(this.obj);
            if(obj.tipo.equalsIgnoreCase("objeto")){
                ((LinkedList)obj.val).forEach((a) -> {
                    if(a instanceof Obj_a_arr && ((Obj_a_arr)a).id.equalsIgnoreCase(this.id)){
                        Iterator<nodo> it = ((LinkedList)((Obj_a_arr)a).val).descendingIterator();
                        LinkedList reverse = new LinkedList();
                        it.forEachRemaining(r -> {
                            reverse.add(r);
                        });
                        ((Obj_a_arr)a).val = reverse;
                    }
                });
            }
        }
        
        return this;
    }
    
}
