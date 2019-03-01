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
public class num extends nodo{
    
    public num(String val){
        try{
            this.val = Integer.parseInt(val);
            return;
        }catch(NumberFormatException ex){
            
        }
        
        try{
            this.val = Double.parseDouble(val);
        }catch(NumberFormatException ex){
            
        }
    }
    
    @Override
    public nodo run(env ambiente) {
        //System.out.print(this.val);
        return this;
    }
    
}
