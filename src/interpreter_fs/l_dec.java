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
public class l_dec extends nodo{
    nodo l, d;
    
    public l_dec(nodo l, nodo d){
        this.l = l;
        this.d = d;
    }

    @Override
    public nodo run(env ambiente) {
        l.run(ambiente);
        d.run(ambiente);
        return this;
    }
    
    
}
