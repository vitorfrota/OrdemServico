/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgos.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sgos.model.beans.Avaliacao;
import sgos.model.beans.Cliente;
import sgos.model.beans.OrdemServico;
import sgos.model.beans.Tecnico;
import sgos.model.dao.AvaliacaoDAO;
import sgos.model.dao.ClienteDAO;
import sgos.model.dao.OrdemServicoDAO;
import sgos.model.dao.TecnicoDAO;

/**
 *
 * @author vitor_9g3eyo1
 */
@WebServlet(name = "ControllerOS", urlPatterns = {"/ControllerOS"})
public class ControllerOS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //////////////////////////////////////////

        OrdemServico os = new OrdemServico();
        OrdemServicoDAO odao = new OrdemServicoDAO();
        AvaliacaoDAO adao = new AvaliacaoDAO();
        ClienteDAO cdao = new ClienteDAO();
        TecnicoDAO tdao = new TecnicoDAO();
        ///////////////////////////////////////////
        int opcao = Integer.parseInt(request.getParameter("botao"));
        /////////////////////////////////////////////////////////////////////////////////////
        Avaliacao avaliacao = new Avaliacao();
        Cliente c = cdao.consultaNome(request.getParameter("cliente").toUpperCase());
        Tecnico t = tdao.consultaNome(request.getParameter("tecnico").toUpperCase());
        avaliacao.setAvacliid(c.getCliid()); // retorna o ID do cliente selecionado
        avaliacao.setAvatecid(t.getTecid()); // retorna o ID do tecnico selecionado
        ////////////////////////////////////////////////////////////////////////////////////
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = formato.parse(request.getParameter("txtdata"));
        } catch (ParseException ex) {
            Logger.getLogger(ControllerOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////////
        os.setOsdescaparelho(request.getParameter("txtdesc"));
        os.setOsdefeito(request.getParameter("txtdefeito"));
        os.setOsdataconclusao(data); // data convertida
        /////////////////////////////////////////////////////////////////////////////////////
        switch (opcao) {
            case 1:
                os.setOssituacao("ABERTO"); // SITUAÇÃO DA ORDEM DE SERVIÇO TODA VEZ QUE FOR ABERTA
                odao.salvar(os);
                break;
            default:
                break;
        }
        ////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////// // pega o id da ultima OS cadastrada
        avaliacao.setAvaosid(odao.consultaUltimoID());
        adao.salvar(avaliacao); /////////////////////////////////////////////////////////////////////////////////////

        response.sendRedirect("os/Ordens.jsp");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
