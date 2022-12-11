package fc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import org.junit.Assert;

import fc.banque.Banque_transaction;



public class Test_Client {
    private Client client;
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
    

    public void test(){
        
        System.out.println("Debut test Client ok");

        int id = 0;
        Carte_banquaire cb = new Carte_banquaire("CIC", "Visa", "42", new Banque_transaction());
        Film f = new Film(0, "A", "B", new Vector<String>(), "c", new Vector<String>(), 0, 0);

        try{client = new Client(id, cb);}
        catch(Exception e){System.out.println("error init");}

        assert client.get_id() == 0: "error get_id";

        assert client.get_nom() == "": "error get_nom";

        assert client.get_prenom() == "": "error get_prenom";

        assert client.get_adresse() == "": "error get_adresse";

        assert client.get_telephone() == "": "error get_telephone";

        assert client.get_historique().size() == 0: "error get_historique";

        assert client.get_solde() == 0: "error get_solde";

        assert client.get_nb_film_en_location()==0: "error get_nb_film_en_location";

        assert client.get_nb_film_mensuel()==0: "get_nb_film_mensuel";

        assert client.get_nb_film_mensuel()==0: "get_nb_film_mensuel";
        
        setUpStreams();
        client.debiterMono();
        restoreStreams();
        try{Assert.assertEquals("compte 42 débité de 5\n", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterMono");}
        reset();

        setUpStreams();
        client.debiterAll();
        restoreStreams();
        try{Assert.assertEquals("", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterAll");}
        reset();


        setUpStreams();
        client.add_Historique(f);
        client.add_Historique(f);
        client.debiterAll();
        client.rendre(f);
        client.rendre(f);
        restoreStreams();
        try{Assert.assertEquals("compte 42 débité de 5\ncompte 42 débité de 5\n", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterAll");}
        reset();



        try{client.solde_suffisant();}
        catch(Exception e){System.out.println("solde_suffisant ok");}

        assert client.peut_louer()==true: "error peut_louer ";
        client.louer(f);
        assert client.peut_louer()==false: "error peut_louer ";
        client.rendre(f);

        

        client.add_Historique(f);
        assert client.get_historique().size()==4: "error add_Historique";

        
        assert client.get_nb_film_en_location()==1: "Aucun film en location";
        int i = client.get_historique().size();
        client.rendre(f);
        assert client.get_nb_film_en_location()==0: "il reste un film en location";
        assert client.get_historique().size()==i: "le film rendu n'est pas ajoute dans historique";


        assert client.louer(f) == true: "Probleme louer";
        assert client.louer(f) == false: "Probleme louer";





        System.out.println("Test Client ok");

    }
}
