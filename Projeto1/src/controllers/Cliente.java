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
import utilities.Util;
import views.ErroPrompt;

/**
 *
 * @author jogos
 */
public class Cliente {

    private final FileController fileController;

    public Cliente() {
        this.fileController = new FileController("user.home");
    }

    public Cliente(String path) {
        this.fileController = new FileController(path);
    }

    public ArrayList<models.Cliente> importar() {
        ArrayList<models.Cliente> conteudoRetornar;
        ObjectInputStream ois;

        try {
            File arquivo = fileController.getArquivo();

            ois = new ObjectInputStream(
                    new FileInputStream(arquivo)
            );

            conteudoRetornar = (ArrayList<models.Cliente>) ois.readObject();
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

    public boolean exportar(ArrayList<models.Cliente> conteudo) {
        ObjectOutputStream oos;
        Boolean saida = false;
        ArrayList<String> IDs = new ArrayList<String>();
        ArrayList<String> emails = new ArrayList<String>();

        for (models.Cliente cliente : conteudo) {
            String ID = "" + cliente.getID();
            String nome = cliente.getNome();
            String email = cliente.getEmail();
            String score = "" + cliente.getScore();

            if (Util.emailEIDJaExisteOuInvalido(
                    ID, nome, email, IDs, emails
            )) {
                return saida;
            }

            IDs.add(ID);
            emails.add(email);

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
        }
        
        return saida;
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

    public String getCol4() {
        return models.Cliente.COL4;
    }
}
