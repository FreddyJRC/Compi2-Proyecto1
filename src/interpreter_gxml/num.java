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
public class num extends nodo {

    public num(String e){
        this.val = e;
    }
    
    @Override
    public nodo run() {
        return this;
    }
    
}
