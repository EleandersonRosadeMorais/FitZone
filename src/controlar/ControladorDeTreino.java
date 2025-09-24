package controlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Treino;

public class ControladorDeTreino {

    public boolean criar(Treino treino) {
        String sql = "INSERT INTO TREINO (fkUsuario, fkInstrutor, nome, descricao, objetivo, duracao_minutos) VALUES (?,?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, treino.getFkUsuario());
            comando.setInt(2, treino.getFkInstrutor());
            comando.setString(3, treino.getNome());
            comando.setString(4, treino.getDescricao());
            comando.setString(5, treino.getObjetivo());
            comando.setInt(6, treino.getDuracao_minutos());
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public List<Treino> consultar(int selecionar, int id, int TreinoId) {
        String sql = "SELECT * from treino ";

        if (selecionar == 1) {
            sql += " WHERE FkUsuario = " + id;
        } else if(selecionar == 2) {
            sql += " WHERE PkTreino = " + TreinoId;
        }

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Treino> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Treino tre = new Treino();

                tre.setPkTreino(resultado.getInt("pkTreino"));
                tre.setFkUsuario(resultado.getInt("fkUsuario"));
                tre.setFkInstrutor(resultado.getInt("fkInstrutor"));
                tre.setNome(resultado.getString("nome"));
                tre.setDescricao(resultado.getString("descricao"));
                tre.setObjetivo(resultado.getString("objetivo"));
                tre.setDuracao_minutos(resultado.getInt("duracao_minutos"));
                tre.setConcluido(resultado.getBoolean("concluido"));

                lista.add(tre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return lista;
    }

    public boolean deletar(String nome) {
        String sql = "DELETE FROM TREINO WHERE nome = ? ";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, nome);

            comando.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean verificar(int id) {
        String sql = "SELECT * FROM TREINO WHERE fkInstrutor = ?";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet rs = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, id);

            rs = comando.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, rs);
        }
        return false;
    }

    public List<Treino> consultarOpcao(int opcao, int id) {
        String sql = "SELECT * from treino ";

        switch (opcao) {
            case 1:
                sql += " Where fkInstrutor = " + id;
                break;
            case 2:
                sql += " where concluido = true";
                break;
        }

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Treino> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Treino tre = new Treino();

                tre.setPkTreino(resultado.getInt("pkTreino"));
                tre.setFkUsuario(resultado.getInt("fkUsuario"));
                tre.setFkInstrutor(resultado.getInt("fkInstrutor"));
                tre.setNome(resultado.getString("nome"));
                tre.setDescricao(resultado.getString("descricao"));
                tre.setObjetivo(resultado.getString("objetivo"));
                tre.setDuracao_minutos(resultado.getInt("duracao_minutos"));
                tre.setConcluido(resultado.getBoolean("concluido"));

                lista.add(tre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return lista;
    }
    
    public boolean verificarTreinoUsuario(int id) {
        String sql = "SELECT * FROM TREINO WHERE fkUsuario = ?";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet rs = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, id);

            rs = comando.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, rs);
        }
        return false;
    }
}
