/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author Usuario
 */
public class EscolherArquivo {

    File arquivo = null;
    String pastainicial;

    public EscolherArquivo() {
        this.pastainicial = System.getProperty("user.home");
    }

    public EscolherArquivo(String pastaInicial) {
        this.pastainicial = pastaInicial;
    }

    public void AbreArquivo() throws IOException {

        JFileChooser fileChooser = new JFileChooser(pastainicial);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            arquivo = fileChooser.getSelectedFile();
        }
    }

    public ArrayList LerArquivo() throws IOException {
        BufferedReader bufferedReader = null;

        AbreArquivo();

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
}
