package modelo;

public class Plano_Beneficio {
    private int pkPlanoBeneficio;
    private int fkPlano;
    private Beneficio beneficio;

    public Plano_Beneficio() {
    }

    public Plano_Beneficio(int pkPlanoBeneficio, int fkPlano, Beneficio beneficio) {
        this.pkPlanoBeneficio = pkPlanoBeneficio;
        this.fkPlano = fkPlano;
        this.beneficio = beneficio;
    }

    public int getPkPlanoBeneficio() {
        return pkPlanoBeneficio;
    }

    public void setPkPlanoBeneficio(int pkPlanoBeneficio) {
        this.pkPlanoBeneficio = pkPlanoBeneficio;
    }

    public int getFkPlano() {
        return fkPlano;
    }

    public void setFkPlano(int fkPlano) {
        this.fkPlano = fkPlano;
    }

    public Beneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Beneficio beneficio) {
        this.beneficio = beneficio;
    }

   
}
