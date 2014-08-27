/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

/**
 *
 * @author Marco
 */
public class CursoDAO extends DAO {

    public static void gravar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tbCurso (codigo,  cargaHoraria, obrigatoriedade, nome)"
      
                    + " values (" + curso.getCodigo() + ",  " + curso.getCargaHoraria() + ", " + curso.getObrigatoriedade()+", '"+curso.getNome();
            stringSQL = stringSQL + "')";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tbCurso set "
                    + "cargaHoraria = " + curso.getCargaHoraria() + ", "
                    + "obrigatoriedade = " + curso.getObrigatoriedade()
                    + ", nome = '" +curso.getNome()+"'";

            stringSQL = stringSQL + " where codigo = " + curso.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tbCurso where codigo = "
                    + curso.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Curso obterCurso(int codCurso) throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Curso curso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tbCurso where codigo = " + codCurso);
            rs.first();
            curso = instanciarCurso(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return curso;
    } 

    public static List<Curso> obterCursos() 
            throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Curso> cursos = new ArrayList<Curso>();
        Curso curso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery
                    ("select * from tbCurso");
            while (rs.next()) {
                curso = instanciarCurso(rs);
                cursos.add(curso);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return cursos;
    }

    public static Curso instanciarCurso(ResultSet rs) throws SQLException {
        Curso curso = new Curso(rs.getInt("codigo"), rs.getInt("cargaHoraria"), rs.getInt("obrigatoriedade"),rs.getString("nome"));

        return curso;
    }

}
