/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class BasePessoa extends BaseEntidade {

    protected String email;

    public static final String COL3 = "Email";

    public BasePessoa() {
        this.ID = 0;
        this.nome = "";
        this.email = "";
    }

    public BasePessoa(int ID, String nome, String email) {
        this.ID = ID;
        this.nome = nome;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
