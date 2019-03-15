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
public class call_f extends nodo {

    String id;
    LinkedList<nodo> e;
    
    public call_f(String i, LinkedList e) {
        this.id = i;
        this.e = e;
    }

    @Override
    public nodo run() {
        this.val = id + "(";
        
        if(e != null){
            e.forEach((i)->{
                i.run();
                this.val = this.val + i.val.toString() + ", ";
            });
            
            this.val = this.val.toString().substring(0, this.val.toString().length() - 2);
        }
        
        this.val = this.val + ")";
        return this;
    }
    
}
