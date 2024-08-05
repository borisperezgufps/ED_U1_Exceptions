/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions.complejo.controlador;

import exceptions.complejo.modelo.Banco;
import exceptions.complejo.vista.BancoVista;
import java.util.ArrayList;

/**
 *
 * @author Boris Perez
 */
public class BancoControlador {
 
    private Banco negocio;
    private BancoVista frame;
    
    public BancoControlador(BancoVista frame){
        negocio = new Banco();
        this.frame = frame;
    }
    
    public void retirar(){
        String cuenta = frame.getTxtNumeroCuenta().getText();
        String valor = frame.getTxtValor().getText();
        
        try {
            negocio.retirar(cuenta, valor);
        } catch (Exception ex) {
            frame.getTaResultado().setText(ex.getMessage());
        }
    }
    
    public void cargarCuentas(){
        negocio.cargarCuentasArchivo();
    }
    
    public void listarCuentas(){
        ArrayList<String> lista = negocio.listarCuentas();
        frame.getTaCuentas().setText("");
        
        for (String cuenta : lista) {
            frame.getTaCuentas().append(cuenta + "\n");
        }        
    }
}
