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

import model.Estagio;
import model.Questionario;

/**
 *
 * @author Pedro
 */
public class ManterQuestionarioController extends HttpServlet {

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
            if(request.getParameter("codEstagio")!= null){
                int codestagio = Integer.parseInt(request.getParameter("codEstagio"));
                request.setAttribute("codestagio", codestagio);
            }
            
            request.setAttribute("operacao", operacao);
            
            request.setAttribute("estagios", Estagio.obterEstagios());

           //request.setAttribute("professores", Professor.obterProfessores()); Somente para chaves estrangeiras
            if (!operacao.equals("Incluir")) {
                int codQuestionario = Integer.parseInt(request.getParameter("codQuestionario"));
                Questionario questionario = Questionario.obterQuestionario(codQuestionario);
                request.setAttribute("questionario", questionario);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterQuestionario.jsp");
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
 
        int codigo = Integer.parseInt(request.getParameter("txtCodQuest"));
        int frequencia = Integer.parseInt(request.getParameter("txtFreqQuest"));
        int dedicacao = Integer.parseInt(request.getParameter("txtDedQuest"));
        int interesse = Integer.parseInt(request.getParameter("txtIntQuest"));
        int avaliacaogeral = Integer.parseInt(request.getParameter("txtAvalQuest"));
        int codestagio= Integer.parseInt(request.getParameter("optCodEstagio"));
     
        try {
            
            Estagio estagio = null;
            if (codestagio != 0) {
                estagio= Estagio.obterEstagio(codestagio);
            }
            
            Questionario questionario = new Questionario(codigo,  frequencia,  dedicacao,  interesse, avaliacaogeral,  estagio);
            if (operacao.equals("Incluir")) {
                questionario.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    questionario.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        questionario.excluir();
                    }
                }
            }
            RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisaQuestionarioController");
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
