package fc;
import fc.banque.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

import org.junit.Assert;
public class Test_Abonne_Parent {
    private Abonne_parent parent;
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
        Carte_banquaire cb = new Carte_banquaire("CIC", "Visa", "42", new Banque_transaction());
        Film f = new Film(0, "A", "B", new Vector<String>(), "c", new Vector<String>(), 0, 0);

        Abonne_enfant e1 = new Abonne_enfant(1, null, null, null, null, 10, cb);
        Abonne_enfant e2 = new Abonne_enfant(2, null, null, null, null, 0, cb);

        try{
        parent = new Abonne_parent(0, "ANDRE", "Paul", "SMH", "3630", 15, cb);
        }
        catch(Exception e){System.out.println("probleme init");}
    
        /*
         * Test Abonne change
         */

        
        


        setUpStreams();
        System.out.println(parent.get_solde());
        parent.recharger(50);
        System.out.println(parent.get_solde());
        restoreStreams();
        try{Assert.assertEquals("15\n65\n", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterMono");}
        reset();

        setUpStreams();
        System.out.println(parent.get_solde());
        for(int i=0;i<19;i++){
            parent.add_Historique(f);
        }
        System.out.println(parent.get_solde());
        parent.vingtieme_films();
        System.out.println(parent.get_solde());
        parent.add_Historique(f);
        parent.vingtieme_films();
        System.out.println(parent.get_solde());
        for(int i=0;i<20;i++){
            parent.rendre(f);
        }
        restoreStreams();
        try{Assert.assertEquals("65\n65\n65\n75\n", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterMono");}
        reset();

        parent.debiterMono();
        assert parent.get_solde() == 71 : "error debiterMono";


        parent.add_Historique(f);
        parent.add_Historique(f);
        parent.debiterAll();
        parent.rendre(f);
        parent.rendre(f);
        assert parent.get_solde() == 63 : "error debiterAll";


        parent.louer(f);
        parent.louer(f);
        parent.rendre(f);
        parent.rendre(f);
        assert parent.get_solde() == 55 : "error louer";

        /*Partie Abonne OK */

        /*Partie Abonne_Parent */


        setUpStreams();
        System.out.println(parent.get_nb_enfant());
        parent.add_enfant(e2);
        System.out.println(parent.get_nb_enfant());
        Vector<Abonne_enfant> lst_enfant = parent.get_liste_enfant();
        System.out.println(lst_enfant.size());
        System.out.println(lst_enfant.get(0).get_id());
        restoreStreams();
        try{Assert.assertEquals("0\n1\n1\n2\n", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterMono");}
        reset();

        e1.add_Historique(f);
        e1.add_Historique(f);
        assert parent.get_historique_enfant(e1).size() == e1.get_historique().size() : "error get_historique_enfant";

        assert parent.get_solde_enfant(e1) == 10 : "error get_solde_enfant";

        System.out.println("Abonne_Parent ok");
    
    }
}