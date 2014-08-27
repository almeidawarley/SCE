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
import model.Aluno;
import model.Curso;


/**
 *
 * @author Marco
 */
public class ManterAlunoController extends HttpServlet {

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
                int codAluno = Integer.parseInt(request.getParameter("codAluno"));
                Aluno aluno = Aluno.obterAluno(codAluno);
                request.setAttribute("aluno", aluno);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
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
        int codAluno = Integer.parseInt(request.getParameter("txtCodAluno"));
        String logradouro = request.getParameter("txtLogEndAluno");
        String numero = request.getParameter("txtNumEndAluno");
        String complemento = request.getParameter("txtCompEndAluno");
        String bairro = request.getParameter("txtBairroEndAluno");
        String cidade = request.getParameter("txtCidEndAluno");
        String uf = request.getParameter("txtUfEndAluno");
        String nome = request.getParameter("txtNomAluno");
        String telefone = request.getParameter("txtTelAluno");
        int codcurso = Integer.parseInt(request.getParameter("optCodCurso"));
     
        try {
            Curso curso = null;
            if (codcurso != 0) {
                curso = Curso.obterCurso(codcurso);
            }
            Aluno aluno = new Aluno(codAluno,logradouro,numero,complemento,bairro,cidade,uf,curso,nome,telefone);
            if (operacao.equals("Incluir")) {
                aluno.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    aluno.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        aluno.excluir();
                    }
                }
            }
            RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisaAlunoController");
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
