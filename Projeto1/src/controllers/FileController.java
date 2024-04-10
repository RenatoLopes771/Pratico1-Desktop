/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import views.ErroPrompt;
import views.EscolherArquivo;

/**
 *
 * @author Usuario
 */
public class FileController {

    private final String path;
    private final EscolherArquivo escolherArquivo;

    public FileController() {
        this.path = "user.home";
        this.escolherArquivo = new EscolherArquivo();
    }

    public FileController(String caminho) {
        this.path = caminho;
        this.escolherArquivo = new EscolherArquivo();
    }

    private ArrayList<String> lerArquivo(File arquivo) throws IOException {
        BufferedReader bufferedReader;

        bufferedReader = new BufferedReader(new FileReader(arquivo));

        ArrayList<String> linhas = new ArrayList<String>();

        while (bufferedReader.ready()) {
            linhas.add(
                    bufferedReader.readLine()
            );
        }

        bufferedReader.close();

        return linhas;
    }

    public ArrayList<ArrayList<String>> importar() {

        ArrayList<ArrayList<String>> conteudo = new ArrayList<ArrayList<String>>();

        try {
            File arquivo = escolherArquivo.AbreArquivo(this.path);

            if (arquivo == null) {
                return null;
            }

            ArrayList<String> linhas = this.lerArquivo(arquivo);
            ArrayList<String> conteudoParte;

            for (String linha : linhas) {
                conteudoParte = new ArrayList<String>();
                for (String parte : linha.split(";")) {
                    conteudoParte.add(parte);
                }

                conteudo.add(conteudoParte);
            }

        } catch (IOException exception) {
            ErroPrompt.gerar("Erro IOException: " + exception.getLocalizedMessage());
            conteudo = null;
        } catch (Exception exception) {
            ErroPrompt.gerar("Erro: " + exception.getLocalizedMessage());
            conteudo = null;
        }

        return conteudo;
    }

    public void escreverArquivo(
            File arquivo,
            ArrayList<ArrayList<String>> conteudo
    ) throws IOException {
        BufferedWriter bufferedWriter;

        bufferedWriter = new BufferedWriter(new FileWriter(arquivo));

        ArrayList<String> linhas = new ArrayList<String>();

        for (ArrayList<String> arraylist : conteudo) {
            bufferedWriter.write(String.join(";", arraylist) + "\n");
            bufferedWriter.flush();
        }

        bufferedWriter.close();
    }

    public boolean exportar(ArrayList<ArrayList<String>> conteudo) {
        try {
            File arquivo = escolherArquivo.AbreArquivo(this.path);

            if (arquivo == null) {
                return false;
            }

            this.escreverArquivo(arquivo, conteudo);

        } catch (IOException exception) {
            ErroPrompt.gerar("Erro IOException: " + exception.getLocalizedMessage());
            return false;
        } catch (Exception exception) {
            ErroPrompt.gerar("Erro: " + exception.getLocalizedMessage());
            return false;
        }

        return true;
    }

};
