/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.OrientadorInstituicaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class OrientadorInstituicao extends Pessoa{

    private Curso curso;
    private int codCurso;

    public OrientadorInstituicao(int codigo, Curso curso, String nome, String telefone) {
        super(codigo, nome, telefone);
        this.curso = curso;
    }

 

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the codCurso
     */
    public int getCodCurso() {
        return codCurso;
    }

    /**
     * @param codCurso the codCurso to set
     */
    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }
    
    public static OrientadorInstituicao obterOrientadorInstituicao(int codOrientadorInstituicao)
            throws ClassNotFoundException, SQLException{
        return OrientadorInstituicaoDAO.obterOrientadorInstituicao(codOrientadorInstituicao);
    }
    
    public static List<OrientadorInstituicao> obterOrientadorInstituicoes()
            throws ClassNotFoundException, SQLException {
        return OrientadorInstituicaoDAO.obterOrientadorInstituicoes();
    }
    public void gravar() throws SQLException, ClassNotFoundException {
        OrientadorInstituicaoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        OrientadorInstituicaoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        OrientadorInstituicaoDAO.excluir(this);
    }
    
}
