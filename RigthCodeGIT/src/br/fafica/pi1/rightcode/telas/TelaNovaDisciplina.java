/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fafica.pi1.rightcode.telas;

import br.fafica.pi1.rightcode.disciplina.Disciplina;
import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.DisciplinaListaVaziaException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.fachada.Fachada;
import br.fafica.pi1.rightcode.usuario.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EDWARD
 */
public class TelaNovaDisciplina extends javax.swing.JFrame {
    private Fachada fachada;
    private Compiler telaAnt;
    private Usuario usuario;
    /**
     * Creates new form TelaNovaDisciplina
     */
    public TelaNovaDisciplina() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public TelaNovaDisciplina(Compiler telaAnt,Usuario usuario){
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

        campoNome = new javax.swing.JTextField();
        Concluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        salvarD = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Disciplina");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        getContentPane().add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 36, 300, -1));

        Concluir.setText("Concluir");
        Concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(Concluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 207, 95, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descrição:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 62, -1, -1));

        salvarD.setText("Salvar");
        salvarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarDActionPerformed(evt);
            }
        });
        getContentPane().add(salvarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 207, 90, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome da Disciplina:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 11, -1, -1));

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 88, 300, 101));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/back.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void ConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConcluirActionPerformed
        this.telaAnt.setEnabled(true);
        this.setVisible(false);
        try {
            this.telaAnt.carregarListaCombo();
        } catch (DisciplinaListaVaziaException ex) {
           
        } catch (SQLException ex) {
           
        }

    }//GEN-LAST:event_ConcluirActionPerformed

    private void salvarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarDActionPerformed
        System.out.println("CODIGO USUARIO DISCIPLINA"+usuario.getCodigo());
        Disciplina disciplina = new Disciplina(campoNome.getText(),campoDescricao.getText(),usuario.getCodigo());
        int i= disciplina.getCodigo();
        System.out.println(disciplina);
        //fachada = Fachada.getInstancia();
        try {
            this.fachada.AdicionarDisciplina(disciplina);
            limparCampos();
            JOptionPane.showMessageDialog(null,"Disciplina Cadastrada!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } catch (CodigoInvalidoException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } catch (NomeInvalidoException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
    }//GEN-LAST:event_salvarDActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.telaAnt.setEnabled(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing
    public void limparCampos(){
        this.campoNome.setText(null);
        this.campoDescricao.setText(null);
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
            java.util.logging.Logger.getLogger(TelaNovaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovaDisciplina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Concluir;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salvarD;
    // End of variables declaration//GEN-END:variables
}
