package controlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Instrutor;

public class ControladorDeInstrutor {

    public Instrutor autenticar(String email, String senha) {
        String sql = "SELECT * FROM INSTRUTOR WHERE email = ? AND senha = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Instrutor instrutor = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, email);
            comando.setString(2, senha);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                instrutor = new Instrutor();
                instrutor.setPkInstrutor(resultado.getInt("pkInstrutor"));
                instrutor.setNome(resultado.getString("nome"));
                instrutor.setEspecialidade(resultado.getString("especialidade"));
                instrutor.setCref(resultado.getString("cref"));
                instrutor.setTelefone(resultado.getString("telefone"));
                instrutor.setEmail(resultado.getString("email"));
                instrutor.setSenha(resultado.getString("senha"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return instrutor;
    }

    public boolean inserir(Instrutor instrutor) {
        String sql = "INSERT INTO INSTRUTOR (nome, especialidade, cref, telefone, email, senha) VALUES (?,?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, instrutor.getNome());
            comando.setString(2, instrutor.getEspecialidade());
            comando.setString(3, instrutor.getCref());
            comando.setString(4, instrutor.getTelefone());
            comando.setString(5, instrutor.getEmail());
            comando.setString(6, instrutor.getSenha());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }

        return false;
    }
    
    
    public boolean alterar(Instrutor instrutor) {
        String sql = "UPDATE INSTRUTOR SET nome = ?, especialidade = ?, cref = ?, telefone = ?, email = ?, senha = ? WHERE pkInstrutor = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, instrutor.getNome());
            comando.setString(2, instrutor.getEspecialidade());
            comando.setString(3, instrutor.getCref());
            comando.setString(4, instrutor.getTelefone());
            comando.setString(5, instrutor.getEmail());
            comando.setString(6, instrutor.getSenha());
            comando.setInt(7, instrutor.getPkInstrutor());

            int linhas = comando.executeUpdate();
            return linhas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar instrutor: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }

        return false;
    }
}
