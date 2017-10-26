package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class TestServerMajuscule {
	public static void main(String args[]){
		
		try{
		int portServeur = 9111;
		
		ServerSocket serveur= new ServerSocket(portServeur);
		System.out.println("Serveur demarre :" +serveur);
		
		int noClient =1;
		
		while(true){
			Socket client = serveur.accept();
			System.out.println("Connexion reussie no" +noClient);
			++noClient;
			ReceveurEnvoyeur r= new ReceveurEnvoyeur(client, noClient);
			r.start();
		}
		
		System.out.println("Arret du serveur");
	}
	catch(Exception e){
		System.out.println("erreur serveur:" +e);
	}
	
	}
}
