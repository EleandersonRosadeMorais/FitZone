package controlar;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorDeAssinatura {

    public boolean assinarPlano(int fkUsuario, int fkPlano) {
        removerAssinaturaExistente(fkUsuario);

        String sql = "INSERT INTO ASSINATURA(fkUsuario, fkPlano, data_inicio, status) VALUES (?, ?, CURDATE(), 'Ativa')";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement ps = null;
        try {
            ps = gerenciador.prepararComando(sql);
            ps.setInt(1, fkUsuario);
            ps.setInt(2, fkPlano);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Plano assinado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao assinar plano: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            gerenciador.fecharConexao(ps);
        }
    }

    public boolean removerAssinaturaExistente(int fkUsuario) {
        String sql = "DELETE FROM ASSINATURA WHERE fkUsuario = ? AND status = 'Ativa'";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement ps = null;
        try {
            ps = gerenciador.prepararComando(sql);
            ps.setInt(1, fkUsuario);
            int removidas = ps.executeUpdate();
            if (removidas > 0) {
                System.out.println("Assinatura anterior removida.");
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover assinatura: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            gerenciador.fecharConexao(ps);
        }
    }
}