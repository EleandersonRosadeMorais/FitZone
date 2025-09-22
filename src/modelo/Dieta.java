
package modelo;

public class Dieta {
    private int pkDieta;
    private int fkUsuario;
    private String refeicao;
    private double peso;
    private double calorias;
    private double proteinas;
    private double carboidratos;
    private double gorduras;
    private String observacoes;

    public Dieta() {
    }

    public Dieta(int pkDieta, int fkUsuario, String refeicao, double peso, double calorias, double proteinas, double carboidratos, double gorduras, String observacoes) {
        this.pkDieta = pkDieta;
        this.fkUsuario = fkUsuario;
        this.refeicao = refeicao;
        this.peso = peso;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.gorduras = gorduras;
        this.observacoes = observacoes;
    }

    public int getPkDieta() {
        return pkDieta;
    }

    public void setPkDieta(int pkDieta) {
        this.pkDieta = pkDieta;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public double getGorduras() {
        return gorduras;
    }

    public void setGorduras(double gorduras) {
        this.gorduras = gorduras;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

  
   
}
