/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatroom.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author abdou
 */
public class login_verif {
    public int verif_cred(String username, String password){
        try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:10000/chathub", "root", null)) {
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                //execute query
                try (ResultSet rs = stmt.executeQuery("SELECT id_user, password FROM users WHERE username = '"+username+"'" )) {
                    //position result to first
                    rs.first();
                    if (password.equals(rs.getString("password"))){
                        return rs.getInt("id_user");
                    }else{
                        return -1;
                    }
                } catch (SQLException ex) {
                    System.getLogger(login_verif.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            } catch (SQLException ex) {
                System.getLogger(login_verif.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } catch (SQLException ex) {
            System.getLogger(login_verif.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return 0;
    }
}
