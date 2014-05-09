package br.fafica.pi1.rightcode.telas;

//import br.fafica.pi1.rightcode.aluno.Aluno;
import br.fafica.pi1.rightcode.compilador.Compilador;
import br.fafica.pi1.rightcode.compilador.Resultado;
import br.fafica.pi1.rightcode.disciplina.Disciplina;
//import br.fafica.pi1.rightcode.exception.AlunoNaoEncontradoException;
//import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;
import br.fafica.pi1.rightcode.exception.CaminhoNaoEncontraException;
import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.DisciplinaListaVaziaException;
import br.fafica.pi1.rightcode.exception.DisciplinaNaoEncontradaException;
import br.fafica.pi1.rightcode.exception.FiltroNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.FiltrolistaVaziaException;
import br.fafica.pi1.rightcode.exception.JavaException;
import br.fafica.pi1.rightcode.exception.NaoCompiladoException;
import br.fafica.pi1.rightcode.exception.NenhumArquivoCompiladoException;
import br.fafica.pi1.rightcode.exception.UsuarioNaoEncontradoException;
import br.fafica.pi1.rightcode.fachada.Fachada;
import br.fafica.pi1.rightcode.filtro.Filtro;
import br.fafica.pi1.rightcode.usuario.Usuario;
import br.fafica.pi1.rightcode.util.UtilArquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
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
public class Compiler extends javax.swing.JFrame {

