package br.edu.ifpr.projetoIntegrador.visao.principal;

import br.edu.ifpr.projetoIntegrador.DAO.AcademicoDAO;
import br.edu.ifpr.projetoIntegrador.modelo.Academico;
import br.edu.ifpr.projetoIntegrador.util.FabricaRelatorio;
import br.edu.ifpr.projetoIntegrador.visao.cadastro.GUIcadastroAcademico;
import br.edu.ifpr.projetoIntegrador.visao.cadastro.GUIcadastroAtividade;
import br.edu.ifpr.projetoIntegrador.visao.cadastro.GUIcadastroCurso;
import br.edu.ifpr.projetoIntegrador.visao.cadastro.GUIcadastroUsuario;
import br.edu.ifpr.projetoIntegrador.visao.pesquisar.GUIpesquisaAtivid;
import br.edu.ifpr.projetoIntegrador.visao.pesquisar.GUIpesquisaUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperReport;

public class GUItelaPrincipal extends javax.swing.JFrame {
    
    private List<Academico> list = new ArrayList<>();
    
    public GUItelaPrincipal() {
        initComponents();
        carregarTabela();
    }
    
    private Academico retornaObjeto(){
        Academico a = new Academico();
        a.setNome(txAcademico.getText());
        return a;
    }
    
    //Método para atualizar tabelas da interface gráfica
    public void carregarTabela(){
        
        DefaultTableModel modeloTabela = (DefaultTableModel) tbAcademicos.getModel();
        
        try {
            // a lista recebe o resultado do método pesquisar que está no DAO
            list = AcademicoDAO.pesquisar(retornaObjeto());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //Alterar o número de linhas para 0 no modelo
         modeloTabela.setNumRows(0);

        int aux=0;

        //foreach = para cada 
        //para cada objeto presente na lista
        //insira uma nova linha preenchida na tabela

        for (Academico a: list) {
            modeloTabela.addRow(new Object[]{
                a.getNome(),
                a.getCurso().getNome()
            });
            aux++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txAcademico = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAcademicos = new javax.swing.JTable();
        btDetalhes = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        imCadasAtividade = new javax.swing.JMenuItem();
        imCadasAcademico = new javax.swing.JMenuItem();
        imCadasUsuario = new javax.swing.JMenuItem();
        miCadasCursos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        imUsuariosCadas = new javax.swing.JMenuItem();
        btRelatorioAcademico = new javax.swing.JMenu();
        miRelatorio = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu2.setText("jMenu2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Controle de horas complementares");

        jLabel2.setText("Acadêmico:");

        txAcademico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txAcademicoKeyReleased(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projetoIntegrador/visao/icones/pesquisar.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btPesquisarMouseReleased(evt);
            }
        });

        tbAcademicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do acadêmico", "Nome do curso"
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
        tbAcademicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbAcademicosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbAcademicos);

