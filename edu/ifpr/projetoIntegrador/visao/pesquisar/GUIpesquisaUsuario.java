package br.edu.ifpr.projetoIntegrador.visao.pesquisar;

import br.edu.ifpr.projetoIntegrador.DAO.UsuarioDAO;
import br.edu.ifpr.projetoIntegrador.modelo.Usuario;
import br.edu.ifpr.projetoIntegrador.visao.cadastro.GUIcadastroUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUIpesquisaUsuario extends javax.swing.JFrame {
    
    private List<Usuario> list = new ArrayList<>();

    public GUIpesquisaUsuario() {
        initComponents();
        carregarTabela();
    }
    
    //Método para atualizar tabelas da interface gráfica
    public void carregarTabela() {

        DefaultTableModel modeloTabela = (DefaultTableModel) tbUsuarios.getModel();

        try {
            // a lista recebe o resultado do método pesquisar que está no DAO
            list = UsuarioDAO.listar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //Alterar o número de linhas para 0 no modelo
        modeloTabela.setNumRows(0);

        int aux = 0;

        //foreach = para cada 
        //para cada objeto presente na lista
        //insira uma nova linha preenchida na tabela
        for (Usuario usuario : list) {
            modeloTabela.addRow(new Object[]{
                usuario.getNome(),
                usuario.getUserName()
            });
            aux++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Usuários cadastrados");
        jLabel1.setToolTipText("");

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Nome de usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projetoIntegrador/visao/icones/BotaoNovo.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btNovoMouseReleased(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projetoIntegrador/visao/icones/alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btAlterarMouseReleased(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projetoIntegrador/visao/icones/delete.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btExcluirMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNovoMouseReleased
        new GUIcadastroUsuario().setVisible(true);
    }//GEN-LAST:event_btNovoMouseReleased

    private void btAlterarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlterarMouseReleased
        try {
            Usuario usuario = list.get(tbUsuarios.getSelectedRow());
            new GUIcadastroUsuario(usuario).setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um item da lista");
        }
    }//GEN-LAST:event_btAlterarMouseReleased

    private void btExcluirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirMouseReleased
        try {
            int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir");
            if (opc == JOptionPane.YES_OPTION) {
                UsuarioDAO.excluir(list.get(tbUsuarios.getSelectedRow()));
                carregarTabela();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir no banco\nTente novamente");
        } catch( ArrayIndexOutOfBoundsException e ){
            JOptionPane.showMessageDialog(null, "Selecione um item da lista");
        }
    }//GEN-LAST:event_btExcluirMouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregarTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tbUsuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseReleased
        if (evt.getClickCount() == 2) {
            Usuario usuario = list.get(tbUsuarios.getSelectedRow());
            new GUIcadastroUsuario(usuario).setVisible(true);
        }
    }//GEN-LAST:event_tbUsuariosMouseReleased

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
            java.util.logging.Logger.getLogger(GUIpesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIpesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIpesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIpesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIpesquisaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables

}
