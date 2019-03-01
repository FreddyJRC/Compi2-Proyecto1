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
public class asign_oper extends nodo {

    String id;
    nodo e;
    int tipo;
    
    public asign_oper(String id, nodo e, int tipo){
        this.id = id;
        this.e = e;
        this.tipo = tipo;
    }
    
    private void setVal(Object val, Object e){
        switch(this.tipo){
            case 1:
                if(val instanceof Integer){
                    if(e instanceof Integer){
                        this.val = (int)val + (int)e;
                    }else if(e instanceof Double){
                        this.val = (double)((int)val + (double)e);
                    }else if(e instanceof String){
                        this.val = (String)((int)val + (String)e);
                    }
                }else if(val instanceof Double){
                    if(e instanceof Integer){
                        this.val = (double)((double)val + (int)e);
                    }else if(e instanceof Double){
                        this.val = (double)((double)val + (double)e);
                    }else if(e instanceof String){
                        this.val = (String)((double)val + (String)e);
                    }
                }else if(val instanceof String){
                    if(e instanceof Integer){
                        this.val = (String)((String)val + (int)e);
                    }else if(e instanceof Double){
                        this.val = (String)((String)val + (double)e);
                    }else if(e instanceof String){
                        this.val = (String)((String)val + (String)e);
                    }else if(e instanceof Boolean){
                        String tmp = ((Boolean)e) ? "Verdadero" : "Falso";
                        this.val = (String)val + tmp;
                    }
                }else if(val instanceof Boolean){
                    if(e instanceof String){
                        this.val = (((Boolean)val) ? "Verdadero" : "Falso") + (String)e;
                    }
                }
                break;
            case 2:
                if(val instanceof Integer){
                    if(e instanceof Integer){
                        this.val = (int)val - (int)e;
                    }else if(e instanceof Double){
                        this.val = (double)((int)val - (double)e);
                    }
                }else if(val instanceof Double){
                    if(e instanceof Integer){
                        this.val = (double)((double)val - (int)e);
                    }else if(e instanceof Double){
                        this.val = (double)((double)val - (double)e);
                    }
                }
                break;
            case 3:
                if(val instanceof Integer){
                    if(e instanceof Integer){
                        this.val = (int)val * (int)e;
                    }else if(e instanceof Double){
                        this.val = (double)((int)val * (double)e);
                    }
                }else if(val instanceof Double){
                    if(e instanceof Integer){
                        this.val = (double)((double)val * (int)e);
                    }else if(e instanceof Double){
                        this.val = (double)((double)val * (double)e);
                    }
                }
                break;
            case 4:
                if(val instanceof Integer){
                    if(e instanceof Integer){
                        this.val = (double)val / (double)e;
                    }else if(e instanceof Double){
                        this.val = (double)((int)val / (double)e);
                    }
                }else if(val instanceof Double){
                    if(e instanceof Integer){
                        this.val = (double)((double)val / (int)e);
                    }else if(e instanceof Double){
                        this.val = (double)((double)val / (double)e);
                    }
                }
                break;
        }
    }
    
    @Override
    public nodo run(env ambiente) {
        Object val = ambiente.get(id);
        Object e = this.e.run(ambiente).val;
        setVal(val, e);
        
        ambiente.set(id, this.val);
        
        return this;
    }
    
}
