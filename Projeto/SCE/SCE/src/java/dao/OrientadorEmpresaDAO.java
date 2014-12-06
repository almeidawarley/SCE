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
import model.OrientadorEmpresa;
/**
 *
 * @author Marco
 */
public class OrientadorEmpresaDAO extends DAO {
    public static void gravar( OrientadorEmpresa orientadorEmpresa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        String stringSQL2;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tbOrientadorEmpresa (codigo,profissao,TbEmpresa_codigo)"
      
                    + " values (" + orientadorEmpresa.getCodigo()+ ",'"+orientadorEmpresa.getProfissao()+"' ," ;
          if (orientadorEmpresa.getEmpresa() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + orientadorEmpresa.getEmpresa().getCodigo();
            }
            stringSQL = stringSQL + ");";
            stringSQL2 = "insert into tbPessoa (codigo,nome,telefone) values ("+orientadorEmpresa.getCodigo() +", '" + orientadorEmpresa.getNome()+"', '"+orientadorEmpresa.getTelefone()+"');";
            comando.execute(stringSQL);
            comando.execute(stringSQL2);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static void alterar(OrientadorEmpresa orientadorEmpresa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tbOrientadorEmpresa set "
                    + "profissao = '" + orientadorEmpresa.getProfissao() + "', "
            + "tbEmpresa_Codigo = ";
            if (orientadorEmpresa.getEmpresa() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + orientadorEmpresa.getEmpresa().getCodigo();
            }
            stringSQL = stringSQL + " where codigo =" + orientadorEmpresa.getCodigo();
            comando.execute(stringSQL);
            stringSQL = "update tbPessoa set "
                    +"nome = '" +   orientadorEmpresa.getNome()+"', "
                    +"telefone = '"+ orientadorEmpresa.getTelefone()+"'"
                    +" where codigo ="+ orientadorEmpresa.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static void excluir(OrientadorEmpresa orientadorEmpresa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tbOrientadorEmpresa where codigo = "
                    + orientadorEmpresa.getCodigo();
            comando.execute(stringSQL);
            stringSQL = "delete from tbPessoa where codigo = "
                    + orientadorEmpresa.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static OrientadorEmpresa obterOrientadorEmpresa(int codOrientadorEmpresa) throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        OrientadorEmpresa orientadorEmpresa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tbOrientadorEmpresa, tbPessoa where tbOrientadorEmpresa.codigo = tbPessoa.codigo and tbPessoa.codigo = " + codOrientadorEmpresa);
            rs.first();
            orientadorEmpresa = instanciarOrientadorEmpresa(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return orientadorEmpresa;
    } 
    public static List<OrientadorEmpresa> obterOrientadorEmpresas() 
            throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<OrientadorEmpresa> orientadorEmpresas = new ArrayList<OrientadorEmpresa>();
        OrientadorEmpresa orientadorEmpresa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery
                    ("select * from tbOrientadorEmpresa, tbPessoa where tbOrientadorEmpresa.codigo = tbPessoa.codigo");
            while (rs.next()) {
                orientadorEmpresa = instanciarOrientadorEmpresa(rs);
                orientadorEmpresas.add(orientadorEmpresa);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return orientadorEmpresas;
    }
    public static OrientadorEmpresa instanciarOrientadorEmpresa(ResultSet rs) throws SQLException {
        OrientadorEmpresa orientadorEmpresa = new OrientadorEmpresa(rs.getInt("codigo"),rs.getString("profissao"),
        null,
        rs.getString("nome"),
        rs.getString("telefone"));
        orientadorEmpresa.setCodEmpresa(rs.getInt("tbEmpresa_codigo"));
        return orientadorEmpresa;
    }
}