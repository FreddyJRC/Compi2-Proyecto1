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
public class inline_if extends nodo {

    nodo condition, t, f;
    
    public inline_if(nodo condition, nodo t, nodo f){
        this.condition = condition;
        this.t = t;
        this.f = f;
    }
    
    @Override
    public nodo run(env ambiente) {
        nodo c = this.condition.run(ambiente);
        if(c.val instanceof Boolean){
            if((Boolean)c.val){
                nodo e = this.t.run(ambiente);
                this.val = e.val;
            }else{
                nodo e = this.f.run(ambiente);
                this.val = e.val;
            }
        }
        
        return this;
    }
    
}
