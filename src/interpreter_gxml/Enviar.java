/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_gxml;

import interpreter_fs.Obj_a;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 *
 * @author freddy
 */
public class Enviar extends nodo {

    HashMap attrs;
    String def;
    
    public Enviar(HashMap a, String c) {
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
        
        this.val = this.val + nombre.toString() + ".AlClic(InterSendVals());\n";

        return this;
    }

    @Override
    public Object get() {
        Hashtable t = new Hashtable<String, interpreter_fs.simbol>();
        LinkedList<interpreter_fs.Obj_a> attr = new LinkedList<>();
        
        attr.add(new Obj_a("etiqueta", "enviar", 0));
        attr.add(new Obj_a("fuente", (attrs.get("fuente") != null) ? attrs.get("fuente").toString().replaceAll("^\"|\"$", "") : "Arial", 0));
        attr.add(new Obj_a("tam", (attrs.get("tam") != null) ? Integer.parseInt(attrs.get("tam").toString()) : 12, 0));
        attr.add(new Obj_a("color", (attrs.get("color") != null) ? attrs.get("color").toString().replaceAll("^\"|\"$", "") : "#000000", 0));
        attr.add(new Obj_a("x", Integer.parseInt((String) attrs.get("x")), 0));
        attr.add(new Obj_a("y", Integer.parseInt((String) attrs.get("y")), 0));
        attr.add(new Obj_a("referencia", (attrs.get("Referencia") != null) ? attrs.get("Referencia").toString().replaceAll("^\"|\"$", "") : "nulo", 0));
        attr.add(new Obj_a("valor", def, 0));
        attr.add(new Obj_a("alto", (attrs.get("alto") != null) ? Integer.parseInt((String) attrs.get("alto")) : 50 , 0));
        attr.add(new Obj_a("ancho", (attrs.get("ancho") != null) ? Integer.parseInt((String) attrs.get("ancho")) : 50 , 0));
        
        if(attrs.get("AlClick") != null){
            nodo alc = (nodo) ((nodo)  attrs.get("AlClick")).get();
            attr.add(new Obj_a("accion", alc.val, 0));
        }
        t.put(attrs.get("nombre").toString().replaceAll("^\"|\"$", ""), new interpreter_fs.simbol("Obj", attr));
        return t;
    }
    
}
