package fc;

public class Test_Abonne_Parent {
    private Abonne_parent parent;


    public void test(){
        Carte_banquaire cb = new Carte_banquaire("CIC", "Visa", "42", new Banque_transaction());
        try{
        parent = new Abonne_parent(0, "ANDRE", "Paul", "SMH", "3630", 15, null);
        }
        catch(Exception e){System.out.println("probleme init");}
    
    
    
    }
}
