/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import views.ErroPrompt;

/**
 *
 * @author jogos
 */
public class Produto {

    private final FileController fileController;

    private final int ID_INDEX = 0;
    private final int NOME_INDEX = 1;
    private final int PRECO_INDEX = 2;

    public Produto() {
        this.fileController = new FileController("user.home\\Documents\\Programação Dekstop\\Pratico1-Desktop"); // #TODO DEBUG
    }

    public Produto(String path) {
        this.fileController = new FileController(path);
    }

    public ArrayList<models.Produto> importar() {
        ArrayList<ArrayList<String>> conteudoLido;
        ArrayList<models.Produto> conteudoRetornar = new ArrayList<models.Produto>();

        conteudoLido = fileController.importar();

        if (conteudoLido == null) {
            return null;
        }

        for (ArrayList<String> lista : conteudoLido) {
            models.Produto produto = new models.Produto();

            produto.setID(Integer.parseInt(lista.get(ID_INDEX)));
            produto.setNome(lista.get(NOME_INDEX));
            produto.setPreco(Double.parseDouble(lista.get(PRECO_INDEX)));

            conteudoRetornar.add(produto);
        }

        return conteudoRetornar;
    }

    public boolean exportar(ArrayList<models.Produto> conteudo) {

        ArrayList<ArrayList<String>> conteudoexportar = new ArrayList<ArrayList<String>>();

        for (models.Produto produto : conteudo) {
            ArrayList<String> produtoexportar = new ArrayList<String>();

            String ID = "" + produto.getID();
            String nome = produto.getNome();
            String preco = "" + produto.getPreco();

            if (IDJaExisteOuInvalido(ID, nome, preco, conteudoexportar)) {
                return false;
            }

            produtoexportar.add(ID);
            produtoexportar.add(nome);
            produtoexportar.add(preco);

            conteudoexportar.add(produtoexportar);
        }

        return fileController.exportar(conteudoexportar);
    }

    private boolean IDJaExisteOuInvalido(
            String ID,
            String nome,
            String preco,
            ArrayList<ArrayList<String>> conteudo
    ) {
        int index = 1;

        if (nome.contains(";")) {
            ErroPrompt.gerar(
                    "Erro: nome contém \";\".\nNome: " + nome + "\nID: " + ID
            );
            return true;
        }

        for (ArrayList<String> arraylist : conteudo) {
            String IDAtual = arraylist.get(0);
            String nomeAtual = arraylist.get(1);

            if (IDAtual.equals(ID)) {
                ErroPrompt.gerar(
                        "Erro: ID já existe.\nID: " + IDAtual + "\nNome: " + nome
                );
                return true;
            }

            index++;
        }

        return false;
    }

    public String getCol1() {
        return models.Produto.COL1;
    }

    public String getCol2() {
        return models.Produto.COL2;
    }

    public String getCol3() {
        return models.Produto.COL3;
    }
}
