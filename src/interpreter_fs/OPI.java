/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.Hashtable;

/**
 *
 * @author freddy
 */
public class OPI extends nodo {

    //String id;
    nodo id, e;
    
    public OPI(nodo i, nodo e) {
        this.id = i;
        this.e = e;
    }

    @Override
    public nodo run(env ambiente) {
        
        Hashtable tmp = (Hashtable) this.id.run(ambiente).val;
        
        this.val = ((simbol) tmp.get(e.run(ambiente).val)).val;
        
        return this;
    }
    
}
