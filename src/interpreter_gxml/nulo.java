/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_gxml;

/**
 *
 * @author freddy
 */
public class nulo extends nodo {

    public nulo(){
        this.val = "nulo";
    }
    
    @Override
    public nodo run() {
        return this;
    }

    @Override
    public Object get() {
        return this;
    }
    
}
