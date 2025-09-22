
package modelo;
import java.util.Date;

public class AvaliacaoFisica {
    
    private int pkAvaliacaoFisica;
    private int fkUsuario;
    private Date data_avaliacao;
    private double peso;
    private double altura;
    private double circunferencia_abdominal;
    private double massa_muscular;
    private double gordura_corporal;
    private double imc;
    private double tmb;
    private String observacoes;

    public AvaliacaoFisica() {
    }

    public AvaliacaoFisica(int pkAvaliacaoFisica, int fkUsuario, Date data_avaliacao, double peso, double altura, double circunferencia_abdominal, double massa_muscular, double gordura_corporal, double imc, double tmb, String observacoes) {
        this.pkAvaliacaoFisica = pkAvaliacaoFisica;
        this.fkUsuario = fkUsuario;
        this.data_avaliacao = data_avaliacao;
        this.peso = peso;
        this.altura = altura;
        this.circunferencia_abdominal = circunferencia_abdominal;
        this.massa_muscular = massa_muscular;
        this.gordura_corporal = gordura_corporal;
        this.imc = imc;
        this.tmb = tmb;
        this.observacoes = observacoes;
    }

    public int getPkAvaliacaoFisica() {
        return pkAvaliacaoFisica;
    }

    public void setPkAvaliacaoFisica(int pkAvaliacaoFisica) {
        this.pkAvaliacaoFisica = pkAvaliacaoFisica;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Date getData_avaliacao() {
        return data_avaliacao;
    }

    public void setData_avaliacao(Date data_avaliacao) {
        this.data_avaliacao = data_avaliacao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getCircunferencia_abdominal() {
        return circunferencia_abdominal;
    }

    public void setCircunferencia_abdominal(double circunferencia_abdominal) {
        this.circunferencia_abdominal = circunferencia_abdominal;
    }

    public double getMassa_muscular() {
        return massa_muscular;
    }

    public void setMassa_muscular(double massa_muscular) {
        this.massa_muscular = massa_muscular;
    }

    public double getGordura_corporal() {
        return gordura_corporal;
    }

    public void setGordura_corporal(double gordura_corporal) {
        this.gordura_corporal = gordura_corporal;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getTmb() {
        return tmb;
    }

    public void setTmb(double tmb) {
        this.tmb = tmb;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}