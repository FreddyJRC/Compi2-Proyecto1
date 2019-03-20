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
public class rel_exp extends nodo {

    nodo e1, e2;
    String op;
    
    public rel_exp(nodo e1, nodo e2, String string) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = string;
    }

    @Override
    public nodo run() {
        e1.run();
        e2.run();
        this.val = e1.val + op + e2.val;
        return this;
    }

    @Override
    public Object get() {
        e1.get();
        e2.get();
        this.val = e1.val + op + e2.val;
        return this;
    }
    
}
