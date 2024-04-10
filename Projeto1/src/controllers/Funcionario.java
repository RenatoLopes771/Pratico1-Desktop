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
public class Funcionario {

    private final FileController fileController;

    private final int ID_INDEX = 0;
    private final int NOME_INDEX = 1;
    private final int EMAIL_INDEX = 2;

    public Funcionario() {
        this.fileController = new FileController("user.home\\Documents\\Programação Dekstop\\Pratico1-Desktop"); // #TODO DEBUG
    }

    public Funcionario(String path) {
        this.fileController = new FileController(path);
    }

    public ArrayList<models.Funcionario> importar() {
        ArrayList<ArrayList<String>> conteudoLido;
        ArrayList<models.Funcionario> conteudoRetornar = new ArrayList<models.Funcionario>();

        conteudoLido = fileController.importar();

        if (conteudoLido == null) {
            return null;
        }

        for (ArrayList<String> lista : conteudoLido) {
            models.Funcionario funcionario = new models.Funcionario();

            funcionario.setID(Integer.parseInt(lista.get(ID_INDEX)));
            funcionario.setNome(lista.get(NOME_INDEX));
            funcionario.setEmail(lista.get(EMAIL_INDEX));

            conteudoRetornar.add(funcionario);
        }

        return conteudoRetornar;
    }

    public boolean exportar(ArrayList<models.Funcionario> conteudo) {

        ArrayList<ArrayList<String>> conteudoexportar = new ArrayList<ArrayList<String>>();

        for (models.Funcionario funcionario : conteudo) {
            ArrayList<String> funcionarioexportar = new ArrayList<String>();

            String ID = "" + funcionario.getID();
            String nome = funcionario.getNome();
            String email = funcionario.getEmail();

            if (emailEIDJaExisteOuInvalido(ID, nome, email, conteudoexportar)) {
                return false;
            }

            funcionarioexportar.add(ID);
            funcionarioexportar.add(nome);
            funcionarioexportar.add(email);

            conteudoexportar.add(funcionarioexportar);
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
        return models.Funcionario.COL1;
    }

    public String getCol2() {
        return models.Funcionario.COL2;
    }

    public String getCol3() {
        return models.Funcionario.COL3;
    }
}
