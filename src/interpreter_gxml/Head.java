/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_gxml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author freddy
 */
public class Head extends nodo {

    LinkedList<String> imp;
    LinkedList<nodo> cont;
    
    public Head(LinkedList i, LinkedList x) {
        this.imp = i;
        this.cont = x;
    }

    @Override
    public nodo run() {
        
        this.val = "";
        
        if(imp != null){
            for(String i : imp){
                Path file = Paths.get(proyecto.display.home, i);
                String ext = getExtension(i).get();
                if(ext.equalsIgnoreCase("fs")){
                    
                    try {
                        System.out.println("importando: " + file);
                        this.val = this.val + new String(Files.readAllBytes(file)) + "\n\n";
                    } catch (IOException ex) {
                        Logger.getLogger(Head.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else if(ext.equalsIgnoreCase("gxml")){       
                    
                    try{
                        System.out.println("importando: " + file);
                        grammar_gxml.parser p = new grammar_gxml.parser(new String(Files.readAllBytes(file)));
                        p.parse();

                        interpreter_gxml.nodo res = p.root.run();
                        this.val = this.val + res.val.toString() + "\n\n";
                    } catch (Exception ex) {
                        Logger.getLogger(Head.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }
        
        for(nodo e : cont){
            e.run();
            this.val = this.val.toString() + e.val.toString();
        }
        
        return this;
    }
    
    public Optional<String> getExtension(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
    
}
