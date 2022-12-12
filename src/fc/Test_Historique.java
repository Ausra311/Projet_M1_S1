package fc;

import java.util.Vector;

public class Test_Historique {
    Historique histo;

    public void test(){

        

        
        Film f = new Film(0, "A", "B", new Vector<String>(), "c", new Vector<String>(), 0, 0);
        histo = new Historique(f);

        assert histo.get_film() == f: "error get_film"; 

        try{
        histo.rendre();
        }
        catch(Exception e){System.out.println("Probleme historique.rendre()");}
    }
    
}
