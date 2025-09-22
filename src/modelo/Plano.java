
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Plano {
    private int pkPlano;
    private String nome;
    private String descricao;
    private double preco_mensal;
    private int duracao_minima;
    private List<Plano_Beneficio> beneficios = new ArrayList<>(); 

    public Plano() {
    }

    public Plano(int pkPlano, String nome, String descricao, double preco_mensal, int duracao_minima) {
        this.pkPlano = pkPlano;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_mensal = preco_mensal;
        this.duracao_minima = duracao_minima;
    }

    public int getPkPlano() {
        return pkPlano;
    }

    public void setPkPlano(int pkPlano) {
        this.pkPlano = pkPlano;
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

    public double getPreco_mensal() {
        return preco_mensal;
    }

    public void setPreco_mensal(double preco_mensal) {
        this.preco_mensal = preco_mensal;
    }

    public int getDuracao_minima() {
        return duracao_minima;
    }

    public void setDuracao_minima(int duracao_minima) {
        this.duracao_minima = duracao_minima;
    }

    public List<Plano_Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Plano_Beneficio> beneficios) {
        this.beneficios = beneficios;
    }
    

}