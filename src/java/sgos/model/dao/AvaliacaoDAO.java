/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import sgos.model.beans.Avaliacao;
import sgos.model.beans.OrdemServico;
import sgos.model.connection.ConnectionFactory;

/**
 *
 * @author vitor_9g3eyo1
 */
public class AvaliacaoDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void salvar(Avaliacao a) {
        conn = ConnectionFactory.getConexao();

        sql = "insert into avaliacao(avacliid,avatecid,avaosid) values (?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getAvacliid());
            ps.setInt(2, a.getAvatecid());
            ps.setInt(3, a.getAvaosid());

            ps.execute();
          

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso !!");
             ps.close();
        } catch (Exception e) {
            System.out.println("Erro no salvar -> " + e.getMessage());
        }
    } // fim do método salvar

    public String consultaNomeCliente(int id) { // método para retornar o nome do cliente da ordem
        String nomeCliente = "";
        Statement st = null;
        ResultSet rs = null;
        OrdemServico os = null;
        try {
            Connection conn = ConnectionFactory.getConexao();
            st = conn.createStatement();
            rs = st.executeQuery("select c.clinome AS NOME from avaliacao a inner join cliente c on c.cliid = a.avacliid where a.avaosid='" + id + "'");
            if (rs.next()) {
                nomeCliente = rs.getString("NOME");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na consulta!!!");
            e.printStackTrace();
        }
        return nomeCliente;
    }

    public String consultaNomeTecnico(int id) { // método para retornar nome do tecnico da ordem
        String nomeTecnico = "";
        Statement st = null;
        ResultSet rs = null;
        try {
            Connection conn = ConnectionFactory.getConexao();
            st = conn.createStatement();
            rs = st.executeQuery("select t.tecnome AS NOME from avaliacao a inner join tecnico t on t.tecid = a.avatecid where a.avaosid='" + id + "'");
            if (rs.next()) {
                nomeTecnico = rs.getString("NOME");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na consulta!!!");
            e.printStackTrace();
        }
        return nomeTecnico;
    }
    
    public void atualiza(Avaliacao a){
        
        conn = ConnectionFactory.getConexao();
         
         String sql = "UPDATE AVALIACAO SET AVACLIID = ?, AVATECID = ? WHERE AVAOSID = ?";
         
         try{
             ps = conn.prepareStatement(sql);
             
             ps.setInt(1, a.getAvacliid());
             ps.setInt(2, a.getAvatecid());
             ps.setInt(3, a.getAvaosid());
             ps.execute();
             
              ps.close();
         }catch(SQLException e){
             
         }
    }
}
