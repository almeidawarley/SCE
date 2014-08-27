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
import model.Estagio;
import model.OrientadorInstituicao;
import model.Empresa;
import model.OrientadorEmpresa;
import model.Aluno;
/**
 *
 * @author Marco
 */
public class ManterEstagioController extends HttpServlet {

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
            request.setAttribute("alunos", Aluno.obterAlunos());
            request.setAttribute("empresas", Empresa.obterEmpresas());
            request.setAttribute("orientadorempresas", OrientadorEmpresa.obterOrientadorEmpresas());
            request.setAttribute("orientadorinstituicaos", OrientadorInstituicao.obterOrientadorInstituicoes());

           //request.setAttribute("professores", Professor.obterProfessores()); Somente para chaves estrangeiras
            if (!operacao.equals("Incluir")) {
                int codEstagio = Integer.parseInt(request.getParameter("codEstagio"));
                Estagio estagio = Estagio.obterEstagio(codEstagio);
                request.setAttribute("estagio", estagio);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterEstagio.jsp");
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
 
        int codigo = Integer.parseInt(request.getParameter("txtCodEst"));
        int cargaHoraria = Integer.parseInt(request.getParameter("txtCHorariaEst"));
        String descricao = request.getParameter("txtDescEst");
        float remuneracao = Float.parseFloat(request.getParameter("txtRemEst"));
        String dataInicio = request.getParameter("txtDtInEst");
        String dataTermino = request.getParameter("txtDtTermEst");
        int codorientadorInstituicao = Integer.parseInt(request.getParameter("optCodOriInst"));
        int codempresa = Integer.parseInt(request.getParameter("optCodEmp"));
        int codorientadorEmpresa = Integer.parseInt(request.getParameter("optCodOriEmp"));
        int codaluno = Integer.parseInt(request.getParameter("optCodAluno"));
     
        try {
            OrientadorInstituicao orientadorInstituicao = null;
            if (codorientadorInstituicao != 0) {
                orientadorInstituicao = OrientadorInstituicao.obterOrientadorInstituicao(codorientadorInstituicao);
            }
            Empresa empresa = null;
            if (codempresa != 0) {
                empresa = Empresa.obterEmpresa(codempresa);
            }
            OrientadorEmpresa orientadorEmpresa = null;
            if (codorientadorEmpresa != 0) {
                orientadorEmpresa = OrientadorEmpresa.obterOrientadorEmpresa(codorientadorEmpresa);
            }
            Aluno aluno = null;
            if (codaluno != 0) {
                aluno = Aluno.obterAluno(codaluno);
            }
            Estagio estagio = new Estagio(codigo,  cargaHoraria,  descricao,  remuneracao, dataInicio,  dataTermino,  orientadorInstituicao, empresa, orientadorEmpresa, aluno);
            if (operacao.equals("Incluir")) {
                estagio.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    estagio.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        estagio.excluir();
                    }
                }
            }
            RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisaEstagioController");
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
