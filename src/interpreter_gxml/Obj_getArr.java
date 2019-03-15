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
public class Obj_getArr extends nodo {
    
    nodo e;
    String id;
    int i;

    public Obj_getArr(nodo e, String i, int n) {
        this.e = e;
        this.id = i;
        this.i = n;
    }

    @Override
    public nodo run() {
        this.e.run();
        this.val = e.val + "." + id + "[" + i + "]";
        return this;
    }
    
}
