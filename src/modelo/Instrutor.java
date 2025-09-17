
package modelo;

public class Instrutor {
    private int pkInstrutor;
    private String nome;
    private String especialidade; 
    private String creft;
    private String telefone;
    private String email;

    public Instrutor() {
    }

    public Instrutor(int pkInstrutor, String nome, String especialidade, String creft, String telefone, String email) {
        this.pkInstrutor = pkInstrutor;
        this.nome = nome;
        this.especialidade = especialidade;
        this.creft = creft;
        this.telefone = telefone;
        this.email = email;
    }

    public int getPkInstrutor() {
        return pkInstrutor;
    }

    public void setPkInstrutor(int pkInstrutor) {
        this.pkInstrutor = pkInstrutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCreft() {
        return creft;
    }

    public void setCreft(String creft) {
        this.creft = creft;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
