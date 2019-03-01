/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.LinkedList;

/**
 *
 * @author freddy
 */
public class Func extends nodo {

    String id;
    nodo bloque;
    LinkedList parametros;
    
    public Func(String id, LinkedList parametros, nodo bloque){
        this.id = id;
        this.parametros = parametros;
        this.bloque = bloque;
    }
    
    @Override
    public nodo run(env ambiente) {
        display.putFuncion(new funcion(id, parametros, bloque));
        return this;
    }
    
}
