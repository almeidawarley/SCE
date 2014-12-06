/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.CursoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Curso { 
    private int codigo;
    private String nome;
    private int cargaHoraria;
    private int obrigatoriedade;

    public Curso(int codigo, int cargaHoraria, int obrigatoriedade,String nome) {
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.obrigatoriedade = obrigatoriedade;
        this.nome=nome;
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
     * @return the obrigatoriedade
     */
    public int getObrigatoriedade() {
        return obrigatoriedade;
    }

    /**
     * @param obrigatoriedade the obrigatoriedade to set
     */
    public void setObrigatoriedade(int obrigatoriedade) {
        this.obrigatoriedade = obrigatoriedade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        CursoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        CursoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        CursoDAO.excluir(this);
    }
    
    public static Curso obterCurso(int codCurso)
            throws ClassNotFoundException, SQLException{
        return CursoDAO.obterCurso(codCurso);
    }
    
    public static List<Curso> obterCursos()
            throws ClassNotFoundException, SQLException {
        return CursoDAO.obterCursos();
    }
    
}
