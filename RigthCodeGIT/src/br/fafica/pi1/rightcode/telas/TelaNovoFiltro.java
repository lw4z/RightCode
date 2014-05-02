/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fafica.pi1.rightcode.telas;

import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.FiltroConteudoInvalidoException;
import br.fafica.pi1.rightcode.exception.FiltrolistaVaziaException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.fachada.Fachada;
import br.fafica.pi1.rightcode.filtro.Filtro;
import br.fafica.pi1.rightcode.usuario.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EDWARD
 */
public class TelaNovoFiltro extends javax.swing.JFrame {
    private Fachada fachada;
    private Usuario usuario;
    private Filtro filtro;
    private ConfigurarFiltro telaAnt; 
    /**
     * Creates new form TelaFiltro
     */
    private TelaNovoFiltro() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public TelaNovoFiltro(ConfigurarFiltro telaAnt, Usuario usuario){
        this();
        this.usuario = usuario;
        this.telaAnt=telaAnt;
        fachada = Fachada.getInstancia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoConteudo = new javax.swing.JTextArea();
        salvarF = new javax.swing.JButton();
        Concluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Filtro");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nome do filtro");

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Conteudo Filtro");

        campoConteudo.setColumns(20);
        campoConteudo.setRows(5);
        jScrollPane1.setViewportView(campoConteudo);

        salvarF.setText("Salvar");
        salvarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					salvarFActionPerformed(evt);
				} catch (FiltroConteudoInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        Concluir.setText("Concluir");
        Concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(salvarF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(Concluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarF)
                    .addComponent(Concluir))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarFActionPerformed(java.awt.event.ActionEvent evt) throws FiltroConteudoInvalidoException {//GEN-FIRST:event_salvarFActionPerformed
       System.out.println("Teste TelaNovoUsuario codigo "+usuario.getCodigo());
       Filtro filtro = new Filtro(campoNome.getText(),campoConteudo.getText(),usuario.getCodigo());
       int i= filtro.getCodigo();
       System.out.println(filtro);
      // fachada = Fachada.getInstancia();
        try {
        this.fachada.AdicionarFiltro(filtro);
        limparCampos();
        JOptionPane.showMessageDialog(null,"Filtro Cadastrado!");
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        } catch (CodigoInvalidoException ex) {
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        } catch (NomeInvalidoException ex) {
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        }
       
    }//GEN-LAST:event_salvarFActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void ConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConcluirActionPerformed
      this.telaAnt.setEnabled(true);
      this.setVisible(false);
        try {
            this.telaAnt.carregarJTable();
        } catch (SQLException ex) {
           
        } catch (FiltrolistaVaziaException ex) {
          
        }
      
    }//GEN-LAST:event_ConcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.telaAnt.setEnabled(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing
    public void limparCampos(){
        this.campoNome.setText(null);
        this.campoConteudo.setText(null);
        
    }
        
    
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
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        } catch (InstantiationException ex) {
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        } catch (IllegalAccessException ex) {
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaNovoFiltro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Concluir;
    private javax.swing.JTextArea campoConteudo;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salvarF;
    // End of variables declaration//GEN-END:variables
}