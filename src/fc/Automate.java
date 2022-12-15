package fc;
import fc.banque.Banque_transaction;
public class Automate {

    public Automate(){}
    
    public void sortir_DVD(int id){
        System.out.println("DVD sortie");

    }
    public void sortir_QRcode(int id_film){
        System.out.println("QR code sortie");
    }
    public void retour(){
       System.out.println("DVD rendu"); 
    }
    public void imprimer_ticket(){
       System.out.println("Impression....Ticket imprimé"); 

    }
    public int lire_disque_rendu(){
        return 2;
    }
    public Carte_banquaire get_cb(){
        return new Carte_banquaire("CIC", "Visa", "42", new Banque_transaction());
    }
}