package modelo;

import java.util.Date;
public class Assinatura {
    private int pkAssinatura;
    private int fkUsuario;
    private int fkPlano;
    private Date data_inicio;
    private Date data_fim;
    private String status;
    private Date data_renovacao;
    private Plano plano;

    public Assinatura() {
    }

    public Assinatura(int pkAssinatura, int fkUsuario, int fkPlano, Date data_inicio, Date data_fim, String status, Date data_renovacao, Plano plano) {
        this.pkAssinatura = pkAssinatura;
        this.fkUsuario = fkUsuario;
        this.fkPlano = fkPlano;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.status = status;
        this.data_renovacao = data_renovacao;
        this.plano = plano;
    }

    public int getPkAssinatura() {
        return pkAssinatura;
    }

    public void setPkAssinatura(int pkAssinatura) {
        this.pkAssinatura = pkAssinatura;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkPlano() {
        return fkPlano;
    }

    public void setFkPlano(int fkPlano) {
        this.fkPlano = fkPlano;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_renovacao() {
        return data_renovacao;
    }

    public void setData_renovacao(Date data_renovacao) {
        this.data_renovacao = data_renovacao;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
    
    
}