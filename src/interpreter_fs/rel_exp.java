/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.Objects;

/**
 *
 * @author freddy
 */
public class rel_exp extends nodo {

    nodo e1, e2;
    String op;
    
    public rel_exp(nodo e1, nodo e2, String op){
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }
    
    private void setVal(Object e1, Object e2){
        switch(this.op){
            case ">":
                if(e1 instanceof Integer){
                    if(e2 instanceof Integer){
                        this.val = (int)e1 > (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (int)e1 > (Double)e2;
                    }
                }else if(e1 instanceof Double){
                    if(e2 instanceof Integer){
                        this.val = (Double)e1 > (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (Double)e1 > (Double)e2;
                    }
                }else if(e1 instanceof String){
                    if(e2 instanceof String){
                        this.val = getAscii((String)e1) > getAscii((String)e2);
                    }
                }else if(e1 instanceof Boolean){
                    if(e2 instanceof Boolean){
                        this.val = (((Boolean)e1) ? 1 : 0) > (((Boolean)e2) ? 1 : 0);
                    }
                }
                break;
                
            case "<":
                if(e1 instanceof Integer){
                    if(e2 instanceof Integer){
                        this.val = (int)e1 < (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (int)e1 < (Double)e2;
                    }
                }else if(e1 instanceof Double){
                    if(e2 instanceof Integer){
                        this.val = (Double)e1 < (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (Double)e1 < (Double)e2;
                    }
                }else if(e1 instanceof String){
                    if(e2 instanceof String){
                        this.val = getAscii((String)e1) < getAscii((String)e2);
                    }
                }else if(e1 instanceof Boolean){
                    if(e2 instanceof Boolean){
                        this.val = (((Boolean)e1) ? 1 : 0) < (((Boolean)e2) ? 1 : 0);
                    }
                }
                break;
                
            case ">=":
                if(e1 instanceof Integer){
                    if(e2 instanceof Integer){
                        this.val = (int)e1 >= (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (int)e1 >= (Double)e2;
                    }
                }else if(e1 instanceof Double){
                    if(e2 instanceof Integer){
                        this.val = (Double)e1 >= (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (Double)e1 >= (Double)e2;
                    }
                }else if(e1 instanceof String){
                    if(e2 instanceof String){
                        this.val = getAscii((String)e1) >= getAscii((String)e2);
                    }
                }else if(e1 instanceof Boolean){
                    if(e2 instanceof Boolean){
                        this.val = (((Boolean)e1) ? 1 : 0) >= (((Boolean)e2) ? 1 : 0);
                    }
                }
                break;
                
            case "<=":
                if(e1 instanceof Integer){
                    if(e2 instanceof Integer){
                        this.val = (int)e1 <= (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (int)e1 <= (Double)e2;
                    }
                }else if(e1 instanceof Double){
                    if(e2 instanceof Integer){
                        this.val = (Double)e1 <= (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (Double)e1 <= (Double)e2;
                    }
                }else if(e1 instanceof String){
                    if(e2 instanceof String){
                        this.val = getAscii((String)e1) <= getAscii((String)e2);
                    }
                }else if(e1 instanceof Boolean){
                    if(e2 instanceof Boolean){
                        this.val = (((Boolean)e1) ? 1 : 0) <= (((Boolean)e2) ? 1 : 0);
                    }
                }
                break;
                
            case "==":
                if(e1 instanceof Integer){
                    if(e2 instanceof Integer){
                        this.val = (int)e1 == (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (int)e1 == (Double)e2;
                    }
                }else if(e1 instanceof Double){
                    if(e2 instanceof Integer){
                        this.val = (Double)e1 == (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = Objects.equals((Double)e1, (Double)e2);
                    }
                }else if(e1 instanceof String){
                    if(e2 instanceof String){
                        this.val = getAscii((String)e1) == getAscii((String)e2);
                    }
                }else if(e1 instanceof Boolean){
                    if(e2 instanceof Boolean){
                        this.val = (((Boolean)e1) ? 1 : 0) == (((Boolean)e2) ? 1 : 0);
                    }
                }
                break;
                
            case "!=":
                if(e1 instanceof Integer){
                    if(e2 instanceof Integer){
                        this.val = (int)e1 != (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = (int)e1 != (Double)e2;
                    }
                }else if(e1 instanceof Double){
                    if(e2 instanceof Integer){
                        this.val = (Double)e1 != (int) e2;
                    }else if(e2 instanceof Double){
                        this.val = !Objects.equals((Double)e1, (Double)e2);
                    }
                }else if(e1 instanceof String){
                    if(e2 instanceof String){
                        this.val = getAscii((String)e1) != getAscii((String)e2);
                    }
                }else if(e1 instanceof Boolean){
                    if(e2 instanceof Boolean){
                        this.val = (((Boolean)e1) ? 1 : 0) != (((Boolean)e2) ? 1 : 0);
                    }
                }
                break;
        }
    }
    
    @Override
    public nodo run(env ambiente) {
        Object e1 = this.e1.run(ambiente).val;
        Object e2 = this.e2.run(ambiente).val;
        
        setVal(e1, e2);
        return this;
    }

    private int getAscii(String string) {
        char[] tmp = string.toCharArray();
        int t = 0;
        for(char c : tmp) t += (int)c;
        return t;
    }
    
}
