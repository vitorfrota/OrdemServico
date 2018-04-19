/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sgos.model.beans.ItemServico;
import sgos.model.beans.Servico;
import sgos.model.connection.ConnectionFactory;

/**
 *
 * @author vitor_9g3eyo1
 */
public class ItemServicoDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void adicionar(ItemServico i) {
        conn = ConnectionFactory.getConexao();

        sql = "insert into itemservico(iteosid,iteserid) values(?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i.getIteosid());
            ps.setInt(2, i.getIteserid());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso !!");
            ps.close();
        } catch (Exception e) {
            System.out.println("Erro no salvar -> " + e.getMessage());
        }

        ServicoDAO sdao = new ServicoDAO();

        // sdao.modificaStatus(i.getIteserid());
    } // fim do método adicionar

    public void remover(ItemServico i) {
        conn = ConnectionFactory.getConexao();
        String sql = "DELETE FROM itemservico WHERE iteosid = ? and iteserid = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, i.getIteosid());
            ps.setInt(2, i.getIteserid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
        //  ServicoDAO sdao = new ServicoDAO();

        //   sdao.retornaStatus(i.getIteserid());
    }

    public List<Servico> listarServicosOS(int id) {
        conn = ConnectionFactory.getConexao();

        sql = "select * from itemservico i inner join servico s on s.serid = i.iteserid inner join ordemservico o on o.osid = i.iteosid where i.iteosid =" + id + "";

        List<Servico> lista = new ArrayList<Servico>();

        Servico servico = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                servico = new Servico();

                servico.setSerid(rs.getInt("serid"));
                servico.setSerdesc(rs.getString("serdesc"));
                servico.setServalor(rs.getDouble("servalor"));

                lista.add(servico);
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }
        return lista;
    }

    public Double calculaTotal(int id) {

        Double total = null;
        conn = ConnectionFactory.getConexao();

        sql = "select sum(s.servalor) as valor from itemservico i inner join servico s on s.serid = i.iteserid inner join ordemservico o on o.osid = i.iteosid where i.iteosid =" + id + "";

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                total = rs.getDouble("valor");
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return total;
    }
}
