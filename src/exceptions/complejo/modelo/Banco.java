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
    
    
    
    
    
}
