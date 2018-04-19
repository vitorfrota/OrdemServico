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
import sgos.model.beans.Peca;
import sgos.model.connection.ConnectionFactory;

/**
 *
 * @author vitor_9g3eyo1
 */
public class PecaDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void salvar(Peca peca) {
        conn = ConnectionFactory.getConexao();

        sql = "insert into peca(pecdesc,pecvalor, pecstatus) values (?,?,?) ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, peca.getPecdesc());
            ps.setDouble(2, peca.getPecvalor());
            ps.setString(3, peca.getPecstatus());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso !!");

        } catch (Exception e) {
            System.out.println("Erro no salvar -> " + e.getMessage());
        }

    } // fim do método salvar

    public void alterar(Peca peca) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE peca SET pecdesc = ?, pecvalor = ? WHERE pecid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, peca.getPecdesc());
            ps.setDouble(2, peca.getPecvalor());
            ps.setInt(3, peca.getPecid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    public void excluir(Peca peca) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE peca SET pecstatus = 'I' WHERE pecid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, peca.getPecid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    public void modificaStatus(int id) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE peca SET pecstatus = 'I' WHERE pecid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    public void retornaStatus(int id) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE peca SET pecstatus = 'A' WHERE pecid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    public Peca consulta(int codigo) {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM peca where pecid = " + codigo + "";

        Peca peca = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                peca = new Peca();

                peca.setPecid(rs.getInt("pecid"));
                peca.setPecdesc(rs.getString("pecdesc"));
                peca.setPecvalor(rs.getDouble("pecvalor"));

            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return peca;
    }

    public List<Peca> listarPecas() {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM peca where pecstatus = 'A' order by pecdesc;";

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

    public int retornaId(String nome) {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT pecid FROM peca where pecdesc = '" + nome + "' and pecstatus = 'A'";

        Peca peca = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                peca = new Peca();

                peca.setPecid(rs.getInt("pecid"));

            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }
        return peca.getPecid();
    }

    public int contador() {

        conn = ConnectionFactory.getConexao();
        int cont = 0;

        sql = "SELECT count(pecdesc) as cont from peca where pecstatus = 'A'";

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
