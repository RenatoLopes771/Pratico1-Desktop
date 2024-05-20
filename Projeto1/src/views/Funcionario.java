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
public class Funcionario extends javax.swing.JFrame {

    private final controllers.Funcionario funcionarioController;
    DefaultTableModel jTableModel;

    /**
     * Creates new form Funcionario
     */
    public Funcionario() {
        funcionarioController = new controllers.Funcionario();

        jTableModel = new DefaultTableModel();
        jTableModel.addColumn(funcionarioController.getCol1());
        jTableModel.addColumn(funcionarioController.getCol2());
        jTableModel.addColumn(funcionarioController.getCol3());
        jTableModel.addColumn(funcionarioController.getCol4() + " (Sim/Não)");

        initComponents();
    }

    private void clearjTable() {
        while (jTableModel.getRowCount() > 0) {
            jTableModel.removeRow(0);
        }
    }

    private void adicionarItem(int ID, String nome, String email, boolean recesso) {
        String recessoValor;

        if (recesso) {
            recessoValor = "Sim";
        } else {
            recessoValor = "Não";
        }

        jTableModel.addRow(new Object[]{
            ID,
            nome,
            email,
            recessoValor
        });
    }

    private void exportar() {
        ArrayList<models.Funcionario> conteudo = new ArrayList<models.Funcionario>();

        for (int x = 0; x < jTableModel.getRowCount(); x++) {
            models.Funcionario funcionario = new models.Funcionario();

            try {
                funcionario.setID(
                        Integer.parseInt(
                                "" + jTableModel.getValueAt(x, 0)
                        )
                );
            } catch (Exception e) {
                ErroPrompt.gerar(
                        "Erro: ID inválido\nID: " + jTableModel.getValueAt(x, 0) + "\nPosição: " + (x + 1)
                );
                return;
            }

            funcionario.setNome("" + jTableModel.getValueAt(x, 1));
            funcionario.setEmail("" + jTableModel.getValueAt(x, 2));

            try {
                String recessoValor = "" + jTableModel.getValueAt(x, 3);

                switch (recessoValor) {
                    case "Sim":
                        funcionario.setRecesso(true);
                        break;

                    case "Não":
                        funcionario.setRecesso(false);
                        break;

                    default:
                        throw new Exception("Valor inválido");
                }

            } catch (Exception e) {
                ErroPrompt.gerar(
                        "Erro: Valor \"Recesso\" inválido: " + jTableModel.getValueAt(x, 3)
                );
                return;
            }

            conteudo.add(funcionario);
        }

        funcionarioController.exportar(conteudo);
    }

    private void importar() {
        ArrayList<models.Funcionario> importar = new ArrayList<models.Funcionario>();

        importar = funcionarioController.importar();

        if (importar == null) {
            return;
        }

        int linha = 0;
        this.clearjTable();

        for (models.Funcionario funcionario : importar) {
            adicionarItem(
                    funcionario.getID(),
                    funcionario.getNome(),
                    funcionario.getEmail(),
                    funcionario.getRecesso()
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

    private void atualizar() {
        AvisoPrompt.gerar("Clique em um campo para atualizar, então altere as informações. \nPressione enter para fazer efeito.");
    }

    private void pesquisar() {
        int ID = PesquisarPrompt.gerar("ID");

        if (ID == -1) {
            return;
        }

        try {
            for (int i = 0; i < jTable.getRowCount(); i++) {
                if (Integer.parseInt("" + jTable.getValueAt(i, 0)) == ID) {
                    System.out.println(ID + " " + i);
                    jTable.changeSelection(i, 0, false, false);
                    return;
                }
            }
            AvisoPrompt.gerar("Não encontrado");
        } catch (Exception e) {
            ErroPrompt.gerar("Erro fatal");
        }
    }

    private void adicionar() {
        try {
            int ID = Integer.parseInt(jTextField1.getText());
            String nome = jTextField2.getText();
            String email = jTextField3.getText();
            String recessoValor = jTextField4.getText();
            Boolean recesso;

            switch (recessoValor) {
                case "Sim":
                    recesso = true;
                    break;

                case "Não":
                    recesso = false;
                    break;

                default:
                    ErroPrompt.gerar("Erro: valor \"Recesso\" inválido.\nID: " + ID);
                   return;
            }

            adicionarItem(ID, nome, email, recesso);
        } catch (Exception e) {
            ErroPrompt.gerar("Erro: valor \"ID\" inválido");
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonAtualizar = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();

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

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel3.setText("Email");

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAtualizarMouseClicked(evt);
            }
        });

        jLabel4.setText("Recesso");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPesquisarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(176, 176, 176))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonImportar)
                            .addComponent(jButtonExportar))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDeletar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAtualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonDeletar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAtualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(4, 4, 4)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jButtonExportar)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImportar)
                    .addComponent(jButtonAdicionar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAdicionarMouseClicked
        this.adicionar();
    }//GEN-LAST:event_jButtonAdicionarMouseClicked

    private void jButtonExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExportarMouseClicked
        this.exportar();
    }//GEN-LAST:event_jButtonExportarMouseClicked

    private void jButtonImportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImportarMouseClicked
        this.importar();
    }//GEN-LAST:event_jButtonImportarMouseClicked

    private void jButtonAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtualizarMouseClicked
        this.atualizar();
    }//GEN-LAST:event_jButtonAtualizarMouseClicked

    private void jButtonDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeletarMouseClicked
        this.deletar();
    }//GEN-LAST:event_jButtonDeletarMouseClicked

    private void jButtonPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPesquisarMouseClicked
        this.pesquisar();
    }//GEN-LAST:event_jButtonPesquisarMouseClicked

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
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonExportar;
    private javax.swing.JButton jButtonImportar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
