/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author freddy
 */
public class display {
    
    static public Stack<Integer> display = new Stack<>();
    private static final LinkedList<funcion> funciones = new LinkedList<>();
    
    static public void putFuncion(funcion cuerpo){
        funciones.add(cuerpo);
    }

    static public funcion getFunction(String id, LinkedList<nodo> parametros) {
        for (funcion f : funciones) {
            if(id.equalsIgnoreCase(f.id) && ((parametros == null && f.parametros == null) ||  parametros.size() == f.parametros.size())){
                return f;
            }
        }
        return null;
    }
    
}

