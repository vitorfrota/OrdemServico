/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
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
public class FecharOS extends HttpServlet {

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

        Avaliacao avaliacao = new Avaliacao();
        AvaliacaoDAO adao = new AvaliacaoDAO();
        ClienteDAO cdao = new ClienteDAO();
        TecnicoDAO tdao = new TecnicoDAO();
        OrdemServico os = new OrdemServico();
        OrdemServicoDAO odao = new OrdemServicoDAO();

        int opcao = Integer.parseInt(request.getParameter("botao"));
        os.setOsid(Integer.parseInt(request.getParameter("id")));

        switch (opcao) {
            case 1: // ALTERAR OS
                os.setOsdefeito(request.getParameter("txtdefeito"));
                os.setOsdescaparelho(request.getParameter("txtdesc"));
              
                odao.alterar(os);
                /////////////////////////////////////////////////////
                avaliacao.setAvaosid(os.getOsid());
                Cliente c = cdao.consultaNome(request.getParameter("cliente").toUpperCase());
                Tecnico t = tdao.consultaNome(request.getParameter("tecnico").toUpperCase());
                avaliacao.setAvacliid(c.getCliid());
                avaliacao.setAvatecid(t.getTecid());
                adao.atualiza(avaliacao); // ATUALIZA NA TABELA AVALIACAO
                ///////////////////////////////////////////////////////////
                break;

            case 2: // FECHAR OS
                os.setOslaudo(request.getParameter("txtlaudo"));
                os.setOssituacao(request.getParameter("situacao"));
                os.setOsvalor(odao.calculatotal(os.getOsid()));
                odao.FecharOS(os);
                break;
        }

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
