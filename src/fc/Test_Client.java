package fc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import org.junit.Assert;

import fc.banque.Banque_transaction;



public class Test_Client {
    private Client client;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    public void restoreStreams() {
        System.setOut(originalOut);
    }
    

    public void test(boolean affichage){
        
        

        int id = 0;
        Carte_banquaire cb = new Carte_banquaire("CIC", "Visa", "42", new Banque_transaction());

        System.out.println("------------------------------------------------------");
        client = new Client(id, cb);
        System.out.println("init ok");

        assert client.get_id() == 0: "error get_id";

        assert client.get_nom() == "": "error get_nom";

        assert client.get_prenom() == "": "error get_prenom";

        assert client.get_adresse() == "": "error get_adresse ok";

        assert client.get_telephone() == "": "error get_telephone ok";

        assert client.get_historique().size() == 0: "error get_historique ok";

        assert client.get_solde() == 0: "error get_solde ok";

        assert client.get_nb_film_en_location()==0: "error get_nb_film_en_location ok";

        assert client.get_nb_film_mensuel()==0: "get_nb_film_mensuel ok";

        assert client.get_nb_film_mensuel()==0: "get_nb_film_mensuel ok";
        
        setUpStreams();
        client.debiterMono();
        restoreStreams();
        try{Assert.assertEquals("compte 42 débité de 5\n", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterMono");}
        

        if(affichage) System.out.println("debiterMono ok");

        if(affichage) System.out.println("test debiterAll");
        System.out.println("1er test: 0 debit attendu");
        client.debiterAll();
        System.out.println("2er test: 2 debit attendu");
        client.add_film_loc();
        client.add_film_loc();
        client.debiterAll();
        client.rm_film_loc();
        client.rm_film_loc();
        if(affichage) System.out.println("debiterMono ok");

        if(affichage) System.out.println("test solde_suffisant");
        client.solde_suffisant();
        if(affichage) System.out.println("solde_suffisant ok");

        if(affichage) System.out.println("test peut_louer");
        assert(client.peut_louer()==true);
        client.add_film_loc();
        assert(client.peut_louer()==false);
        client.rm_film_loc();
        if(affichage) System.out.println("peut_louer ok");

        

        if(affichage) System.out.println("test add_Historique");
        Film f = new Film(0, "A", "B", new Vector<String>(), "c", new Vector<String>(), 0, 0);
        client.add_Historique(f);
        assert(client.get_historique().size()==1);
        if(affichage) System.out.println("add_Historique ok");

        if(affichage) System.out.println("test add_date_rendu");
        client.add_date_rendu(f);
        if(affichage) System.out.println("add_date_rendu ok");

        
        if(affichage) System.out.println("test louer");
        
        /*boolean b = client.louer(f);
        System.out.println(b);*/
        assert client.louer(f) == true: "Probleme louer";
        assert client.louer(f) == false: "Probleme louer";
        if(affichage) System.out.println("louer ok");

        if(affichage) System.out.println("test rendre");
        assert(client.get_nb_film_en_location()==1);
        client.rendre(f);
        assert(client.get_nb_film_en_location()==0);
        if(affichage) System.out.println("rendre ok");

        System.out.println("Test Client ok");

    }
}
