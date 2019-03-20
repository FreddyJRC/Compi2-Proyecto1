/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import interpreter_gxml.Head;
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
public class CADA extends nodo {

    nodo e;
    
    public CADA(nodo e) {
        this.e = e;
    }

    @Override
    public nodo run(env ambiente) {
        Object e = this.e.run(ambiente).val;
        
        if(e instanceof String){
            Path file = Paths.get(proyecto.display.home, e.toString());
            String ext = getExtension(e.toString()).get();
            
            if(ext.equalsIgnoreCase("gdato")){       
                    
                try{
                    System.out.println("leyendo: " + file);
                    grammar_gdato.parser p = new grammar_gdato.parser(new String(Files.readAllBytes(file)));
                    p.parse();

                    this.val = p.root;
                } catch (Exception ex) {
                    Logger.getLogger(Head.class.getName()).log(Level.SEVERE, null, ex);
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
