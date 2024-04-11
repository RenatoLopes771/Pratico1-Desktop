/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jogos
 */
public class Produto extends javax.swing.JFrame {

    private final controllers.Produto produtoController;
    DefaultTableModel jTableModel;

    /**
     * Creates new form Produto
     */
    public Produto() {
        produtoController = new controllers.Produto();

        jTableModel = new DefaultTableModel();
        jTableModel.addColumn(produtoController.getCol1());
        jTableModel.addColumn(produtoController.getCol2());
        jTableModel.addColumn(produtoController.getCol3());

        initComponents();
    }

    private void clearjTable() {
        while (jTableModel.getRowCount() > 0) {
            jTableModel.removeRow(0);
        }
    }

    private void adicionarItem(int ID, String nome, double preco) {
        jTableModel.addRow(new Object[]{
            ID,
            nome,
            preco
        });
    }

    private boolean precoValido(String preco, int ID) {
        boolean contemPonto = false;
        String posicao = "";

        if (ID != -1) {
            posicao = "\nID: " + ID;
        }

        for (char caractere : preco.toCharArray()) {

            if (caractere == ',') {
                ErroPrompt.gerar(
                        "Erro: Preço inválido, contém virgula. Use ponto em vez disso" + posicao
                );
                return false;
            }

            if (caractere == '.') {
                if (contemPonto) {
                    ErroPrompt.gerar(
                            "Erro: Preço inválido, contém múltiplos pontos\n" + posicao
                    );
                    return false;
                } else {
                    contemPonto = true;
                }
            }
        }

        return true;
    }

    private void exportar() {
        ArrayList<models.Produto> conteudo = new ArrayList<models.Produto>();

        for (int x = 0; x < jTableModel.getRowCount(); x++) {
            models.Produto produto = new models.Produto();

            int ID;

            try {
                ID = Integer.parseInt(
                        "" + jTableModel.getValueAt(x, 0)
                );

                produto.setID(ID);

            } catch (Exception e) {
                ErroPrompt.gerar(
                        "Erro: ID inválido\nID: " + jTableModel.getValueAt(x, 0) + "\nPosição: " + (x + 1)
                );
                return;
            }

            produto.setNome("" + jTableModel.getValueAt(x, 1));

            String preco = "" + jTableModel.getValueAt(x, 2);

            if (!precoValido(preco, ID)) {
                return;
            }

            try {
                produto.setPreco(
                        Double.parseDouble(
                                preco
                        )
                );
            } catch (Exception e) {
                ErroPrompt.gerar(
                        "Erro: Preço inválido\nPosição: " + (x + 1)
                );
                return;
            }

            conteudo.add(produto);
        }

        produtoController.exportar(conteudo);
    }

    private void importar() {
        ArrayList<models.Produto> importar = new ArrayList<models.Produto>();

        importar = produtoController.importar();

        if (importar == null) {
            return;
        }

        int linha = 0;
        this.clearjTable();

        for (models.Produto produto : importar) {
            adicionarItem(
                    produto.getID(),
                    produto.getNome(),
                    produto.getPreco()
            );
        }
    }

    private void deletar() {
        int index = jTable.getSelectedRow();

        if (index == -1) {
            ErroPrompt.gerar("Selecione um para deletar");
            return;
        }

        jTableModel.removeRow(index);
    }

    private void adicionar() {
        int ID;
        double preco;

        try {
            ID = Integer.parseInt(jTextField1.getText());

        } catch (Exception e) {
            ErroPrompt.gerar("Erro: valor ID inválido");
            return;
        }

        if (!this.precoValido(jTextField3.getText(), -1)) {
            return;
        }

        try {
            preco = Double.parseDouble(jTextField3.getText());
        } catch (Exception e) {
            ErroPrompt.gerar("Erro: valor preço inválido");
            return;
        }

        String nome = jTextField2.getText();

        adicionarItem(ID, nome, preco);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButtonDeletar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonExportar = new javax.swing.JButton();
        jButtonImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(jTableModel);
        jScrollPane1.setViewportView(jTable);

        jButtonDeletar.setText("Deletar");
        jButtonDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeletarMouseClicked(evt);
            }
        });

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAdicionarMouseClicked(evt);
            }
        });

        jButtonExportar.setText("Exportar");
        jButtonExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonExportarMouseClicked(evt);
            }
        });

        jButtonImportar.setText("Importar");
        jButtonImportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonImportarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3))
                        .addGap(176, 176, 176)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonImportar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonExportar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeletar)
                .addGap(26, 26, 26)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImportar)
                    .addComponent(jButtonAdicionar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeletarMouseClicked
        this.deletar();
    }//GEN-LAST:event_jButtonDeletarMouseClicked

    private void jButtonAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAdicionarMouseClicked
        this.adicionar();
    }//GEN-LAST:event_jButtonAdicionarMouseClicked

    private void jButtonExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExportarMouseClicked
        this.exportar();
    }//GEN-LAST:event_jButtonExportarMouseClicked

    private void jButtonImportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImportarMouseClicked
        this.importar();
    }//GEN-LAST:event_jButtonImportarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonExportar;
    private javax.swing.JButton jButtonImportar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}