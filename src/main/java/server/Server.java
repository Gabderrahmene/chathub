/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONObject;

public class Server extends Thread {
	
	private final Socket Soc;
	
	public Server(Socket Soc) {
	this.Soc = Soc;
	}

	@Override
	public void run() {	
	try { 
  
	BufferedReader bf = new BufferedReader(new InputStreamReader(Soc.getInputStream()));

	PrintWriter pw = new PrintWriter(Soc.getOutputStream(), true);

        String username = bf.readLine();

        String password = bf.readLine();
        
        String request=bf.readLine();
        
        if(request.equals("login")){
            int id = new login_verif().verif_cred(username, password);

            pw.println(id);
        }
         if(request.equals("register")){
            int id = new register_verif().verif_cred(username, password);

            pw.println(id);
        }
       

        }  
		catch (IOException bilal) {
	}
}
                
	public static void main(String[] args) throws IOException {

		ServerSocket ss = new ServerSocket(5640);
		while(true) {
		Socket Soc = ss.accept();
		Server T = new Server(Soc);
		T.start();
            }
    }
}
