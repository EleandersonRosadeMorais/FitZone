
package controlar;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.AvaliacaoFisica;


public class ControladorDeAvaliacao {
        public boolean inserir(AvaliacaoFisica avaliacao) {
        String sql = "INSERT INTO AVALIACAO_FISICA (fkUsuario, data_avaliacao, peso, altura, circunferencia_abdominal, observacoes) VALUES (?,?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, avaliacao.getFkUsuario());
            comando.setDate(2, Date.valueOf(LocalDate.now()));
            comando.setDouble(3, avaliacao.getPeso());
            comando.setDouble(4, avaliacao.getAltura());
            comando.setDouble(5, avaliacao.getCircunferencia_abdominal());
            comando.setString(6, avaliacao.getObservacoes());

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
