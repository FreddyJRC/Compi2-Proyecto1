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
public class aumento extends nodo {
    
    nodo e;
    int aumento;
    
    public aumento(nodo e, int aumento){
        this.e = e;
        this.aumento = aumento;
    }

    @Override
    public nodo run(env ambiente) {
        nodo e = this.e.run(ambiente);
        
        if(e instanceof getId){
            
            this.val = e.val;
            
            if(e.val instanceof Integer)
                ambiente.set(((getId) e).id, (int)this.val + this.aumento);
            
            else if(e.val instanceof Double)
                ambiente.set(((getId) e).id, (double)this.val + this.aumento);
            
        }else if(e instanceof Obj_getId){
            
            if(((Obj_getId) e).obj.val instanceof LinkedList){
                
                ((LinkedList)((Obj_getId) e).obj.val).forEach((a) -> {
                    if(a instanceof Obj_a && ((Obj_a)a).id.equalsIgnoreCase(((Obj_getId) e).id)){
                        this.val = ((Obj_a)a).val;
                        
                        if(this.val instanceof Integer)
                            ((Obj_a)a).val = (int) this.val + this.aumento;
                        
                        else if(this.val instanceof Double)
                            ((Obj_a)a).val = (double) this.val + this.aumento;
                    }
                });
                
            }
            
        }else if(e instanceof getArr){
            
            this.val = e.val;
            
            if(this.val instanceof Integer)
                ((LinkedList<nodo>)(ambiente.get(((getArr) e).id)).val).get(((getArr)e).pos).val = (int) this.val + this.aumento;
            
            else if(this.val instanceof Double)
                ((LinkedList<nodo>)(ambiente.get(((getArr) e).id)).val).get(((getArr)e).pos).val = (double) this.val + this.aumento;
            
        }else if(e instanceof Obj_getArr){
            
            if(((Obj_getArr) e).obj.val instanceof LinkedList){
                
                ((LinkedList) ((Obj_getArr) e).obj.val).forEach((a) -> {
                    if(a instanceof Obj_a_arr && ((Obj_a_arr)a).id.equalsIgnoreCase(((Obj_getArr) e).id)){
                        this.val = ((LinkedList<nodo>)((Obj_a_arr)a).val).get(((Obj_getArr) e).i).val;

                        if(this.val instanceof Integer)
                            ((LinkedList<nodo>)((Obj_a_arr)a).val).get(((Obj_getArr) e).i).val = (int) this.val + this.aumento;

                        else if(this.val instanceof Double)
                            ((LinkedList<nodo>)((Obj_a_arr)a).val).get(((Obj_getArr) e).i).val = (double) this.val + this.aumento;
                    }
                });
            
            }
        }else{
            
            if(e.val instanceof Integer)
                this.val = (int) e.val + this.aumento;
            
            else if(e.val instanceof Double)
                this.val = (double) e.val + this.aumento;
                    
        }
        
        return this;
    }
    
}
