
package modelo;

public class Beneficio {
    private int pkBeneficio;
    private String nome;
    private String descricao;
    private String tipo;

    public Beneficio() {
    }

    public Beneficio(int pkBeneficio, String nome, String descricao, String tipo) {
        this.pkBeneficio = pkBeneficio;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public int getPkBeneficio() {
        return pkBeneficio;
    }

    public void setPkBeneficio(int pkBeneficio) {
        this.pkBeneficio = pkBeneficio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
