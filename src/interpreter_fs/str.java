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
public class str extends nodo {

    public str(String val){
        this.val = val;
    }
    
    @Override
    public nodo run(env ambiente) {
        return this;
    }
    
}
