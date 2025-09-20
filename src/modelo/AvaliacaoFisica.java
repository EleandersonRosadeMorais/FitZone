
package modelo;
import java.util.Date;

public class AvaliacaoFisica {
    
    private int pkAvaliacaoFisica;
    private int fkUsuario;
    private Date data_avaliacao;
    private double peso;
    private double altura;
    private double circunferencia_abdominal;
    private String observacoes;

    public AvaliacaoFisica() {
    }

    public AvaliacaoFisica(int pkAvaliacaoFisica, int fkUsuario, Date data_avaliacao, double peso, double altura, double circuferencia_abdominal, String observacoes) {
        this.pkAvaliacaoFisica = pkAvaliacaoFisica;
        this.fkUsuario = fkUsuario;
        this.data_avaliacao = data_avaliacao;
        this.peso = peso;
        this.altura = altura;
        this.circunferencia_abdominal = circuferencia_abdominal;
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

    public void setCircunferencia_abdominal(double circuferencia_abdominal) {
        this.circunferencia_abdominal = circuferencia_abdominal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
    
}
