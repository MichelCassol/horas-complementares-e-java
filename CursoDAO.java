package br.edu.ifpr.projetoIntegrador.DAO;

import br.edu.ifpr.projetoIntegrador.modelo.Curso;
import br.edu.ifpr.projetoIntegrador.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    public static void inserir(Curso curso)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into tbCurso(nomeCurso,duracaoCurso,areaConheCurso,numRegistro)values(?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, curso.getNome());
        stmt.setString(2, curso.getDuracao());
        stmt.setString(3, curso.getAreaConhecimento());
        stmt.setString(4, curso.getNumeroRegistro());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static void alterar(Curso curso)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "update tbCurso set nomeCurso = ?, duracaoCurso = ?, areaConheCurso = ?, numRegistro = ? where idCurso = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, curso.getNome());
        stmt.setString(2, curso.getDuracao());
        stmt.setString(3, curso.getAreaConhecimento());
        stmt.setString(4, curso.getNumeroRegistro());
        stmt.setInt(5, curso.getIdCurso());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    public static void excluir(Curso curso)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "delete from tbCurso where idCurso = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, curso.getIdCurso());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    public static List<Curso> pesquisar(Curso curso)throws SQLException{
        List<Curso> list = new ArrayList<Curso>();
        Connection con = Conexao.getConexao();
        String sql = "select*from tbCurso where like '"+curso.getNome()+"%' order by nomeCurso";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Curso curso1 = new Curso();
            curso1.setIdCurso(rs.getInt("idCurso"));
            curso1.setNome(rs.getString("nomeCurso"));
            curso1.setDuracao(rs.getString("duracaoCurso"));
            curso1.setAreaConhecimento(rs.getString("areaConheCurso"));
            curso1.setNumeroRegistro(rs.getString("numRegistro"));
            list.add(curso1);
        }
        stmt.close();
        rs.close();
        con.close();
        return list;
    }
    
    public static List<Curso> listar()throws SQLException{
        List<Curso> list = new ArrayList<>();
        Connection con = Conexao.getConexao();
        String sql = "select*from tbCurso order by nomeCurso";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Curso c = new Curso();
            c.setNome(rs.getString("nomeCurso"));
            c.setNumeroRegistro(rs.getString("numRegistro"));
            c.setDuracao(rs.getString("duracaoCurso"));
            c.setAreaConhecimento(rs.getString("areaConheCurso"));
            c.setIdCurso(rs.getInt("idCurso"));
            list.add(c);
        }
        ps.close();
        rs.close();
        con.close();
        return list;
    }
}
