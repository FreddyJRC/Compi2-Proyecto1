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
public class IF extends nodo {

    nodo e, a;
    
    public IF(nodo e, nodo a){
        this.e = e; 
        this.a = a;
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e = this.e.run(ambiente).val;
        if(e instanceof Boolean){
            if((boolean)e){
                this.a.run(new env(ambiente));
            }
        }
        
        return this;
    }
    
}
