package Client;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Clientstring {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		try {
		
			Socket socket = new Socket("192.168.232.2", 1234);
			System.out.println("duffuse");

			OutputStream os = socket.getOutputStream();
			
			PrintWriter pw = new PrintWriter(os, true);
			
			
			pw.println("aa");
			socket.close();
		/*	InputStream sr=socket.getInputStream();
			InputStreamReader r=new InputStreamReader(sr);
			BufferedReader br=new BufferedReader(r);
			String s=br.readLine();
			System.out.println("la resultat "+s);
			System.out.println("end");*/
			}
		catch(Exception ex) {
			ex.printStackTrace();

			
		}

	}

}
