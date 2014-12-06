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
import model.Vaga;

/**
 *
 * @author Aluno
 */
public class VagaDAO {
    public static void gravar(Vaga vaga) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tbVaga (codigo, preenchido, tbEmpresa_codigo, tbCurso_codigo)"
                    + " values (" + vaga.getCodigo() + ", " + vaga.getPreenchido()+ ", ";
            if (vaga.getEmpresa() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + vaga.getEmpresa().getCodigo();
            }
            stringSQL = stringSQL + ", ";
            if (vaga.getCurso() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + vaga.getCurso().getCodigo();
            }
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Vaga vaga) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tbVaga set "
                    + "preenchido = " + vaga.getPreenchido() + ", ";
            if (vaga.getEmpresa() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "TbEmpresa_codigo=" + vaga.getEmpresa().getCodigo() + ",";
            }
            if (vaga.getCurso() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "TbCurso_codigo=" + vaga.getCurso().getCodigo() + ",";
            }
            stringSQL = stringSQL + " where codigo = " + vaga.getCodigo() + ";";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Vaga vaga) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tbVaga where codigo = "
                    + vaga.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Vaga obterVaga(int codVaga) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Vaga vaga = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tbVaga where codigo = " + codVaga);
            rs.first();
            vaga = instanciarVaga(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return vaga;
    }

    public static List<Vaga> obterVagas()
            throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Vaga> vagas = new ArrayList<Vaga>();
        Vaga vaga = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tbVaga");
            while (rs.next()) {
                vaga = instanciarVaga(rs);
                vagas.add(vaga);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return vagas;
    }

    public static Vaga instanciarVaga(ResultSet rs) throws SQLException {
        Vaga vaga = new Vaga(rs.getInt("codigo"),
                null, null,
                rs.getInt("preenchido"));
        vaga.setCodCurso(rs.getInt("tbCurso_codigo"));
        vaga.setCodEmpresa(rs.getInt("tbEmpresa_codigo"));
        return vaga;
    }    
}
