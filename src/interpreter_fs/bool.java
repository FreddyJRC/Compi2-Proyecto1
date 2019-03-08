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
public class bool extends nodo {

    int v;
    
    public bool(int v){
        this.val = (v == 1);
    }
    
    @Override
    public nodo run(env ambiente) {
        return this;
    }
    
}
