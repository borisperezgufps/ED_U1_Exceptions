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
        
        
        try{
            de.ejemplificarSinException(numero);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        de.ejemplificarConException(numero);     
        // 2do tema a resolver: Pero el main no se enteró. 
        // Se enteró fue la consola.
        
        // Si en el llamado anterior hay excepción
        // esto no se ejecuta cuando hay excepción   
        
    }
    
    public void ejemplificarConException(String num){
        System.out.println("Abriendo sesión con el banco");        
        try {
            int numero = Integer.parseInt(num);
            System.out.println("Operación exitosa.");
        } catch (Exception e) {
            // 1er tema a resolver
            System.out.println("O.o se produjo un error: "
                    + e.getMessage()); 
//            e.printStackTrace();
        }
        System.out.println("Cerrando sesión con el banco");
    }   
    
    public void ejemplificarSinException(String num) throws Exception{
        System.out.println("Abriendo sesión con el banco");        
        
        if(num.isEmpty())
            throw new Exception("El campo 'num' no puede estar vacio.");
        
        int numero = 0;
        try{
            numero = Integer.parseInt(num);
        }catch(Exception e){
            // cerrar conexion a la BD
            // limpio buffers
            throw new Exception("El campo 'num' no puede "
                    + "tener caracteres textuales.");
        }
        
        if(numero<18)
            throw new Exception("El número no puede ser menor a 18.");
        
        System.out.println("Operación exitosa.");
        System.out.println("Cerrando sesión con el banco");
    } 
}




