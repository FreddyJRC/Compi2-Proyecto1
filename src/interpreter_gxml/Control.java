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
public class Control extends nodo {

    HashMap attrs;
    String def;
    LinkedList<String> datos;
    
    public Control(HashMap a, String d, LinkedList l) {
        this.attrs = a;
        this.def = d;
        this.datos = l;
    }

    @Override
    public nodo run() {
        
        Object tipo = attrs.get("tipo");
        Object nombre = attrs.get("nombre");
        Object x = attrs.get("x");
        Object y = attrs.get("y");
        
        if(tipo == null || nombre == null || x == null || y == null)
            return this;
        
        nombre = nombre.toString().replaceAll("^\"|\"$", "");
        switch(tipo.toString().toLowerCase().replaceAll("^\"|\"$", "")){
            case "texto":
                this.val = padre + ".CrearCajaTexto(" 
                                + ((attrs.get("alto") != null) ? attrs.get("alto").toString() : "50" ) +
                            ", " + ((attrs.get("ancho") != null) ? attrs.get("ancho").toString() : "50" ) +
                            ", " + ((attrs.get("fuente") != null) ? attrs.get("fuente").toString() : "\"Arial\"") + 
                            ", " + ((attrs.get("tam") != null) ? attrs.get("tam").toString() : 12) +
                            ", " + ((attrs.get("color") != null) ? attrs.get("color").toString() : "\"#000000\"") + 
                            ", " + attrs.get("x").toString() +
                            ", " + attrs.get("y").toString() +
                            ", " + ((attrs.get("negrita") != null && ((boolean) attrs.get("negrita"))) ? "Verdadero" : "Falso") +
                            ", " + ((attrs.get("cursiva") != null && ((boolean) attrs.get("cursiva"))) ? "Verdadero" : "Falso") +
                            ", \"" + ((def != null) ? def : "") + "\"" +
                            ", \"" + nombre + "\"" + 
                            ");\n";
                break;
            case "numerico":
                this.val = padre + ".CrearControlNumerico(" 
                                + ((attrs.get("alto") != null) ? attrs.get("alto").toString() : "50" ) +
                            ", " + ((attrs.get("ancho") != null) ? attrs.get("ancho").toString() : "50" ) +
                            ", " + ((attrs.get("max") != null) ? attrs.get("max").toString() : "nulo" ) +
                            ", " + ((attrs.get("min") != null) ? attrs.get("min").toString() : "nulo" ) +
                            ", " + attrs.get("x").toString() +
                            ", " + attrs.get("y").toString() +
                            ", \"" + ((def != null) ? def : "") + "\"" +
                            ", \"" + nombre + "\"" + 
                            ");\n";
                break;
            case "textoarea":
                this.val = padre + ".CrearAreaTexto(" 
                                + ((attrs.get("alto") != null) ? attrs.get("alto").toString() : "50" ) +
                            ", " + ((attrs.get("ancho") != null) ? attrs.get("ancho").toString() : "50" ) +
                            ", " + ((attrs.get("fuente") != null) ? attrs.get("fuente").toString() : "\"Arial\"") + 
                            ", " + ((attrs.get("tam") != null) ? attrs.get("tam").toString() : 12) +
                            ", " + ((attrs.get("color") != null) ? attrs.get("color").toString() : "\"#000000\"") + 
                            ", " + attrs.get("x").toString() +
                            ", " + attrs.get("y").toString() +
                            ", " + ((attrs.get("negrita") != null && ((boolean) attrs.get("negrita"))) ? "Verdadero" : "Falso") +
                            ", " + ((attrs.get("cursiva") != null && ((boolean) attrs.get("cursiva"))) ? "Verdadero" : "Falso") +
                            ", \"" + ((def != null) ? def : "") + "\"" +
                            ", \"" + nombre + "\"" + 
                            ");\n";
                break;
            case "desplegable":
                this.val = "var ListaDatos" + nombre + " = [" + getDatos() + "];\n";
                this.val = this.val + padre + ".CrearDesplegable(" 
                            + ((attrs.get("alto") != null) ? attrs.get("alto").toString() : "50" ) +
                            ", " + ((attrs.get("ancho") != null) ? attrs.get("ancho").toString() : "50" ) +
                            ", ListaDatos" + nombre + 
                            ", " + attrs.get("x").toString() +
                            ", " + attrs.get("y").toString() +
                            ", \"" + ((def != null) ? def : "") + "\"" + 
                            ", \"" + nombre + "\"" + 
                            ");\n";
                break;

        }
        
        return this;
    }

    private String getDatos() {
        String lista = "";
        for(String d : datos){
            lista = lista + "\"" + d + "\", ";
        }
        
        lista = lista.substring(0, lista.length() - 2);
        return lista;
    }

