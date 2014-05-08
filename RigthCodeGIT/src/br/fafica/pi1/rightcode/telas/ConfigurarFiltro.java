/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fafica.pi1.rightcode.telas;

import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.FiltroNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.exception.FiltrolistaVaziaException;
import br.fafica.pi1.rightcode.exception.UsuarioNaoEncontradoException;
import br.fafica.pi1.rightcode.filtro.Filtro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.fafica.pi1.rightcode.fachada.Fachada;
import br.fafica.pi1.rightcode.usuario.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 
 * @author EDWARd
 */
public class ConfigurarFiltro extends javax.swing.JFrame {
    private Fachada fachada;
    private Usuario usuario;
    private Compiler telaAnt;
    private ArrayList <Filtro> arrayFiltro;
    /**
     * ates new form ConfigurarTelas000
    */
  public ConfigurarFiltro() {
        initComponents();
        this.setLocationRelativeTo(null);
        fachada = Fachada.getInstancia();
        arrayFiltro = new ArrayList<>();
    }
  public ConfigurarFiltro(Compiler telaAnt,Usuario usuario){
      this();
      this.usuario = usuario;
      this.telaAnt=telaAnt;
      fachada = Fachada.getInstancia();
  }
     private static final long serialVersionUID = 1L;
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFiltro = new javax.swing.JTable();
        NovoF = new javax.swing.JButton();
        Concluir = new javax.swing.JButton();
        remover = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurar Filtros");
        setBackground(new java.awt.Color(51, 0, 255));
        setForeground(new java.awt.Color(255, 204, 204));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecionar Filtros");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 36, -1, -1));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });
        jScrollPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseDragged(evt);
            }
        });

        tabelaFiltro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Cod.Usuario", "Selecione"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFiltro.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tabelaFiltro);
        tabelaFiltro.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 61, 392, 287));

        NovoF.setText("Novo");
        NovoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoFActionPerformed(evt);
            }
        });
        getContentPane().add(NovoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 366, 110, -1));

        Concluir.setText("Concluir");
        Concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(Concluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 366, 110, -1));

        remover.setText("Remover");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });
        getContentPane().add(remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 366, 110, -1));

        jButton1.setText("Utilizar Filtros");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 32, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/back.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConcluirActionPerformed
        this.telaAnt.setEnabled(true);
        this.setVisible(false);
       
        
        
    }//GEN-LAST:event_ConcluirActionPerformed

    private void NovoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoFActionPerformed
        System.out.println("Teste CofigureFiltro codigo "+usuario.getCodigo());
        this.setEnabled(false);
        new TelaNovoFiltro(this,usuario).setVisible(true);
        
    }//GEN-LAST:event_NovoFActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        try {
           
//           int linha = tabelaFiltro.getSelectedRow();
//           Filtro f = Fachada.getInstancia().ListaFiltro().get(linha);
//           fachada.RemoverFiltro(f);
//           carregarJTable();
            ArrayList <Filtro>removidos= new ArrayList();
            for (int id = 0; id < tabelaFiltro.getRowCount(); id++) { 
              
              if ((Boolean)tabelaFiltro.getValueAt(id,3) == true){
                  Filtro u = fachada.ListaFiltro().get(id);
                  
                  fachada.RemoverFiltro(u);
                 carregarJTable();
                  }
               }
                 carregarJTable();
        } catch (FiltrolistaVaziaException e) {
           
        } catch (SQLException ex) {
        	ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
		} catch (FiltroNaoEncontradoException ex) {
            Logger.getLogger(ConfigurarFiltro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodigoInvalidoException ex) {
            Logger.getLogger(ConfigurarFiltro.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_removerActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.telaAnt.setEnabled(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        try {
            carregarJTable();
        } catch (SQLException ex) {
            Logger.getLogger(ConfigurarFiltro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FiltrolistaVaziaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            arrayFiltro=filtroSelecionados();
            telaAnt.filtrosSelecionados(arrayFiltro);
            
        } catch (SQLException ex) {
        	this.setVisible(true);
        	ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (FiltrolistaVaziaException ex) {
        	this.setVisible(true);
        	JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
        	this.setVisible(true);
        	JOptionPane.showMessageDialog(null, "Selecione um filtro");
        }catch (UsuarioNaoEncontradoException ex) {
        	this.setVisible(true);
        	JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (CodigoInvalidoException ex) {
        	this.setVisible(true);
        	JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (FiltroNaoEncontradoException ex) {
        	this.setVisible(true);
        	JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jScrollPane1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseDragged
        
    }//GEN-LAST:event_jScrollPane1MouseDragged
    
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
            public void run() {
                new ConfigurarFiltro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Concluir;
    private javax.swing.JButton NovoF;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabelaFiltro;
    // End of variables declaration//GEN-END:variables

    
    //metodo teste
    void carregarJTable() throws SQLException, FiltrolistaVaziaException {
       // Fachada fachada = Fachada.getInstancia();
        ArrayList<Filtro> listaFiltro = new ArrayList<Filtro>();
        listaFiltro = fachada.ListaFiltro();
        
        DefaultTableModel modelo = new DefaultTableModel(){
             @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                   
                    default:
                        return Boolean.class;
                }
            }
            
        };
            
        
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Cod.Usuario");
        modelo.addColumn("Selecione");
        
       if(listaFiltro==null){
           modelo.addRow(new Object [] {null,null,null,null});
       }
        
        for (int i = 0; i < listaFiltro.size(); i++) {
            Filtro f = listaFiltro.get(i);
            //System.out.println(f.toString());
            // Alimenta as linhas de dados  
            modelo.addRow(new Object [] {f.getCodigo(),f.getNome(),f.getCodigo_usuario(), false});
        }
       
          tabelaFiltro.setModel(modelo); 
                 
      
        
         
        

    } 
    
     public Filtro buscaFiltro() throws SQLException, FiltrolistaVaziaException{
        //Fachada fachada = Fachada.getInstancia();
        ArrayList<Filtro> listaFiltro;
        listaFiltro = fachada.ListaFiltro();
         
        Filtro buscaFiltro = null;
        for(Filtro Filtro: listaFiltro){
            buscaFiltro = Filtro;
        }
        return buscaFiltro;
    }
     
     
     public ArrayList filtroSelecionados() throws SQLException, FiltrolistaVaziaException, UsuarioNaoEncontradoException, CodigoInvalidoException, FiltroNaoEncontradoException{        
//        int []linha = tabelaFiltro.getSelectedRows();
//       Filtro u =null;
//         for(int i=0;i<linha.length;i++){
//            u = Fachada.getInstancia().ListaFiltro().get(linha[i]);
//            arrayFiltro.add(u);
//          }
//         //somente para exibir no console
//           for(int i=0;i<arrayFiltro.size();i++){
//   		 Filtro f=arrayFiltro.get(i);
//   		 System.out.println("\n"+f.getNome());
//          }
//          JOptionPane.showMessageDialog(null,"Filtros Ativados!"); 
          for (int id = 0; id < tabelaFiltro.getRowCount(); id++) { 
              
              if ((Boolean)tabelaFiltro.getValueAt(id,3) == true){
                  Filtro u = fachada.ListaFiltro().get(id);
                  arrayFiltro.add(u);
                  System.out.println("\n"+u.getNome());
                   }
               }
             if(!arrayFiltro.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Filtros Ativados!");
             } else {
                 JOptionPane.showMessageDialog(null,"Filtros Não Selecionados!");
             }
           
            return arrayFiltro;
        }
    }


