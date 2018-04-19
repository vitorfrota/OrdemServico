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
import sgos.model.beans.Cliente;
import sgos.model.dao.ClienteDAO;

/**
 *
 * @author vitor_9g3eyo1
 */
@WebServlet(name = "ControllerCliente", urlPatterns = {"/ControllerCliente"})
public class ControllerCliente extends HttpServlet {

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

        Cliente cliente = new Cliente();
        ClienteDAO cdao = new ClienteDAO();

        int opcao = Integer.parseInt(request.getParameter("botao")); // salvar, alterar, excluir

        cliente.setClinome(request.getParameter("txtnome"));
        cliente.setClicpf(request.getParameter("txtcpf"));
        cliente.setCliemail(request.getParameter("txtemail"));
        cliente.setClifone(request.getParameter("txtfone"));

        switch (opcao) {
            case 1:

                cdao.salvar(cliente);
                break;
            case 2:
                cliente.setCliid(Integer.parseInt(request.getParameter("txtid")));
                cdao.alterar(cliente);
                break;
            case 3:
                cliente.setCliid(Integer.parseInt(request.getParameter("txtid")));
                cdao.excluir(cliente);
                break;
        }

        response.sendRedirect("cliente/Clientes.jsp");
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
