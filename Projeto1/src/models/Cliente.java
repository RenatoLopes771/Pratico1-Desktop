/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author jogos
 */
public class Cliente extends BasePessoa implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;
    
    protected double score;
    
    public static final String COL4 = "Score";
    
    public Cliente() {
        this.ID = 0;
        this.nome = "";
        this.email = "";
        this.score = 0.0;
    }
    
    public Cliente(int ID, String nome, String email, double score) {
        this.ID = ID;
        this.nome = nome;
        this.email = email;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
