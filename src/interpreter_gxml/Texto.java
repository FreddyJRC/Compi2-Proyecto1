/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_gxml;

import java.util.HashMap;

/**
 *
 * @author freddy
 */
public class Texto extends nodo {

    HashMap attrs;
    String def;

    public Texto(HashMap a, String c) {
        this.attrs = a;
        this.def = c;
    }

    @Override
    public nodo run() {
        Object x = attrs.get("x");
        Object y = attrs.get("y");
        
        if(x == null || y == null)
            return this;
        
        this.val = padre + ".CrearTexto(" 
                            + ((attrs.get("fuente") != null) ? attrs.get("fuente").toString() : "\"Arial\"") +
                            ", " + ((attrs.get("tam") != null) ? attrs.get("tam").toString() : "12") +
                            ", " + ((attrs.get("color") != null) ? attrs.get("color").toString() : "\"#000000\"") + 
                            ", " + attrs.get("x").toString() +
                            ", " + attrs.get("y").toString() +
                            ", " + ((attrs.get("negrita") != null && ((boolean) attrs.get("negrita"))) ? "Verdadero" : "Falso") +
                            ", " + ((attrs.get("cursiva") != null && ((boolean) attrs.get("cursiva"))) ? "Verdadero" : "Falso") + 
                            ", \"" + def + "\"" +
                            ");\n"; 

        return this;
    }
    
}
