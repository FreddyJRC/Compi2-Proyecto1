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
public class log_exp extends nodo {

    nodo e1, e2;
    String op;
    
    public log_exp(nodo e1, nodo e2, String op){
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }
    
    private void setVal(Object e1, Object e2) {
        if(e1 instanceof Boolean){
            switch(this.op){
                case "or":
                    if(e2 instanceof Boolean)
                        this.val = (Boolean)e1 || (Boolean)e2;
                    break;
                case "and":
                    if(e2 instanceof Boolean)
                        this.val = (Boolean)e1 && (Boolean)e2;
                    break;
                case "not":
                    this.val = !(Boolean)e1;
            }
        }
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e1 = this.e1.run(ambiente).val;
        Object e2 = (this.e2 != null) ? this.e2.run(ambiente).val : null;
        setVal(e1, e2);
        return this;
    }
    
}
