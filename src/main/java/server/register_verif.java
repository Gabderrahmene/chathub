/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Click
 */
public class register_verif {
       public String verif_cred(String username, String password){
        try (Connection conn = DriverManager.getConnection(System.getenv("chathubBaseUrl"), "root", null)) {
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("INSERT INTO users (username, password) VALUES ('"+username+"','"+password+"')")) {
                    return "0";
                } catch (SQLException ex) {
                    System.getLogger(login_verif.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    return "-1";
                }
            } catch (SQLException ex) {
                System.getLogger(login_verif.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                return "-1";
            }
        } catch (SQLException ex) {
            System.getLogger(login_verif.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return "-1";
        }

    }
}
