package br.edu.ifpr.projetoIntegrador.visao.cadastro;

import br.edu.ifpr.projetoIntegrador.DAO.CursoDAO;
import br.edu.ifpr.projetoIntegrador.modelo.Curso;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalBorders;

public class GUIcadastroCurso extends javax.swing.JFrame {
    
    private boolean salvar = true;
    private int id = 0;
    private List<Curso> list = new ArrayList<Curso>();

    public GUIcadastroCurso() {
        initComponents();
    }
    
    public GUIcadastroCurso(Curso curso){
        initComponents();
        preencherCampos(curso);
        salvar = false;
        id = curso.getIdCurso();
    }
    
    private void preencherCampos(Curso curso){
        txNome.setText(curso.getNome());
        txDuracao.setText(curso.getDuracao());
        txNumRegistro.setText(curso.getNumeroRegistro());
        cbConhecimento.setSelectedItem(curso.getAreaConhecimento());
    }
    
    private Curso retornaObjeto(){
        Curso curso = new Curso();
        curso.setNome(txNome.getText().toUpperCase());
        curso.setDuracao(txDuracao.getText().toUpperCase());
        curso.setNumeroRegistro(txNumRegistro.getText().toUpperCase());
        curso.setAreaConhecimento(cbConhecimento.getSelectedItem().toString());
        curso.setIdCurso(id);
        return curso;
    }
    
    private boolean validaCampos(){
        boolean validador = true;
        txDuracao.setText(txDuracao.getText().trim());
        txNome.setText(txNome.getText().trim());
        txNumRegistro.setText(txNumRegistro.getText().trim());
        if (txDuracao.getText().equals("")) {
            validador = false;
            txDuracao.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            txDuracao.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (txNome.getText().equals("")) {
            txNome.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
            validador = false;
        }else{
            txNome.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (txNumRegistro.getText().equals("")) {
            txNumRegistro.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
            validador = false;
        }else{
            txNumRegistro.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (cbConhecimento.getSelectedIndex() == 0) {
            cbConhecimento.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
            validador = false;
        }else{
            cbConhecimento.setBorder(MetalBorders.getTextFieldBorder());
        }
        return validador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txDuracao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txNumRegistro = new javax.swing.JTextField();
        cbConhecimento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        txResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de cursos");

        jLabel2.setText("Nome :");

        jLabel3.setText("Duração(períodos):");

        txDuracao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDuracaoKeyTyped(evt);
            }
        });

        jLabel4.setText("Número de registro");

        txNumRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNumRegistroKeyTyped(evt);
            }
        });

        cbConhecimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Ciências Exatas e da Terra", "Ciências Biológicas", "Engenharias", "Ciências da Saúde", "Ciências Agrárias", "Ciências Sociais Aplicadas", "Ciências Humanas", "Lingüística, Letras e Artes", "Outros" }));

        jLabel5.setText("Área de conhecimento:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbConhecimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txNumRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txResultado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txNumRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbConhecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addGap(34, 34, 34)
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
        try {
            if (validaCampos()) {
                if (salvar) {
                    CursoDAO.inserir(retornaObjeto());
                    txNome.setText("");
                    txDuracao.setText("");
                    txNumRegistro.setText("");
                    cbConhecimento.setSelectedIndex(0);
                    txResultado.setText("Salvo com sucesso");
                }else{
                    CursoDAO.alterar(retornaObjeto());
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco\nTente novamente");
        }
    }//GEN-LAST:event_btSalvarMouseReleased

    private void txDuracaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDuracaoKeyTyped
        //Método para forçar um textfield receber apenas numeros
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txDuracaoKeyTyped

    private void txNumRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNumRegistroKeyTyped
        //Método para forçar um textfield receber apenas numeros
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txNumRegistroKeyTyped

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIcadastroCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbConhecimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txDuracao;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txNumRegistro;
    private javax.swing.JLabel txResultado;
    // End of variables declaration//GEN-END:variables

}
