package br.edu.ifpr.projetoIntegrador.DAO;

import br.edu.ifpr.projetoIntegrador.modelo.Usuario;
import br.edu.ifpr.projetoIntegrador.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public static void inserir(Usuario usuario)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "insert into tbUsuario(nomeUsuario, userNameUsuario, senhaUsuario)"
                + "values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getUserName());
        ps.setString(3, usuario.getSenha());
        ps.execute();
        ps.close();
        con.close();
    }
    
    public static void alterar(Usuario usuario)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "update tbUsuario set nomeUsuario = ?, userNameUsuario = ?, senhaUsuario = ?"
                + "where idUsuario = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getUserName());
        ps.setString(3, usuario.getSenha());
        ps.setInt(4, usuario.getIdUsuario());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
    public static void excluir(Usuario usuario)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "delete from tbUsuario where idUsuario = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, usuario.getIdUsuario());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
    public static List<Usuario> pesquisar(Usuario usuario)throws SQLException{
        List<Usuario> list = new ArrayList<>();
        Connection con = Conexao.getConexao();
        String sql = "select*from tbUsuario where nomeUsuario like '"+usuario.getNome()+"%' "
                + "order by nomeUsuario";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Usuario u = new Usuario();
            u.setNome(rs.getString("nomeUsuario"));
            u.setUserName(rs.getString("userNameUsuario"));
            u.setSenha(rs.getString("senhaUsuario"));
            list.add(u);
        }
        rs.close();
        con.close();
        ps.close();
        return list;
    }
    
    public static List<Usuario> listar()throws SQLException{
        List<Usuario> list = new ArrayList<>();
        Connection con = Conexao.getConexao();
        String sql = "select * from tbUsuario order by nomeUsuario";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString("nomeUsuario"));
            usuario.setUserName(rs.getString("userNameUsuario"));
            usuario.setSenha(rs.getString("senhaUsuario"));
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            list.add(usuario);
        }
        con.close();
        ps.close();
        rs.close();
        return list;
    }
    
    public static Usuario login(Usuario usuario)throws SQLException{
        Connection con = Conexao.getConexao();
        String sql = "select userNameUsuario, senhaUsuario from tbUsuario where userNameUsuario = '"
                + usuario.getUserName()+"' and senhaUsuario = '"+usuario.getSenha()+"'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Usuario u = new Usuario();
        u.setUserName(rs.getString("userNameUsuario"));
        u.setSenha(rs.getString("senhaUsuario"));
        con.close();
        ps.close();
        rs.close();
        return u;
    }
}
