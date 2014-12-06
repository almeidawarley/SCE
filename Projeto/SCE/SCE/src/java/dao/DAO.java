/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marco
 */
public class DAO {

    public static void fecharConexao(Connection conexao, Statement comando) 
           throws SQLException {
        if (comando != null) {
            comando.close();
        }
        if (conexao != null) {
            conexao.close();
        }
    }
}
