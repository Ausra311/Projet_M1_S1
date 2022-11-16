package fc;

import java.util.Date;

public class Location{
    private Client client;
    private String type_client;
    private Film film;
    private Date date_emprunt;
    private Support support;

    Location(Client c,String t,String s,Film f,Date d,Support su){
        client = c;
        type_client = t;
        film = f;
        date_emprunt = d;
        support = su;
    }


    public void retour(){
        support.retour();
    }


   public void debiter(){
    client.debiter();
   }

    public void louer(){
        if (support.disponible()){
            support.sortir_support();
        }
    }
    
    // get 
    public Client get_client(){
        return client;
    }
    public String get_type_client(){
        return type_client;
    }

    public Film film(){
        return film;
    }
    public Date date_emprunt(){
        return date_emprunt;
    }
}
