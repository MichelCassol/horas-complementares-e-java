package br.edu.ifpr.projetoIntegrador.visao.cadastro;

import br.edu.ifpr.projetoIntegrador.DAO.UsuarioDAO;
import br.edu.ifpr.projetoIntegrador.modelo.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.plaf.metal.MetalBorders;

public class GUIcadastroUsuario extends javax.swing.JDialog {
    
    private List<Usuario> list = new ArrayList<>();
    private int id = 0;
    private boolean salvar = true;

    public GUIcadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public GUIcadastroUsuario(Usuario usuario){
        initComponents();
        preencherCampos(usuario);
        id = usuario.getIdUsuario();
        salvar = false;
    }
    
    public GUIcadastroUsuario(){
        initComponents();
        salvar = true;
    }
    
    private void preencherCampos(Usuario usuario){
        txNome.setText(usuario.getNome());
        txNomeUser.setText(usuario.getUserName());
    }
    
    private Usuario retornaObjeto(){
        Usuario usuario = new Usuario();
        usuario.setNome(txNome.getText().toUpperCase());
        usuario.setUserName(txNomeUser.getText());
        usuario.setSenha(Arrays.toString(pfSenha.getPassword()).replace(",", "").replace("[", "").replace("]", "").trim());
        usuario.setConfUserName(Arrays.toString(pfConfSenha.getPassword()).replace(",", "").replace("[", "").replace("]", "").trim());
        usuario.setIdUsuario(id);
        return usuario;
    }
    
    private boolean validaCampos(){
        boolean validador = true;
        txNome.setText(txNome.getText().trim());
        txNomeUser.setText(txNomeUser.getText().trim());
        
        if (txNome.getText().equals("")) {
            validador = false;
            txNome.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            txNome.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (txNomeUser.getText().equals("")) {
            validador = false;
            txNomeUser.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            txNomeUser.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (Arrays.toString(pfSenha.getPassword()).trim().replace(",", "").replace("[", "").replace("]", "").equals("")) {
            validador = false;
            pfSenha.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            pfSenha.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if (Arrays.toString(pfConfSenha.getPassword()).trim().replace(",", "").replace("[", "").replace("]", "").equals("")) {
            validador = false;
            pfConfSenha.setBorder(BorderFactory.createLineBorder(Color.red));
            txResultado.setText("Preencha os campos obrigatórios");
        }else{
            pfConfSenha.setBorder(MetalBorders.getTextFieldBorder());
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
        txNomeUser = new javax.swing.JTextField();
        pfSenha = new javax.swing.JPasswordField();
        pfConfSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txResultado = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        tbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de usuários");

        jLabel2.setText("Nome:");

        jLabel3.setText("Nome de usuário:");

        jLabel4.setText("Senha:");

        jLabel5.setText("Confirme sua senha:");

        btSalvar.setText("Salvar");
        btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSalvarMouseReleased(evt);
            }
        });

        tbCancelar.setText("Cancelar");
        tbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbCancelarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txResultado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pfSenha)
                                        .addComponent(txNomeUser)
                                        .addComponent(pfConfSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(tbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(tbCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(txResultado)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCancelarMouseReleased
        this.dispose();
    }//GEN-LAST:event_tbCancelarMouseReleased

    private void btSalvarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvarMouseReleased
        Usuario usuario = retornaObjeto();
        String senha = Arrays.toString(pfSenha.getPassword()).trim().replace(",", "").replace("[", "").replace("]", "");
        String confSenha = Arrays.toString(pfConfSenha.getPassword()).trim().replace(",", "").replace("[", "").replace("]", "");
        try {
            if (validaCampos()) {
                if (salvar) {
                    if (senha.equals(confSenha)) {
                        UsuarioDAO.inserir(retornaObjeto());
                        txNome.setText("");
                        txNomeUser.setText("");
                        pfSenha.setText("");
                        pfConfSenha.setText("");
                        txResultado.setText("Salvo com sucesso");
                    }else{
                        txResultado.setText("As senhas não conferem");
                        pfConfSenha.setText("");
                        pfSenha.setText("");
                    }
                }else{
                    if (senha.equals(confSenha)) {
                        UsuarioDAO.alterar(retornaObjeto());
                        this.dispose();
                    }else{
                        txResultado.setText("As senhas não conferem");
                        pfConfSenha.setText("");
                        pfSenha.setText("");
                    }
                }
            }else{
                pfConfSenha.setText("");
                pfSenha.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco\nTente novamente");
            e.printStackTrace();
        } catch (RuntimeException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar senha");
        }
    }//GEN-LAST:event_btSalvarMouseReleased

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
            java.util.logging.Logger.getLogger(GUIcadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIcadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIcadastroUsuario dialog = new GUIcadastroUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pfConfSenha;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JButton tbCancelar;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txNomeUser;
    private javax.swing.JLabel txResultado;
    // End of variables declaration//GEN-END:variables

}
