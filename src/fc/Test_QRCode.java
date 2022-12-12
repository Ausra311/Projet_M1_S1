package fc;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import org.junit.Assert;

public class Test_QRCode {
    QRCode qrcode;
    Film film;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
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
        QRCode qrcode = new QRCode(film);
        
        System.out.println("début test classe QRCode :");
        // méthodes de la classe Support
        // get_emplacement
        assert qrcode.get_emplacement() == -1 : "erreur méthode get_emplacement";

        // est_endommage
        assert qrcode.est_endommage() == false : "erreur méthode est_endommage";

        // disponible
        assert qrcode.disponible() == true : "erreur méthode disponible";

        // get_id
        assert qrcode.get_id() == -1 : "erreur méthode get_id";

        // get_film
        assert qrcode.get_film().get_titre().equals(film.get_titre()) : "erreur méthode get_film";


        // méthode spécifique à la classe QRCode
        // sortir le QR-Code
        setUpStreams();
        qrcode.sortir_support();;
        restoreStreams();
        try{Assert.assertEquals("QR code sortie\n", outContent.toString());}
        catch(Exception e){ System.err.println("erreur méthode sortir_support");}
        
        System.out.println("test de classe QRCode OK");
        
    }
}
