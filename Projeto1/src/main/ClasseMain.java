/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.ArrayList;
import views.EscolherArquivo;

/**
 *
 * @author Usuario
 */
public class ClasseMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String DEBUG = "user.home\\Documents\\Programação Dekstop\\Pratico1-Desktop";

        ArrayList<String> teste = new ArrayList<String>();

        try {
            EscolherArquivo obj = new EscolherArquivo(DEBUG);
            teste = obj.LerArquivo();
        } catch (Exception e) {
            System.out.println("Teste");
        }

        teste.forEach((e) -> {
            System.out.println(e);
        });
    }

}
