/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

/**
 *
 * @author freddy
 */
public class Numerico extends nodo {

    String id;
    nodo alto, ancho, max, min, x, y, defecto, nombre;
    
    public Numerico(String i, nodo h, nodo w, nodo max, nodo min, nodo x, nodo y, nodo d, nodo n) {
        this.id = i;
        this.alto = h;
        this.ancho = w;
        this.max = max;
        this.min = min;
        this.x = x;
        this.y = y;
        this.defecto = d;
        this.nombre = n;
    }

    @Override
    public nodo run(env ambiente) {
        
        Object panel = ambiente.get(id).val;
        
        if (panel instanceof JPanel){
    
            Object alto = this.alto.run(ambiente).val;
            Object ancho = this.ancho.run(ambiente).val;
            Object max = this.max.run(ambiente).val;
            Object min = this.min.run(ambiente).val;
            Object x = this.x.run(ambiente).val;
            Object y = this.y.run(ambiente).val;
            Object defecto = this.defecto.run(ambiente).val;
            Object nombre = this.nombre.run(ambiente).val;
            
            SpinnerModel model = new SpinnerNumberModel();
            
            if(max instanceof Integer && min instanceof Integer && defecto instanceof Integer)
                model = new SpinnerNumberModel((int) defecto, (int) min, (int) max, 1);
            else if(max == null && min instanceof Integer && defecto instanceof Integer)
                model = new SpinnerNumberModel((int) defecto, (int) min, null, 1);
            else if(max instanceof Integer && min == null && defecto instanceof Integer)
                model = new SpinnerNumberModel((int) defecto, null, (int) max, 1);
            else if(max == null && min == null && defecto instanceof Integer)
                model = new SpinnerNumberModel((int) defecto, null, null, 1);
                
            JSpinner caja = new JSpinner(model);
            
            if(alto instanceof Integer && ancho instanceof Integer)
                caja.setSize((int) alto, (int) ancho);
            
            if(x instanceof Integer && y instanceof Integer)
                caja.setLocation((int) x, (int) y);
            
            if(nombre instanceof String)
                caja.setName((String) nombre);
            
            ((JPanel) panel).add(caja);
        }
        
        return this;
    }
    
}
