/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PesquisarPrompt {

    public static int gerar(String message) {
        try {
            var value = javax.swing.JOptionPane.showInputDialog(message);
            
            if (value == null) return -1;
            
            return Integer.parseInt(value);
            
        } catch (Exception e) {
            ErroPrompt.gerar("ID inválido! Tente novamente");
            return PesquisarPrompt.gerar(message);
        }
    }
}