        btDetalhes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projetoIntegrador/visao/icones/novo.png"))); // NOI18N
        btDetalhes.setText("Detalhes");
        btDetalhes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btDetalhesMouseReleased(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projetoIntegrador/visao/icones/alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btAlterarMouseReleased(evt);
            }
        });

        jMenu1.setText("Cadastros");

        imCadasAtividade.setText("Cadastro de atividade");
        imCadasAtividade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                imCadasAtividadeMouseReleased(evt);
            }
        });
        jMenu1.add(imCadasAtividade);

        imCadasAcademico.setText("Cadastro de acadêmicos");
        imCadasAcademico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                imCadasAcademicoMouseReleased(evt);
            }
        });
        jMenu1.add(imCadasAcademico);

        imCadasUsuario.setText("Cadastro de usuário");
        imCadasUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                imCadasUsuarioMouseReleased(evt);
            }
        });
        jMenu1.add(imCadasUsuario);

        miCadasCursos.setText("Cadastro de cursos");
        miCadasCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                miCadasCursosMouseReleased(evt);
            }
        });
        jMenu1.add(miCadasCursos);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Usuário");

        imUsuariosCadas.setText("Usuários cadastrados");
        imUsuariosCadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                imUsuariosCadasMouseReleased(evt);
            }
        });
        jMenu3.add(imUsuariosCadas);

        jMenuBar1.add(jMenu3);

        btRelatorioAcademico.setText("Relatórios");

        miRelatorio.setText("Relatório de acadêmicos");
        miRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                miRelatorioMouseReleased(evt);
            }
        });
        btRelatorioAcademico.add(miRelatorio);

        jMenuBar1.add(btRelatorioAcademico);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDetalhes)
                    .addComponent(btAlterar))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void imCadasAcademicoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imCadasAcademicoMouseReleased
        new GUIcadastroAcademico().setVisible(true);
    }//GEN-LAST:event_imCadasAcademicoMouseReleased

    private void imCadasAtividadeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imCadasAtividadeMouseReleased
        new GUIcadastroAtividade().setVisible(true);
    }//GEN-LAST:event_imCadasAtividadeMouseReleased

    private void imCadasUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imCadasUsuarioMouseReleased
        new GUIcadastroUsuario().setVisible(true);
    }//GEN-LAST:event_imCadasUsuarioMouseReleased

    private void miCadasCursosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miCadasCursosMouseReleased
        new GUIcadastroCurso().setVisible(true);
    }//GEN-LAST:event_miCadasCursosMouseReleased

    private void tbAcademicosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAcademicosMouseReleased
        if (evt.getClickCount() == 2) {
            Academico academico = list.get(tbAcademicos.getSelectedRow());
            new GUIpesquisaAtivid(academico).setVisible(true);
        }
    }//GEN-LAST:event_tbAcademicosMouseReleased

    private void txAcademicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAcademicoKeyReleased
        carregarTabela();
    }//GEN-LAST:event_txAcademicoKeyReleased

    private void btPesquisarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPesquisarMouseReleased
        carregarTabela();
    }//GEN-LAST:event_btPesquisarMouseReleased

    private void btDetalhesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDetalhesMouseReleased
        try {
            Academico academico = list.get(tbAcademicos.getSelectedRow());
            new GUIpesquisaAtivid(academico).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um item na lista");
        }
        
    }//GEN-LAST:event_btDetalhesMouseReleased

    private void btAlterarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlterarMouseReleased
        try {
            Academico academico = list.get(tbAcademicos.getSelectedRow());
            new GUIcadastroAcademico(academico).setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um item na lista");
        }
    }//GEN-LAST:event_btAlterarMouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregarTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void imUsuariosCadasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imUsuariosCadasMouseReleased
        new GUIpesquisaUsuario().setVisible(true);
    }//GEN-LAST:event_imUsuariosCadasMouseReleased

    private void miRelatorioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miRelatorioMouseReleased
        try {
            FabricaRelatorio.gerarRelatorio("/home/michel/Dropbox/Semestre4/ProgramacaoIII/NetBeans/ProjetoIntegrador/src/br/edu/ifpr/projetoIntegrador/relatorios/Relacionamento.jasper", AcademicoDAO.retornaRelatorio(retornaObjeto()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_miRelatorioMouseReleased

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
            java.util.logging.Logger.getLogger(GUItelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUItelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUItelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUItelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUItelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btDetalhes;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JMenu btRelatorioAcademico;
    private javax.swing.JMenuItem imCadasAcademico;
    private javax.swing.JMenuItem imCadasAtividade;
    private javax.swing.JMenuItem imCadasUsuario;
    private javax.swing.JMenuItem imUsuariosCadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem miCadasCursos;
    private javax.swing.JMenuItem miRelatorio;
    private javax.swing.JTable tbAcademicos;
    private javax.swing.JTextField txAcademico;
    // End of variables declaration//GEN-END:variables

}
