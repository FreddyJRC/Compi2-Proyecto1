/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import proyecto.IDE;

/**
 *
 * @author freddy
 */
public class imprimir extends nodo{

    nodo e;
    
    public imprimir(nodo e){
        this.e = e;
    }
    
    @Override
    public nodo run(env ambiente) {
        nodo e = this.e.run(ambiente);
        IDE.consoleOut(String.valueOf(e.val));
        return this;
    }
    
}
