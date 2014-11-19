/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.QuestionarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Questionario {
    private int codigo;
    private int frequencia;
    private int dedicacao;
    private int interesse;
    private int avaliacaoGeral;
    private Estagio estagio;
    private int codEstagio;

    public Questionario(int codigo,int frequencia, int dedicacao, int interesse, int avaliacaoGeral, Estagio estagio) {
        this.codigo=codigo;
        this.frequencia = frequencia;
        this.dedicacao = dedicacao;
        this.interesse = interesse;
        this.avaliacaoGeral = avaliacaoGeral;
        this.estagio = estagio;
    }

    /**
     * @return the frequencia
     */
    public int getFrequencia() {
        return frequencia;
    }

    /**
     * @param frequencia the frequencia to set
     */
    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    /**
     * @return the dedicacao
     */
    public int getDedicacao() {
        return dedicacao;
    }

    /**
     * @param dedicacao the dedicacao to set
     */
    public void setDedicacao(int dedicacao) {
        this.dedicacao = dedicacao;
    }

    /**
     * @return the interesse
     */
    public int getInteresse() {
        return interesse;
    }

    /**
     * @param interesse the interesse to set
     */
    public void setInteresse(int interesse) {
        this.interesse = interesse;
    }

    /**
     * @return the avaliacaoGeral
     */
    public int getAvaliacaoGeral() {
        return avaliacaoGeral;
    }

    /**
     * @param avaliacaoGeral the avaliacaoGeral to set
     */
    public void setAvaliacaoGeral(int avaliacaoGeral) {
        this.avaliacaoGeral = avaliacaoGeral;
    }

    /**
     * @return the estagio
     */
    public Estagio getEstagio() {
        return estagio;
    }

    /**
     * @param estagio the estagio to set
     */
    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
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
     * @return the codEstagio
     */
    public int getCodEstagio() {
        return codEstagio;
    }

    /**
     * @param codEstagio the codEstagio to set
     */
    public void setCodEstagio(int codEstagio) {
        this.codEstagio = codEstagio;
    }
    
     public void gravar() throws SQLException, ClassNotFoundException {
        QuestionarioDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        QuestionarioDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        QuestionarioDAO.excluir(this);
    }
    
    public static Questionario obterQuestionario(int codQuestionario)
            throws ClassNotFoundException, SQLException{
        return QuestionarioDAO.obterQuestionario(codQuestionario);
    }
    
    public static List<Questionario> obterQuestionarios()
            throws ClassNotFoundException, SQLException {
        return QuestionarioDAO.obterQuestionarios();
    }
}
