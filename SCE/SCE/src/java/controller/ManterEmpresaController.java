/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;

/**
 *
 * @author Pedro
 */
public class ManterEmpresaController extends HttpServlet {

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
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
           //request.setAttribute("professores", Professor.obterProfessores()); Somente para chaves estrangeiras
            if (!operacao.equals("Incluir")) {
                int codEmpresa = Integer.parseInt(request.getParameter("codEmpresa"));
                Empresa empresa = Empresa.obterEmpresa(codEmpresa);
                request.setAttribute("empresa", empresa);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterEmpresa.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
      public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        int codEmpresa = Integer.parseInt(request.getParameter("txtCodEmpresa"));
        String nome = request.getParameter("txtNomEmpresa");
        String telefone = request.getParameter("txtTelEmpresa");
        String cnpj = request.getParameter("txtCNPJEmpresa");
        String logradouro = request.getParameter("txtLogEndEmpresa");
        String numero = request.getParameter("txtNumEndEmpresa");
        String complemento = request.getParameter("txtCompEndEmpresa");
        String bairro = request.getParameter("txtBairroEndEmpresa");
        String cidade = request.getParameter("txtCidEndEmpresa");
        String uf = request.getParameter("txtUfEndEmpresa");
        
      
        try {
           /* Professor professor = null;
            if (coordenador != 0) {
                professor = Professor.obterProfessor(coordenador);
            }*/
            Empresa empresa = new Empresa(codEmpresa, nome, telefone,  logradouro, numero, complemento, bairro, cidade, uf, cnpj);
            if (operacao.equals("Incluir")) {
                empresa.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    empresa.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        empresa.excluir();
                    }
                }
            }
            RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisaEmpresaController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
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
