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

    @Override
    public Object get() {
        Hashtable t = new Hashtable<String, interpreter_fs.simbol>();
        LinkedList<interpreter_fs.Obj_a> attr = new LinkedList<>();
        
        attr.add(new Obj_a("etiqueta", "texto", 0));
        attr.add(new Obj_a("fuente", (attrs.get("fuente") != null) ? attrs.get("fuente").toString().replaceAll("^\"|\"$", "") : "Arial", 0));
        attr.add(new Obj_a("tam", (attrs.get("tam") != null) ? Integer.parseInt(attrs.get("tam").toString()) : 12, 0));
        attr.add(new Obj_a("color", (attrs.get("color") != null) ? attrs.get("color").toString().replaceAll("^\"|\"$", "") : "#000000", 0));
        attr.add(new Obj_a("x", Integer.parseInt((String) attrs.get("x")), 0));
        attr.add(new Obj_a("y", Integer.parseInt((String) attrs.get("y")), 0));
        attr.add(new Obj_a("negrita", (attrs.get("negrita") != null && ((boolean) attrs.get("negrita"))), 0));
        attr.add(new Obj_a("cursiva", (attrs.get("cursiva") != null && ((boolean) attrs.get("cursiva"))), 0));
        attr.add(new Obj_a("valor", def, 0));
        
        t.put(attrs.get("nombre").toString().replaceAll("^\"|\"$", ""), new interpreter_fs.simbol("Obj", attr));
        return t;
    }
    
}
