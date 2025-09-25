
package modelo;

import java.util.Date;
import javax.swing.Icon;

public class Usuario {
    private int pkUsuario;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Date dataNascimento;
    private String objetivo;
    private Date dataCadastro;
    private Icon imagem;
    private String cpf;
    private String sexo;

    public Usuario() {
    }

    public Usuario(int pkUsuario, String nome, String email, String senha, String telefone, Date dataNascimento, String objetivo, Date dataCadastro, Icon imagem, String cpf, String sexo) {
        this.pkUsuario = pkUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.objetivo = objetivo;
        this.dataCadastro = dataCadastro;
        this.imagem = imagem;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public int getPkUsuario() {
        return pkUsuario;
    }

    public void setPkUsuario(int pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Icon getImagem() {
        return imagem;
    }

    public void setImagem(Icon imagem) {
        this.imagem = imagem;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

  
  public String toString(){
    return nome;
  }

}