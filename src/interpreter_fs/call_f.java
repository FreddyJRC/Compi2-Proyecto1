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
public class call_f extends nodo {
    
    String id;
    LinkedList<nodo> parametros;
    
    public call_f(String id, LinkedList parametros){
        this.id = id;
        this.parametros = parametros;
    }
    
    @Override
    public nodo run(env ambiente) {
        funcion a = display.getFunction(this.id, this.parametros);        
        
        try{
            if(id.equalsIgnoreCase("InterSendVals")){
                System.out.println("Funcion para enviar datos a gdato.");
            }else if(a != null){ 
                env nuevo = new env(ambiente);
                
                if(a.parametros != null){
                    for(int i = 0; i < a.parametros.size(); i++){
                        nodo e = parametros.get(i).run(ambiente);
                        nuevo.put(a.parametros.get(i), "var", e.val);
                    }
                }
                
                nodo e = a.acciones.run(nuevo);
            }
        }catch(Return r){
            this.val = r.val;
        }
        
        return this;
    }
    
}
