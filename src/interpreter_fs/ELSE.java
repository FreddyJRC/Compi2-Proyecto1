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
public class ELSE extends nodo {

    nodo a;
    
    public ELSE(nodo a){
        this.a = a;
    }
    
    @Override
    public nodo run(env ambiente) {
        a.run(new env(ambiente));
        return this;
    }
    
}
