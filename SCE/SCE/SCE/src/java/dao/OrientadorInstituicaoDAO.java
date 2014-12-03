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
import model.OrientadorInstituicao;
/**
 *
 * @author Marco
 */
public class OrientadorInstituicaoDAO extends DAO {
    public static void gravar( OrientadorInstituicao orientadorInstituicao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        String stringSQL2;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tbOrientadorInstituicao (codigo, TbCurso_codigo)"
      
                    + " values (" + orientadorInstituicao.getCodigo()+" ," ;
          if (orientadorInstituicao.getCurso() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + orientadorInstituicao.getCurso().getCodigo();
            }
            stringSQL = stringSQL + ")";
            stringSQL2 = "insert into tbPessoa (codigo, nome, telefone)" + "values(" + orientadorInstituicao.getCodigo()+",'"+ orientadorInstituicao.getNome()+"', '"+ orientadorInstituicao.getTelefone()+"')";
            comando.execute(stringSQL);
            comando.execute(stringSQL2);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static void alterar(OrientadorInstituicao orientadorInstituicao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tbOrientadorInstituicao set "


            +"tbCurso_codigo= ";
            if (orientadorInstituicao.getCurso() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + orientadorInstituicao.getCurso().getCodigo();
            }
            stringSQL = stringSQL + " where codigo =" + orientadorInstituicao.getCodigo();
            comando.execute(stringSQL);
            stringSQL = "update tbPessoa set "
                    +"nome = '" +   orientadorInstituicao.getNome() +"', "
                    +"telefone = '"+ orientadorInstituicao.getTelefone()+"'"
                    +" where codigo ="+ orientadorInstituicao.getCodigo();
            comando.execute(stringSQL);
 
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static void excluir(OrientadorInstituicao orientadorInstituicao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tbOrientadorInstituicao where codigo = "
                    + orientadorInstituicao.getCodigo();
            comando.execute(stringSQL);
            stringSQL = "delete from tbPessoa where codigo = "
                    + orientadorInstituicao.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static OrientadorInstituicao obterOrientadorInstituicao(int codOrientadorInstituicao) throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        OrientadorInstituicao orientadorInstituicao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tbOrientadorInstituicao, tbPessoa where tbOrientadorInstituicao.codigo = tbPessoa.codigo and tbPessoa.codigo = " + codOrientadorInstituicao);
            rs.first();
            orientadorInstituicao = instanciarOrientadorInstituicao(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return orientadorInstituicao;
    } 
    public static List<OrientadorInstituicao> obterOrientadorInstituicoes() 
            throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<OrientadorInstituicao> orientadorInstituicoes = new ArrayList<OrientadorInstituicao>();
        OrientadorInstituicao orientadorInstituicao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery
                    ("select * from tbOrientadorInstituicao, tbPessoa where tbOrientadorInstituicao.codigo = tbPessoa.codigo");
            while (rs.next()) {
                orientadorInstituicao = instanciarOrientadorInstituicao(rs);
                orientadorInstituicoes.add(orientadorInstituicao);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return orientadorInstituicoes;
    }
    public static OrientadorInstituicao instanciarOrientadorInstituicao(ResultSet rs) throws SQLException {
        OrientadorInstituicao orientadorInstituicao = new OrientadorInstituicao(rs.getInt("codigo"),null,
        rs.getString("nome"),
        rs.getString("telefone"));
        orientadorInstituicao.setCodCurso(rs.getInt("tbCurso_codigo"));
        return orientadorInstituicao;
    }
}