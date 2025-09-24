package controlar;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.AvaliacaoFisica;
import utilidade.DialogManager;

public class ControladorDeAvaliacao {

    public boolean inserir(AvaliacaoFisica avaliacao) {
        String sql = "INSERT INTO AVALIACAO_FISICA (fkUsuario, data_avaliacao, peso, altura, circunferencia_abdominal, massa_muscular, gordura_corporal, imc, tmb, observacoes) VALUES (?,?,?,?,?,?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, avaliacao.getFkUsuario());
            comando.setDate(2, Date.valueOf(LocalDate.now()));
            comando.setDouble(3, avaliacao.getPeso());
            comando.setDouble(4, avaliacao.getAltura());
            comando.setDouble(5, avaliacao.getCircunferencia_abdominal());
            comando.setDouble(6, avaliacao.getMassa_muscular());
            comando.setDouble(7, avaliacao.getGordura_corporal());
            comando.setDouble(8, avaliacao.getImc());
            comando.setDouble(9, avaliacao.getTmb());
            comando.setString(10, avaliacao.getObservacoes());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            DialogManager.showErrorDialog(null, "Erro ao inserir avaliação: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
    
    public boolean alterar(AvaliacaoFisica avaliacao) {
        String sql = "UPDATE AVALIACAO_FISICA SET fkUsuario = ?, peso = ?, altura = ?, circunferencia_Abdominal = ?, massa_muscular = ?, gordura_corporal = ?, imc = ?, tmb = ?, observacoes = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, avaliacao.getFkUsuario());
            comando.setDouble(2, avaliacao.getPeso());
            comando.setDouble(3, avaliacao.getAltura());
            comando.setDouble(4, avaliacao.getCircunferencia_abdominal());
            comando.setDouble(5, avaliacao.getMassa_muscular());
            comando.setDouble(6, avaliacao.getGordura_corporal());
            comando.setDouble(7, avaliacao.getImc());
            comando.setDouble(8, avaliacao.getTmb());
            comando.setString(9, avaliacao.getObservacoes());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            DialogManager.showErrorDialog(null, "Erro ao alterar avaliação: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public List<AvaliacaoFisica> consultar(int id) {
        String sql = "SELECT * from avaliacao_fisica WHERE fkUsuario = " + id;

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<AvaliacaoFisica> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                AvaliacaoFisica avaFis = new AvaliacaoFisica();

                avaFis.setPkAvaliacaoFisica(resultado.getInt("pkAvaliacaoFisica"));
                avaFis.setFkUsuario(resultado.getInt("fkUsuario"));
                avaFis.setPeso(resultado.getDouble("peso"));
                avaFis.setAltura(resultado.getDouble("altura"));
                avaFis.setCircunferencia_abdominal(resultado.getDouble("circunferencia_abdominal"));
                avaFis.setMassa_muscular(resultado.getDouble("massa_muscular"));
                avaFis.setGordura_corporal(resultado.getDouble("gordura_corporal"));
                avaFis.setImc(resultado.getDouble("imc"));
                avaFis.setTmb(resultado.getDouble("tmb"));
                avaFis.setObservacoes(resultado.getString("observacoes"));

                lista.add(avaFis);
            }
        } catch (SQLException e) {
            DialogManager.showErrorDialog(null, "Erro ao consultar avaliações: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return lista;
    }

    public boolean consultarExiste(int id) {
        String sql = "SELECT * FROM AVALIACAO_FISICA WHERE fkUsuario = ?";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet rs = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, id);
            rs = comando.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            DialogManager.showErrorDialog(null, "Erro ao verificar avaliação: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, rs);
        }
        return false;
    }
}