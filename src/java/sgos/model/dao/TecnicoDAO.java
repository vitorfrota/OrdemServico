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
import sgos.model.beans.Tecnico;
import sgos.model.connection.ConnectionFactory;

/**
 *
 * @author vitor_9g3eyo1
 */
public class TecnicoDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void salvar(Tecnico tecnico) {
        conn = ConnectionFactory.getConexao();

        sql = "insert into tecnico(tecnome,tecfone,tecemail) values (?,?,?) ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tecnico.getTecnome());
            ps.setString(2, tecnico.getTecfone());
            ps.setString(3, tecnico.getTecemail());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso !!");
        } catch (Exception e) {
            System.out.println("Erro no salvar -> " + e.getMessage());
        }

    } // fim do método salvar

    public void alterar(Tecnico tecnico) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE tecnico SET tecnome = ?, tecemail = ?, tecfone = ? WHERE tecid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, tecnico.getTecnome());
            ps.setString(2, tecnico.getTecemail());
            ps.setString(3, tecnico.getTecfone());
            ps.setInt(4, tecnico.getTecid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    //OK
    public List<Tecnico> listarTecnicos() {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM tecnico order by tecnome;";

        List<Tecnico> lista = new ArrayList<Tecnico>();

        Tecnico tecnico = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                tecnico = new Tecnico();

                tecnico.setTecid(rs.getInt("tecid"));
                tecnico.setTecnome(rs.getString("tecnome"));
                tecnico.setTecfone(rs.getString("tecfone"));
                tecnico.setTecemail(rs.getString("tecemail"));

                lista.add(tecnico);
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }
        return lista;
    }

    public Tecnico consulta(int codigo) {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM tecnico where tecid = " + codigo + "";

        Tecnico tecnico = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                tecnico = new Tecnico();

                tecnico.setTecid(rs.getInt("tecid"));
                tecnico.setTecnome(rs.getString("tecnome"));
                tecnico.setTecfone(rs.getString("tecfone"));
                tecnico.setTecemail(rs.getString("tecemail"));

            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return tecnico;

    }

    public Tecnico consultaNome(String nome) {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM tecnico where tecnome = '" + nome + "'";

        Tecnico tecnico = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                tecnico = new Tecnico();

                tecnico.setTecid(rs.getInt("tecid"));
                tecnico.setTecnome(rs.getString("tecnome"));
                tecnico.setTecfone(rs.getString("tecfone"));
                tecnico.setTecemail(rs.getString("tecemail"));

            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return tecnico;

    }

    public void excluir(Tecnico tecnico) {
        conn = ConnectionFactory.getConexao();
        String sql = "DELETE FROM tecnico WHERE tecid = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, tecnico.getTecid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    public int contador() {

        conn = ConnectionFactory.getConexao();
        int cont = 0;

        sql = "SELECT count(tecnome) as cont from tecnico ";

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
