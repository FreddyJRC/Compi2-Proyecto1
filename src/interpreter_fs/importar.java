/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author freddy
 */
public class importar extends nodo {
    
    nodo e;

    public importar(nodo e){
        this.e = e;
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e = this.e.run(ambiente).val;
        
        if (e instanceof String){
            if(getExtension(e.toString()).get().equalsIgnoreCase("fs")){
                
                Path file = Paths.get(proyecto.display.home, e.toString());
                
                try {
                    System.out.println("importando: " + file);
                    grammar_fs.parser p = new grammar_fs.parser(new String(Files.readAllBytes(file)));

                    p.parse();

                    p.root.run(new env(ambiente));  
                } catch (IOException ex) {
                    Logger.getLogger(nodo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(importar.class.getName()).log(Level.SEVERE, null, ex);
                }        
            }
        }
        
        return this;
    }
 
    public Optional<String> getExtension(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
    
}
