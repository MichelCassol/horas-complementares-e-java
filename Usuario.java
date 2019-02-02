package br.edu.ifpr.projetoIntegrador.modelo;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String userName;
    private String confUserName;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getConfUserName() {
        return confUserName;
    }

    public void setConfUserName(String confUserName) {
        this.confUserName = confUserName;
    }
}
