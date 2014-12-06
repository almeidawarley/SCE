/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;
import model.OrientadorEmpresa;


/**
 *
 * @author Marco
 */
public class ManterOrientadorEmpresaController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            request.setAttribute("empresas", Empresa.obterEmpresas()); 
            if (!operacao.equals("Incluir")) {
                int codOrientadorEmpresa = Integer.parseInt(request.getParameter("codOriEmp"));
                OrientadorEmpresa orientadorempresa = OrientadorEmpresa.obterOrientadorEmpresa(codOrientadorEmpresa);
                request.setAttribute("orientadorempresa", orientadorempresa);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterOrientadorEmpresa.jsp");
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
        int codOrientadorEmpresa = Integer.parseInt(request.getParameter("txtCodOriEmp"));
         String profissao = request.getParameter("txtProfOriEmp");
        String nome = request.getParameter("txtNomOriEmp");
        String telefone = request.getParameter("txtTelOriEmp");
        int codEmpresa = Integer.parseInt(request.getParameter("optCodEmp"));
     
        try {
            Empresa empresa = null;
            if (codEmpresa != 0) {
                empresa = Empresa.obterEmpresa(codEmpresa);
            }
            OrientadorEmpresa orientadorempresa = new OrientadorEmpresa(codOrientadorEmpresa, profissao, empresa, nome, telefone);
            if (operacao.equals("Incluir")) {
                orientadorempresa.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    orientadorempresa.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        orientadorempresa.excluir();
                    }
                }
            }
            RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisaOrientadorEmpresaController");
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
