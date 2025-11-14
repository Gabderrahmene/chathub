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
import java.util.concurrent.CopyOnWriteArrayList;


public class Server extends Thread {
	private static final CopyOnWriteArrayList<Client> clients = new CopyOnWriteArrayList<>();

	private final Socket Soc;
	
	public Server(Socket Soc) {
	this.Soc = Soc;
	}

	@Override
	public void run() {	
	try { 
        
	BufferedReader bf = new BufferedReader(new InputStreamReader(Soc.getInputStream()));

	PrintWriter pw = new PrintWriter(Soc.getOutputStream(), true);
        while(true){
           String request=bf.readLine();
        
            switch (request) {
                case "login" ->                     {
                        String username = bf.readLine();
                        String password = bf.readLine();
                        String id = new login_verif().verif_cred(username, password);
                        if(!id.equals("-1")){
                            clients.add(new Client(id,username,pw));
                        }           
                        pw.println(id);
                    }
                case "register" ->                     {
                        String username = bf.readLine();
                        String password = bf.readLine();
                        String id = new register_verif().verif_cred(username, password);
                        pw.println(id);
                    }
                case "message" ->                     {
                        String id = bf.readLine();
                        String text = new get_groupes().get_groupes(id);
                        pw.println(text);
                    }
                default -> pw.println("-1");
            }
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
