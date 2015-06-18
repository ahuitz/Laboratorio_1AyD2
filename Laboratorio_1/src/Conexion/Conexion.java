/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import javax.persistence.*;

/**
 *
 * @author Cliente
 */
public final class  Conexion {
    
   /* private static Conexion conexion = new Conexion();

    private Conexion() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio_1JPA");
        EntityManager em = emf.createEntityManager();
    }
    
    public static Conexion getInstance(){
        return conexion;
    }
    */
    private static Conexion conectar;
    
    public static Conexion getConexion(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Laboratorio_1JPA");
        EntityManager em = emf.createEntityManager();
        return null;
    }   
    
    private Conexion(){
        
    }
 }
