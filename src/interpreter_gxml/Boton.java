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
public class Boton extends nodo {

    HashMap attrs;
    String def;
    
    public Boton(HashMap a, String c) {
        this.attrs = a;
        this.def = c;
    }

    @Override
    public nodo run() {
        Object nombre = attrs.get("nombre");
        Object x = attrs.get("x");
        Object y = attrs.get("y");
        
        if(nombre == null || x == null || y == null)
            return this;
        
        nombre = nombre.toString().replaceAll("^\"|\"$", "");
        this.val = "var " + nombre.toString() + " = " + padre + ".CrearBoton(" 
                            + ((attrs.get("fuente") != null) ? attrs.get("fuente").toString() : "\"Arial\"") +
                            ", " + ((attrs.get("tam") != null) ? attrs.get("tam").toString() : 12) +
                            ", " + ((attrs.get("color") != null) ? attrs.get("color").toString() : "\"#000000\"") + 
                            ", " + attrs.get("x").toString() +
                            ", " + attrs.get("y").toString() +
                            ", " + ((attrs.get("Referencia") != null) ? attrs.get("Referencia").toString() : "nulo")+
                            ", \"" + def + "\"" +
                            ", " + ((attrs.get("alto") != null) ? attrs.get("alto").toString() : "50" ) +
                            ", " + ((attrs.get("ancho") != null) ? attrs.get("ancho").toString() : "50" ) +
                            
                            ");\n"; 
        
        if(attrs.get("AlClick") != null){
            nodo alc = ((nodo)  attrs.get("AlClick")).run();
            this.val = this.val + nombre.toString() + ".AlClic(" + (alc.val) + ");\n";
        }

        return this;
    }
    
}
