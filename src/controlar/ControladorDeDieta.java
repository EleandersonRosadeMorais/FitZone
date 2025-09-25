package controlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Dieta;

public class ControladorDeDieta {

    public boolean inserir(Dieta dieta) {
        String sql = "INSERT INTO DIETA (fkUsuario, refeicao, peso, calorias, proteinas, carboidratos, gorduras, observacoes) VALUES (?,?,?,?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, dieta.getFkUsuario());
            comando.setString(2, dieta.getRefeicao());
            comando.setDouble(3, dieta.getPeso());
            comando.setDouble(4, dieta.getCalorias());
            comando.setDouble(5, dieta.getProteinas());
            comando.setDouble(6, dieta.getCarboidratos());
            comando.setDouble(7, dieta.getGorduras());
            comando.setString(8, dieta.getObservacoes());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dieta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean consultar(int id) {
        String sql = "SELECT * FROM DIETA WHERE fkUsuario = ?";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet rs = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, id);
            rs = comando.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar dieta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            gerenciador.fecharConexao(comando, rs);
        }
        return false;
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM DIETA WHERE fkUsuario = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, id); 
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover dieta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
}