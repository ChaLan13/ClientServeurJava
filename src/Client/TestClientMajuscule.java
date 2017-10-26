package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
public class TestClientMajuscule {

    public static void main(String[] args) 
    {
        try {
            
            // TODO Auto-generated method stub
            String adresseServeur;
            int portServeur;
            
            System.out.println("Tapez l'adresse du serveur:");
            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
            adresseServeur = clavier.readLine().trim();
            System.out.println("Tapez le port du serveur");
            portServeur = Integer.parseInt(clavier.readLine().trim());
            InetAddress adresse = InetAddress.getByName(adresseServeur);
            Socket socket = new Socket(adresse, portServeur);
            System.out.println("Socket connecté :"+ socket);
            BufferedReader fluxEntrant = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream fluxSortant = new PrintStream(socket.getOutputStream());
            boolean stop;
            do
            {
                System.out.println("Tapez la chaine à transformer ou \"quitter \" pour terminer");
                String requete = clavier.readLine();
                stop = requete.equalsIgnoreCase("quitter");
                if (!stop)
                {
                    fluxSortant.println(requete);
                    String reponse = fluxEntrant.readLine();
                    System.out.println(reponse);
                }
            } while (! stop);
            System.out.println("Arret de votre initiative");
            socket.close();
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

}