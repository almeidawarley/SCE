/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import dao.VagaDAO;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Aluno
 */
public class Vaga {
    private int codigo;
    private Curso curso;
    private Empresa empresa; 
    private int preenchido;
    private int codCurso;
    private int codEmpresa;

    public Vaga(int codigo, Curso curso, Empresa empresa, int preenchido) {
        this.codigo = codigo;
        this.curso = curso;
        this.empresa = empresa;
        this.preenchido = preenchido;
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
     * @return the preenchido
     */
    public int getPreenchido() {
        return preenchido;
    }

    /**
     * @param preenchido the preenchido to set
     */
    public void setPreenchido(int preenchido) {
        this.preenchido = preenchido;
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
    
    public static Vaga obterVaga(int codVaga)
            throws ClassNotFoundException, SQLException{
        return VagaDAO.obterVaga(codVaga);
    }
    
    public static List<Vaga> obterVagas()
            throws ClassNotFoundException, SQLException {
        return VagaDAO.obterVagas();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        VagaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        VagaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        VagaDAO.excluir(this);
    }
    
    
}
