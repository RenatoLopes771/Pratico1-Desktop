/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import views.ErroPrompt;
import utilities.Util;

/**
 *
 * @author jogos
 */
public class Cliente {
    
    private final FileController fileController;
    
    private final int ID_INDEX = 0;
    private final int NOME_INDEX = 1;
    private final int EMAIL_INDEX = 2;
    
    public Cliente() {
        this.fileController = new FileController("user.home");
    }
    
    public Cliente(String path) {
        this.fileController = new FileController(path);
    }
    
    public ArrayList<models.Cliente> importar() {
        ArrayList<ArrayList<String>> conteudoLido;
        ArrayList<models.Cliente> conteudoRetornar = new ArrayList<models.Cliente>();
        
        conteudoLido = fileController.importar();
        
        if (conteudoLido == null) {
            return null;
        }
        
        for (ArrayList<String> lista : conteudoLido) {
            models.Cliente cliente = new models.Cliente();
            
            cliente.setID(Integer.parseInt(lista.get(ID_INDEX)));
            cliente.setNome(lista.get(NOME_INDEX));
            cliente.setEmail(lista.get(EMAIL_INDEX));
            
            conteudoRetornar.add(cliente);
        }
        
        return conteudoRetornar;
    }
    
    public boolean exportar(ArrayList<models.Cliente> conteudo) {
        
        ArrayList<ArrayList<String>> conteudoexportar = new ArrayList<ArrayList<String>>();
        
        for (models.Cliente cliente : conteudo) {
            ArrayList<String> clienteexportar = new ArrayList<String>();
            
            String ID = "" + cliente.getID();
            String nome = cliente.getNome();
            String email = cliente.getEmail();
            
            if (emailEIDJaExisteOuInvalido(ID, nome, email, conteudoexportar)) {
                return false;
            }
            
            clienteexportar.add(ID);
            clienteexportar.add(nome);
            clienteexportar.add(email);
            
            conteudoexportar.add(clienteexportar);
        }
        
        return fileController.exportar(conteudoexportar);
    }
    
    private boolean emailEIDJaExisteOuInvalido(
            String ID,
            String nome,
            String email,
            ArrayList<ArrayList<String>> conteudo
    ) {
        int index = 1;
        
        if (!Util.emailEValido(email)) {
            ErroPrompt.gerar(
                    "Erro: email invalido.\nEmail: " + email + "\nID: " + ID
            );
            return true;
        }
        
        if (nome.contains(";") || email.contains(";")) {
            ErroPrompt.gerar(
                    "Erro: nome contém \";\".\nNome: " + nome + "\nID: " + ID
            );
            return true;
        }
        
        for (ArrayList<String> arraylist : conteudo) {
            String IDAtual = arraylist.get(0);
            String nomeAtual = arraylist.get(1);
            String emailAtual = arraylist.get(2);
            
            if (IDAtual.equals(ID)) {
                ErroPrompt.gerar(
                        "Erro: ID já existe.\nID: " + IDAtual + "\nNome: " + nome
                );
                return true;
            }
            
            if (emailAtual.equals(email)) {
                ErroPrompt.gerar(
                        "Erro: email já está cadastrado.\nEmail: " + emailAtual + "\nID: " + ID
                );
                return true;
            }
            
            index++;
        }
        
        return false;
    }
    
    public String getCol1() {
        return models.Cliente.COL1;
    }
    
    public String getCol2() {
        return models.Cliente.COL2;
    }
    
    public String getCol3() {
        return models.Cliente.COL3;
    }
}
