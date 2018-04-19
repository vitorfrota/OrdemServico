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
import sgos.model.beans.Cliente;
import sgos.model.connection.ConnectionFactory;

/**
 *
 * @author vitor_9g3eyo1
 */
public class ClienteDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void salvar(Cliente cliente) {
        conn = ConnectionFactory.getConexao();

        sql = "insert into cliente(clinome,clicpf,clifone,cliemail) values (?,?,?,?) ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getClinome());
            ps.setString(2, cliente.getClicpf());
            ps.setString(3, cliente.getClifone());
            ps.setString(4, cliente.getCliemail());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso !!");
        } catch (Exception e) {
            System.out.println("Erro no salvar -> " + e.getMessage());
        }

    } // fim do método salvar

    public void alterar(Cliente cliente) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE cliente SET clinome = ?, clicpf = ?, cliemail = ?, clifone = ? WHERE cliid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, cliente.getClinome());
            ps.setString(2, cliente.getClicpf());
            ps.setString(3, cliente.getCliemail());
            ps.setString(4, cliente.getClifone());
            ps.setInt(5, cliente.getCliid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }
    //OK

    public void excluir(Cliente cliente) {
        conn = ConnectionFactory.getConexao();
        String sql = "DELETE FROM cliente WHERE cliid = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, cliente.getCliid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    public Cliente consulta(int codigo) {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM cliente where cliid = " + codigo + "";

        Cliente cliente = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                cliente = new Cliente();

                cliente.setCliid(rs.getInt("cliid"));
                cliente.setClinome(rs.getString("clinome"));
                cliente.setClicpf(rs.getString("clicpf"));
                cliente.setClifone(rs.getString("clifone"));
                cliente.setCliemail(rs.getString("cliemail"));

            }
            ps.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return cliente;

    }

    public List<Cliente> listarClientes() {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM cliente order by clinome;";

        List<Cliente> lista = new ArrayList<Cliente>();

        Cliente cliente = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                cliente = new Cliente();

                cliente.setCliid(rs.getInt("cliid"));
                cliente.setClinome(rs.getString("clinome"));
                cliente.setClicpf(rs.getString("clicpf"));
                cliente.setClifone(rs.getString("clifone"));
                cliente.setCliemail(rs.getString("cliemail"));

                lista.add(cliente);
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }
        return lista;
    }

    public Cliente consultaNome(String nome) {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM cliente where clinome = '" + nome + "'";

        Cliente cliente = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                cliente = new Cliente();

                cliente.setCliid(rs.getInt("cliid"));
                cliente.setClinome(rs.getString("clinome"));
                cliente.setClicpf(rs.getString("clicpf"));
                cliente.setClifone(rs.getString("clifone"));
                cliente.setCliemail(rs.getString("cliemail"));
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return cliente;
    }

    public int contador() {

        conn = ConnectionFactory.getConexao();
        int cont = 0;

        sql = "SELECT count(clinome) as cont from cliente";

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
