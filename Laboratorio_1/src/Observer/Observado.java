/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;
import java.util.Observable;
/**
 *
 * @author Cliente
 */
public class Observado extends Observable{
    
    private double temperatureF = 32; 
    
   
    public double getF(){
   
        return temperatureF;
    }
    
    public double getC(){
        return (temperatureF-32.0)*5.0/9.0;
    }
    
    public void setF(double tempF){
        temperatureF = tempF;
        setChanged();
        notifyObservers();
    }
    public void setC(double tempC){
        
        temperatureF = tempC*9/5+32;
        setChanged();
        notifyObservers();
    }
   
}
