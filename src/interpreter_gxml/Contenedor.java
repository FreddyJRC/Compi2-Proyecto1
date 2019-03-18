/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_gxml;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author freddy
 */
public class Contenedor extends nodo {

    HashMap attrs;
    LinkedList<nodo> cont;
    
    public Contenedor(HashMap a, LinkedList c) {
        this.attrs = a;
        this.cont = c;
    }

    @Override
    public nodo run() {
        
        Object id = attrs.get("id");
        Object x = attrs.get("x");
        Object y = attrs.get("y");
        
        if(id == null || x == null || y == null)
            return this;
        
        id = id.toString().replaceAll("^\"|\"$", "");
        this.val = "var " + id.toString() + " = " + padre + ".CrearContenedor(" 
                                + ((attrs.get("alto") != null) ? attrs.get("alto").toString() : "500" ) +
                            ", " + ((attrs.get("ancho") != null) ? attrs.get("ancho").toString() : "500" ) +
                            ", " + ((attrs.get("color") != null) ? attrs.get("color").toString() : this.ColorVentana) + 
                            ", " + ((attrs.get("borde") != null && ((boolean) attrs.get("borde"))) ? "Verdadero" : "Falso") +
                            ", " + attrs.get("x").toString() +
                            ", " + attrs.get("y").toString() +
                            ");\n";
        
        for(nodo e : cont){
            e.padre = id.toString();
            e.run();
            this.val = this.val.toString() + e.val.toString();
        }
        
        return this;
    }
    
}
