/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import views.ErroPrompt;

/**
 *
 * @author jogos
 */
public class Produto {

    private final FileController fileController;

    public Produto() {
        this.fileController = new FileController("user.home");
    }

    public Produto(String path) {
        this.fileController = new FileController(path);
    }

    public ArrayList<models.Produto> importar() {
        ArrayList<models.Produto> conteudoRetornar;
        ObjectInputStream ois;

        try {
            File arquivo = fileController.getArquivo();

            ois = new ObjectInputStream(
                    new FileInputStream(arquivo)
            );

            conteudoRetornar = (ArrayList<models.Produto>) ois.readObject();
            ois.close();

        } catch (IOException e) {
            ErroPrompt.gerar(e.getLocalizedMessage());
            conteudoRetornar = null;
        } catch (ClassNotFoundException e) {
            ErroPrompt.gerar(e.getLocalizedMessage());
            conteudoRetornar = null;
        } catch (Exception e) {
            ErroPrompt.gerar(e.getLocalizedMessage());
            conteudoRetornar = null;
        }

        return conteudoRetornar;
    }

    public boolean exportar(ArrayList<models.Produto> conteudo) {
        ObjectOutputStream oos;
        Boolean saida = false;
        ArrayList<String> IDs = new ArrayList<String>();

        for (models.Produto produto : conteudo) {
            String ID = "" + produto.getID();
            String nome = produto.getNome();
//            String preco = "" + produto.getPreco();

            if (nome.contains(";")) {
                ErroPrompt.gerar(
                        "Erro: nome contém \";\".\nNome: " + nome + "\nID: " + ID
                );
                return false;
            }

            if (IDs.contains(ID)) {
                ErroPrompt.gerar(
                        "Erro: ID já existe\nID: " + ID
                );
                return false;
            }

            IDs.add(ID);
        }

        try {
            File arquivo = fileController.getArquivo();

            oos = new ObjectOutputStream(
                    new FileOutputStream(arquivo)
            );

            oos.writeObject(conteudo);

            saida = true;

            oos.close();
        } catch (IOException e) {
            ErroPrompt.gerar(
                    "Erro IOException: " + e.getLocalizedMessage()
                    + "\nVocê está tentando salvar sobre um arquivo já escrito?"
            );
            saida = false;
        } catch (Exception e) {
            ErroPrompt.gerar(e.getLocalizedMessage());
            saida = false;
        }
        return saida;
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
