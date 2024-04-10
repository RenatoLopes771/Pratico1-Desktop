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
public class ErroPrompt {

    public static void gerar(String errormessage) {
        JOptionPane.showMessageDialog(new JFrame(), errormessage, "Prompt",
                JOptionPane.ERROR_MESSAGE);
    }
}