    @Override
    public Object get() {
        Hashtable t = new Hashtable<String, interpreter_fs.simbol>();
        LinkedList<interpreter_fs.Obj_a> attr = new LinkedList<>();
        
        attr.add(new Obj_a("etiqueta", "control", 0));
        
        switch(attrs.get("tipo").toString().toLowerCase().replaceAll("^\"|\"$", "")){
            case "texto":
                attr.add(new Obj_a("tipo", "texto", 0));
                attr.add(new Obj_a("alto", (attrs.get("alto") != null) ? Integer.parseInt((String) attrs.get("alto")) : 50 , 0));
                attr.add(new Obj_a("ancho", (attrs.get("ancho") != null) ? Integer.parseInt((String) attrs.get("ancho")) : 50 , 0));
                attr.add(new Obj_a("fuente", (attrs.get("fuente") != null) ? attrs.get("fuente").toString().replaceAll("^\"|\"$", "") : "Arial", 0));
                attr.add(new Obj_a("tam", (attrs.get("tam") != null) ? Integer.parseInt(attrs.get("tam").toString()) : 12, 0));
                attr.add(new Obj_a("color", (attrs.get("color") != null) ? attrs.get("color").toString().replaceAll("^\"|\"$", "") : "#000000", 0));
                attr.add(new Obj_a("x", Integer.parseInt((String) attrs.get("x")), 0));
                attr.add(new Obj_a("y", Integer.parseInt((String) attrs.get("y")), 0));
                attr.add(new Obj_a("negrita", (attrs.get("negrita") != null && ((boolean) attrs.get("negrita"))), 0));
                attr.add(new Obj_a("cursiva", (attrs.get("cursiva") != null && ((boolean) attrs.get("cursiva"))), 0));
                attr.add(new Obj_a("valor", def, 0));
                break;
                
            case "numerico":
                attr.add(new Obj_a("tipo", "numerico", 0));
                attr.add(new Obj_a("alto", (attrs.get("alto") != null) ? Integer.parseInt((String) attrs.get("alto")) : 50 , 0));
                attr.add(new Obj_a("ancho", (attrs.get("ancho") != null) ? Integer.parseInt((String) attrs.get("ancho")) : 50 , 0));
                attr.add(new Obj_a("max", (attrs.get("max") != null) ? Integer.parseInt((String) attrs.get("max")) : null , 0));
                attr.add(new Obj_a("min", (attrs.get("min") != null) ? Integer.parseInt((String) attrs.get("min")) : null , 0));
                attr.add(new Obj_a("x", Integer.parseInt((String) attrs.get("x")), 0));
                attr.add(new Obj_a("y", Integer.parseInt((String) attrs.get("y")), 0));
                attr.add(new Obj_a("valor", def, 0));
                break;
                
            case "textoarea":
                attr.add(new Obj_a("tipo", "textoarea", 0));
                attr.add(new Obj_a("alto", (attrs.get("alto") != null) ? Integer.parseInt((String) attrs.get("alto")) : 50 , 0));
                attr.add(new Obj_a("ancho", (attrs.get("ancho") != null) ? Integer.parseInt((String) attrs.get("ancho")) : 50 , 0));
                attr.add(new Obj_a("fuente", (attrs.get("fuente") != null) ? attrs.get("fuente").toString().replaceAll("^\"|\"$", "") : "Arial", 0));
                attr.add(new Obj_a("tam", (attrs.get("tam") != null) ? Integer.parseInt(attrs.get("tam").toString()) : 12, 0));
                attr.add(new Obj_a("color", (attrs.get("color") != null) ? attrs.get("color").toString().replaceAll("^\"|\"$", "") : "#000000", 0));
                attr.add(new Obj_a("x", Integer.parseInt((String) attrs.get("x")), 0));
                attr.add(new Obj_a("y", Integer.parseInt((String) attrs.get("y")), 0));
                attr.add(new Obj_a("negrita", (attrs.get("negrita") != null && ((boolean) attrs.get("negrita"))), 0));
                attr.add(new Obj_a("cursiva", (attrs.get("cursiva") != null && ((boolean) attrs.get("cursiva"))), 0));
                attr.add(new Obj_a("valor", def, 0));
                break;
                
            case "desplegable":
                attr.add(new Obj_a("tipo", "desplegable", 0));
                attr.add(new Obj_a("alto", (attrs.get("alto") != null) ? Integer.parseInt((String) attrs.get("alto")) : 50 , 0));
                attr.add(new Obj_a("ancho", (attrs.get("ancho") != null) ? Integer.parseInt((String) attrs.get("ancho")) : 50 , 0));
                attr.add(new Obj_a("lista", datos, 0));
                attr.add(new Obj_a("x", Integer.parseInt((String) attrs.get("x")), 0));
                attr.add(new Obj_a("y", Integer.parseInt((String) attrs.get("y")), 0));
                attr.add(new Obj_a("valor", def, 0));
                break;
                
        }
        
        t.put(attrs.get("nombre").toString().replaceAll("^\"|\"$", ""), new interpreter_fs.simbol("Obj", attr));
        return t;
    }
    
}
