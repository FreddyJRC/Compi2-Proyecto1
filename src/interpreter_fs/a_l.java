/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

/**
 *
 * @author freddy
 */
public class a_l extends nodo {
    nodo l, a;
    
    public a_l(nodo l, nodo a){
        this.l = l;
        this.a = a;
    }

    @Override
    public nodo run(env ambiente) {
        try{
            this.l.run(ambiente);
        }catch(Break b){
            //return this;
        }catch(Return r){
            this.val = r.val;
        }
        
        this.a.run(ambiente);
        return this;
    }
}
