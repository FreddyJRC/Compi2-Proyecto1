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
public class Ventana extends nodo {

    HashMap attrs;
    LinkedList<nodo> cont;
    
    public Ventana(HashMap a, LinkedList c) {
        this.attrs = a;
        this.cont = c;
    }

    @Override
    public nodo run() {
        Object id = attrs.get("id");
        Object tipo = attrs.get("tipo");
        
        if(id == null || tipo == null)
            return this;
        
        id = id.toString().replaceAll("^\"|\"$", "");
        tipo = tipo.toString().replaceAll("^\"|\"$", "");
        this.val = "var " + id.toString() + " = CrearVentana(" 
                                + ((attrs.get("color") != null) ? attrs.get("color").toString() : "\"#FFFFFF\"") +                             
                            ", " + ((attrs.get("alto") != null) ? attrs.get("alto").toString() : "500" ) +
                            ", " + ((attrs.get("ancho") != null) ? attrs.get("ancho").toString() : "500" ) +
                            ", \"" + id.toString() + "\"" + 
                            ");\n";
        
        for(nodo e : cont){
            e.padre = id.toString();
            e.ColorVentana = (attrs.get("color") != null) ? attrs.get("color").toString() : "\"#FFFFFF\"";
            e.run();
            this.val = this.val.toString() + e.val.toString();
        }
        
        if(attrs.get("AlCargar") != null){
            nodo alcargar = ((nodo) attrs.get("AlCargar")).run();
            this.val = this.val + id.toString() + ".AlCargar(" + alcargar.val + ");\n";
        }
        
        if(attrs.get("AlCerrar") != null){
            nodo alcerrar = ((nodo) attrs.get("AlCerrar")).run();
            this.val = this.val + id.toString() + ".AlCerrar(" + alcerrar.val + ");\n";
        }
        
        if(tipo.toString().equalsIgnoreCase("principal"))
            this.val = this.val + id.toString() + ".AlCargar();\n";
        
        return this;
    }
    
}
