package fc;
import java.util.Vector;
import java.util.Date;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;

import fc.banque.Banque_transaction;

public class Test_Location{
    //classe de test pour la location d'un film
    Location location;
    
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    public void restoreStreams() {
        System.setOut(originalOut);
    }

    public void reset(){
        outContent = new ByteArrayOutputStream();
    }

    public void test(){
        Carte_banquaire cb = new Carte_banquaire("CIC", "Visa", "42", new Banque_transaction());
        Client client1 = new Client(0,cb);
        Client client2 = new Client(1,cb);
        Film film;
        Historique historique;
        Support support1;
        Support support2;

        // film
        int id_film = 1;
        String titre = "M1 info";
        String realisateur = "Vania Marangozova";
        Vector<String> acteurs = new Vector<String>();
        acteurs.add("Paul Andre");
        String resume = "Une classe agréable qui pose peu de question en classe et qui a une très bonne entente interne";
        Vector<String> genre = new Vector<String>();
        genre.add("humour");
        int restriction = 0;
        int nb_location = 0;
        film = new Film(id_film, titre, realisateur, acteurs, resume, genre, restriction, nb_location);
        historique = new Historique(film);

        // support du film
        support1 = new QRCode(film);
        support2 = new DVD(film, 1, false, true, 1);


        //Instanciation
        Location location1 = new Location(client1, historique, support1);
        Location location2 = new Location(client2, historique, support2);

        // louer
        setUpStreams();
        location1.louer(film);
        restoreStreams();
        try{Assert.assertEquals("QR code sortie\ncompte 42 débité de 5\n", outContent.toString());}
        catch(Exception e){ System.err.println("erreur méthode louer");}
        reset();

        setUpStreams();
        location2.louer(film);
        restoreStreams();
        try{Assert.assertEquals("DVD sortie\ncompte 42 débité de 5\n", outContent.toString());}
        catch(Exception e){ System.err.println("erreur méthode louer");}
        reset();

        // retour

        assert location1.get_Client().get_nb_film_en_location() == 1;

        location1.retour();
        location2.retour();

        assert location1.get_Client().get_nb_film_en_location() == 0;

        assert location1.date_rendu()!= null;
        assert location2.date_rendu()!= null;
       // je pense que du coup faut vérifier l'historique pour valider la fonction, tu en penses quoi ?
       // verifier que histo a bien 1 date de fin et verifier que film en location de client a baissé


    }
}