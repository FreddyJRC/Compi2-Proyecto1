/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

/**
 *
 * @author freddy
 */
public class aumento extends nodo {
    
    String id;
    int aumento;
    
    public aumento(String id, int aumento){
        this.id = id;
        this.aumento = aumento;
    }

    @Override
    public nodo run(env ambiente) {
        this.val = ambiente.get(id);
        
        if(this.val instanceof Integer){
            ambiente.set(id, ((int)val + this.aumento));
        }else{
            if(this.val instanceof Double){
                ambiente.set(id, ((Double)this.val + this.aumento));
            }
        }
        
        return this;
    }
    
}
