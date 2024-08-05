/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions.complejo.modelo;

/**
 *
 * @author Boris Perez
 */
public class Banco {
    
    public void retirar(String cuenta, String valor) throws Exception{
        
        if(validarSiCuentaExiste(cuenta)){
            
            // Acá se puede generar una excepción.
            // Qué propone hacer?
            double dValor = Double.parseDouble(valor);
            
            boolean hayFondos = validarSiHayFondos(cuenta, dValor);
            if(hayFondos){
                // Realiza las operaciones respectivas
            }else{
                throw new Exception("No cuenta con fondos suficientes");
            }
        }else
            throw new Exception("La cuenta no existe");
    }
    
    /**
     * Este metodo simula la validación de fondos en la
     * cuenta bancaria. Implementa un random para 
     * retornar falso o verdadero.
     * @param cuenta
     * @return 
     */
    private boolean validarSiHayFondos(String cuenta, double valorRetirar){
        boolean hayFondos = false;
        
        int valor = (int)(Math.random()*100);
        if(valor>60)
            hayFondos = true;
        
        return hayFondos;
    }
    
    /**
     * Este metodo simula la validación de la cuenta. 
     * Implementa un random para retornar falso o verdadero.
     * @param cuenta
     * @return 
     */
    private boolean validarSiCuentaExiste(String cuenta){
        boolean existeCuenta = false;
        
        int valor = (int)(Math.random()*100);
        if(valor>60)
            existeCuenta = true;
        
        return existeCuenta;
    }
    
}
