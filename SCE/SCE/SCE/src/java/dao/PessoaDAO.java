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
import model.Pessoa;

/**
 *
 * @author Marco
 */
public class PessoaDAO extends DAO {

    public static void gravar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tbPessoa (nome,telefone,codigo)"
                    + " values ('" + pessoa.getNome()+ "', '" + pessoa.getTelefone()
                    + "', "+pessoa.getCodigo();
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static void alterar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tbPessoa set "
            + "nome = '" + pessoa.getNome() + "', "
            + "telefone = '" + pessoa.getTelefone() ;

            stringSQL = stringSQL + " where codigo = " + pessoa.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static void excluir(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tbPessoa where codigo = "
                    + pessoa.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static Pessoa obterPessoa(int codPessoa) throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Pessoa pessoa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tbPessoa where codigo = " + codPessoa);
            rs.first();
            pessoa = instanciarPessoa(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return pessoa;
    } 
public static List<Pessoa> obterPessoas() 
            throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Pessoa pessoa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery
                    ("select * from tbPessoa");
            while (rs.next()) {
                pessoa = instanciarPessoa(rs);
                pessoas.add(pessoa);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return pessoas;
    }

    public static Pessoa instanciarPessoa(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa(rs.getInt("codigo"),rs.getString("nome"),
                rs.getString("telefone"));
       return pessoa;
    }

}
