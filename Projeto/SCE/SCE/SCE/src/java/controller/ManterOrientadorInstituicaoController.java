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
import model.Curso;
import model.OrientadorInstituicao;


/**
 *
 * @author Marco
 */
public class ManterOrientadorInstituicaoController extends HttpServlet {

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
            request.setAttribute("cursos", Curso.obterCursos());
            if (!operacao.equals("Incluir")) {
                int codOrientadorInstituicao = Integer.parseInt(request.getParameter("codOriInst"));
                OrientadorInstituicao orientadorinstituicao = OrientadorInstituicao.obterOrientadorInstituicao(codOrientadorInstituicao);
                request.setAttribute("orientadorinstituicao", orientadorinstituicao);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterOrientadorInstituicao.jsp");
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
        int codOrientadorInstituicao = Integer.parseInt(request.getParameter("txtCodOriInst"));
        String nome = request.getParameter("txtNomOriInst");
        String telefone = request.getParameter("txtTelOriInst");
        int codcurso = Integer.parseInt(request.getParameter("optCodCurso"));

     
        try {
            Curso curso = null;
        
            if (codcurso != 0) {
                curso = Curso.obterCurso(codcurso);
            }
            OrientadorInstituicao orientadorinstituicao = new OrientadorInstituicao(codOrientadorInstituicao, curso, nome, telefone);
            if (operacao.equals("Incluir")) {
                orientadorinstituicao.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    orientadorinstituicao.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        orientadorinstituicao.excluir();
                    }
                }
            }
            RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisaOrientadorInstituicaoController");
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
