/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controllers.Cliente;

/**
 *
 * @author Usuario
 */
public class ClasseMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Teste");
        
        Cliente cliente = new Cliente();
        
        System.out.println(cliente.getNome());
    }
    
}
