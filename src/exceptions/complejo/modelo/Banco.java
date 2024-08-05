/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions.complejo.modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Boris Perez
 */
public class Banco {
    
    public ArrayList<Cuenta> cuentas;

    public Banco() {
        cuentas = new ArrayList<Cuenta>();
    }
    
    public void cargarCuentasArchivo(){
        Scanner fileIn = null;
        
        try {
            fileIn = new Scanner(new FileReader("src/cuentas.txt"));
            while (fileIn.hasNextLine()) {
                String oneLine = fileIn.nextLine();
                System.out.println(oneLine);
                cuentas.add(convertirAObjeto(oneLine));
            }            
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // Close the stream
            if (fileIn != null) {
                fileIn.close();
            }            
        }
    }
    
    private Cuenta convertirAObjeto(String linea){
        if(linea!=null && !linea.isBlank()){
            String[] cuenta = linea.split(";");
            
            String numeroCuenta = cuenta[0];
            // Ojo, acá se puede saltar una excepción.
            double saldo = Double.parseDouble(cuenta[1]);
            
            Cuenta c = new Cuenta(numeroCuenta, saldo);
            return c;
        }
        return null;
    }
    
    public ArrayList<String> listarCuentas(){
        ArrayList<String> lista = new ArrayList<>();
        for (Cuenta c : cuentas) {
            lista.add(c.getNumero());
        }
        return lista;
    }
    
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
