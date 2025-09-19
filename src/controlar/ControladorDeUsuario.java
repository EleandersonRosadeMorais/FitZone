package controlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Usuario;
import utilidade.Util;

public class ControladorDeUsuario {

    public Usuario autenticar(String email, String senha) {
        String sql = "SELECT * from USUARIO  WHERE email = ? and senha = ? and ativo = true";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario usu = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, email);
            comando.setString(2, senha);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                Usuario cliente = new Usuario();
                
                comando.setString(1, cliente.getNome());
                comando.setString(2, cliente.getEmail());
                comando.setString(3, cliente.getSenha());
                comando.setString(4, cliente.getTelefone());
                comando.setDate(5, new java.sql.Date(cliente.getDataNascimento().getTime()));
                comando.setString(6, cliente.getObjetivo());
                comando.setBytes(7, Util.converterIconToBytes(cliente.getImagem()));
                comando.setString(8, cliente.getCpf());
                comando.setBoolean(9, cliente.isAtivo());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return usu;
    }

    public boolean inserir(Usuario cliente) {
        String sql = "INSERT INTO USUARIO (nome, email, senha, telefone, data_nascimento, objetivo, imagem, cpf, ativo) VALUES (?,?,?,?,?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
            comando.setString(4, cliente.getTelefone());
            comando.setDate(5, new java.sql.Date(cliente.getDataNascimento().getTime()));
            comando.setString(6, cliente.getObjetivo());
            comando.setBytes(7, Util.converterIconToBytes(cliente.getImagem()));
            comando.setString(8, cliente.getCpf());
            comando.setBoolean(9, cliente.isAtivo());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

}
