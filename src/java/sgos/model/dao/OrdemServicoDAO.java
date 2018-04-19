/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgos.model.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sgos.model.beans.OrdemServico;
import sgos.model.connection.ConnectionFactory;

/**
 *
 * @author vitor_9g3eyo1
 */
public class OrdemServicoDAO {

    java.util.Date date = new java.util.Date();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void salvar(OrdemServico os) {
        conn = ConnectionFactory.getConexao();

        sql = "insert into ordemservico(ossituacao,osdefeito, osdesc_aparelho, osdata_abertura, osdata_conclusao) values (?,?,?,?,?) ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, os.getOssituacao());
            ps.setString(2, os.getOsdefeito());
            ps.setString(3, os.getOsdescaparelho());
            ps.setTimestamp(4, new java.sql.Timestamp(date.getTime())); // pega data e hora atual
            ps.setDate(5, new java.sql.Date(os.getOsdataconclusao().getTime()));
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso !!");
            ps.close();
        } catch (HeadlessException | SQLException e) {
            System.out.println("Erro no salvar -> " + e.getMessage());
        }

    } // fim do método salvar

    public void alterar(OrdemServico os) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE ORDEMSERVICO SET osdesc_aparelho = ?, osdefeito = ? WHERE osid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, os.getOsdescaparelho());
            ps.setString(2, os.getOsdefeito());
            ps.setInt(3, os.getOsid());

            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }
    //OK

    public List<OrdemServico> listarOrdens() {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM ordemservico where ossituacao = 'ABERTO' order by osid desc";

        List<OrdemServico> lista = new ArrayList<OrdemServico>();

        OrdemServico os = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                os = new OrdemServico();

                os.setOsid(rs.getInt("osid"));
                os.setOsdataabertura(rs.getDate("osdata_abertura"));
                os.setOssituacao(rs.getString("ossituacao"));
                os.setOsdescaparelho(rs.getString("osdesc_aparelho"));
                os.setOsdefeito(rs.getString("osdefeito"));

                lista.add(os);
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }
        return lista;
    }

    public List<OrdemServico> relatorio() {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM ordemservico where ossituacao != 'ABERTO' order by osdata_abertura desc";

        List<OrdemServico> lista = new ArrayList<OrdemServico>();

        OrdemServico os = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                os = new OrdemServico();

                os.setOsid(rs.getInt("osid"));
                os.setOsdataabertura(rs.getDate("osdata_abertura"));
                os.setOssituacao(rs.getString("ossituacao"));
                os.setOsdescaparelho(rs.getString("osdesc_aparelho"));
                os.setOsdefeito(rs.getString("osdefeito"));
                os.setOsvalor(rs.getDouble("osvalor"));

                lista.add(os);
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }
        return lista;
    }

    public int consultaUltimoID() {
        int id = 0;

        conn = ConnectionFactory.getConexao();

        sql = "SELECT MAX(osid) as ultimo FROM ordemservico";

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("ultimo");
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return id;
    }

    public OrdemServico consulta(int codigo) {
        conn = ConnectionFactory.getConexao();

        sql = "SELECT * FROM ordemservico where osid = " + codigo + "";

        OrdemServico os = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                os = new OrdemServico();

                os.setOsid(rs.getInt("osid"));
                os.setOssituacao(rs.getString("ossituacao"));
                os.setOsdefeito(rs.getString("osdefeito"));
                os.setOsdescaparelho(rs.getString("osdesc_aparelho"));
                os.setOsvalor(rs.getDouble("osvalor"));
                os.setOslaudo(rs.getString("oslaudo"));
                os.setOsdataabertura(rs.getDate("osdata_abertura"));
                os.setOsdataconclusao(rs.getDate("osdata_conclusao"));
                os.setOsdataentrega(rs.getDate("osdata_entrega"));
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return os;

    }

    public void FecharOS(OrdemServico os) {
        conn = ConnectionFactory.getConexao();
        String sql = "UPDATE ORDEMSERVICO SET ossituacao = ?, osvalor = ?, oslaudo = ?, osdata_entrega = ? WHERE osid = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, os.getOssituacao());
            ps.setDouble(2, os.getOsvalor());
            ps.setString(3, os.getOslaudo());
            ps.setTimestamp(4, new java.sql.Timestamp(date.getTime())); // pega data e hora atual
            ps.setInt(5, os.getOsid());
            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }

    public Double calculatotal(int id) { // METODO PARA CONSULTAR TABELA ITEMPECA E ITEMSERVICO CALCULANDO O VALOR TOTAL

        Double total, totalpeca, totalservico = null;

        ItemPecaDAO idao = new ItemPecaDAO();
        ItemServicoDAO isdao = new ItemServicoDAO();

        totalpeca = idao.calculaTotal(id); // CALCULAR TOTAL PEÇAS
        totalservico = isdao.calculaTotal(id); // CALCULAR TOTAL SERVIÇOS

        total = totalpeca + totalservico; // SOMA PEÇAS + SERVIÇOS

        return total;
    }

    public Double somatotal() { // METODO PARA CALCULAR SOMA DOS VALORES DAS O.S FECHADAS

        conn = ConnectionFactory.getConexao();
        Double total = null;

        sql = "SELECT sum(osvalor) as cont from ordemservico where ossituacao = 'FECHADO'";

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                total = rs.getDouble("cont");

            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro na Consulta !!" + e.getMessage());
        }

        return total;
    }

    public int contador() {

        conn = ConnectionFactory.getConexao();
        int cont = 0;

        sql = "SELECT count(ossituacao) as cont from ordemservico where ossituacao = 'ABERTO'";

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
