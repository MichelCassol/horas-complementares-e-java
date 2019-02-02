package br.edu.ifpr.projetoIntegrador.DAO;

import br.edu.ifpr.projetoIntegrador.modelo.Academico;
import br.edu.ifpr.projetoIntegrador.modelo.Atividade;
import br.edu.ifpr.projetoIntegrador.modelo.Curso;
import br.edu.ifpr.projetoIntegrador.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO {
    public static void inserir(Atividade atividade)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into tbAtividade(descAtividade, cargaHoraAtividade, dataInicioAtividade,"
                + "numRegistroAtividade, idAluno)values(?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, atividade.getDescricao());
        stmt.setTime(2, Time.valueOf(atividade.getCargaHora()));
        stmt.setDate(3, Date.valueOf(atividade.getDataInicio()));
        stmt.setString(4, atividade.getNumRegistro());
        stmt.setInt(5, atividade.getAcademico().getIdAcademico());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static void alterar(Atividade atividade)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "update tbAtividade set descAtividade = ?, cargaHoraAtividade = ?,dataInicioAtividade = ?,"
                + "numRegistroAtividade = ?, idAluno = ? where idAtividade = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, atividade.getDescricao());
        ps.setTime(2, Time.valueOf(atividade.getCargaHora()));
        ps.setDate(3, Date.valueOf(atividade.getDataInicio()));
        ps.setString(4, atividade.getNumRegistro());
        ps.setInt(5, atividade.getAcademico().getIdAcademico());
        ps.setInt(6, atividade.getIdAtividade());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
    public static void excluir(Atividade atividade)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "delete from tbAtividade where idAtividade = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, atividade.getIdAtividade());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
    public static List<Atividade> pesquisar(Atividade atividade)throws SQLException{
        List<Atividade> list = new ArrayList<Atividade>();
        Connection con = Conexao.getConexao();
        String sql = "select"
                + "     curso.*,"
                + "     aluno.*,"
                + "     ativ.*"
                + "from"
                + "     tbAtividade ativ,"
                + "     tbAluno aluno,"
                + "     tbCurso curso"
                + "where"
                + "     aluno.idCurso = curso.idCurso and\n"
                + "     ativ.idAluno = aluno.idAluno and\n"
                + "     ativ.descAtividade like '"+atividade.getDescricao()+"%' "
                + "order by ativ.descAtividade";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setNome(rs.getString("nomeCurso"));
            c.setNumeroRegistro(rs.getString("numRegistro"));
            c.setDuracao(rs.getString("duracaoCurso"));
            c.setAreaConhecimento(rs.getString("areaConheCurso"));
            
            Academico acad = new Academico();
            acad.setCurso(c);
            acad.setDataIngresso(rs.getString("dataIngreAluno"));
            acad.setDataNascimento(rs.getString("dataNascAluno"));
            acad.setNome(rs.getString("nomeAluno"));
            acad.setRa(rs.getString("raAluno"));
            acad.setRg(rs.getString("rgAluno"));
            
            Atividade a = new Atividade();
            a.setDescricao(rs.getString("descAtividade"));
            a.setCargaHora(rs.getString("cargaHoraAtividade"));
            a.setDataInicio(rs.getString("dataInicioAtividade"));
            a.setNumRegistro(rs.getString("numRegistroAtividade"));
            a.setAcademico(acad);
            
            list.add(a);
        }
        rs.close();
        ps.close();
        con.close();
        return list;
    }
    
    public static List<Atividade> listar(Academico academico)throws SQLException{
        List<Atividade> list = new ArrayList<>();
        Connection con = Conexao.getConexao();
        String sql = "select A.*, B.*, C.* from tbAluno as A inner join tbAtividade as\n" +
            "B on A.idAluno = B.idAluno inner join tbCurso as C on A.idCurso = C.idCurso \n" +
            "and A.nomeAluno like '"+academico.getNome()+"%' order by B.descAtividade";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setAreaConhecimento(rs.getString("areaConheCurso"));
            c.setDuracao(rs.getString("duracaoCurso"));
            c.setIdCurso(rs.getInt("idCurso"));
            c.setNome(rs.getString("nomeCurso"));
            c.setNumeroRegistro(String.valueOf(rs.getInt("numRegistro")));
            
            Academico acad = new Academico();
            acad.setDataIngresso(rs.getString("dataIngreAluno"));
            acad.setDataNascimento(rs.getDate("dataNascAluno").toString());
            acad.setIdAcademico(rs.getInt("idAluno"));
            acad.setNome(rs.getString("nomeAluno"));
            acad.setRa(rs.getString("raAluno"));
            acad.setRg(rs.getString("rgAluno"));
            acad.setCurso(c);
            
            Atividade a = new Atividade();
            a.setCargaHora(rs.getTime("cargaHoraAtividade").toString());
            a.setDataInicio(rs.getDate("dataInicioAtividade").toString());
            a.setDescricao(rs.getString("descAtividade"));
            a.setIdAtividade(rs.getInt("idAtividade"));
            a.setNumRegistro(rs.getString("numRegistroAtividade"));
            a.setAcademico(acad);
            
            list.add(a);
        }
        con.close();
        rs.close();
        ps.close();
        return list;
    }

}
