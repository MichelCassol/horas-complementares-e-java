package br.edu.ifpr.projetoIntegrador.DAO;

import br.edu.ifpr.projetoIntegrador.modelo.Academico;
import br.edu.ifpr.projetoIntegrador.modelo.Curso;
import br.edu.ifpr.projetoIntegrador.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AcademicoDAO {
    public static void inserir(Academico academico)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into tbAluno(nomeAluno,rgAluno,raAluno,dataNascAluno"
                + ",dataIngreAluno,idCurso,emailAluno,telefoneAluno)values(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, academico.getNome());
        stmt.setString(2, academico.getRg());
        stmt.setString(3, academico.getRa());
        stmt.setDate(4, Date.valueOf(academico.getDataNascimento()));
        stmt.setString(5, academico.getDataIngresso());
        stmt.setInt(6, academico.getCurso().getIdCurso());
        stmt.setString(7, academico.getEmail());
        stmt.setString(8, academico.getTelefone());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static void alterar(Academico academico)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "update tbAluno set nomeAluno = ?, rgAluno = ?, raAluno = ?,"
                + "dataNascAluno = ?, dataIngreAluno = ?, idCurso = ?, emailAluno = ?, telefoneAluno = ? where idAluno = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, academico.getNome());
        stmt.setString(2, academico.getRg());
        stmt.setString(3, academico.getRa());
        stmt.setString(4, academico.getDataNascimento());
        stmt.setString(5, academico.getDataIngresso());
        stmt.setInt(6, academico.getCurso().getIdCurso());
        stmt.setString(7, academico.getEmail());
        stmt.setString(8, academico.getTelefone());
        stmt.setInt(9, academico.getIdAcademico());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    public static void excluir(Academico academico)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "delete from tbAluno where = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, academico.getIdAcademico());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    public static List<Academico> pesquisar(Academico academico)throws SQLException{
        List<Academico> list = new ArrayList<>();
        Connection con = Conexao.getConexao();
        String sql = "select\n"
                + "     aluno.*,\n"
                + "     curso.*\n"
                + "from\n"
                + "     tbAluno aluno,\n"
                + "     tbCurso curso\n"
                + "where\n"
                + "     aluno.idCurso = curso.idCurso and\n"
                + "     aluno.nomeAluno like '"+academico.getNome()+"%' "
                + "order by aluno.nomeAluno";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setAreaConhecimento(rs.getString("areaConheCurso"));
            c.setDuracao(rs.getString("duracaoCurso"));
            c.setIdCurso(rs.getInt("idCurso"));
            c.setNome(rs.getString("nomeCurso"));
            c.setNumeroRegistro(rs.getString("numRegistro"));
            
            Academico a = new Academico();
            a.setIdAcademico(rs.getInt("idAluno"));
            a.setNome(rs.getString("nomeAluno"));
            a.setRa(rs.getString("raAluno"));
            a.setRg(rs.getString("rgAluno"));
            a.setDataNascimento(rs.getString("dataNascAluno"));
            a.setDataIngresso(rs.getString("dataIngreAluno"));
            a.setEmail(rs.getString("emailAluno"));
            a.setTelefone(rs.getString("telefoneAluno"));
            a.setCurso(c);
            list.add(a);
        }
        stmt.close();
        con.close();
        rs.close();
        return list;
    }
    
    public static List<Academico> listar()throws SQLException{
        List<Academico> list = new ArrayList<>();
        Connection con = Conexao.getConexao();
        String sql = "select*from tbAluno, tbCurso order by nomeAluno";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setAreaConhecimento(rs.getString("areaConheCurso"));
            c.setDuracao(rs.getString("duracaoCurso"));
            c.setNome(rs.getString("nomeCurso"));
            c.setNumeroRegistro(rs.getString("numRegistro"));
            c.setIdCurso(rs.getInt("idCurso"));
            
            Academico a = new Academico();
            a.setDataIngresso(rs.getString("dataIngreAluno"));
            a.setDataNascimento(rs.getString("dataNascAluno"));
            a.setNome(rs.getString("nomeAluno"));
            a.setRa(rs.getString("raAluno"));
            a.setRg(rs.getString("rgAluno"));
            a.setIdAcademico(rs.getInt("idAluno"));
            a.setEmail(rs.getString("emailAluno"));
            a.setTelefone(rs.getString("telefoneAluno"));
            a.setCurso(c);
            
            list.add(a);
        }
        con.close();
        rs.close();
        stmt.close();
        return list;
    }
    
    public static String geraRa()throws SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        java.util.Date date = new java.util.Date();
        Connection con = Conexao.getConexao();
        String sql = "select max(idAluno) from tbAluno";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String retorno = sdf.format(date)+(rs.getInt("max(idAluno)")+1);
        return retorno;
    }
    
    public static ResultSet retornaRelatorio(Academico academico)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "select*from tbAluno where tbAluno.nomeAluno like '"+academico.getNome()+"%' order by "
                + "tbAluno.nomeAluno";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
