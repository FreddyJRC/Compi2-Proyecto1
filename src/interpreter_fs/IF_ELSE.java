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
public class IF_ELSE extends nodo{

    nodo e, a, ef;
    
    public IF_ELSE(nodo e, nodo a, nodo ef){
        this.e = e;
        this.a = a;
        this.ef = ef;
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e = this.e.run(ambiente).val;
        if(e instanceof Boolean){
            if((boolean)e){
                a.run(new env(ambiente));
            }else{
                if(ef != null) ef.run(ambiente);
            }
        }
        
        return this;
    }
    
}
