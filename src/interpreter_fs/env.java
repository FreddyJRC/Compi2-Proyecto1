/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_fs;

import java.nio.charset.Charset;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author freddy
 */
class env {
    private String name;
    public env last;
    private Hashtable<String, simbol> tabla;
    
    public env(env last){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        this.name = new String(array, Charset.forName("UTF-8"));
        
        tabla = new Hashtable<>();
        this.last = last;
    }
    
    public env(String name, env last){
        this.name = name;
        this.last = last;
        tabla = new Hashtable<>();
    }
    
    public void put(String id, String tipo, Object val){
        if(tabla.containsKey(id)){
            System.out.println("ERROR: Variable " + id + " ya existe.");
        }else{
            tabla.put(id, new simbol(tipo, val));
        }
    }
    
    public simbol get(String id){
        if(tabla.containsKey(id)){
            return tabla.get(id);
        }else{
            if(last != null){
                return last.get(id);
            }else{
                System.out.println("ERROR: Variable " + id + " no existe.");
                return null;
            }
        }
    }
    
    public void set(String id, Object val){
        if(tabla.containsKey(id)){
            tabla.get(id).val = val;
        }else{
            if(last != null){
                last.set(id, val);
            }else{
                System.out.println("ERROR: Variable " + id + " no existe.");
            }
        }
    }
    
    public boolean exists(String id){
        return tabla.containsKey(id);
    }

    public void putAll(Map map) {
        tabla.putAll(map);
    }
}
