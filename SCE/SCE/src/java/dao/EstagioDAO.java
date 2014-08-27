/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import model.Estagio;

/**
 *
 * @author Warley
 */
public class EstagioDAO extends DAO {

    public static void gravar(Estagio estagio) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tbEstagio (codigo, cargaHoraria, descricao, remuneracao, dataInicio, dataTermino, tbEmpresa_codigo, tbAluno_codigo, tbOrientadorEmpresa_codigo, tbOrientadorInstituicao_codigo)"
                    + " values (" + estagio.getCodigo() + ", " + estagio.getCargaHoraria()
                    + ", '" + estagio.getDescricao() + "', " + estagio.getRemuneracao() + ", '" + estagio.getDataInicio() + "', '" + estagio.getDataTermino() + "', ";
            if (estagio.getEmpresa() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + estagio.getEmpresa().getCodigo();
            }
            stringSQL = stringSQL + ", ";
            if (estagio.getAluno() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + estagio.getAluno().getCodigo();
            }
            stringSQL = stringSQL + ", ";
            if (estagio.getOrientadorEmpresa() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + estagio.getOrientadorEmpresa().getCodigo();
            }
            stringSQL = stringSQL + ", ";
            if (estagio.getOrientadorInstituicao() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + estagio.getOrientadorInstituicao().getCodigo();
            }
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Estagio estagio) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tbEstagio set "
                    + "cargaHoraria = " + estagio.getCargaHoraria() + ", "
                    + "descricao = '" + estagio.getDescricao() + "', "
                    + "remuneracao = '" + estagio.getRemuneracao() + "', "
                    + "dataInicio = '" + estagio.getDataInicio() + "', "
                    + "dataTermino= '" + estagio.getDataTermino() + "',";
            if (estagio.getEmpresa() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "TbEmpresa_codigo=" + estagio.getEmpresa().getCodigo() + ",";
            }
            if (estagio.getAluno() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "TbAluno_codigo=" + estagio.getAluno().getCodigo() + ",";
            }
            if (estagio.getOrientadorEmpresa() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "TbOrientadorEmpresa_codigo=" + estagio.getOrientadorEmpresa().getCodigo() + ",";
            }
            if (estagio.getOrientadorInstituicao() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "TbOrientadorInstituicao_codigo=" + estagio.getOrientadorInstituicao().getCodigo();
            }
            stringSQL = stringSQL + " where tbEstagio.codigo = " + estagio.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Estagio estagio) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tbEstagio where codigo = "
                    + estagio.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Estagio obterEstagio(int codEstagio) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Estagio estagio = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tbEstagio where codigo = " + codEstagio);
            rs.first();
            estagio = instanciarEstagio(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return estagio;
    }

    public static List<Estagio> obterEstagios()
            throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Estagio> estagios = new ArrayList<Estagio>();
        Estagio estagio = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tbEstagio");
            while (rs.next()) {
                estagio = instanciarEstagio(rs);
                estagios.add(estagio);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return estagios;
    }

    public static Estagio instanciarEstagio(ResultSet rs) throws SQLException {
        Estagio estagio = new Estagio(rs.getInt("codigo"),
                rs.getInt("cargaHoraria"),
                rs.getString("descricao"),
                rs.getFloat("remuneracao"),
                rs.getString("dataInicio"),
                rs.getString("dataTermino"),
                null, null, null, null);
        estagio.setCodAluno(rs.getInt("tbAluno_codigo"));
        estagio.setCodEmpresa(rs.getInt("tbEmpresa_codigo"));
        estagio.setCodOrientadorEmpresa(rs.getInt("tbOrientadorEmpresa_codigo"));
        estagio.setCodOrientadorInstituicao(rs.getInt("tbOrientadorInstituicao_codigo"));
        return estagio;
    }

}
