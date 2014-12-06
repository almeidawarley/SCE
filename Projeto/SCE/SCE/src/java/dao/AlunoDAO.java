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
import model.Aluno;

/**
 *
 * @author Marco
 */
public class AlunoDAO extends DAO {

    public static void gravar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        String stringSQL2;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tbAluno (codigo, logradouro, numero, complemento, bairro, cidade, uf,tbCurso_codigo)"
      
                    + " values (" + aluno.getCodigo() + ",  '"  + aluno.getLogradouro() + "', '" + aluno.getNumero()
                    + "', '" + aluno.getComplemento() +"', '" + aluno.getBairro() + "', '" + aluno.getCidade() + "', '" +aluno.getUf()+"',";
           if (aluno.getCurso() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + aluno.getCurso().getCodigo();
            }
            stringSQL = stringSQL + ");";
            stringSQL2 = "insert into tbPessoa (codigo,nome,telefone) values ("+aluno.getCodigo() +", '" + aluno.getNome()+"', '"+aluno.getTelefone()+"');";
            comando.execute(stringSQL);
            comando.execute(stringSQL2);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tbAluno set "
                    + "logradouro = '" + aluno.getLogradouro() + "', "
                    + "numero = '" + aluno.getNumero() + "', "
                    + "complemento = '" + aluno.getComplemento() + "', "
                    + "bairro = '" + aluno.getBairro() + "', "
                    + "cidade = '" + aluno.getCidade() + "', "
                    + "uf = '" + aluno.getUf() + "', "
            
                  + "tbCurso_Codigo = ";
            if (aluno.getCurso() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + aluno.getCurso().getCodigo();
            }
            stringSQL = stringSQL + " where codigo = " + aluno.getCodigo();
            comando.execute(stringSQL);
            stringSQL = "update tbPessoa set "
                    +"nome = '" +   aluno.getNome()+"', "
                    +"telefone = '"+ aluno.getTelefone() +"'"
                    +" where codigo ="+ aluno.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tbAluno where codigo = "
                    + aluno.getCodigo();
            comando.execute(stringSQL);
            stringSQL = "delete from tbPessoa where codigo = "
                    + aluno.getCodigo();
            comando.execute(stringSQL);
            
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Aluno obterAluno(int codAluno) throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Aluno aluno = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tbAluno, tbPessoa where tbAluno.codigo = tbPessoa.codigo and tbPessoa.codigo = " + codAluno);
            rs.first();
           aluno = instanciarAluno(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return aluno;
    } 

    public static List<Aluno> obterAlunos() 
            throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Aluno> alunos = new ArrayList<Aluno>();
        Aluno aluno = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery
                    ("select * from tbAluno, tbPessoa where tbAluno.codigo = tbPessoa.codigo");
            while (rs.next()) {
                aluno = instanciarAluno(rs);
                alunos.add(aluno);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return alunos;
    }

    public static Aluno instanciarAluno(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno(rs.getInt("codigo"),
                rs.getString("logradouro"),rs.getString("numero"),rs.getString("complemento"),
                rs.getString("bairro"),rs.getString("cidade"),
                rs.getString("uf"),null,rs.getString("nome"),rs.getString("telefone"));
        aluno.setCodCurso(rs.getInt("tbCurso_codigo"));
      //  curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"));
        return aluno;
    }

}
