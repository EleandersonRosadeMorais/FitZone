package controlar;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorDeAssinatura {

    // Assina um plano para o usuário
    public boolean assinarPlano(int fkUsuario, int fkPlano) {
        // Remove assinatura ativa anterior do usuário
        removerAssinaturaExistente(fkUsuario);

        // SQL para inserir nova assinatura
        String sql = "INSERT INTO ASSINATURA(fkUsuario, fkPlano, data_inicio, status) VALUES (?, ?, CURDATE(), 'Ativa')";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement ps = null;
        try {
            // Prepara comando SQL e define valores
            ps = gerenciador.prepararComando(sql);
            ps.setInt(1, fkUsuario);
            ps.setInt(2, fkPlano);

            // Executa inserção
            ps.executeUpdate();

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Plano assinado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            // Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao assinar plano: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            // Fecha conexão
            gerenciador.fecharConexao(ps);
        }
    }

    // Remove assinatura ativa de um usuário
    public boolean removerAssinaturaExistente(int fkUsuario) {
        // SQL para apagar assinatura ativa
        String sql = "DELETE FROM ASSINATURA WHERE fkUsuario = ? AND status = 'Ativa'";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement ps = null;
        try {
            // Prepara comando SQL e define valores
            ps = gerenciador.prepararComando(sql);
            ps.setInt(1, fkUsuario);

            // Executa exclusão
            int removidas = ps.executeUpdate();

            // Loga no console se removeu algo
            if (removidas > 0) {
                System.out.println("Assinatura anterior removida.");
            }
            return true;
        } catch (SQLException e) {
            // Mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao remover assinatura: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            // Fecha conexão
            gerenciador.fecharConexao(ps);
        }
    }
}
