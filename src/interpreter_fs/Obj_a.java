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
public class Obj_a extends nodo {
    String id;
    nodo e;
    
    public Obj_a(String id, nodo e){
        this.id = id;
        this.e = e;
    }

    @Override
    public nodo run(env ambiente) {
        
        this.val = this.e.run(ambiente).val;
        
        return this;
    }
}