    private Charset utf8 = StandardCharsets.UTF_8;
    private RightCode telaAnt;
    private int codigoUsuario;
    private Fachada fachada;
    private Usuario usuario;
    private Disciplina disciplina;
    private ArrayList <Filtro> arrayFiltro;
    /**
     * Creas new form Compilador
     */
    public Compiler() {
        initComponents();
        this.setLocationRelativeTo(null);
       this.disciplina=disciplina;
        fachada = Fachada.getInstancia();
        arrayFiltro = new ArrayList<>();
       
       
    }
    public Compiler(RightCode telaAnt,Usuario usuario){
        this();
        this.telaAnt= telaAnt;
        this.usuario=usuario;
        fachada = Fachada.getInstancia();
        arrayFiltro = new ArrayList<>();
    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        acessoFiltros = new javax.swing.JButton();
        adcionarDisciplina = new javax.swing.JButton();
        compilaArquivos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        ComboD = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        exportar = new javax.swing.JLabel();
        adcionarDis = new javax.swing.JLabel();
        logorightode = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoResultado = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        canvas1 = new java.awt.Canvas();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar3.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar4.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar4.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RightCode - Compilador");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Resultado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, 20));

        acessoFiltros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/filtros03.png"))); // NOI18N
        acessoFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acessoFiltrosActionPerformed(evt);
            }
        });
        getContentPane().add(acessoFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 80, 70));

        adcionarDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/Sign_Add_Icon_32.png"))); // NOI18N
        adcionarDisciplina.setBorder(null);
        adcionarDisciplina.setBorderPainted(false);
        adcionarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adcionarDisciplinaActionPerformed(evt);
            }
        });
        getContentPane().add(adcionarDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 30, 30));

        compilaArquivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/Fileexplorer-green-64.png"))); // NOI18N
        compilaArquivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilaArquivosActionPerformed(evt);
            }
        });
        getContentPane().add(compilaArquivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 600, 80, 70));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/abrir2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, 80, 70));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, 30));

        ComboD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboDActionPerformed(evt);
            }
        });
        getContentPane().add(ComboD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Disciplinas:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Verificar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 580, -1, -1));

        exportar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exportar.setForeground(new java.awt.Color(255, 255, 255));
        exportar.setText("Exportar");
        getContentPane().add(exportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 580, -1, -1));

        adcionarDis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adcionarDis.setForeground(new java.awt.Color(255, 255, 255));
        adcionarDis.setText("Adicionar");
        getContentPane().add(adcionarDis, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 70, -1));

        logorightode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/rcodelogo.png"))); // NOI18N
        getContentPane().add(logorightode, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, 90));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Filtros");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 50, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Remover");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/remover.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 30, 30));

        jInternalFrame1.setBackground(new java.awt.Color(0, 0, 153));
        jInternalFrame1.setBorder(null);
        jInternalFrame1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jInternalFrame1.setEnabled(false);
        jInternalFrame1.setFocusable(false);
        jInternalFrame1.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/compilar.png"))); // NOI18N
        jInternalFrame1.setVerifyInputWhenFocusTarget(false);
        jInternalFrame1.setVisible(true);

        CampoResultado.setEditable(false);
        CampoResultado.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(CampoResultado);

        jInternalFrame1.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1040, 480));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/fafica/pi1/rightcode/telas/icones/back.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));
        getContentPane().add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 640, -1, -1));

        jMenuBar5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu7.setText("Menu");

        jMenuItem1.setText("Trocar Usuário");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuBar5.add(jMenu7);

        jMenu8.setText("Ajuda");

        jMenuItem3.setText("Manual");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jMenuItem2.setText("Sobre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem2);

        jMenuBar5.add(jMenu8);

        setJMenuBar(jMenuBar5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acessoFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acessoFiltrosActionPerformed
        try {
            this.setEnabled(false);
            ConfigurarFiltro configureF;
            configureF = new ConfigurarFiltro(this,usuario);
           
            configureF.setVisible(true);
            configureF.carregarJTable();
        } catch (SQLException ex) {
           
        } catch (FiltrolistaVaziaException ex) {
            
        }
       
    }//GEN-LAST:event_acessoFiltrosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         this.telaAnt.setEnabled(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
         new RightCode().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            File arquivo;
            JFileChooser arq= new JFileChooser();
            int Result=arq.showSaveDialog(this);
            if(Result==JFileChooser.APPROVE_OPTION)
            {
                arquivo = arq.getSelectedFile(); //Classe para Arquivos
                try (FileWriter inArq = new FileWriter(arquivo.getPath())) {
                    inArq.write(CampoResultado.getText());
                }
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(this,"Erro ao abrir o arquivo");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void compilaArquivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compilaArquivosActionPerformed

        try {

            Compilador compilador = new Compilador(arrayFiltro, DisciplinaSelecionada());
            UtilArquivo dell = new UtilArquivo();
            dell.deletarCriarArquvo();
            compilador.Compilar(Caminho());
            CampoResultado.setText(ArquivoResultado());

        }/* catch (AlunolistaVaziaException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, ex.getMessage());
        } */catch (CaminhoNaoEncontraException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (JavaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } /*catch (AlunoNaoEncontradoException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (CodigoInvalidoException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        }*/catch (ArrayIndexOutOfBoundsException ex){
            this.setEnabled(true);
            JOptionPane.showMessageDialog(null,"Nenhum Aluno foi selecionada!");

        } catch (DisciplinaListaVaziaException ex) {
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DisciplinaNaoEncontradaException ex) {
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodigoInvalidoException ex) {
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_compilaArquivosActionPerformed

    private void ComboDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboDActionPerformed
       
    }//GEN-LAST:event_ComboDActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setEnabled(false);
        new Sobre(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       
        Ajuda();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void adcionarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcionarDisciplinaActionPerformed
        this.setEnabled(false);
        new TelaNovaDisciplina(this,this.usuario).setVisible(true);
    }//GEN-LAST:event_adcionarDisciplinaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if(fachada.ListaDisciplina().isEmpty()){
            }
            else{

                this.setEnabled(false);
                new RemoDisciplina(this,this.usuario).setVisible(true);
            }
        } catch (DisciplinaListaVaziaException ex) {
            JOptionPane.showMessageDialog(null,"Não há Disicplinas Cadastradas!");
        } catch (SQLException ex) {
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
                new Compiler().setVisible(true);
                
            }
        });
    }

    public String Caminho(){
        JFileChooser fc = new JFileChooser();
        
		String caminho = "";
        // restringe a amostra a diretorios apenas
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int res = fc.showOpenDialog(null);
        
        if(res == JFileChooser.APPROVE_OPTION){
            File diretorio = fc.getSelectedFile();
            caminho = diretorio.getAbsolutePath();
        }
        else{
        	//throw new CaminhoNaoEncontraException();
         JOptionPane.showMessageDialog(null, "Você nao selecionou nenhum local!"); 
    	}
        System.out.println(caminho);
        return caminho;
    }
    
    public String ArquivoResultado() throws IOException{
		Path path = Paths.get("Resultados/ArquivoResultado.txt");
		BufferedReader reader = Files.newBufferedReader(path, utf8);
			String resultado = "";
			String line = null;
			while((line = reader.readLine()) != null ){
				resultado += "\n" +line;
			}
			return resultado;
	}
    
    public void setCodigoUsuario(Usuario usuario) {  
        this.usuario = usuario;
    }  
    
    public Usuario getCodigoUsuario(){
        return this.usuario;
        
    }
    //metodo carregar lista drop down
     public void carregarListaCombo() throws DisciplinaListaVaziaException, SQLException{
        ArrayList<Disciplina> listaDisciplina;
        listaDisciplina = fachada.ListaDisciplina();

        ComboD.removeAllItems();
        
        for (int i = 0; i < listaDisciplina.size(); i++) {
            Disciplina d = listaDisciplina.get(i);
         ComboD.addItem(d.getNome( ));
            
         
        }

       
    }
    //metodo carregar tebela disciplinas
     
  /*public void carregarDisciplinas() throws DisciplinaListaVaziaException, SQLException{
        //Fachada fachada = Fachada.getInstancia();
        ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
        listaDisciplina = fachada.ListaDisciplina();

        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Cod.Usuario");

        if (listaDisciplina.size() == 0) {
            modelo.addRow(new String[]{"Sem dados",
                        null,
                        null,
                        null});
        }
        
        for (int i = 0; i < listaDisciplina.size(); i++) {
            Disciplina d = listaDisciplina.get(i);
           
            
            modelo.addRow(new String[]{d.getCodigo()+"",d.getNome(),d.getCodigo_usuario()+""});
        }

        tabelaDisciplina.setModel(modelo);

    

    }
     */
   
    /* public void carregarTabelaAluno() throws AlunolistaVaziaException, SQLException{
    // Fachada fachada = Fachada.getInstancia();
    ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
    listaAluno = fachada.ListaAluno();
    
    DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
    modelo.addColumn("Codigo");
    modelo.addColumn("Nome");
    modelo.addColumn("Turma");
    modelo.addColumn("Cod.Disciplina");
    
    if (listaAluno.size() == 0) {
    modelo.addRow(new String[]{"Sem dados",
    null,
    null
    ,null
    ,null});
    }
    
    for (int i = 0; i < listaAluno.size(); i++) {
    Aluno a = listaAluno.get(i);
    
    modelo.addRow(new String[]{a.getCodigo()+"",a.getNome(),a.getTurma(),""+a.getCodigo_disciplina()});
    }
    
    tabelaAluno.setModel(modelo);
    }*/
    
        
    public Disciplina BuscaDisciplina() throws DisciplinaListaVaziaException, SQLException{
       
        ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
        listaDisciplina = fachada.ListaDisciplina();
         
        Disciplina disciplinaBusca = null;
        for(Disciplina disciplina: listaDisciplina){
            disciplinaBusca = disciplina;
        }
        return disciplinaBusca;
    }
    
    public Disciplina DisciplinaSelecionada() throws DisciplinaListaVaziaException, DisciplinaListaVaziaException, DisciplinaListaVaziaException, DisciplinaListaVaziaException, DisciplinaListaVaziaException, SQLException, DisciplinaNaoEncontradaException, CodigoInvalidoException{
        int item = ComboD.getSelectedIndex();
         //int linha = tabelaDisciplina.getSelectedIndex();
         Disciplina d = fachada.ListaDisciplina().get(item);
       //Disciplina d = fachada.ListaDisciplina().get(linha);
            fachada.BuscarDisciplina(d.getCodigo());
            return d;
    }
    
    /*public Aluno AlunoSelecionado() throws AlunolistaVaziaException, AlunolistaVaziaException, AlunolistaVaziaException, AlunolistaVaziaException, SQLException, AlunoNaoEncontradoException, CodigoInvalidoException{
    int linha =tabelaAluno.getSelectedRow();
    Aluno al=fachada.ListaAluno().get(linha);
    fachada.BuscarAluno(al.getCodigo());
    return al;
    }*/
    public void Ajuda(){
        String caminho="C:\\Users\\EDWARD\\Desktop\\Resultado.txt";
        File file = new File(caminho);
    }
    public void filtrosSelecionados(ArrayList filtros){
      this.arrayFiltro=filtros; 
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane CampoResultado;
    private javax.swing.JComboBox ComboD;
    private javax.swing.JButton acessoFiltros;
    private javax.swing.JLabel adcionarDis;
    private javax.swing.JButton adcionarDisciplina;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton compilaArquivos;
    private javax.swing.JLabel exportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logorightode;
    // End of variables declaration//GEN-END:variables
}
