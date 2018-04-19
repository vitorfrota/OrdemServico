/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sgos.model.beans.ItemPeca;
import sgos.model.dao.ItemPecaDAO;
import sgos.model.dao.PecaDAO;

/**
 *
 * @author vitor_9g3eyo1
 */
@WebServlet(name = "AddPeca", urlPatterns = {"/AddPeca"})
public class AddPeca extends HttpServlet {

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

        ItemPeca i = new ItemPeca();
        ItemPecaDAO idao = new ItemPecaDAO();
        PecaDAO pdao = new PecaDAO();

        int opcao = Integer.parseInt(request.getParameter("botao"));

        switch (opcao) {
            case 1:
                i.setIteosid(Integer.parseInt(request.getParameter("osid")));
                i.setItepecid(pdao.retornaId(request.getParameter("peca")));

                idao.adicionar(i);

                break;

            default:
                i.setIteosid(Integer.parseInt(request.getParameter("osid")));
                i.setItepecid(Integer.parseInt(request.getParameter("botao")));
                idao.remover(i);
                break;

        }

        response.sendRedirect("os/FecharOS.jsp?codigo=" + i.getIteosid());
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
