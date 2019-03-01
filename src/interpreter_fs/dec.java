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
public class dec extends nodo {
    
    String tipo, id;
    nodo e;
    
    public dec(String id, nodo e){
        this.tipo = "var";
        this.id = id;
        this.e = e;
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e = null;
        if(this.e != null) e = this.e.run(ambiente).val;
        ambiente.put((String)this.id, tipo, e);
        return this;
    }
    
}
