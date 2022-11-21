package fc;

import java.util.Vector;

public class Test_Historique {
    Historique histo;

    public void test(boolean affichage){

        

        if(affichage) System.out.println("------------------------------------------------------");
        Film f = new Film(0, "A", "B", new Vector<String>(), "c", new Vector<String>(), 0, 0);
        histo = new Historique(f);
        if(affichage) System.out.println("init ok");

        if(affichage) System.out.println("------------------------------------------------------");
        assert(histo.get_film() == f); 
        if(affichage) System.out.println("init ok");

        
    }
    
}
