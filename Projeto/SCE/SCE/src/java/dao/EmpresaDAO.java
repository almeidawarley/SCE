/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;

/**
 *
 * @author Warley
 */
public class EmpresaDAO extends DAO {

    public static void gravar(Empresa empresa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tbEmpresa (codigo, nome, telefone,  logradouro, numero, complemento, bairro, cidade, uf, cnpj)"
      
                    + " values (" + empresa.getCodigo() + ", '"+empresa.getNome()+"', '" + empresa.getTelefone() + "',  '" + empresa.getLogradouro() + "', '" + empresa.getNumero()
                    + "', '" + empresa.getComplemento() +"', '"+ empresa.getBairro() +"', '"+ empresa.getCidade() +"', '"+empresa.getUf()+"', '"+empresa.getCnpj()+"'";

            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Empresa empresa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tbEmpresa set "
                    + "nome = '"+empresa.getNome()+"',"
                    + "telefone = '" + empresa.getTelefone() + "', "
                    + "logradouro = '" + empresa.getLogradouro() + "', "
                    + "numero = '" + empresa.getNumero() + "', "
                    + "complemento = '" + empresa.getComplemento() + "', "
                    + "bairro = '" + empresa.getBairro() + "', "
                    + "cidade = '" + empresa.getCidade() + "', "
                    + "uf = '" + empresa.getUf() + "', "
                    + "cnpj= '"+empresa.getCnpj()+"'";

            stringSQL = stringSQL + " where codigo = " + empresa.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Empresa empresa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tbEmpresa where codigo = "
                    + empresa.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Empresa obterEmpresa(int codEmpresa) throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Empresa empresa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tbEmpresa where codigo = " + codEmpresa);
            rs.first();
           empresa = instanciarEmpresa(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return empresa;
    } 

    public static List<Empresa> obterEmpresas() 
            throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Empresa> empresas = new ArrayList<Empresa>();
        Empresa empresa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery
                    ("select * from tbEmpresa");
            while (rs.next()) {
                empresa = instanciarEmpresa(rs);
                empresas.add(empresa);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return empresas;
    }

    public static Empresa instanciarEmpresa(ResultSet rs) throws SQLException {
        Empresa empresa = new Empresa(rs.getInt("codigo"), 
                rs.getString("nome"),
                rs.getString("telefone"),
                rs.getString("logradouro"),rs.getString("numero"),rs.getString("complemento"),
                rs.getString("bairro"),rs.getString("cidade"),
                rs.getString("uf"),
                rs.getString("cnpj"));
      //  curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"));
        return empresa;
    }

}
