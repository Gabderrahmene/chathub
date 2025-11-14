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
 * @author abdou
 */
public class get_groupes {
    public String get_groupes(String id_user){
        try (Connection conn = DriverManager.getConnection(System.getenv("chathubBaseUrl"), "root", null)) {
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT g.* FROM groupes g JOIN membre m ON g.id_groupe = m.id_groupe WHERE m.id_user = '"+ id_user+"'" )) {
                    String res = "";
                    while (rs.next()) {
                        res+=rs.getString("id_groupe")+":"+rs.getString("title")+",";
                }
                    return res;
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
