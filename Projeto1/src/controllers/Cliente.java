/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import views.EscolherArquivo;

/**
 *
 * @author jogos
 */
public class Cliente {
    private final EscolherArquivo escolherArquivo;
    private final models.Cliente clienteModel;
    
    public Cliente() {
        escolherArquivo = new EscolherArquivo();
        clienteModel = new models.Cliente();
    }
    
    public boolean importar() {
        return true;
    }
    
    public boolean exportar() {
        return true;
    }
}
