package modelo; 

public class Instrutor {

    private int pkInstrutor;
    private String nome;
    private String especialidade;
    private String cref;
    private String telefone;
    private String email;
    private String senha;

    public Instrutor() {
    }

    public Instrutor(int pkInstrutor, String nome, String especialidade, String cref, String telefone, String email, String senha) {
        this.pkInstrutor = pkInstrutor;
        this.nome = nome;
        this.especialidade = especialidade;
        this.cref = cref;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
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

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    } 
    
}
