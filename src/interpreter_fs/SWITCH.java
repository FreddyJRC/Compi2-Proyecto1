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
public class SWITCH extends nodo{

    nodo e;
    LinkedList<CASE> cases;
    
    public SWITCH(nodo e, LinkedList cases) {
        this.e = e;
        this.cases = cases;
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e = this.e.run(ambiente).val;
        
        try{
            cases.forEach((c) -> {
                if (c.e != null){
                    Object t = c.e.run(ambiente).val;
                    if(e.equals(t)){
                        c.run(ambiente);
                    }
                }else{
                    c.run(ambiente);
                }
            });
        } catch (Break b){}
        
        return this;
    }
    
}
