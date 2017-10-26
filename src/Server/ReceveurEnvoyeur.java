package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ReceveurEnvoyeur extends Thread {
	BufferedReader fluxEntrant;
	PrintStream fluxSortant;
	int noClient;
	
	public ReceveurEnvoyeur(Socket client, int noClient) throws IOException{
		fluxEntrant = new BufferedReader();
		fluxSortant = new PrintStream();
		this.noClient=noClient;
		
		public void run(){
			try{
			while(!this.isInterrupted()){
				String requete = fluxEntrant.readLine();
				System.out.println("Le client no" +noClient+" a envoye :" +requete);
				String reponse = requete.toUpperCase();
				fluxSortant.println(reponse);
			}
			}
			catch(Exception e){
				System.out.println("Arret de la conversation avec le client no " +noClient+ " : "+e);
			}
		}
		
	}
}
