
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
    private boolean ativo;

    public Usuario() {
    }

    public Usuario(int pkUsuario, String nome, String email, String senha, String telefone, Date dataNascimento, String objetivo, Date dataCadastro, Icon imagem, String cpf, boolean ativo) {
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
        this.ativo = ativo;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

   public String getAtivoString(){
    if(ativo){
      return "Ativo";
    }else{
      return "Inativo";
    }
  }
  
  public String toString(){
    return String.valueOf(pkUsuario);
  }
  
    public String removerCpf(String cpf) {
        return cpf = cpf.replaceAll("[^0-9]", "");
    }
    
    public boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return false;
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        int soma = 0;
        int peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * peso--;
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }
        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * peso--;
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }
        return cpf.charAt(9) == (digito1 + '0') && cpf.charAt(10) == (digito2 + '0');
    }
}