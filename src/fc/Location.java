package fc;

import java.util.Date;

public class Location{
    private Client client;
    private Film film;
    private Date date_emprunt;
    private Support support;

    Location(Client c,String s,Film f,Date d,Support su){
        client = c;
        film = f;
        date_emprunt = d;
        support = su;
    }

    public void retour(){
        support.retour();
        mise_a_jour_client();
    }

    public void debiter(){
        client.debiterMono();
    }

    public void louer(Film film){
        if (support.disponible() && client.peut_louer(film)){
            support.sortir_support();
        }
    }
    
    // get 
    public Client get_client(){
        return client;
    }

    public Film film(){
        return film;
    }
    public Date date_emprunt(){
        return date_emprunt;
    }

    public void mise_a_jour_client(){ // appelle une méthode de client qui permet de faire tous les changement nécessaire au compte client
        client.louer(film);
    }
}
