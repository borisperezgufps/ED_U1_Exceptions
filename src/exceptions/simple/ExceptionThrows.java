/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions.simple;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Boris Perez
 */
public class ExceptionThrows {
    
    public static void main(String[] args) {
        ExceptionThrows de = new ExceptionThrows();
        String numero = JOptionPane.showInputDialog("Ingrese un "
                + "valor a tranferir:");
        
        int iNum = Integer.parseInt(numero);
        
        de.ejemplificarSinThrows(iNum);
        try {  
            de.ejemplificarConThrows(iNum);
        } catch (Exception ex) {
            // Realizar alguna operación
        }
    }
    
    /**
     * El metodo valida que la edad sea mayor
     * @param num 
     */
    public boolean ejemplificarConThrows(int edad) throws Exception{
        System.out.println("Abriendo sesión con el banco");     
        boolean exito = false;
        if(edad>18 && edad<65){
            System.out.println("Se puede crear el cliente");
            exito = true;
        }else{
            exito = false;
            // Cómo se notifica que la persona es menor de 
            // edad, o que la persona ya es muy mayor?
            // El método solo retornará falso.
            if(edad<18)
                throw new Exception("La persona es menor de edad.");
            else if(edad>65)
                throw new Exception("La persona es mayor de edad.");
        }            
        System.out.println("Cerrando sesión con el banco");
        return exito;
    }   
    
    /**
     * El metodo valida que la edad sea mayor
     * @param num 
     */
    public boolean ejemplificarSinThrows(int edad){
        System.out.println("Abriendo sesión con el banco");     
        boolean exito = false;
        if(edad>18 && edad<65){
            System.out.println("Se puede crear el cliente");
            exito = true;
        }else{
            exito = false;
            // Cómo se notifica que la persona es menor de 
            // edad, o que la persona ya es muy mayor?
            // El método solo retornará falso.
        }            
        System.out.println("Cerrando sesión con el banco");
        return exito;
    }   
    
    
    
}
