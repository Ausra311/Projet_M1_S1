package fc;

import java.util.Date;

public class Location{
    private Client client;
    private Historique historique;
    private Support support;

    public Location(Client c,Historique histo,Support _support){
        client = c;
        historique = histo;
        support = _support;
    }

    public void retour(){
        support.retour();
        client.rendre(get_Film());
        historique.rendre();
    }

    public void debiter(){
        client.debiterMono();
    }

    public void louer(Film film){
        if (support.disponible() && client.peut_louer()){
            support.sortir_support();
            client.louer(film);
        }
    }
    
    // get 
    public Client get_Client(){
        return client;
    }

    public Film get_Historique(){
        return historique.film;
    }

    public Film get_Film(){
        return historique.film;
    }

    public Support get_Support(){
        return support;
    }
    
    public Date date_emprunt(){
        return historique.date_debut;
    }

    public Date date_rendu(){
        return historique.date_fin;
    }

    public void mise_a_jour_client(){ // appelle une méthode de client qui permet de faire tous les changement nécessaire au compte client
        client.louer(get_Film());
    }
} 
 