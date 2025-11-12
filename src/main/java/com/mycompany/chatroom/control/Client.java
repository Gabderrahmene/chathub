/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatroom.control;

import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client {
    public int login(String username,String password){
        try {
            Socket soc = new Socket("localhost", 5640);
            BufferedReader bf = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter pw = new PrintWriter(soc.getOutputStream(), true);
            pw.println(username);
            pw.println(password);
            pw.println("login");
            return Integer.parseInt(bf.readLine());
        } catch (IOException ex) {
            System.getLogger(Client.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return 10;
        }
    }
    public int register(String username,String password){
        try {
            Socket soc = new Socket("localhost", 5640);
            BufferedReader bf = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter pw = new PrintWriter(soc.getOutputStream(), true);
            pw.println(username);
            pw.println(password);
            pw.println("register");
            return Integer.parseInt(bf.readLine());
        } catch (IOException ex) {
            System.getLogger(Client.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return 10;
        }
    }
}
