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
import sgos.model.beans.Servico;
import sgos.model.connection.ConnectionFactory;

/**
 *
 * @author vitor_9g3eyo1
 */
public class ServicoDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void salvar(Servico servico) {
        conn = ConnectionFactory.getConexao();

        sql = "insert into servico(serdesc,servalor, serstatus) values (?,?,?) ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, servico.getSerdesc());
            ps.setDouble(2, servico.getServalor());
            ps.setString(3, servico.getSerstatus());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso !!");
        } catch (Exception e) {
            System.out.println("Erro no salvar -> " + e.getMessage());
        }

    } // fim do método salvar

    public void alterar(Servico servico) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE servico SET serdesc = ?, servalor = ? WHERE serid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, servico.getSerdesc());
            ps.setDouble(2, servico.getServalor());
            ps.setInt(3, servico.getSerid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    public void excluir(Servico servico) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE servico SET serstatus = ? WHERE serid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, servico.getSerstatus());
            ps.setInt(2, servico.getSerid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    public Servico consulta(int codigo) {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM servico where serid = " + codigo + "";

        Servico servico = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                servico = new Servico();

                servico.setSerid(rs.getInt("serid"));
                servico.setSerdesc(rs.getString("serdesc"));
                servico.setServalor(rs.getDouble("servalor"));

            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return servico;
    }

    public List<Servico> listarServicos() {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM servico where serstatus = 'A' order by serdesc;";

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

    /* public void modificaStatus(int id) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE peca SET serstatus = 'I' WHERE serid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();

        } catch (Exception e) {

        }
    } 
     
        public void retornaStatus(int id) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE peca SET serstatus = 'A' WHERE serid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();

        } catch (Exception e) {

        }
    } */
    public int retornaId(String nome) {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT serid FROM servico where serdesc = '" + nome + "'";

        Servico servico = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                servico = new Servico();

                servico.setSerid(rs.getInt("serid"));

            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }
        return servico.getSerid();
    }

    public int contador() {

        conn = ConnectionFactory.getConexao();
        int cont = 0;

        sql = "SELECT count(serdesc) as cont from servico where serstatus = 'A'";

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                cont = rs.getInt("cont");

            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }
        return cont;
    }

}
