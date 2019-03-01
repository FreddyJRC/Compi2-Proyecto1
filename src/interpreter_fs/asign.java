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
public class asign extends nodo{

    String id;
    nodo e;
    
    public asign(String id, nodo e){
        this.id = id;
        this.e = e;
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e = null;
        if(this.e != null) e = this.e.run(ambiente).val;
        ambiente.set((String)this.val, e);
        return this;
    }
    
}
