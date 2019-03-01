/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.LinkedList;

/**
 *
 * @author freddy
 */
public class Obj extends nodo{
    String id;
    LinkedList<nodo> atributos;
    
    public Obj(String id, LinkedList atributos){
        this.id = id;
        this.atributos = atributos;
    }

    @Override
    public nodo run(env ambiente) {
        if(atributos != null){
            this.atributos.forEach((attr) -> {
                attr.run(ambiente);
            });
        }
        ambiente.put(id, "objeto", atributos);
        return this;
    }
}
