package br.edu.ifpr.projetoIntegrador.visao.cadastro;

import br.edu.ifpr.projetoIntegrador.DAO.AcademicoDAO;
import br.edu.ifpr.projetoIntegrador.DAO.CursoDAO;
import br.edu.ifpr.projetoIntegrador.modelo.Academico;
import br.edu.ifpr.projetoIntegrador.modelo.Curso;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalBorders;

public class GUIcadastroAcademico extends javax.swing.JDialog {
    
    private List<Curso> list = new ArrayList<>();
    private int id = 0;
    private boolean salvar = true;
    private String ra;
    

    public GUIcadastroAcademico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherCombo();
        salvar = true;
        preencheRa();
        txRegistroAcad.setEditable(false);
    }
    
    public GUIcadastroAcademico() {
        initComponents();
        preencherCombo();
        salvar = false;
        preencheRa();
        txRegistroAcad.setEditable(false);
    }
    
    
    public GUIcadastroAcademico(Academico academico){
        initComponents();
        preencherCombo();
        preencherCampos(academico);
        salvar = false;
        id = academico.getIdAcademico();
        txRegistroAcad.setEditable(false);
    }   
    
    private void preencheRa(){
        try {
             ra = AcademicoDAO.geraRa();
             txRegistroAcad.setText(ra);
        } catch (SQLException e) {
        }
    }
    
    private void preencherCampos(Academico academico){
        //Método para converter data normal para padrao americano
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = formato.parse(academico.getDataNascimento());
        } catch (ParseException ex) {
            
        }
        formato.applyPattern("dd-MM-yyyy");
        
        txNome.setText(academico.getNome());
        ftxDataNasc.setText(formato.format(data).replace("-", "/"));
        txRegistroAcad.setText(academico.getRa());
        txRg.setText(academico.getRg());
        ftxDataIngres.setText(academico.getDataIngresso());
        cbCurso.setSelectedItem(academico.getCurso().getNome());
        txEmail.setText(academico.getEmail());
        ftxTelefone.setText(academico.getTelefone());
    }
    
    private Academico retornaObjeto(){
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date data = null;
        try {
            data = formato.parse(ftxDataNasc.getText().replace("/", "-"));
        } catch (ParseException ex) {
            
        }
        formato.applyPattern("yyyy-MM-dd");
        Academico academico = new Academico();
        academico.setNome(txNome.getText().toUpperCase());
        academico.setDataIngresso(ftxDataIngres.getText().replace("/", ""));
        academico.setDataNascimento(formato.format(data));
        academico.setRa(txRegistroAcad.getText());
        academico.setRg(txRg.getText());
        academico.setIdAcademico(id);
        academico.setEmail(txEmail.getText());
        academico.setTelefone(ftxTelefone.getText());
        
        Curso c = list.get(cbCurso.getSelectedIndex()-1);
        
        academico.setCurso(c);
        
        return academico;
    }
    
    private void preencherCombo(){
        try {
            cbCurso.removeAllItems();
            cbCurso.addItem("Selecione");
            list = CursoDAO.listar();
            for (Curso curso : list) {
                cbCurso.addItem(curso.getNome());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco\nTente novamente");
        }
    }
    
    private boolean validaCampos(){
        boolean validador = true;
        txNome.setText(txNome.getText().trim());
        ftxDataNasc.setText(ftxDataNasc.getText().trim());
        txRegistroAcad.setText(txRegistroAcad.getText().trim());
        txRg.setText(txRg.getText().trim());
        ftxDataIngres.setText(ftxDataIngres.getText().trim());
        
        if (txNome.getText().equals("")) {
            validador = false;
            txNome.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            txNome.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (ftxDataIngres.getText().equals("")) {
            validador = false;
            ftxDataIngres.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            ftxDataIngres.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (txRegistroAcad.getText().equals("")) {
            validador = false;
            txRegistroAcad.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            txRegistroAcad.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (txRg.getText().equals("")) {
            validador = false;
            txRg.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            txRg.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (ftxDataNasc.getText().equals("")) {
            validador = false;
            ftxDataNasc.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            ftxDataNasc.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (cbCurso.getSelectedIndex() == 0) {
            validador = false;
            cbCurso.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            cbCurso.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        return validador;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txRegistroAcad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ftxDataIngres = new javax.swing.JFormattedTextField();
        txRg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbCurso = new javax.swing.JComboBox<>();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        txResultado = new javax.swing.JLabel();
        ftxDataNasc = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ftxTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de alunos");

        jLabel2.setText("Nome:");

        jLabel3.setText("RG:");

        jLabel4.setText("Registro acadêmico:");

        txRegistroAcad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txRegistroAcadKeyTyped(evt);
            }
        });

        jLabel5.setText("Data de nascimento:");

        jLabel6.setText("Data de ingresso:");

        try {
            ftxDataIngres.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txRg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txRgKeyTyped(evt);
            }
        });

        jLabel7.setText("Curso:");

        btSalvar.setText("Salvar");
        btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSalvarMouseReleased(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btCancelarMouseReleased(evt);
            }
        });

        try {
            ftxDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("E-mail:");

        jLabel9.setText("Telefone:");

        try {
            ftxTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(ftxTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(ftxDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txRegistroAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ftxDataIngres)
                                        .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txResultado)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ftxTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txRegistroAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ftxDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ftxDataIngres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(txResultado)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseReleased
        this.dispose();
    }//GEN-LAST:event_btCancelarMouseReleased

    private void btSalvarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvarMouseReleased
        if (validaCampos()) {
            try {
                if (salvar) {
                    AcademicoDAO.inserir(retornaObjeto());
                    txResultado.setText("Salvo com sucesso");
                    txNome.setText("");
                    txRegistroAcad.setText("");
                    txRg.setText("");
                    ftxDataIngres.setText("");
                    ftxDataNasc.setText("");
                    ftxTelefone.setText("");
                    txEmail.setText("");
                    cbCurso.setSelectedIndex(0);
                    preencheRa();
                }else{
                    AcademicoDAO.alterar(retornaObjeto());
                    this.dispose();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar no banco\nTente novamente");
            }
        }
    }//GEN-LAST:event_btSalvarMouseReleased

    private void txRgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRgKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txRgKeyTyped

    private void txRegistroAcadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRegistroAcadKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txRegistroAcadKeyTyped

    public static void main(String args[]) {

        //For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIcadastroAcademico dialog = new GUIcadastroAcademico(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JFormattedTextField ftxDataIngres;
    private javax.swing.JFormattedTextField ftxDataNasc;
    private javax.swing.JFormattedTextField ftxTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txRegistroAcad;
    private javax.swing.JLabel txResultado;
    private javax.swing.JTextField txRg;
    // End of variables declaration//GEN-END:variables

}
