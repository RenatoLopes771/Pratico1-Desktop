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
public class AvisoPrompt {
    
    public static void gerar(String infomessage) {
        JOptionPane.showMessageDialog(new JFrame(), infomessage, "Prompt",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
