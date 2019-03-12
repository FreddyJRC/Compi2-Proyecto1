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
public class Buscar extends nodo {

    nodo e;
    String funcion;
    
    public Buscar(nodo e, String funcion){
        this.e = e;
        this.funcion = funcion;
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e = this.e.run(ambiente).val;
        
        if(e instanceof LinkedList){
            for(nodo item : ((LinkedList<nodo>) e)){
                LinkedList<nodo> parametros = new LinkedList<>();
                parametros.add(item);
                nodo f = (new call_f(this.funcion, parametros)).run(ambiente);
                if (f.val != null && f.val instanceof Boolean && (boolean) f.val){
                    this.val = item.val;
                    break;
                }
            }            
        }
               
        return this;
    }
    
}
