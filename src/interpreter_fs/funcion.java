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
class funcion {
    String id;
    LinkedList<String> parametros;
    nodo acciones;
    
    public funcion(String id, LinkedList<String> parametros, nodo acciones){
        this.id = id;
        this.parametros = parametros;
        this.acciones = acciones;
    }
}
