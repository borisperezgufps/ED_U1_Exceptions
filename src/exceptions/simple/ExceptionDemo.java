/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions.simple;

import javax.swing.JOptionPane;

/**
 *
 * @author Boris Perez
 */
public class ExceptionDemo {
    
    public static void main(String[] args) {
        ExceptionDemo de = new ExceptionDemo();
        String numero = JOptionPane.showInputDialog("Ingrese un "
                + "valor a tranferir:");
        de.ejemplificarSinException(numero);
        // Si en el llamado anterior hay excepción
        // esto no se ejecuta cuando hay excepción   
        de.ejemplificarConException(numero);     
        // 2do tema a resolver: Pero el main no se enteró. 
        // Se enteró fue la consola.
    }
    
    public void ejemplificarConException(String num){
        System.out.println("Abriendo sesión con el banco");        
        try {
            int numero = Integer.parseInt(num);
            System.out.println("Operación exitosa.");
        } catch (Exception e) {
            // 1er tema a resolver
            System.out.println("O.o se produjo un error. "
                    + "Qué clase de error?"); 
//            e.printStackTrace();
        }
        System.out.println("Cerrando sesión con el banco");
    }   
    
    public void ejemplificarSinException(String num){
        System.out.println("Abriendo sesión con el banco");        
        int numero = Integer.parseInt(num);
        System.out.println("Operación exitosa.");
        System.out.println("Cerrando sesión con el banco");
    } 
}




