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
import java.util.Map;

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

    @Override
    public Object get() {
        Hashtable t = new Hashtable<String, interpreter_fs.simbol>();
        LinkedList<interpreter_fs.Obj_a> attr = new LinkedList<>();
        
        attr.add(new Obj_a("etiqueta", "contenedor", 0));
        attr.add(new Obj_a("id", attrs.get("id").toString().replaceAll("^\"|\"$", ""), 0));
        attr.add(new Obj_a("alto", (attrs.get("alto") != null) ? Integer.parseInt((String) attrs.get("alto")) : 50 , 0));
        attr.add(new Obj_a("ancho", (attrs.get("ancho") != null) ? Integer.parseInt((String) attrs.get("ancho")) : 50 , 0));
        attr.add(new Obj_a("color", (attrs.get("color") != null) ? attrs.get("color").toString().replaceAll("^\"|\"$", "") : "#000000", 0));
        attr.add(new Obj_a("borde", (attrs.get("borde") != null && ((boolean) attrs.get("borde"))), 0));
        attr.add(new Obj_a("x", Integer.parseInt((String) attrs.get("x")), 0));
        attr.add(new Obj_a("y", Integer.parseInt((String) attrs.get("y")), 0));
        
        t.put(attrs.get("id").toString().replaceAll("^\"|\"$", ""), new interpreter_fs.simbol("Obj", attr));
        
        for(nodo e : cont){
            t.putAll((Map) e.get());
        }
        
        return t;
    }
    
}
