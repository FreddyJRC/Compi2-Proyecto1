/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_gxml;

/**
 *
 * @author freddy
 */
public class Atributo {

    public String nombre;
    public Object valor;
    
    public Atributo(String accion, Object i) {
        this.nombre = accion;
        this.valor = i;
    }
    
}
