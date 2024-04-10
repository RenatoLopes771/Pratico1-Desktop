/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Usuario
 */
public class EscolherArquivo {

    JFileChooser fileChooser;

    public EscolherArquivo() {
    }

    public File AbreArquivo(String pastainicial) throws IOException {

        File arquivo;
        fileChooser = new JFileChooser(pastainicial);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }
}
