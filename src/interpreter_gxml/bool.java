/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_gxml;

import java.util.LinkedList;

/**
 *
 * @author freddy
 */
public class bool extends nodo {

    public bool(int i){
        this.val = (i == 1);
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
