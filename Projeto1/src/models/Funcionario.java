/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author jogos
 */
public class Funcionario extends BasePessoa {
    protected boolean recesso;
    
    public static final String COL4 = "Recesso";
    
    public Funcionario() {
        this.ID = 0;
        this.nome = "";
        this.email = "";
        this.recesso = false;
    }
    
    public Funcionario(int ID, String nome, String email, boolean recesso) {
        this.ID = ID;
        this.nome = nome;
        this.email = email;
        this.recesso = recesso;
    }

    public boolean getRecesso() {
        return recesso;
    }

    public void setRecesso(boolean recesso) {
        this.recesso = recesso;
    }
}
