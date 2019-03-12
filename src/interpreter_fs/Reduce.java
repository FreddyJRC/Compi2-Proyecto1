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
public class Reduce extends nodo {

    nodo e;
    String funcion;
    
    public Reduce(nodo e, String funcion){
        this.e = e;
        this.funcion = funcion;
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e = this.e.run(ambiente).val;
        
        if(e instanceof LinkedList){
            if(((LinkedList<nodo>) e).peekFirst().val instanceof Integer)
                this.val = 0;
            if(((LinkedList<nodo>) e).peekFirst().val instanceof Double)
                this.val = 0.0;
            if(((LinkedList<nodo>) e).peekFirst().val instanceof String)
                this.val = "";
            ((LinkedList<nodo>) e).forEach((nodo item) -> {
                
                LinkedList<nodo> parametros = new LinkedList<>();
                parametros.add(this);
                parametros.add(item);
                nodo f = (new call_f(this.funcion, parametros)).run(ambiente);
                if (f.val != null)
                    this.val = f.val;
            });
            
        }
        
        
        return this;
    }
    
}
