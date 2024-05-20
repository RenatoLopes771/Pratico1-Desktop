/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.util.ArrayList;
import views.ErroPrompt;

/**
 *
 * @author Usuario
 */
public class Util {

    // https://stackoverflow.com/a/16058059
    public static boolean emailEValido(String email) {
           String pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
    
    public static boolean emailEIDJaExisteOuInvalido(
            String ID,
            String nome,
            String email,
            ArrayList<String> IDs,
            ArrayList<String> emails
    ) {
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

        if (IDs.contains(ID)) {
            ErroPrompt.gerar(
                    "Erro: ID já existe\nID: " + ID
            );
            return true;
        }
        
        if (emails.contains(email)) {
            ErroPrompt.gerar(
                    "Erro: email ja existe\nEmail: " + email + "\nID: " + ID
            );
            return true;
        }
        
        return false;
    }
}
