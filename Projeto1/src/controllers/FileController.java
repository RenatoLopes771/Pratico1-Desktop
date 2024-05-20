/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.File;
import java.io.IOException;
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

    // https://stackoverflow.com/a/30022340
    public File getArquivo() throws IOException {
        return escolherArquivo.AbreArquivo(this.path);
    }
};
