package br.edu.ifpr.projetoIntegrador.util;

import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class FabricaRelatorio {
    
    public static void gerarRelatorio(String caminho, ResultSet rs){
        try {
            //recebe um ResultSet vindo do banco de dados
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            
            //Imprime o relátorio
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminho,new HashMap(),jrRS);
            
            //Componente para visualizar o relatório
            JasperViewer.viewReport(jasperPrint);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não foi gerado. \nMudar a pasta raiz do jasper no evento do botão relatorio na GUItelaPrincipal \n");
        }
    }

}
