package controlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Beneficio;
import modelo.Plano;
import modelo.Plano_Beneficio;

public class ControladorDePlano {

    public List<Plano> consultarPlanos() {
        List<Plano> lista = new ArrayList<>();
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        String sqlPlano = "SELECT * FROM PLANO";
        String sqlBeneficios = "SELECT pb.pkPlanoBeneficio, b.pkBeneficio, b.nome, b.descricao, b.tipo "
                + "FROM PLANO_BENEFICIO pb "
                + "INNER JOIN BENEFICIO b ON pb.fkBeneficio = b.pkBeneficio "
                + "WHERE pb.fkPlano = ?";

        PreparedStatement psPlano = null;
        PreparedStatement psBen = null;
        ResultSet rsPlano = null;
        ResultSet rsBen = null;

        try {
            psPlano = gerenciador.prepararComando(sqlPlano);
            rsPlano = psPlano.executeQuery();

            while (rsPlano.next()) {
                Plano plano = new Plano();
                plano.setPkPlano(rsPlano.getInt("pkPlano"));
                plano.setNome(rsPlano.getString("nome"));
                plano.setDescricao(rsPlano.getString("descricao"));
                plano.setPreco_mensal(rsPlano.getDouble("preco_mensal"));
                plano.setDuracao_minima(rsPlano.getInt("duracao_minima"));

                psBen = gerenciador.prepararComando(sqlBeneficios);
                psBen.setInt(1, plano.getPkPlano());
                rsBen = psBen.executeQuery();
                while (rsBen.next()) {
                    Plano_Beneficio pb = new Plano_Beneficio();
                    Beneficio ben = new Beneficio();
                    ben.setPkBeneficio(rsBen.getInt("pkBeneficio"));
                    ben.setNome(rsBen.getString("nome"));
                    ben.setDescricao(rsBen.getString("descricao"));
                    ben.setTipo(rsBen.getString("tipo"));
                    pb.setBeneficio(ben);
                    pb.setFkPlano(plano.getPkPlano());
                    plano.getBeneficios().add(pb);
                }

                lista.add(plano);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar planos: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(psPlano, rsPlano);
            gerenciador.fecharConexao(psBen, rsBen);
        }

        return lista;
    }
}
