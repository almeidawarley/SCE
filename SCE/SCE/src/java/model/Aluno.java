/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.AlunoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Aluno extends Pessoa{

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private Curso curso;
    private int codCurso;

    public Aluno(int codigo, String logradouro, String numero, String complemento, String bairro, String cidade, String uf, Curso curso, String nome, String telefone) {
        super(codigo, nome, telefone);
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
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
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() throws ClassNotFoundException, SQLException {
        if (curso == null && codCurso != 0) {
            curso = Curso.obterCurso(codCurso);
        }
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
    
    public static Aluno obterAluno(int codAluno)
            throws ClassNotFoundException, SQLException{
        return AlunoDAO.obterAluno(codAluno);
    }
    
    public static List<Aluno> obterAlunos()
            throws ClassNotFoundException, SQLException {
        return AlunoDAO.obterAlunos();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        AlunoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AlunoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AlunoDAO.excluir(this);
    }

}