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
public class detener extends nodo{

    public detener(){};
    
    @Override
    public nodo run(env ambiente) {
        if(display.display.peek() == 1){
            display.display.pop();
            display.display.push(2);
            
            throw new Break();
        }else {
            System.out.println("ERROR: break no puede estar aqui.");
        }
        return this;
    }
    
}