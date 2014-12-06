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
import model.Curso;
import model.Empresa;
import model.Vaga;

/**
 *
 * @author Aluno
 */
public class ManterVagaController extends HttpServlet {

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
            request.setAttribute("cursos", Curso.obterCursos()); 
            request.setAttribute("empresas", Empresa.obterEmpresas()); 

            if (!operacao.equals("Incluir")) {
                int codVaga = Integer.parseInt(request.getParameter("codVaga"));
                Vaga vaga = Vaga.obterVaga(codVaga);
                request.setAttribute("vaga", vaga);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterVaga.jsp");
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
        int codVaga = Integer.parseInt(request.getParameter("txtCodVaga"));
        int preenchido = Integer.parseInt(request.getParameter("optPreen"));
        int codcurso = Integer.parseInt(request.getParameter("optCodCurso"));
        int codempresa = Integer.parseInt(request.getParameter("optCodEmp"));
     
        try {
            Curso curso = null;
            if (codcurso != 0) {
                curso = Curso.obterCurso(codcurso);
            }
            
            Empresa empresa = null;
            if (codempresa != 0) {
                empresa = Empresa.obterEmpresa(codempresa);
            }
            Vaga vaga = new Vaga(codVaga, curso, empresa, preenchido);
            if (operacao.equals("Incluir")) {
                vaga.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    vaga.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        vaga.excluir();
                    }
                }
            }
            RequestDispatcher view = 
                    request.getRequestDispatcher("index.jsp");
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