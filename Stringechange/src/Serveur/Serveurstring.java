package Serveur;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.net.Socket;
public class Serveurstring {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method 
			try {
				ServerSocket socketServeur = new ServerSocket(66);
			System.out.println("Le serveur attend la connexion d'un client");
			int nb=0;	
				while(true){
		Socket socket = socketServeur.accept();
		InputStream is = socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s= br.readLine().toString();
			++nb;
		System.out.println("je suis un client  connecté "+nb);
					System.out.println(s);
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os,true);
			pw.println(s.toString());
					socket.close();
					}	} catch (IOException e) {System.out.println(e.toString());}	}

	
	
	private static void clientstring(int result) {
		// TODO Auto-generated method stub
		
	}

}