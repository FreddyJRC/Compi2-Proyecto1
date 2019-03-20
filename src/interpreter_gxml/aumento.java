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
public class aumento extends nodo {

    nodo e;
    String op;
    
    public aumento(nodo e, int i) {
        this.e = e;
        this.op = (i == 1) ? "++" : " --";
    }
    
    @Override
    public nodo run() {
        this.e.run();
        this.val = e.val + op;
        return this;
    }

    @Override
    public Object get() {
        this.e.get();
        this.val = e.val + op;
        return this;
    }
    
}
