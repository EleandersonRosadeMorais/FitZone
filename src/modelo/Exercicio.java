
package modelo;

public class Exercicio {
    private int pkExercicio;
    private String nome;
    private String descricao;
    private String tipo;
    private String grupo_muscular;
    private String equipamento;
    private String nivel_dificuldade;

    public Exercicio() {
    }

    public Exercicio(int pkExercicio, String nome, String descricao, String tipo, String grupo_muscular, String equipamento, String nivel_dificuldade) {
        this.pkExercicio = pkExercicio;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.grupo_muscular = grupo_muscular;
        this.equipamento = equipamento;
        this.nivel_dificuldade = nivel_dificuldade;
    }

    public int getPkExercicio() {
        return pkExercicio;
    }

    public void setPkExercicio(int pkExercicio) {
        this.pkExercicio = pkExercicio;
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

    public String getGrupo_muscular() {
        return grupo_muscular;
    }

    public void setGrupo_muscular(String grupo_muscular) {
        this.grupo_muscular = grupo_muscular;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getNivel_dificuldade() {
        return nivel_dificuldade;
    }

    public void setNivel_dificuldade(String nivel_dificuldade) {
        this.nivel_dificuldade = nivel_dificuldade;
    }
    
}
