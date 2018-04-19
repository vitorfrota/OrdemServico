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
import sgos.model.beans.ItemPeca;
import sgos.model.beans.Peca;
import sgos.model.connection.ConnectionFactory;

/**
 *
 * @author vitor_9g3eyo1
 */
public class ItemPecaDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void adicionar(ItemPeca i) { // MÉTODO ADICIONAR PEÇA NA TABELA ITEMPEÇA
        conn = ConnectionFactory.getConexao();

        sql = "insert into itempeca(iteosid,itepecid) values(?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i.getIteosid());
            ps.setInt(2, i.getItepecid());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso !!");
            ps.close();
        } catch (Exception e) {
            System.out.println("Erro no salvar -> " + e.getMessage());
        }

        PecaDAO pdao = new PecaDAO();

        pdao.modificaStatus(i.getItepecid());
    } // fim do método adicionar

    public void remover(ItemPeca i) { // MÉTODO REMOVER PEÇA NA TABELA ITEMPEÇA
        conn = ConnectionFactory.getConexao();
        String sql = "DELETE FROM itempeca WHERE iteosid = ? and itepecid = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, i.getIteosid());
            ps.setInt(2, i.getItepecid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
        PecaDAO pdao = new PecaDAO();

        pdao.retornaStatus(i.getItepecid());

    }

    public List<Peca> listarPecasOS(int id) {
        conn = ConnectionFactory.getConexao();

        sql = "select * from itempeca i inner join peca p on p.pecid = i.itepecid inner join ordemservico o on o.osid = i.iteosid where i.iteosid =" + id + "";

        List<Peca> lista = new ArrayList<Peca>();

        Peca peca = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                peca = new Peca();

                peca.setPecid(rs.getInt("pecid"));
                peca.setPecdesc(rs.getString("pecdesc"));
                peca.setPecvalor(rs.getDouble("pecvalor"));

                lista.add(peca);
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

        sql = "select sum(p.pecvalor) as valor from itempeca i inner join peca p on p.pecid = i.itepecid inner join ordemservico o on o.osid = i.iteosid where i.iteosid =" + id + "";

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
