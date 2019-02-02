package br.edu.ifpr.projetoIntegrador.visao.pesquisar;

import br.edu.ifpr.projetoIntegrador.DAO.AtividadeDAO;
import br.edu.ifpr.projetoIntegrador.modelo.Academico;
import br.edu.ifpr.projetoIntegrador.modelo.Atividade;
import br.edu.ifpr.projetoIntegrador.visao.cadastro.GUIcadastroAtividade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUIpesquisaAtivid extends javax.swing.JFrame {
    
    private Academico a = new Academico();
    private List<Atividade> list = new ArrayList<>();

    public GUIpesquisaAtivid() {
        initComponents();
        carregarTabela();
    }
    
    public GUIpesquisaAtivid(Academico academico) {
        initComponents();
        carregarTabela();
        a = academico;
        
    }
    
    //Método para atualizar tabelas da interface gráfica
    public void carregarTabela(){
        
        DefaultTableModel modeloTabela = (DefaultTableModel) tbAtividade.getModel();
        
        try {
            // a lista recebe o resultado do método pesquisar que está no DAO
            list = AtividadeDAO.listar(a);
        } catch (SQLException ex) {
        }
        
        //Alterar o número de linhas para 0 no modelo
         modeloTabela.setNumRows(0);

            int aux=0;
            
            //foreach = para cada 
            //para cada objeto presente na lista
            //insira uma nova linha preenchida na tabela
           
            for (Atividade a: list) {
                modeloTabela.addRow(new Object[]{
                    a.getDescricao(),
                    a.getAcademico().getNome(),
                    a.getCargaHora()
                });
                aux++;
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAtividade = new javax.swing.JTable();
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
        jLabel1.setText("Atividades acadêmico");

        tbAtividade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Nome do aluno", "Duração"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tbAtividade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbAtividadeMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbAtividade);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projetoIntegrador/visao/icones/BotaoNovo.png"))); // NOI18N
        btNovo.setText("Nova atividade");
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
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addGap(81, 81, 81))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNovoMouseReleased
        try {
            new GUIcadastroAtividade(a).setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }//GEN-LAST:event_btNovoMouseReleased

    private void btAlterarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlterarMouseReleased
        try {
            Atividade atividade = list.get(tbAtividade.getSelectedRow());
            new GUIcadastroAtividade(atividade).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um item");
        }
    }//GEN-LAST:event_btAlterarMouseReleased

    private void btExcluirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirMouseReleased
        int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir");
        if (opcao == JOptionPane.YES_OPTION) {
            try {
                Atividade a = list.get(tbAtividade.getSelectedRow());
                AtividadeDAO.excluir(a);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir do banco");
            } catch (ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "Selecione uma linha da lista");
            }  
        }
    }//GEN-LAST:event_btExcluirMouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregarTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tbAtividadeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAtividadeMouseReleased
        if (evt.getClickCount() == 2) {
            Atividade atividade = list.get(tbAtividade.getSelectedRow());
            new GUIcadastroAtividade(atividade).setVisible(true);
        }
    }//GEN-LAST:event_tbAtividadeMouseReleased

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
            java.util.logging.Logger.getLogger(GUIpesquisaAtivid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIpesquisaAtivid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIpesquisaAtivid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIpesquisaAtivid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIpesquisaAtivid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAtividade;
    // End of variables declaration//GEN-END:variables

}
