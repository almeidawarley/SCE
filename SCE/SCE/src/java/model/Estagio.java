/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.EstagioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Estagio {
    private int codigo;
    private int cargaHoraria;
    private String descricao;
    private float remuneracao;
    private String dataInicio;
    private String dataTermino;
    private OrientadorInstituicao orientadorInstituicao; 
    private Empresa empresa;
    private OrientadorEmpresa orientadorEmpresa;
    private Aluno aluno;
    private int codOrientadorInstituicao;
    private int codEmpresa;
    private int codOrientadorEmpresa;
    private int codAluno;

    public Estagio(int codigo, int cargaHoraria, String descricao, float remuneracao, String dataInicio, String dataTermino, OrientadorInstituicao orientadorInstituicao, Empresa empresa, OrientadorEmpresa orientadorEmpresa, Aluno aluno) {
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
        this.remuneracao = remuneracao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.orientadorInstituicao = orientadorInstituicao;
        this.empresa = empresa;
        this.orientadorEmpresa = orientadorEmpresa;
        this.aluno = aluno;
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
     * @return the cargaHoraria
     */
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the remuneracao
     */
    public float getRemuneracao() {
        return remuneracao;
    }

    /**
     * @param remuneracao the remuneracao to set
     */
    public void setRemuneracao(float remuneracao) {
        this.remuneracao = remuneracao;
    }

    /**
     * @return the dataInicio
     */
    public String getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public String getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * @return the orientadorInstituicao
     */
    public OrientadorInstituicao getOrientadorInstituicao() {
        return orientadorInstituicao;
    }

    /**
     * @param orientadorInstituicao the orientadorInstituicao to set
     */
    public void setOrientadorInstituicao(OrientadorInstituicao orientadorInstituicao) {
        this.orientadorInstituicao = orientadorInstituicao;
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
     * @return the orientadorEmpresa
     */
    public OrientadorEmpresa getOrientadorEmpresa() {
        return orientadorEmpresa;
    }

    /**
     * @param orientadorEmpresa the orientadorEmpresa to set
     */
    public void setOrientadorEmpresa(OrientadorEmpresa orientadorEmpresa) {
        this.orientadorEmpresa = orientadorEmpresa;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the codOrientadorInstituicao
     */
    public int getCodOrientadorInstituicao() {
        return codOrientadorInstituicao;
    }

    /**
     * @param codOrientadorInstituicao the codOrientadorInstituicao to set
     */
    public void setCodOrientadorInstituicao(int codOrientadorInstituicao) {
        this.codOrientadorInstituicao = codOrientadorInstituicao;
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

    /**
     * @return the codOrientadorEmpresa
     */
    public int getCodOrientadorEmpresa() {
        return codOrientadorEmpresa;
    }

    /**
     * @param codOrientadorEmpresa the codOrientadorEmpresa to set
     */
    public void setCodOrientadorEmpresa(int codOrientadorEmpresa) {
        this.codOrientadorEmpresa = codOrientadorEmpresa;
    }

    /**
     * @return the codAluno
     */
    public int getCodAluno() {
        return codAluno;
    }

    /**
     * @param codAluno the codAluno to set
     */
    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }
    
    public static Estagio obterEstagio(int codEstagio)
            throws ClassNotFoundException, SQLException{
        return EstagioDAO.obterEstagio(codEstagio);
    }
    
    public static List<Estagio> obterEstagios()
            throws ClassNotFoundException, SQLException {
        return EstagioDAO.obterEstagios();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        EstagioDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        EstagioDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        EstagioDAO.excluir(this);
    }

}
 