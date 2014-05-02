package br.fafica.pi1.rightcode.telas;




import br.fafica.pi1.rightcode.aluno.Aluno;
import br.fafica.pi1.rightcode.compilador.Compilador;
import br.fafica.pi1.rightcode.compilador.Resultado;
import br.fafica.pi1.rightcode.disciplina.Disciplina;
import br.fafica.pi1.rightcode.exception.AlunoNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;
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
    private Aluno aluno;
    private ArrayList <Filtro> arrayFiltro;
    /**
     * Creas new form Compilador
     */
    public Compiler() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.aluno=aluno;
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoResultado = new javax.swing.JTextPane();
        compilaArquivos = new javax.swing.JButton();
        sairBotao = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        acessoFiltros = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaDisciplina = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAluno = new javax.swing.JTable();
        adcionarDisciplina = new javax.swing.JButton();
        adicionarAluno = new javax.swing.JButton();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compilador");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        CampoResultado.setEditable(false);
        jScrollPane1.setViewportView(CampoResultado);

        compilaArquivos.setText("Compilar Arquivos");
        compilaArquivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilaArquivosActionPerformed(evt);
            }
        });

        sairBotao.setText("Sair");
        sairBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairBotaoActionPerformed(evt);
            }
        });

        jButton1.setText("Exportar Resultado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(compilaArquivos)
                        .addGap(179, 179, 179)
                        .addComponent(jButton1))
                    .addComponent(sairBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {compilaArquivos, sairBotao});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compilaArquivos)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(sairBotao)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel1.setText("Resultado");

        jLabel2.setText("Selecione a Disciplina");

        acessoFiltros.setText("Filtros");
        acessoFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acessoFiltrosActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecione o Aluno ");

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        tabelaDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome ", "Cod.Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaDisciplina);

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        tabelaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Aluno", "Cod.Disciplina"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaAluno);

        adcionarDisciplina.setText("Adicionar Disciplina");
        adcionarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adcionarDisciplinaActionPerformed(evt);
            }
        });

        adicionarAluno.setText("Adicionar Aluno");
        adicionarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarAlunoActionPerformed(evt);
            }
        });

        jMenu7.setText("Menu");

        jMenuItem1.setText("Trocar Usuário");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuBar5.add(jMenu7);

        setJMenuBar(jMenuBar5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(adcionarDisciplina))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(adicionarAluno)
                                .addGap(62, 62, 62)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(137, 137, 137)
                        .addComponent(acessoFiltros)
                        .addGap(35, 35, 35))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {adcionarDisciplina, adicionarAluno});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(acessoFiltros)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adicionarAluno)
                            .addComponent(adcionarDisciplina))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairBotaoActionPerformed
        //telaAnt.setEnabled(true);
        //this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_sairBotaoActionPerformed

    private void compilaArquivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compilaArquivosActionPerformed
    
        try {
          
            Compilador compilador = new Compilador(arrayFiltro,AlunoSelecionado());
            UtilArquivo dell = new UtilArquivo();
            dell.deletarCriarArquvo();
            compilador.Compilar(Caminho());
            CampoResultado.setText(ArquivoResultado());
        
        } catch (AlunolistaVaziaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (SQLException ex) {
        	ex.printStackTrace();
        	JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (CaminhoNaoEncontraException ex) {
        	JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (JavaException ex) {
        	JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (IOException ex) {
        	JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (AlunoNaoEncontradoException ex) {
        	JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (CodigoInvalidoException ex) {
        	JOptionPane.showMessageDialog(this, ex.getMessage());
        }catch (ArrayIndexOutOfBoundsException ex){
                    this.setEnabled(true);
                    JOptionPane.showMessageDialog(null,"Nenhum Aluno foi selecionada!");
                    
                }

    }//GEN-LAST:event_compilaArquivosActionPerformed

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

    private void adcionarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcionarDisciplinaActionPerformed
         this.setEnabled(false);
         new TelaNovaDisciplina(this,this.usuario).setVisible(true);
    }//GEN-LAST:event_adcionarDisciplinaActionPerformed

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        try {
            carregarDisciplinas();
        } catch (DisciplinaListaVaziaException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        } catch (SQLException ex) {
        	ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        try {
            carregarTabelaAluno();
        } catch (AlunolistaVaziaException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        } catch (SQLException ex) {
        	ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void adicionarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarAlunoActionPerformed
       this.setEnabled(false);
       System.out.println("DISCIPLINA TABELA: " + tabelaDisciplina.getSelectedRow());
        try {
            if(BuscaDisciplina() == null){
                JOptionPane.showMessageDialog(null,"Não existem disciplinas!");
                this.setEnabled(true);
                
                
            }else{
                try {
                    new TelaNovoAluno(this,DisciplinaSelecionada()).setVisible(true);
                } catch (DisciplinaListaVaziaException ex) {
                    Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                	ex.printStackTrace();
        			JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (DisciplinaNaoEncontradaException ex) {
                    Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CodigoInvalidoException ex) {
                    Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ArrayIndexOutOfBoundsException ex){
                    this.setEnabled(true);
                    JOptionPane.showMessageDialog(null,"Nenhuma disciplina foi selecionada!");
                    
                }
            }} catch (DisciplinaListaVaziaException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } catch (SQLException ex) {
        	ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
             this.setEnabled(true);
        }
    }//GEN-LAST:event_adicionarAlunoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         this.telaAnt.setEnabled(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
         new RightCode().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    //metodo carregar tebela disciplinas
    public void carregarDisciplinas() throws DisciplinaListaVaziaException, SQLException{
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
    public void carregarTabelaAluno() throws AlunolistaVaziaException, SQLException{
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
    }
    
        
    public Disciplina BuscaDisciplina() throws DisciplinaListaVaziaException, SQLException{
       // Fachada fachada = Fachada.getInstancia();
        ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
        listaDisciplina = fachada.ListaDisciplina();
         
        Disciplina disciplinaBusca = null;
        for(Disciplina disciplina: listaDisciplina){
            disciplinaBusca = disciplina;
        }
        return disciplinaBusca;
    }
    
    public Disciplina DisciplinaSelecionada() throws DisciplinaListaVaziaException, DisciplinaListaVaziaException, DisciplinaListaVaziaException, DisciplinaListaVaziaException, DisciplinaListaVaziaException, SQLException, DisciplinaNaoEncontradaException, CodigoInvalidoException{
        int linha = tabelaDisciplina.getSelectedRow();

            Disciplina d = fachada.ListaDisciplina().get(linha);
            fachada.BuscarDisciplina(d.getCodigo());
            return d;
    }
    public Aluno AlunoSelecionado() throws AlunolistaVaziaException, AlunolistaVaziaException, AlunolistaVaziaException, AlunolistaVaziaException, SQLException, AlunoNaoEncontradoException, CodigoInvalidoException{
        int linha =tabelaAluno.getSelectedRow();
        Aluno al=fachada.ListaAluno().get(linha);
        fachada.BuscarAluno(al.getCodigo());
        return al;
    }
    public void Ajuda(){
        String caminho="";
        File file = new File(caminho);
    }
    public void filtrosSelecionados(ArrayList filtros){
      this.arrayFiltro=filtros; 
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane CampoResultado;
    private javax.swing.JButton acessoFiltros;
    private javax.swing.JButton adcionarDisciplina;
    private javax.swing.JButton adicionarAluno;
    private javax.swing.JButton compilaArquivos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton sairBotao;
    private javax.swing.JTable tabelaAluno;
    private javax.swing.JTable tabelaDisciplina;
    // End of variables declaration//GEN-END:variables
}
