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
        parent.debiterMono();
        restoreStreams();
        try{Assert.assertEquals("compte 42 débité de 4\n", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterMono");}
        reset();

        setUpStreams();
        parent.debiterAll();
        restoreStreams();
        try{Assert.assertEquals("", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterAll");}
        reset();

        setUpStreams();
        parent.louer(f);
        parent.louer(f);
        parent.debiterAll();
        parent.rendre(f);
        parent.rendre(f);
        restoreStreams();
        try{Assert.assertEquals("compte 42 débité de 4\ncompte 42 débité de 4\n", outContent.toString());}
        catch(Exception e){ System.out.println("error debiterAll");}
        reset();

        
        System.out.println("Abonne_Parent ok");
    
    }
}