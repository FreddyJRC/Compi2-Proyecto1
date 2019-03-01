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
public class Return extends RuntimeException {
    final Object val;
    
    Return(Object val){
        super(null, null, false, false);
        this.val = val;
    }
}
