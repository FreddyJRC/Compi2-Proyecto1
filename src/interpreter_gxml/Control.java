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
    
}
