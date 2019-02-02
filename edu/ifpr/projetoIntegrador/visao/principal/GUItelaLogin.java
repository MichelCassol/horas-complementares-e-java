package br.edu.ifpr.projetoIntegrador.visao.principal;

import br.edu.ifpr.projetoIntegrador.DAO.UsuarioDAO;
import br.edu.ifpr.projetoIntegrador.modelo.Usuario;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Arrays;

public class GUItelaLogin extends javax.swing.JFrame {

    public GUItelaLogin() {
        initComponents();
    }
    
    private Usuario retornaObjeto(){
        Usuario usuario = new Usuario();
        usuario.setUserName(txUsuario.getText().trim());
        usuario.setSenha(Arrays.toString(pfSenha.getPassword()).replace("[", "").replace("]", "").replace(",", ""));
        return usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        pfSenha = new javax.swing.JPasswordField();
        btEntrar = new javax.swing.JButton();
        txResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Bem vindo");

        jLabel2.setText("Entre com seu usuário e senha");

        jLabel3.setText("Usuário:");

        jLabel4.setText("Senha:");

        btEntrar.setText("Entrar");
        btEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btEntrarMouseReleased(evt);
            }
        });
        btEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btEntrarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txResultado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txUsuario)
                                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btEntrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btEntrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(txResultado)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEntrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEntrarMouseReleased
       try {
            Usuario login = retornaObjeto();
            Usuario result = UsuarioDAO.login(retornaObjeto());
            if (result.getUserName().equals(login.getUserName())&&result.getSenha().equals(login.getSenha())) {
                new GUItelaPrincipal().setVisible(true);
                this.dispose();
            }else{
                txResultado.setText("Usuário incorreto");
            }
        } catch (SQLException ex) {
            txResultado.setText("Senha incorreta");
        }
    }//GEN-LAST:event_btEntrarMouseReleased

    private void btEntrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btEntrarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                Usuario login = retornaObjeto();
                Usuario result = UsuarioDAO.login(retornaObjeto());
                if (result.getUserName().equals(login.getUserName())&&result.getSenha().equals(login.getSenha())) {
                    new GUItelaPrincipal().setVisible(true);
                    this.dispose();
                }else{
                    txResultado.setText("Usuário incorreto");
                }
            } catch (SQLException ex) {
                txResultado.setText("Senha incorreta");
            } 
        }
    }//GEN-LAST:event_btEntrarKeyReleased

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
            java.util.logging.Logger.getLogger(GUItelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUItelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUItelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUItelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUItelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JLabel txResultado;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables

}
