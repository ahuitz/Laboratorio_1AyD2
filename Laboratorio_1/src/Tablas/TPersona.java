/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;
import javax.persistence.*;
import java.io.Serializable;
/**
 *
 * @author EST1659109
 */
@Entity
public class TPersona implements Serializable{
    @Id
    private int id;
    private String nombre;
    private String apellido;
    private boolean conectado;

    public TPersona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
    @Override
    public String toString(){
        return "Persona"+nombre+" "+apellido;
    }
    
    
}
