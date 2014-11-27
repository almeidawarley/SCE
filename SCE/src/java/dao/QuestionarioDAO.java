/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Questionario;

/**
 *
 * @author Marco
 */
public class QuestionarioDAO extends DAO {

    public static void gravar(Questionario questionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tbQuestionario (codigo,frequencia,dedicacao,interesse,avaliacaoGeral,tbEstagio_codigo)"
      
                    + " values (" + questionario.getCodigo()+ ",  " + questionario.getFrequencia() + ", " + questionario.getDedicacao()
                    + ", " + questionario.getInteresse()+ ",  " + questionario.getAvaliacaoGeral()+ ",  " ;
           if (questionario.getEstagio() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + questionario.getEstagio().getCodigo();
            }
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Questionario questionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tbQuestionario set "
                    + "frequencia = " + questionario.getFrequencia()+ ", "
                    + "dedicacao = " + questionario.getDedicacao() + ", "
                    + "interesse = " + questionario.getInteresse() + ", "
                    + "avaliacaoGeral = " + questionario.getAvaliacaoGeral() + ", " 
                    + "tbEstagio_Codigo = ";
            if (questionario.getEstagio() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + questionario.getEstagio().getCodigo();
            }
            stringSQL = stringSQL + " where codigo = " + questionario.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Questionario questionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tbQuestionario where codigo = "
                    + questionario.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Questionario obterQuestionario(int codQuestionario) throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Questionario questionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tbQuestionario where codigo = " + codQuestionario);
            rs.first();
           questionario = instanciarQuestionario(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return questionario;
    } 

    public static List<Questionario> obterQuestionarios() 
            throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Questionario> questionarios = new ArrayList<Questionario>();
        Questionario questionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery
                    ("select * from tbQuestionario");
            while (rs.next()) {
                questionario = instanciarQuestionario(rs);
                questionarios.add(questionario);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return questionarios;
    }

    public static Questionario instanciarQuestionario(ResultSet rs) throws SQLException {
        Questionario questionario = new Questionario(rs.getInt("codigo"), rs.getInt("frequencia"),
                rs.getInt("dedicacao"),rs.getInt("interesse"),rs.getInt("avaliacaoGeral"),
                null);
        questionario.setCodEstagio(rs.getInt("tbEstagio_codigo"));
      //  curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"));
        return questionario;
    }

}
