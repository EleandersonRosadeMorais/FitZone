
package modelo;

public class ExercicioTreino {
    private int pkExercicioTreino;
    private int fkExercicio;
    private int carga;
    private int repeticoes;
    private int series;
    private int ordem;
    private Exercicio exercicio;

    public ExercicioTreino() {
    }

    public ExercicioTreino(int pkExercicioTreino, int fkExercicio, int carga, int repeticoes, int series, int ordem, Exercicio exercicio) {
        this.pkExercicioTreino = pkExercicioTreino;
        this.fkExercicio = fkExercicio;
        this.carga = carga;
        this.repeticoes = repeticoes;
        this.series = series;
        this.ordem = ordem;
        this.exercicio = exercicio;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }


    public int getPkExercicioTreino() {
        return pkExercicioTreino;
    }

    public void setPkExercicioTreino(int pkExercicioTreino) {
        this.pkExercicioTreino = pkExercicioTreino;
    }

    public int getFkExercicio() {
        return fkExercicio;
    }

    public void setFkExercicio(int fkExercicio) {
        this.fkExercicio = fkExercicio;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

}
