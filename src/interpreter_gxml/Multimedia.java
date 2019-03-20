/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_gxml;

import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author freddy
 */
public class Multimedia extends nodo {

    HashMap attrs;
    
    public Multimedia(HashMap a) {
        attrs = a;
    }

    @Override
    public nodo run() {
        this.val = "";
        
        return this;
    }

    @Override
    public Object get() {
        return new Hashtable<>();
    }
    
}
