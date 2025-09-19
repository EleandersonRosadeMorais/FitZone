
package modelo;

public class Treino {
    private int pkTreino;
    private int fkUsuario;
    private int fkInstrutor;
    private String nome;
    private String descricao;
    private String objetivo;
    private int duracao_minutos;
    private boolean concluido;
    private int fkExercicioTreino;

    public Treino() {
    }

    public int getPkTreino() {
        return pkTreino;
    }

    public void setPkTreino(int pkTreino) {
        this.pkTreino = pkTreino;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkInstrutor() {
        return fkInstrutor;
    }

    public void setFkInstrutor(int fkInstrutor) {
        this.fkInstrutor = fkInstrutor;
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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getDuracao_minutos() {
        return duracao_minutos;
    }

    public void setDuracao_minutos(int duracao_minutos) {
        this.duracao_minutos = duracao_minutos;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public int getFkExercicioTreino() {
        return fkExercicioTreino;
    }

    public void setFkExercicioTreino(int fkExercicioTreino) {
        this.fkExercicioTreino = fkExercicioTreino;
    }

    public Treino(int pkTreino, int fkUsuario, int fkInstrutor, String nome, String descricao, String objetivo, int duracao_minutos, boolean concluido, int fkExercicioTreino) {
        this.pkTreino = pkTreino;
        this.fkUsuario = fkUsuario;
        this.fkInstrutor = fkInstrutor;
        this.nome = nome;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.duracao_minutos = duracao_minutos;
        this.concluido = concluido;
        this.fkExercicioTreino = fkExercicioTreino;
    }

    
}
