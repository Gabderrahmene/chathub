/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatroom.control;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class ClientHandle {
    private BufferedReader bf;
    private PrintWriter pw;

    public ClientHandle(BufferedReader bf, PrintWriter pw) {
        this.bf = bf;
        this.pw = pw;
    }
    
    public String login(String username,String password){
        try {
            pw.println("login");
            pw.println(username);
            pw.println(password);
            return bf.readLine();
        } catch (IOException ex) {
            System.getLogger(ClientHandle.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return "-1";
    }
    public String register(String username,String password){
        try {
            pw.println("register");
            pw.println(username);
            pw.println(password);
            return bf.readLine();
        } catch (IOException ex) {
            System.getLogger(ClientHandle.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return "-1";
    }
    public String send_message(String id_user,String message,String id_groupe){
        try {
            pw.println("message");
            pw.println(id_user);
            pw.println(id_groupe);
            pw.println(message);
            return bf.readLine();
        } catch (IOException ex) {
            System.getLogger(ClientHandle.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return "-1";
    }
    public String get_groupes(String id_user){
        try {
            pw.println("message");
            pw.println(id_user);
            return bf.readLine();
        } catch (IOException ex) {
            System.getLogger(ClientHandle.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return "-1";
    }
}
