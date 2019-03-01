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
public class retornar extends nodo {
    
    nodo e;
    
    public retornar(nodo e){
        this.e = e;
    }

    @Override
    public nodo run(env ambiente) {
        nodo e = this.e.run(ambiente);
        this.val = e.val;
        throw new Return(val);
    }
    
}
