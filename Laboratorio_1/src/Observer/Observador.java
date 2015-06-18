/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author Cliente
 */
public class Observador implements Observer{
    
    private Observado modelo;
    public  Observador (Observado model){
        
        modelo = model;
        model.addObserver(this);
        
    }
    public void update (Observable t, Object O){
        System.out.println("la temperatura ha cambiado "+ modelo.getF()); 
    }
    
}
