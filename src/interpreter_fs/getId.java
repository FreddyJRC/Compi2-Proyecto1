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
public class getId extends nodo{
    
    String id;
    
    public getId(String id){
        this.id = id;
    }
    
    @Override
    public nodo run(env ambiente) {
        simbol tmp = ambiente.get((String)this.id);
        this.val = tmp.val;
        return this;
    }
    
}
