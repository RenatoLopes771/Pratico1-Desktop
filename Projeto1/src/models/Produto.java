/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author jogos
 */
public class Produto extends BaseEntidade implements java.io.Serializable {
    
    private static final long serialVersionUID = 3L;

    protected double preco;

    public static final String COL3 = "Preço";

    public Produto() {
        this.ID = 0;
        this.nome = "";
        this.preco = 0;
    }

    public Produto(int ID, String nome, double preco) {
        this.ID = ID;
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
