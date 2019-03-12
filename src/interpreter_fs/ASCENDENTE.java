/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author freddy
 */
public class ASCENDENTE extends nodo {

    String obj, id;
    nodo e;
    
    public ASCENDENTE(String obj, String id){
        this.obj = obj;
        this.id = id;
    }
    
    public ASCENDENTE(nodo e){
        this.e = e;
    }
    
    @Override
    public nodo run(env ambiente) {
        if(this.e == null){
            if(obj == null){
                simbol arr = ambiente.get(id);
                if(arr.tipo.equalsIgnoreCase("array")){
                    //((LinkedList)arr.val).sort(Comparator.reverseOrder());
                    Collections.sort((LinkedList)arr.val, new Comparator<Object>() {
                        @Override
                        public int compare(Object t, Object t1) {
                            t = ((nodo)t).val;
                            t1 = ((nodo)t1).val;
                            if(t instanceof String && t1 instanceof String)
                                return -(((String)t).compareTo((String)t1));
                            else if (t instanceof Integer && t1 instanceof Integer)
                                return -((int)t - (int)t1);
                            else if (t instanceof Double && t1 instanceof Double)
                                return -((int) ((double)t - (double)t1));
                            return 0;
                        }

                    });
                }
            }else{
                simbol obj = ambiente.get(this.obj);
                if(obj.tipo.equalsIgnoreCase("objeto")){
                    ((LinkedList)obj.val).forEach((a) -> {
                        if(a instanceof Obj_a_arr && ((Obj_a_arr)a).id.equalsIgnoreCase(this.id)){
                            //((LinkedList)((Obj_a_arr)a).val).sort(Comparator.reverseOrder());
                            Collections.sort((LinkedList)((Obj_a_arr)a).val, new Comparator<Object>() {
                                @Override
                                public int compare(Object t, Object t1) {
                                    t = ((nodo)t).val;
                                    t1 = ((nodo)t1).val;
                                    if(t instanceof String && t1 instanceof String)
                                        return -(((String)t).compareTo((String)t1));
                                    else if (t instanceof Integer && t1 instanceof Integer)
                                        return -((int)t - (int)t1);
                                    else if (t instanceof Double && t1 instanceof Double)
                                        return -((int) ((double)t - (double)t1));
                                    return 0;
                                }

                            });
                        }
                    });
                }
            }
        } else {
            nodo e = this.e.run(ambiente);
            if (e.val instanceof LinkedList){
                Collections.sort((LinkedList)e.val, new Comparator<Object>() {
                        @Override
                        public int compare(Object t, Object t1) {
                            t = ((nodo)t).val;
                            t1 = ((nodo)t1).val;
                            if(t instanceof String && t1 instanceof String)
                                return -(((String)t).compareTo((String)t1));
                            else if (t instanceof Integer && t1 instanceof Integer)
                                return -((int)t - (int)t1);
                            else if (t instanceof Double && t1 instanceof Double)
                                return -((int) ((double)t - (double)t1));
                            return 0;
                        }
                });
                
                this.val = e.val;
            }
        }
        
        return this;
    }
    
}
