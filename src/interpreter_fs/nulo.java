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
public class nulo extends nodo {

    public nulo(){
        this.val = null;
    }
    
    @Override
    public nodo run(env ambiente) {
        return this;
    }
    
}
