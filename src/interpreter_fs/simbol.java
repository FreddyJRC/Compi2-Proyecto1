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
public class simbol extends nodo{
    String tipo;
    public Object start, exit;
    
    public simbol(String tipo, Object val){
        this.tipo = tipo;
        this.val = val;
    }

    @Override
    public nodo run(env ambiente) {
        return this;
    }
}
