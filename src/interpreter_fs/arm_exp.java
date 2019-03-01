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
public class arm_exp extends nodo {

    nodo e1, e2;
    String op;
    
    public arm_exp(nodo e1, nodo e2, String op){
        this.val = e1;
        this.e2 = e2;
        this.op = op;
    }
    
    private void setVal(Object e1, Object e2){
        if(e2 != null){
            switch(op){
                case "+":
                    if(e1 instanceof Integer){
                        if(e2 instanceof Integer){
                            this.val = (int)e1 + (int)e2;
                        }else if(e2 instanceof Double){
                            this.val = (double)((int)e1 + (double)e2);
                        }else if(e2 instanceof String){
                            this.val = (String)((int)e1 + (String)e2);
                        }
                    }else if(e1 instanceof Double){
                        if(e2 instanceof Integer){
                            this.val = (double)((double)e1 + (int)e2);
                        }else if(e2 instanceof Double){
                            this.val = (double)((double)e1 + (double)e2);
                        }else if(e2 instanceof String){
                            this.val = (String)((double)e1 + (String)e2);
                        }
                    }else if(e1 instanceof String){
                        if(e2 instanceof Integer){
                            this.val = (String)((String)e1 + (int)e2);
                        }else if(e2 instanceof Double){
                            this.val = (String)((String)e1 + (double)e2);
                        }else if(e2 instanceof String){
                            this.val = (String)((String)e1 + (String)e2);
                        }else if(e2 instanceof Boolean){
                            String tmp = ((Boolean)e2) ? "Verdadero" : "Falso";
                            this.val = (String)e1 + tmp;
                        }
                    }else if(e1 instanceof Boolean){
                        if(e2 instanceof String){
                            this.val = (((Boolean)e1) ? "Verdadero" : "Falso") + (String)e2;
                        }
                    }
                    break;
                    
                case "-":
                    if(e1 instanceof Integer){
                        if(e2 instanceof Integer){
                            this.val = (int)e1 - (int)e2;
                        }else if(e2 instanceof Double){
                            this.val = (double)((int)e1 - (double)e2);
                        }
                    }else if(e1 instanceof Double){
                        if(e2 instanceof Integer){
                            this.val = (double)((double)e1 - (int)e2);
                        }else if(e2 instanceof Double){
                            this.val = (double)((double)e1 - (double)e2);
                        }
                    }
                    break;
                    
                case "*":
                    if(e1 instanceof Integer){
                        if(e2 instanceof Integer){
                            this.val = (int)e1 * (int)e2;
                        }else if(e2 instanceof Double){
                            this.val = (double)((int)e1 * (double)e2);
                        }
                    }else if(e1 instanceof Double){
                        if(e2 instanceof Integer){
                            this.val = (double)((double)e1 * (int)e2);
                        }else if(e2 instanceof Double){
                            this.val = (double)((double)e1 * (double)e2);
                        }
                    }
                    break;
                    
                case "/":
                    if(e1 instanceof Integer){
                        if(e2 instanceof Integer){
                            this.val = (double)e1 * (double)e2;
                        }else if(e2 instanceof Double){
                            this.val = (double)((int)e1 * (double)e2);
                        }
                    }else if(e1 instanceof Double){
                        if(e2 instanceof Integer){
                            this.val = (double)((double)e1 * (int)e2);
                        }else if(e2 instanceof Double){
                            this.val = (double)((double)e1 * (double)e2);
                        }
                    }
                    break;
                    
                case "^":
                    if(e1 instanceof Integer){
                        if(e2 instanceof Integer){
                            this.val = (int)e1 ^ (int)e2;
                        }else if(e2 instanceof Double){
                            this.val = Math.pow((Double)e1, (Double)e2);
                        }else if(e2 instanceof Boolean){
                            this.val = (int)e1 ^ (((Boolean)e2) ? 1 : 0);
                        }
                    }else if(e1 instanceof Double){
                        if(e2 instanceof Integer){
                            this.val = Math.pow((Double)e1, (Double)e2);
                        }else if(e2 instanceof Double){
                            this.val = Math.pow((Double)e1, (Double)e2);
                        }else if(e2 instanceof Boolean){
                            this.val = (int)e1 ^ (((Boolean)e2) ? 1 : 0);
                        }
                    }else if(e1 instanceof Boolean){
                        if(e2 instanceof Integer){
                            this.val = (((Boolean)e1) ? 1 : 0) ^ (int)e2;
                        }else if(e2 instanceof Double){
                            this.val = Math.pow((((Boolean)e1) ? 1 : 0), (Double)e2);
                        }
                    }
                    break;
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
