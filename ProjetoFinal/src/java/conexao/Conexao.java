/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Senai
 */
public class Conexao {
      public static final String url = "jdbc:mysql://db4free.net:3306/guitlherme23?useSSL=false";
    public static final String user = "guitoplineo";
    public static final String senha = "guito23052007";
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
