/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author freddy
 */
public class Desplegable extends nodo {

    String id;
    nodo alto, ancho, lista, x, y, defecto, nombre;
    
    public Desplegable(String i, nodo h, nodo w, nodo l, nodo x, nodo y, nodo d, nodo n) {
        this.id = i;
        this.alto = h;
        this.ancho = w;
        this.lista = l;
        this.x = x;
        this.y = y;
        this.defecto = d;
        this.nombre = n;
    }

    @Override
    public nodo run(env ambiente) {
        
        Object panel = ambiente.get(id).val;
        
        if(panel instanceof JPanel){
            Object alto = this.alto.run(ambiente).val;
            Object ancho = this.ancho.run(ambiente).val;
            Object lista = this.lista.run(ambiente).val;
            Object x = this.x.run(ambiente).val;
            Object y = this.y.run(ambiente).val;
            Object defecto = this.defecto.run(ambiente).val;
            Object nombre = this.nombre.run(ambiente).val;
            
            JComboBox caja = new JComboBox();
            
            if(lista instanceof LinkedList){
                String [] list = new String[((LinkedList) lista).size()];
                for (int i = 0; i < ((LinkedList) lista).size(); i++) {
                    list[i] = ((nodo) ((LinkedList) lista).get(i)).val.toString();
                }
                
                ArrayList<String> tmp = new ArrayList<>();
                ((LinkedList<nodo>) lista).forEach((i) -> {
                    tmp.add(i.val.toString());
                });
                
                caja = new JComboBox(tmp.toArray());
            }
            
            if(alto instanceof Integer && ancho instanceof Integer)
                caja.setSize((int) ancho, (int) alto);
            
            if(x instanceof Integer && y instanceof Integer)
                caja.setLocation((int) x, (int) y);
            
            if(defecto instanceof String)
                caja.setSelectedItem(defecto);
            
            if(nombre instanceof String)
                caja.setName((String) nombre);
            
            ((JPanel) panel).add(caja);
        }
        
        return this;
    }
    
}
