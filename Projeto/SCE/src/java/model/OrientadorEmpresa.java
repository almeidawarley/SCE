/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.AlunoDAO;
import dao.OrientadorEmpresaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class OrientadorEmpresa extends Pessoa{

    private String profissao;
    private Empresa empresa;
    private int codEmpresa;

    public OrientadorEmpresa(int codigo, String profissao, Empresa empresa, String nome, String telefone) {
        super(codigo, nome, telefone);
        this.profissao = profissao;
        this.empresa = empresa;
    }

 


    /**
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @param profissao the profissao to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the codEmpresa
     */
    public int getCodEmpresa() {
        return codEmpresa;
    }

    /**
     * @param codEmpresa the codEmpresa to set
     */
    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
    
    public static OrientadorEmpresa obterOrientadorEmpresa(int codOrientadorEmpresa)
            throws ClassNotFoundException, SQLException{
        return OrientadorEmpresaDAO.obterOrientadorEmpresa(codOrientadorEmpresa);
    }
    
    public static List<OrientadorEmpresa> obterOrientadorEmpresas()
            throws ClassNotFoundException, SQLException {
        return OrientadorEmpresaDAO.obterOrientadorEmpresas();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        OrientadorEmpresaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        OrientadorEmpresaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        OrientadorEmpresaDAO.excluir(this);
    }
}
