package br.edu.ifpr.projetoIntegrador.visao.cadastro;

import br.edu.ifpr.projetoIntegrador.DAO.AcademicoDAO;
import br.edu.ifpr.projetoIntegrador.DAO.AtividadeDAO;
import br.edu.ifpr.projetoIntegrador.modelo.Academico;
import br.edu.ifpr.projetoIntegrador.modelo.Atividade;
import java.awt.Color;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalBorders;

public class GUIcadastroAtividade extends javax.swing.JDialog {
    
    private List<Academico> list = new ArrayList<>();
    private boolean salvar = true;
    private int id = 0;

    public GUIcadastroAtividade(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherCombo();
    }
    
    public GUIcadastroAtividade() {
        initComponents();
        preencherCombo();
    }
    
    public GUIcadastroAtividade(Academico academico) {
        initComponents();
        preencherCombo();
        cbAcademico.setSelectedItem(academico.getNome());
        cbAcademico.setEnabled(false);
    }
    
    public GUIcadastroAtividade(Atividade atividade){
    initComponents();
    preencherCombo();
    preencherCampos(atividade);
    salvar = false;
    id = atividade.getIdAtividade();
    cbAcademico.setEnabled(false);
}
    
    private void preencherCombo(){
        try {
            cbAcademico.removeAllItems();
            cbAcademico.addItem("Selecione");
            list = AcademicoDAO.listar();
            for (Academico academico : list) {
                cbAcademico.addItem(academico.getNome());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco\nTente novamente");
        }
    }
    
    private Atividade retornaObjeto(){
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date data = null;
        try {
            data = formato.parse(ftxDataInicio.getText().replace("/", "-"));
        } catch (ParseException ex) {
            
        }
        formato.applyPattern("yyyy-MM-dd");
        Atividade atividade = new Atividade();
        atividade.setCargaHora(ftxCargaHor.getText()+":00");
        atividade.setDataInicio(formato.format(data));
        atividade.setDescricao(txDescricao.getText().toUpperCase());
        atividade.setIdAtividade(id);
        atividade.setNumRegistro(txNumRegistro.getText().toUpperCase());
        
        Academico a = list.get(cbAcademico.getSelectedIndex()-1);
        
        atividade.setAcademico(a);
        
        return atividade;
    }
    
    private void preencherCampos(Atividade atividade){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = formato.parse(atividade.getDataInicio());
        } catch (ParseException ex) {
            
        }
        formato.applyPattern("dd-MM-yyyy");
        
        ftxCargaHor.setText(atividade.getCargaHora());
        txDescricao.setText(atividade.getDescricao());
        txNumRegistro.setText(atividade.getNumRegistro());
        ftxDataInicio.setText(formato.format(data).replace("-", "/"));
        cbAcademico.setSelectedItem(atividade.getAcademico().getNome());
    }
    
    private boolean validaCampos(){
        boolean validador = true;
        ftxCargaHor.setText(ftxCargaHor.getText().trim());
        txDescricao.setText(txDescricao.getText().trim());
        txNumRegistro.setText(txNumRegistro.getText().trim());
        ftxDataInicio.setText(ftxDataInicio.getText().trim());
        
        if (ftxCargaHor.getText().equals("")) {
            validador = false;
            ftxCargaHor.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            ftxCargaHor.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (txDescricao.getText().equals("")) {
            validador = false;
            txDescricao.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            txDescricao.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (txNumRegistro.getText().equals("")) {
            validador = false;
            txNumRegistro.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            txNumRegistro.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (ftxDataInicio.getText().equals("")) {
            validador = false;
            ftxDataInicio.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            ftxDataInicio.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (cbAcademico.getSelectedIndex() == 0) {
            cbAcademico.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
            validador = false;
        }else{
            cbAcademico.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        return validador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txNumRegistro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ftxDataInicio = new javax.swing.JFormattedTextField();
        cbAcademico = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        txResultado = new javax.swing.JLabel();
        ftxCargaHor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de atividades");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Carga horária:");

        jLabel4.setText("Número de registro:");

        txNumRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNumRegistroKeyTyped(evt);
            }
        });

        jLabel5.setText("Data de realizaçõa:");

        try {
            ftxDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Acadêmico:");

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
            ftxCargaHor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
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
                        .addGap(111, 111, 111)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(ftxCargaHor, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txNumRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txResultado)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ftxCargaHor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txNumRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ftxDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
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
                    AtividadeDAO.inserir(retornaObjeto());
                    ftxCargaHor.setText("");
                    txNumRegistro.setText("");
                    txDescricao.setText("");
                    ftxDataInicio.setText("");
                    cbAcademico.setSelectedIndex(0);
                    txResultado.setText("Salvo com sucesso");
                }else{
                    AtividadeDAO.alterar(retornaObjeto());
                    this.dispose();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar no banco\nTente novamente");
            }
        }
    }//GEN-LAST:event_btSalvarMouseReleased

    private void txNumRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNumRegistroKeyTyped
        //Método para fazer um textfield receber apenas numeros
	String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txNumRegistroKeyTyped

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
            java.util.logging.Logger.getLogger(GUIcadastroAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIcadastroAtividade dialog = new GUIcadastroAtividade(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbAcademico;
    private javax.swing.JFormattedTextField ftxCargaHor;
    private javax.swing.JFormattedTextField ftxDataInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txDescricao;
    private javax.swing.JTextField txNumRegistro;
    private javax.swing.JLabel txResultado;
    // End of variables declaration//GEN-END:variables

}
