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
public class Obj_getId extends nodo {

    nodo e;
    String id;
    
    public Obj_getId(nodo e, String i) {
        this.e = e;
        this.id = i;
    }

    @Override
    public nodo run() {
        e.run();
        this.val = e.val + "." + id;
        return this;
    }

    @Override
    public Object get() {
        e.get();
        this.val = e.val + "." + id;
        return this;
    }
    
}
