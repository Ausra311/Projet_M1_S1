package fc;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import org.junit.Assert;

public class Test_DVD {
    DVD dvd;
    Film film;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    public void reset(){
        outContent = new ByteArrayOutputStream();
    }

    public void restoreStreams() {
        System.setOut(originalOut);
    }

    public void test() {
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
        Film film = new Film(id_film, titre, realisateur, acteurs, resume, genre, restriction, nb_location);
        
        int emplacement = 10; 
        Boolean endommage = false;
        Boolean disponible = true;
        int id = 1;
        DVD dvd = new DVD(film, emplacement, endommage, disponible, id);
        
        System.out.println("début test classe DVD :");
        // méthodes de la classe Support
        // get_emplacement
        assert dvd.get_emplacement() == 10 : "erreur méthode get_emplacement";

        // est_endommage
        assert dvd.est_endommage() == false : "erreur méthode est_endommage";
        dvd.endommage = true;
        assert dvd.est_endommage() == true : "erreur méthode est_endommage";

        // disponible
        assert dvd.disponible() == true : "erreur méthode disponible";
        dvd.disponible = false;
        assert dvd.disponible() == false : "erreur méthode disponible";

        // get_id
        assert dvd.get_id() == 1 : "erreur méthode get_id";
        

        // get_film
        assert(dvd.get_film().get_titre().equals(film.get_titre()));

        // sortir le DVD
        setUpStreams();
        dvd.sortir_support();;
        restoreStreams();
        try{Assert.assertEquals("DVD sortie\n", outContent.toString());}
        catch(Exception e){ System.err.println("erreur méthode sortir_support");}

        // retour
        reset();
        setUpStreams();
        dvd.retour();
        restoreStreams();
        try{Assert.assertEquals("DVD rendu\n", outContent.toString());}
        catch(Exception e){ System.err.println("erreur méthode retour");}
        assert(dvd.disponible() == true);
        
        System.out.println("test de classe DVD OK");
    }
}
