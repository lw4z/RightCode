 package br.fafica.pi1.rightcode.telas;

import br.fafica.pi1.rightcode.disciplina.Disciplina;
import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;
import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.DisciplinaListaVaziaException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.exception.UsuarioNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.UsuariolistaVaziaException;
import br.fafica.pi1.rightcode.fachada.Fachada;
import br.fafica.pi1.rightcode.factory.DataSourceType;
import static br.fafica.pi1.rightcode.factory.DataSourceType.ORACLE;
import br.fafica.pi1.rightcode.usuario.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lw4z
 */
public class RightCode extends javax.swing.JFrame {

       
    private Fachada fachada;
    private Usuario usuario;
    private Disciplina disciplina;
    
    
    /**
     * Creates new form RightCode
     */
    public RightCode() {
        try {
            initComponents();
            fachada = Fachada.getInstancia();
            this.setLocationRelativeTo(null);
            if(!listaTabela().equals("")){
                carregarUsuario();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RightCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UsuariolistaVaziaException ex) {
            //Logger.getLogger(RightCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex){
        	
        }
       
            
        };
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        remover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        instalarTabelas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adicionar Usuario");
        setForeground(java.awt.Color.green);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome do Usuário:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 230, -1));

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, -1));

        jButton2.setText("Criar Usuário");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 90, -1));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 88, 346, 170));

        remover.setText("Remover Usuário");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });
        getContentPane().add(remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/back.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 330));

        jMenu1.setText("Menu");

        jMenu2.setText("Configurações");

        instalarTabelas.setText("Instalar Tabelas");
        instalarTabelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instalarTabelasActionPerformed(evt);
            }
        });
        jMenu2.add(instalarTabelas);

        jMenu1.add(jMenu2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.setEnabled(true);
        try {
            if(buscaUsuario()==null){
                JOptionPane.showMessageDialog(null,"Selecione  o Usuario");
                this.setEnabled(true);
            }else{
                Compiler compiler;
                    this.setVisible(false);
                    compiler= new Compiler(this,usuarioSelecionado());
                    compiler.setVisible(true);
                try {
                    compiler.carregarDisciplinas();
                } catch (DisciplinaListaVaziaException ex) {
                   
                }
                /* try {
                compiler.carregarTabelaAluno();
                } catch (AlunolistaVaziaException ex) {
                
                }*/
                    
            }
            this.setEnabled(true);
        } catch (ArrayIndexOutOfBoundsException ex){
        	this.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Nenhum Usuario Selecionando");
            this.setVisible(true);
        } catch (SQLException ex) {
        	ex.printStackTrace();
        	this.setEnabled(true);
			JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UsuariolistaVaziaException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
            this.setEnabled(true);
            //Logger.getLogger(RightCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UsuarioNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
             this.setEnabled(true);
            //Logger.getLogger(RightCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodigoInvalidoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
             this.setEnabled(true);
            //Logger.getLogger(RightCode.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AdicionarUsuario(jTextField1.getText());
        jTextField1.setText("");
        try {
            carregarUsuario();
        } catch (SQLException ex) {
        	ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UsuariolistaVaziaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //Logger.getLogger(RightCode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void instalarTabelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instalarTabelasActionPerformed
        
        try {
            fachada.installDataSource();
        } catch (SQLException ex) {
            ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
            //Logger.getLogger(RightCode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_instalarTabelasActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        try {
            carregarUsuario();
        } catch (SQLException ex) {
        	ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UsuariolistaVaziaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        try {

            int linha = tabelaUsuario.getSelectedRow();

            Usuario u = fachada.ListaUsuario().get(linha);
            fachada.RemoverUsuario(u);
            carregarUsuario();

        } catch (UsuariolistaVaziaException ex) {
        	JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UsuarioNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //Logger.getLogger(ConfigurarFiltro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodigoInvalidoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //Logger.getLogger(ConfigurarFiltro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        	ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Selecione um usuário para remover!");
        }

    }//GEN-LAST:event_removerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
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
               
                    new RightCode().setVisible(true);
               
            }
        });
    }
    public Usuario usuarioSelecionado() throws SQLException, UsuarioNaoEncontradoException, CodigoInvalidoException, UsuariolistaVaziaException{
         int linha = tabelaUsuario.getSelectedRow();

            Usuario u = fachada.ListaUsuario().get(linha);
            fachada.BuscarUsuario(u.getCodigo());
            return u;
    }
    
     public Usuario buscaUsuario() throws SQLException, UsuariolistaVaziaException{
         
        Usuario buscaUsuario = null;
        for(Usuario usuario: fachada.ListaUsuario()){
            buscaUsuario = usuario;
        }
        return buscaUsuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem instalarTabelas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabelaUsuario;
    // End of variables declaration//GEN-END:variables

    /*private void Listar(){
        try {
            Fachada fachada = Fachada.getInstancia();  
            ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
              listaUsuarios = fachada.ListaUsuario();
              String resultado = "";
              for(Usuario usuario: listaUsuarios){
                    resultado +=usuario;
              }
              jTextPane1.setText(resultado);
                    
         } catch (SQLException ex) {
        	 JOptionPane.showMessageDialog(null,ex.getMessage());
         } catch (UsuariolistaVaziaException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }
}*/
    public void AdicionarUsuario(String nomeUsuario){
         try {
            this.usuario = new Usuario(nomeUsuario);
          
            fachada.AdicionarUsuario(this.usuario);
           
        
        } catch (CodigoInvalidoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NomeInvalidoException ex) {
        	JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
    }
    
    public void carregarUsuario() throws SQLException, UsuariolistaVaziaException {
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        listaUsuario = fachada.ListaUsuario();

        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        

        if (listaUsuario.size() == 0) {
            modelo.addRow(new String[]{"Sem dados",
                        null,
                        null,});
        }
        
        for (int i = 0; i < listaUsuario.size(); i++) {
            Usuario u = listaUsuario.get(i);
            //System.out.println(f.toString());


            // Alimenta as linhas de dados  
            modelo.addRow(new String[]{u.getCodigo()+"",u.getNome(),});
        }

        tabelaUsuario.setModel(modelo);

    } 
    public ArrayList listaTabela() throws SQLException, UsuariolistaVaziaException{
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        listaUsuario = fachada.ListaUsuario();
        
        return listaUsuario; 
    }
    
   
    
    
}

