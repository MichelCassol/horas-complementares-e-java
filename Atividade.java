package br.edu.ifpr.projetoIntegrador.modelo;

public class Atividade {
    private int idAtividade;
    private String descricao;
    private String cargaHora;
    private String dataInicio;
    private String numRegistro;
    private Academico academico;

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCargaHora() {
        return cargaHora;
    }

    public void setCargaHora(String cargaHora) {
        this.cargaHora = cargaHora;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public Academico getAcademico() {
        return academico;
    }

    public void setAcademico(Academico academico) {
        this.academico = academico;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
}
